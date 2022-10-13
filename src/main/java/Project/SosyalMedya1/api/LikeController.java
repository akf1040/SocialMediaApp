package Project.SosyalMedya1.api;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Project.SosyalMedya1.business.LikeService;
import Project.SosyalMedya1.entities.Like;
import Project.SosyalMedya1.requests.LikeCreateRequest;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/likes")
public class LikeController {
	
	private LikeService likeService;
	
	public LikeController(LikeService likeService) {
		super();
		this.likeService = likeService;
	}

	@GetMapping
	public List<Like> getAllLikes (@RequestParam Optional <Integer> userId,@RequestParam Optional<Integer> postId  ) {
	return this.likeService.getAllLikesWithParam(userId,postId);
	}
	


@PostMapping
public Like createOneLike(@RequestBody LikeCreateRequest likeRequest) {
	return this.likeService.createOneLike(likeRequest);
}
@DeleteMapping("/{likeId}")
public void deleteOneLike(@PathVariable int likeId) {
		likeService.deleteOneCommentById(likeId);

}
}



