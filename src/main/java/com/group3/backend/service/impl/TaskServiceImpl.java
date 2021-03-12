package com.group3.backend.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.group3.backend.datasource.entity.CareHomeEntity;
import com.group3.backend.datasource.entity.CareWorkerEntity;
import com.group3.backend.datasource.entity.TaskEntity;
import com.group3.backend.datasource.repos.CareHomeRepository;
import com.group3.backend.datasource.repos.CareWorkerRepository;
import com.group3.backend.datasource.repos.TaskRepository;
import com.group3.backend.service.TaskService;
import com.group3.backend.service.helper.Utility;
import com.group3.backend.ui.model.request.TaskRequest;
import com.group3.backend.ui.model.response.ErrorMessages;
import com.group3.backend.ui.model.response.TaskResponse;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired 
    CareHomeRepository careHomeRepository;
	
	@Autowired
	CareWorkerRepository careWorkerRepository;
	
	@Override
	public TaskResponse createTask(TaskRequest taskRequest) {
		TaskResponse toReturn = new TaskResponse();
    	TaskEntity taskEntity = new TaskEntity();
        BeanUtils.copyProperties(taskRequest, taskEntity);
        
//        Optional<CareHomeEntity> resp = careHomeRepository.findById(taskRequest.getCareHomeId());
//        if (resp.isEmpty()) {
//        	throw new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorMessages.RESIDENT_NOT_FOUND.getErrorMessage());
//        }
        // dummy care home for local DB by id=7 {will have to make changes on the front-end before using the above for tasks}
    	Optional<CareHomeEntity> resp = careHomeRepository.findById((long) 7);
        CareHomeEntity defHome = resp.get();
        taskEntity.setCareHome(defHome);
        
        try {
        Optional<CareWorkerEntity> resp2 = careWorkerRepository.findById(taskRequest.getCareWorkerId());
        CareWorkerEntity taskWorker = resp2.get();
        taskEntity.setCareWorker(taskWorker);
        BeanUtils.copyProperties(taskRepository.save(taskEntity), toReturn);
        }catch(Exception ex) {
        	//if id is null don't assign worker
        	//perhaps create something for unassigned tasks(or require worker input in frontend)
            BeanUtils.copyProperties(taskRepository.save(taskEntity), toReturn, "careWorkerId");
        }
        
        toReturn.setOperationMessage("task added");
        toReturn.setCareHomeId(taskEntity.getCareHome().getCareHomeId());
        return toReturn;
	}
	
	@Override
    public TaskResponse editTask(TaskRequest taskRequest) {
		if (taskRepository.existsById(taskRequest.getTaskId())) {
    		Optional<TaskEntity> taskEnt = taskRepository.findById(taskRequest.getTaskId());
        	TaskEntity taskEntity = taskEnt.get();
        	TaskResponse toReturn = new TaskResponse();
        	
        	// possible nullpointer problem bellow -- fix coming soon™
        	try {
        	if(taskRequest.getCareWorkerId()!= taskEntity.getCareWorkerId()) {
        		Optional<CareWorkerEntity> resp2 = careWorkerRepository.findById(taskRequest.getCareWorkerId());
                CareWorkerEntity taskWorker = resp2.get();
                taskEntity.setCareWorker(taskWorker);
        	}
        	}catch(Exception ex) {
        		//temp solution for nullpointer trigered when task is unassigned
        		Optional<CareWorkerEntity> resp2 = careWorkerRepository.findById(taskRequest.getCareWorkerId());
                CareWorkerEntity taskWorker = resp2.get();
                taskEntity.setCareWorker(taskWorker);
        	}
            BeanUtils.copyProperties(taskRequest, taskEntity, Utility.getNullPropertyNames(taskRequest));
        	BeanUtils.copyProperties(taskRepository.save(taskEntity), toReturn);
            toReturn.setOperationMessage("edit Complete");
            return toReturn;
    	}
    	else {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorMessages.COULD_NOT_FIND.getErrorMessage());
    	}
	}
	
	@Override
    public ArrayList<TaskResponse> getAllTasksForHome(long careHomeId) {
		ArrayList<TaskResponse> toReturn = new ArrayList<>();
    	Optional<CareHomeEntity> resp = careHomeRepository.findById(careHomeId);
        CareHomeEntity careHome = resp.get();
        List<TaskEntity> allTasksForHome = careHome.getTasks();
        
        for (TaskEntity tEntity: allTasksForHome) {
        	TaskResponse tResponse = new TaskResponse();
        	try {
            BeanUtils.copyProperties(tEntity, tResponse);
        	}catch(Exception ex) {
        		// will throw nullpointer on null careWorkerId - temp solution
                BeanUtils.copyProperties(tEntity, tResponse, "careWorkerId");
        	}
            tResponse.setOperationMessage("task returned");
            tResponse.setCareWorkerName(tEntity.getCareWorker().getFullName());
            toReturn.add(tResponse);
        }
        return toReturn;
	}
	
	
//	To-dos left to do
	
//  getTask might not be needed
//	@Override
//    public TaskResponse getTask(long taskId) {
//		return null;
//	}
//
//	@Override
//	public Object deleteTask(long taskId) {
//		return null;
//	}
// changes and testing needed
}
