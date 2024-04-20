package com.Mian.myfirstwebapp.todo;

import java.time.LocalDate;

import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity //mapping the bean into database table
 
public class Todo {
	
	@Id
	@GeneratedValue
    private int id;
    
	private String username;
    
	@Size(min=10, message="Enter atleast 10 characters")
    private String description;
    
	private LocalDate targetDate;
    private boolean done;
    
    // create a default constructor for entitiy
    public Todo() {}

    // Constructor, getters, and setters
    // Constructor
    public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    // Getters and setters for properties
    // id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // targetDate
    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    // done
    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
