package Project.SosyalMedya1.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Project.SosyalMedya1.dataAccess.LikeDao;
import Project.SosyalMedya1.entities.Like;
import Project.SosyalMedya1.entities.Post;
import Project.SosyalMedya1.entities.User;
import Project.SosyalMedya1.requests.LikeCreateRequest;

@Service
public class LikeService {

 private  LikeDao likeDao;
private  UserService userService;
private PostService postService;
public LikeService(LikeDao likeDao, UserService userService, PostService postService) {
	super();
	this.likeDao = likeDao;
	this.userService = userService;
	this.postService = postService;
}



public List<Like> getAllLikesWithParam(Optional<Integer> userId, Optional<Integer> postId) {
	
	if(userId.isPresent()&&postId.isPresent()) {
		return this.likeDao.findByuserIdAndPostId(userId.get(),postId.get());
	}else if(userId.isPresent()) {
		return likeDao.findByUserId(userId.get());
	}else if(postId.isPresent()) {
		return likeDao.findByPostId(postId.get());
	}
	return likeDao.findAll();
}

public Like createOneLike(LikeCreateRequest likeRequest) {
  User user=userService.getOneUserById(likeRequest.getUserId());
  Post post=postService.getOnePostById(likeRequest.getPostId());
  if(user!=null&&post!=null) {
	  
	  Like likeToSave= new Like();
	  likeToSave.setId(likeRequest.getId());
	  likeToSave.setPost(post);
	  likeToSave.setUser(user);
  }
	 return null;
}



public void deleteOneCommentById(int likeId) {
	likeDao.deleteById(likeId);
	
}




}
	

