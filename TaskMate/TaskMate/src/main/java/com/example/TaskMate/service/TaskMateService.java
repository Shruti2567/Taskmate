package com.example.TaskMate.service;

import java.util.List;

import com.example.TaskMate.dto.TaskMate;

public interface TaskMateService {
	List<TaskMate> getAllTask() ;
	void addTask(TaskMate mate) ;
	TaskMate getTaskById(Long id) ;
	
	void  deleteTaskById(Long id) ;
}
