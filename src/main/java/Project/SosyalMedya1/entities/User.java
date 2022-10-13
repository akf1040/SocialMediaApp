package Project.SosyalMedya1.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {
	
	@Id 
	private int id;
	
	private String userName;
	
	private String password;

}
