<template>
    <div class="submit-form">
        <div v-if="!submitted">
            <div class="form-grup">
                <label for="title">Apellido</label>
                <input type="text" class="form-control" id="apellido" required v-model="user.apellido" name="apellido">
            </div>

            <div class="form-grup">
                <label for="title">Nombre</label>
                <input type="text" class="form-control" id="nombre" required v-model="user.nombre" name="nombre">
            </div>

            <div class="form-grup">
                <label for="title">Correo Electronico</label>
                <input type="text" class="form-control" id="email" required v-model="user.email" name="email">
            </div>

            <button @click="grabaUser" class="btn btn=success"></button>
        </div>

        <div v-else>
            <h4>Se ha enviado exitosamente!</h4>
            <button class="btn btn-succes" @click="newTutorial">Agregar</button>
        </div>
    </div>
</template>

<script>
import UsersDataService from '@/services/UsersDataService';

export default {
    name:"add-user",
    data() {
        return {
            user: {
                id:null,
                nombre:"",
                apellido:"",
                email:""
            },submitted: false
        };
    },
    methods: {
        saveUser(){

            var data={
                nombre:this.nombre,
                apellido:this.apellido,
                email:this.email
            };

            UsersDataService.create()
            .then(response => {
                this.user.id= response.data.id;
                console.log(response.data);
                this.submitted=true;
            })
            .catch(e=>{
                console.log(e);
            })
        },
        newUser(){
            this.submitted=false;
            this.user={};
        }
    }
}
</script>

<style>
.submit-form{
    max-width: 300px;
    margin: auto;
}
</style>