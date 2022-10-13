package Project.SosyalMedya1.requests;

import lombok.Data;

@Data

public class PostCreateRequest {
	private int id;
	  
    private String title;
    
    private String text;
    
    private int userId;
    
    
}
