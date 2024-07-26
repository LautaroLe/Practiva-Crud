import axios from "axios";

export default axios.create({
    baseURL: "http://localhost:10090/api",
    headers:{
        "Content-Type": "application/json"
    }
});