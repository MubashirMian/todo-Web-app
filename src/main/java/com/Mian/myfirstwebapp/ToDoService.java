package com.Mian.myfirstwebapp;

import java.time.LocalDate;
import java.util.ArrayList; // Change to your preferred List implementation
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.Mian.myfirstwebapp.todo.Todo;

import jakarta.validation.Valid;

@Service
public class ToDoService {
  
  private static final List<Todo> todos = new ArrayList<>();
  
  private static int todosCount = 0;
  
  static {
    todos.add(new Todo(++todosCount, "Mobi", "Dockers 1", LocalDate.now().plusYears(1), false));
    todos.add(new Todo(++todosCount, "Mian", "Spring security 1", LocalDate.now().plusYears(1), false));
    todos.add(new Todo(++todosCount, "Mian", "AWS 1", LocalDate.now().plusYears(1), false));
  }
  
  public List<Todo> findByUsername(String username) {
	  Predicate<?super Todo> predicate = 
			  todo -> todo.getUsername().equalsIgnoreCase(username);
    return todos.stream().filter(predicate).toList();
  }
  
  public void addTodos(String username,String description,LocalDate targetDate, boolean done) {
	  Todo todo = new Todo(++todosCount,username,description,targetDate,done);
	  todos.add(todo); // we will call this method passing arguments thru add todos page  
  }
 
  public void deleteById(int id) {
	  Predicate<? super Todo> predicate = todo -> todo.getId()==id;
	  // todo -> conddition
	  todos.removeIf(predicate);
  }

  public Todo findById(int id) {
	
	// thru functional programming find that particular todo with id
	 Predicate<? super Todo> predicate = todo -> todo.getId()==id;
	  // stream of todos, find the thru filtering
	 Todo todo = todos.stream().filter(predicate).findFirst().get();
	 return todo;
}

public void updateTodo(@Valid Todo todo) {
	// TODO Auto-generated method stub
	deleteById(todo.getId());
	todos.add(todo);
}
}
