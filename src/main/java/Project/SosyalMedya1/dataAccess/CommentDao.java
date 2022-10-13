package Project.SosyalMedya1.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Project.SosyalMedya1.entities.Comment;

public interface CommentDao extends JpaRepository<Comment, Integer> {

	List<Comment> findByUserIdAndPostId(Integer userId, Integer postId);

	List<Comment> findByUserId(Integer userId);

	List<Comment> findByPostId(Integer postId);

}
