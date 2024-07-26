<template>
    
    <div v-if="currentUser" class="edit-form">
        <h4>Usuario</h4>
        <form>
            <div class="gorm-group">
                <label for="title">Nombre</label>
                <input type="text" class="form-control" id="nombre" v-model="currentUser.nombre">
            </div>
            <div class="gorm-group">
                <label for="description">Apellido</label>
                <input type="text" class="form-control" id="apellido" v-model="currentUser.apellido">
            </div>
            <div class="gorm-group">
                <label><strong>Correo</strong></label>{{currentUser.email}}
            </div>
        </form>
        <button class="badge badge-danger mr-2" @click="deleteUser">Borrar</button>
        <button type="submit" class="badge badge-success" @click="updateUser">Modificar</button>
        <p>{{ message }}</p>
    </div>
    <div v-else>
        <br>
        <p>Por favor click en algún usuarios</p>
    </div>
</template>

<script>
    import UsersDataService from '@/services/UsersDataService';
    export default{
        name:"user",
        data(){
            return{
                currentUser:null,
                message:""
            };
        },
        methods: {
            getUser(id) {
                UsersDataService.get(id)
                .then(response => {
                    this.currentUser=response.data;
                    console.log(response.data);
                })
                .catch(e=> {
                    console.log(e +"no se pudo acceder al usuario :" + response.data);
                });
            },
            updateUser() {
                UsersDataService.update(this.currentUser.id,this.currentUser)
                .then(response => {
                    console.log(response.data);
                }).catch(e =>{
                    console.log(" no se guardo con exito el usuario :"+ currentUser.nombre + " - " + currentUser.apellido)
                })
            },
            deleteUser(){
                UsersDataService.delete(this.currentUser.id)
                .then(response => {
                    console.log(response.data);
                    this.$router.push({name: "users"});
                })
                .catch(e => {
                    console.log(e);
                });
            }

        },
        mounted(){
            this.message='';
            this.getUser(this.$route.params.id);
        }
    }
</script>
<style>
.edit-form{
    max-width: 300px;
    margin: auto;
}
</style>