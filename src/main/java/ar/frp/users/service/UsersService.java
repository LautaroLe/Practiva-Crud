package ar.frp.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.frp.users.entity.Users;
import ar.frp.users.repository.UsersRepository;

@Service
public class UsersService {
	@Autowired
	private UsersRepository usersRepository;
	
	public void UsersService(UsersRepository usersRepository)
	{
		this.usersRepository = usersRepository;
	}
	
	public List<Users> getUsers(){
		return usersRepository.findAll();
	}
	
	public Users saveUser(Users users) {
		return usersRepository.save(users);
	}
	
	public Users getUserById(int id) {
	    return usersRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
	}
	
	public Users updateUser(int id, Users user) {
        Optional<Users> existingUser = usersRepository.findById(id);
        if (existingUser.isPresent()) {
            Users updatedUser = existingUser.get();
            updatedUser.setNombre(user.getNombre()); 
            updatedUser.setApellido(user.getApellido());
            updatedUser.setEmail(user.getEmail());
            return usersRepository.save(updatedUser);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    public void deleteUser(int id) {
        usersRepository.deleteById(id);
    }
}
