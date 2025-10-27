package com.example.TaskMate.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.TaskMate.dto.TaskMate;
import com.example.TaskMate.service.TaskMateService;

@Controller
public class TaskMateController
{
 
	@Autowired
	private TaskMateService mateService ;
	
	//
	@GetMapping("/")
    public String homePage() {
        return "home";  // home.html opens first
    }
	
	 @GetMapping("/home")
	    public String homeAgain() {
	        return "home";
	    }
	 @GetMapping("/about")
	 public String aboutPage() {
	     return "about"; // This will open about.html
	 }

	 @GetMapping("/contact")
	 public String contactPage() {
	     return "contact"; // This will open contact.html
	 }
	 
	//display List Of tasks
	@GetMapping("/todo")
	public String viewTodoPage(Model model)
	{
		model.addAttribute("listTasks", mateService.getAllTask()) ;
		return "index" ;
		
	}
	
	
	//handler method to add New Task 
	@GetMapping("/addNewTaskForm")
	public String addNewTaskForm(Model model)
	{
		TaskMate taskMate =new TaskMate() ;
		model.addAttribute("taskMate", taskMate) ;
		return "add-new-task" ;
	}
	
	//Add Task
	@PostMapping("/addTask")
	public String addTask(@ModelAttribute("taskMate") TaskMate mate)
	{
		mateService.addTask(mate) ;
		return "redirect:/todo" ;
	}
	
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value="id") Long id, Model model)
	{
		TaskMate taskMate = mateService.getTaskById(id) ;
		model.addAttribute("taskMate", taskMate) ;
		return "update_task" ;
	}
	
	@GetMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable (value="id") Long id) 
	{
		mateService.deleteTaskById(id) ;
		return "redirect:/todo" ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}


