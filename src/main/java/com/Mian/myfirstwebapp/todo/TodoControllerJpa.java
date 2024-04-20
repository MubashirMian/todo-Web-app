package com.Mian.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Mian.myfirstwebapp.ToDoService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

	
	
	
	private TodoControllerJpa( TodoRepository todoRepository) {
		super();
		
		this.todoRepository= todoRepository;
	}
	
	private TodoRepository todoRepository ;
	
	// list todos
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedinUserName(model);
		List<Todo> todos = todoRepository.findByUsername(username);
		model.addAttribute("todos",todos);
		//todoRepository.ge
		return "listTodos";
	}


	private String getLoggedinUserName(ModelMap model) {
		Authentication authentication =
				SecurityContextHolder.getContext().getAuthentication();
		
				return authentication.getName();}
	
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username= getLoggedinUserName(model);
		Todo todo = new Todo(0,username,"default",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";
	}

	
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model,@Valid Todo todo, BindingResult result){
		if(result.hasErrors()) {
			return "todo";
		}
		String username = getLoggedinUserName(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		
		//todoService.addTodos(username, todo.getDescription(), 
			//	todo.getTargetDate() ,false);
		return "redirect:list-todos";
			}
	
	
	@RequestMapping("delete-todo")
	public String deleteTodos(@RequestParam int id ) {
		//Delete Todo
		todoRepository.deleteById(id);
		//todoService.deleteById(id);
		return "redirect:list-todos";
	}

	
	@RequestMapping(value="update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo",todo);
		
		return "todo";
	}

	
	@RequestMapping(value="update-todo",method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username = getLoggedinUserName(model);
		todo.setUsername(username);
		//todoService.updateTodo(todo);
		todoRepository.save(todo);
		return "redirect:list-todos" ;
	}
	}

	