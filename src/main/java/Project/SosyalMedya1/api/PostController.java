package Project.SosyalMedya1.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Project.SosyalMedya1.business.PostService;
import Project.SosyalMedya1.entities.Post;
import Project.SosyalMedya1.requests.PostCreateRequest;
import Project.SosyalMedya1.requests.PostUpdateRequest;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	private PostService postService;

	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}
	@GetMapping
	public List<Post> getAllPost(){
		return this.postService.getAllPost();
	}
    @GetMapping("/{postId}")
	public Post getOnePost (@PathVariable int postId) {
		return this.postService.getOnePostById(postId);
    	
    }
    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequest ) {
		return this.postService.createOnePost(newPostRequest);
    	
    }
    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable int postId) {
    	this.postService.deleteOnePostById(postId);
    }
    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable int postId, @RequestBody PostUpdateRequest  updatepost) {
    	return this.postService.updateOnePostById(postId,updatepost);
    }
    
    
}
