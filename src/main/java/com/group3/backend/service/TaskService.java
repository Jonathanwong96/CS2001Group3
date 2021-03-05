package com.group3.backend.service;

import java.util.ArrayList;

import com.group3.backend.ui.model.request.TaskRequest;
import com.group3.backend.ui.model.response.TaskResponse;

public interface TaskService {
	TaskResponse createTask(TaskRequest taskRequest);
	TaskResponse editTask(TaskRequest taskRequest);
	ArrayList<TaskResponse> getAllTasksForHome(long careHomeId);
//	TaskResponse getTask(long taskId); 
//	Object deleteTask(long taskId); 
}
