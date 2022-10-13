package Project.SosyalMedya1.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Project.SosyalMedya1.dataAccess.UserDao;
import Project.SosyalMedya1.entities.User;

@Service
public class UserService {
	
	private UserDao userDao;
@Autowired
	public UserService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
  public List<User> getAllUsers() {
	  return this.userDao.findAll();
  }
public User  getOneSave(User user) {
	return this.userDao.save(user);
}
public User getOneUserById(int userId) {
	return this.userDao.findById(userId).orElse(null);
}

public User getOneUpdate(int userId, User newUser) {
	 Optional<User> user =userDao.findById(userId);
     if(user.isPresent()) {
         User foundUser=user.get();
         foundUser.setUserName(newUser.getUserName());
         foundUser.setPassword(newUser.getPassword());
        
         return this.userDao.save(foundUser);
      
     }else {
      return null;
      }
     }
			public void deleteById(int UserId) {
			    userDao.deleteById(UserId);
			    }
			
		
			}
			  
  

