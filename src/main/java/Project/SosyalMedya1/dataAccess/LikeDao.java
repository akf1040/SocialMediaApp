package Project.SosyalMedya1.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Project.SosyalMedya1.entities.Like;

public interface LikeDao extends JpaRepository<Like, Integer> {

	List<Like> findByuserIdAndPostId(Integer userId, Integer postId);

	List<Like> findByUserId(Integer userId);

	List<Like> findByPostId(Integer postId);

}
