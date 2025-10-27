package com.example.TaskMate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskMate.dto.TaskMate;
import com.example.TaskMate.repo.TaskMateRepo;

@Service
public class TaskMateServiceImp implements TaskMateService{

	@Autowired
	private TaskMateRepo mateRepo ;
	
	
	
	@Override
	public List<TaskMate> getAllTask() {
		return mateRepo.findAll();
	}



	@Override
	public void addTask(TaskMate mate) {
		mateRepo.save(mate) ;
	}



	@Override
	public TaskMate getTaskById(Long id) {
		
		Optional<TaskMate> optional=mateRepo.findById(id) ;
		TaskMate mate=null;
		if (optional.isPresent()) 
		{
			mate=optional.get() ;
		}
		else {
			throw new RuntimeException("Task with Id: "+id+" not present") ;
		}
		
		return mate;
	}

	@Override
	public void deleteTaskById(Long id) {
		mateRepo.deleteById(id);		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
