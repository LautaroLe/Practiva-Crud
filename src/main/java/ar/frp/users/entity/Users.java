package ar.frp.users.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private long id;
	
	@Column (name = "NOMBRE")
	@NotNull(message = "El nombre no puede ser nulo")
	private String nombre;
	
	@Column (name = "APELLIDO")
	@NotNull(message = "El apellido no puede ser nulo")
	private String apellido;
	
	@Column (name = "EMAIL")
	@NotNull(message = "El email no puede ser nulo")
	private String email;
}
