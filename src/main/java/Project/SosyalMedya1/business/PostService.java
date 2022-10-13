package Project.SosyalMedya1.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Project.SosyalMedya1.dataAccess.PostDao;
import Project.SosyalMedya1.entities.Post;
import Project.SosyalMedya1.entities.User;
import Project.SosyalMedya1.requests.PostCreateRequest;
import Project.SosyalMedya1.requests.PostUpdateRequest;

@Service
public class PostService {
	
	private PostDao postDao;
	private UserService userService;
	
public PostService(PostDao postDao, UserService userService) {
		super();
		this.postDao = postDao;
		this.userService = userService;
	}

	public List<Post> getAllPost() {
	 return this.postDao.findAll();
		
	}

	public Post getOnePostById(int postId) {
		
		return this.postDao.findById(postId).orElse(null);
	}

	public Post createOnePost(PostCreateRequest newPostRequest) {
	
		User user = userService.getOneUserById(newPostRequest.getUserId());
		if(user==null) {
			return null;
		}else {
			Post toPostSave=new Post ();
			toPostSave.setId(newPostRequest.getId());
			toPostSave.setText(newPostRequest.getText());
			toPostSave.setTitle(newPostRequest.getTitle());
			toPostSave.setUser(user);
			return this.postDao.save(toPostSave);
		}
		
	}
	

	public void deleteOnePostById(int postId) {
	  this.postDao.deleteById(postId);
		
	}
public Post updateOnePostById(int postId, PostUpdateRequest updatepost) {
		
	Optional<Post> post=postDao.findById(postId);
	if(post.isPresent()) {
		Post toUpdateSave=post.get();
		toUpdateSave.setText(updatepost.getText());
		toUpdateSave.setTitle(updatepost.getTitle());
		return this.postDao.save(toUpdateSave);
	}
	return null;
	
	}
	
	
	
}
