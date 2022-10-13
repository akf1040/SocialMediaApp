package Project.SosyalMedya1.dataAccess;


import org.springframework.data.jpa.repository.JpaRepository;

import Project.SosyalMedya1.entities.Post;

public interface PostDao  extends JpaRepository<Post, Integer> {
	
	

}
