import http from "../http-common";

class UserDataService{
    getAll() {
        return http.get("/users")
    }
    //esta por ver de aca para abajo
    get(id) {
        return http.get(`/user/${id}`);
    }
    
    findById(id) {
        return http.get(`/user?id=${id}`)
    }
    
    create(data) {
        return http.post("/user",data);
    }

    update(id,data) {
        return http.put(`/update-user/${id}`,data)
    }

    delete(id) {
        return http.delete(`/delete-user${id}`)
    }

    deleteAll() {
        return http.delete(`/users`)
    }
    
}
export default new UserDataService();