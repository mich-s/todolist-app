package com.michal.todolist.controller;

import java.security.Principal;
import java.util.List;
//import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.michal.todolist.entity.Task;
import com.michal.todolist.entity.TodoList;
import com.michal.todolist.service.TodoListService;

@Controller
public class AppController {

	@Autowired
	private TodoListService todoListService;
	
//	private Logger myLogger = Logger.getLogger(getClass().getName());

	@GetMapping("/")
	public String showHome(Model model, Principal principal) {
		String username = principal.getName();
		model.addAttribute("username", username);
		List<TodoList> todoLists = todoListService.getTodoLists(username);
		model.addAttribute("todoLists", todoLists);
		
		TodoList todoList = new TodoList();
		model.addAttribute("todoList", todoList);
	
		return "home";
	
	}
	
	//Handling lists
	//
	
	@RequestMapping("/showFormAddList")
	public String showFormAddList(Model model, Principal principal) {
		TodoList todoList = new TodoList();
		model.addAttribute("todolist", todoList);
		
		String username = principal.getName();
		model.addAttribute("todoListUser", username);
		
		return "todolist-form";
	}
	
	@PostMapping("/addList")
	public String addList(@ModelAttribute("todolist") TodoList todoList) {
		todoListService.addList(todoList);
		
		return "redirect:/";
	}
	
	@GetMapping("/deleteList")
	public String deleteList(@ModelAttribute("tempTodoListId") int listId) {
		todoListService.deleteList(listId);
		
		return "redirect:/";
	}
	
	@GetMapping("/updateList")
	public String updateList(@ModelAttribute("tempTodoListId") int listId, Model model, Principal principal) {
		TodoList todoList = todoListService.getTodoList(listId);
		model.addAttribute("todolist", todoList);
		
		String username = principal.getName();
		model.addAttribute("todoListUser", username);
		
		return "todolist-form";
	}

	//Handling tasks
	//
	
	@PostMapping(value="/manageTodoList", params="addTask")
	public String addTask(@ModelAttribute("todoList") TodoList todoList, @RequestParam("task") String task) {
		Task newTask = new Task();
		newTask.setTask(task);
		newTask.setTodoList(todoList);
		
		todoListService.addTask(newTask);
		
		return "redirect:/";
	}
	
	@GetMapping("/deleteTask")
	public String deleteTask(@ModelAttribute("taskId") int taskId) {
		todoListService.deleteTask(taskId);
		
		return "redirect:/";
	}
	
	@GetMapping("/updateTaskForm")
	public String updateTaskForm(@ModelAttribute("taskId") int taskId, Model model) {
		Task task = todoListService.getTask(taskId);
		model.addAttribute("task", task);
		
		return "update-task-form";
	}
	
	@PostMapping("/updateTask")
	public String updateTask(@ModelAttribute("task") Task task) {
		todoListService.updateTask(task);
		
		return "redirect:/";
	}
	
	
	@PostMapping(value="/manageTodoList", params="toggleDone")
	public String setAsDone(@ModelAttribute("todoList") TodoList todoList, @RequestParam("toggleDone") int taskIndex) {
		Task task = todoList.getTasks().get(taskIndex);
		int done = task.getDone();
		if (done == 1) {
			done = 0;
		} else {
			done = 1;
		}
		todoListService.toggleDone(task, done);
		return "redirect:/";
	}
	
} 
