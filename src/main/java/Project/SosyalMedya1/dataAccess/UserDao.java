package Project.SosyalMedya1.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import Project.SosyalMedya1.entities.User;

public interface UserDao  extends JpaRepository<User, Integer>{

}
