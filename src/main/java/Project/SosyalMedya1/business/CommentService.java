package Project.SosyalMedya1.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import Project.SosyalMedya1.dataAccess.CommentDao;
import Project.SosyalMedya1.entities.Comment;
import Project.SosyalMedya1.entities.Post;
import Project.SosyalMedya1.entities.User;
import Project.SosyalMedya1.requests.CommentCreateRequest;
import Project.SosyalMedya1.requests.CommentUpdateRequest;

@Service
public class CommentService {
	
	private CommentDao commentDao;
    private UserService userService;
    private PostService postService;


	public CommentService(CommentDao commentDao, UserService userService, PostService postService) {
		super();
		this.commentDao = commentDao;
		this.userService = userService;
		this.postService = postService;
	}

	public List<Comment> getAllCommentsWithParam(Optional<Integer> userId, Optional<Integer> postId) {
		if(userId.isPresent() &&postId.isPresent()) {
			return commentDao.findByUserIdAndPostId(userId.get(),postId.get());
		}
		 else if(userId.isPresent()) {
			return this.commentDao.findByUserId(userId.get());
		}
		 else if(postId.isPresent()) {
			 return this.commentDao.findByPostId(postId.get());
		 }
		 return commentDao.findAll();
		 }

	public Comment getOneCommentById(int commentId) {
		
		return this.commentDao.findById(commentId).orElse(null);
	}

	public Comment createOneComment(CommentCreateRequest request) {
		User  user= userService.getOneUserById(request.getUserId());
	   Post post=postService.getOnePostById(request.getPostId());
	   if(user !=null&&post!=null) {
		   Comment commentToSave=new Comment();
		   commentToSave.setId(request.getId());
		   commentToSave.setUser(user);
		   commentToSave.setPost(post);
		   commentToSave.setText(request.getText());
		   return commentDao.save(commentToSave);
	   }else
	   return null;
	}

	public Comment createOneUpdateById(int commentId, CommentUpdateRequest updateRequest) {
	Optional<Comment> comment=commentDao.findById(commentId);
	if(comment.isPresent()) {
		Comment commentToUpdate= comment.get();
		commentToUpdate.setText(updateRequest.getText());
		return this.commentDao.save(commentToUpdate);
	}
		return null;
		
	}

	public  void deleteOneCommentById(int commentId) {
    commentDao.deleteById(commentId);
		
	}
	}	

	
		
	
	
	


