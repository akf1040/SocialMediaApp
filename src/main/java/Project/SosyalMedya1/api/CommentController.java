package Project.SosyalMedya1.api;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Project.SosyalMedya1.business.CommentService;
import Project.SosyalMedya1.entities.Comment;
import Project.SosyalMedya1.requests.CommentCreateRequest;
import Project.SosyalMedya1.requests.CommentUpdateRequest;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	private CommentService commentService;

	public CommentController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}
	@GetMapping
	public List<Comment> getAllComments(@RequestParam Optional<Integer> userId,@RequestParam Optional<Integer> postId){
		return this.commentService.getAllCommentsWithParam(userId,postId);
	}
	@GetMapping("/{commentId}")
	public Comment getOneComment(@PathVariable int commentId) {
		return this.commentService.getOneCommentById(commentId);
	}

@PostMapping
public  Comment createOneComment(@RequestBody CommentCreateRequest request) {
	return this.commentService.createOneComment(request);
}
@PutMapping("/{commentId}")
public Comment createOneUpdate(@PathVariable int commentId,@RequestBody CommentUpdateRequest updateRequest ) {
	return this.commentService.createOneUpdateById(commentId,updateRequest);
}
@DeleteMapping("/{commentId}")
public void deleteOneComment(@PathVariable int commentId) {
		commentService.deleteOneCommentById(commentId);

}
}
