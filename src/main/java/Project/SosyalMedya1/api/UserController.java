package Project.SosyalMedya1.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Project.SosyalMedya1.business.UserService;
import Project.SosyalMedya1.entities.User;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {
	  
	private UserService userService;

	    @Autowired
	    public UserController(UserService userService) {
	        super();
	        this.userService = userService;
	    }

	
	@GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
       return userService.getAllUsers();
        }
   @PostMapping("/saveOneUser")
    public  User  getOneSave( @RequestBody User user ){
        return userService.getOneSave(user);
    }
   @GetMapping("/{userId}")
   public User getOneUsers( @ PathVariable int userId){
       return userService.getOneUserById(userId);
   }
   @PutMapping("/{userId}")
   public User  getOneUpdate( @PathVariable int userId, @RequestBody User  newUser) {
       return userService.getOneUpdate(userId, newUser);
       
   }
   @DeleteMapping("/{userId}")
   public void deleteById( int userId) {
	   userService.deleteById(userId);
   }
}
