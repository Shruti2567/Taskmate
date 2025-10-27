package com.example.TaskMate.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskMate.dto.TaskMate;

public interface TaskMateRepo extends JpaRepository<TaskMate, Long>
{

}
