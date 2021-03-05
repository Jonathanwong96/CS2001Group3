package com.group3.backend.ui.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group3.backend.service.TaskService;
import com.group3.backend.ui.model.request.TaskRequest;
import com.group3.backend.ui.model.response.TaskResponse;

@RestController
@RequestMapping("task")
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@PostMapping
	TaskResponse createTask(@RequestBody TaskRequest taskRequest) {
		return taskService.createTask(taskRequest);
	};
	
	@PutMapping
	TaskResponse editTask(@RequestBody TaskRequest taskRequest) {
		return taskService.editTask(taskRequest);
	};
	
	@GetMapping(path="all")
	ArrayList<TaskResponse> getAllTasksForHome(@RequestParam long careHomeId){
		return taskService.getAllTasksForHome(careHomeId);
	};
//	
//	@GetMapping
//	TaskResponse getTask(@RequestParam long taskId) {
//		return taskService.getTask(taskId);
//	}; 
//	
//	@DeleteMapping(produces="application/json")
//	Object deleteTask(@RequestParam long taskId) {
//		return taskService.deleteTask(taskId);
//	}; 
}
