package Project.SosyalMedya1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Data
@Table(name="comments")

public class Comment {
	 @Id
	    private int id;
	    
	    private String title;
	    
	    @Lob
	    @Column(columnDefinition = "text")
	    private String text;
	    
	    
	   
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id",nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    @JsonIgnore
	    private User user;
	    
	    
	   
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="post_id",nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    @JsonIgnore
	    private Post post;
	}


