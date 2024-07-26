<template>
    
    <div class="list row">
        <div class="col-md-8">
            <div class="input-group mb-3">
                <input type="text" class="form-control" v-model="id" placeholder="Buscar por id" />
                <div class="input-group-append">
                    <button class="btn btn-outine-secondary" type="button" @click="searchId"> 
                        Buscar
                    </button>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <h4>Lista de usuarios</h4>
            <ul class="list-group">
                <li class="list-group-item" :class="{active:index == currentIndex}" 
                v-for="(user,index) in users" :key="index" @click="setActiveUser(user,index)">
                {{ user.id+ " : " + user.nombre }}
                </li>
            </ul>
            <button class="m-3 btn btn-sm btn-danger" @click="removeAllUsers"> Borrar Todos</button>

        </div>

        <div class="col-md-6">
            <div v-if="currentUser">
                <h4>Usuario</h4>
                <div>
                    <label><strong>Nombre:</strong></label> {{ currentUser.nombre }}
                </div>
                <div>
                    <label> <strong> Apellido:</strong></label>{{ currentUser.apellido }}
                </div>
                <div>
                    <label> <strong> Correo:</strong></label>{{ currentUser.email }}
                </div>
                <router-link :to="'/user/' + currentUser.id " class="badge badgre-warning">Editar</router-link>
            </div>
            <div v-else>
                <br/>
                <p>Por favor click en un Usuario...</p>
            </div>
        </div>
    </div>
</template>

<script>
import UsersDataService from '../services/UsersDataService';

export default {
    name:"users-list",
    data() {
            return{
            users:[],
            currentUser: null,
            currentIndex: -1,
            nombre:""
        };
    },
    methods: {
        retriveUsers(){
            UsersDataService.getAll().then(response => {
                this.users = response.data;
                console.log(response.data + "line 64 UsersList");
            }).catch(e=> {
                console.log(e);
            })
        },
        refreshList() {
            this.retriveUsers();
            this.currentUser=null;
            this.currentIndex=-1;
        },
        setActiveUser(user,index) {
            this.currentUser= user;
            this.currentIndex= user ? index : -1;
        },
        removeAllUsers() { 
            UsersDataService.deleteAll()
            .then(response => {
                console.log(response.data);
                this.refreshList();
            }).catch(e=> {console.log(e);});
            
        },
        // searchId(){
        //     UsersDataService.findById(this.id).then(response => {
        //         this.user = response.data;
        //         this.setActiveUser(null);
        //         console.log(response.data)
        //     })
        //     .catch(e=> {
        //         console.log(e);
        //     });
        // }
        searchId() {
            if (this.id) {
                UsersDataService.get(this.id).then(response => {
                    this.currentUser = response.data; // Asegúrate de asignar a `currentUser` 
                    this.currentIndex = -1; // Resetea el índice actual
                    console.log(response.data);
                }).catch(e => {
                    console.log(e);
                    this.message = "Usuario no encontrado";
                });
            } else {
                this.message = "Por favor ingrese un ID válido";
            }
        }

    },
    mounted(){
        this.retriveUsers();
    }

}
</script>
<style>
.list{
    text-align: left;
    max-width: 750px;
    margin: auto;
}
</style>"