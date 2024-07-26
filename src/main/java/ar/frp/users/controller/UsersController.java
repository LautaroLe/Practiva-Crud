package ar.frp.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.frp.users.entity.Users;
import ar.frp.users.service.UsersService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8080/")
public class UsersController {
	
	@Autowired
	UsersService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<Users>> listUsers(){
		List<Users> resource = userService.getUsers();
		return ResponseEntity.ok(resource);
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<Users> getUser(@PathVariable int id) {
	    Users resource = userService.getUserById(id);
	    if (resource != null) {
	        return ResponseEntity.ok(resource);
	    } else {
	        return ResponseEntity.notFound().build(); // Retorna 404 si el usuario no se encuentra
	    }
	}
	/*
	@PostMapping("/user")
	public ResponseEntity<Users> saveUSer( Users user) {
		Users resource = userService.saveUser(user);
		return ResponseEntity.ok(resource);
	}
	*/
	
	@PostMapping("/users")
    public ResponseEntity<Users> saveUser(@RequestBody Users user) {
        Users resource = userService.saveUser(user);
        return ResponseEntity.ok(resource);
    }
	
	@PutMapping("/update-user/{id}")
	 public ResponseEntity<Users> updateUser(@PathVariable int id, @RequestBody Users user) {
        Users updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }
	
	@DeleteMapping("/delete-user")
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
