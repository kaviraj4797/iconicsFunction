package com.iconicsbooking.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.iconicsbooking.model.Availability;
import com.iconicsbooking.model.Status;
import com.iconicsbooking.model.Task;
import com.iconicsbooking.model.Workers;
import com.iconicsbooking.repository.TaskServiceRepository;

@Service
public class TaskServiceImpl implements ITaskService{
	
	@Autowired
	TaskServiceRepository taskServiceRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	public static final String BASEURL="http://localhost:8080/worker-api/";

	public void setTaskServiceRepo(TaskServiceRepository taskServiceRepo) {
		this.taskServiceRepo = taskServiceRepo;
	}

	@Override
	public Task addTask(Task taskService) {
		// TODO Auto-generated method stub
		return taskServiceRepo.save(taskService);
	}

	@Override
	public Task getBytaskId(int taskId) {
		// TODO Auto-generated method stub
		return taskServiceRepo.findById(taskId).get();
	}

	@Override
	public void deleteTask(int taskId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Task updateTask(Task taskService) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return taskServiceRepo.findAll();
	}

	@Override
	public List<Task> getByOrganiser(String organiserName) {
		// TODO Auto-generated method stub
		return taskServiceRepo.findByOrganiser(organiserName);
	}

	@Override
	public List<Task> getByTaskName(String taskName) {
		// TODO Auto-generated method stub
		return taskServiceRepo.findByTaskName(taskName);
	}

	@Override
	public List<Task> getByTaskStartDate(LocalDate startDate) {
		// TODO Auto-generated method stub
		return taskServiceRepo.findByStartDate(startDate);
	}

	@Override
	public List<Task> getByTaskEndDate(LocalDate endDate) {
		// TODO Auto-generated method stub
		return taskServiceRepo.findByEndDate(endDate);
	}

	@Override
	public List<Task> getByRating(double rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getByStatus(Status status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Workers> getByWorkerStatus(String status){
	 	String url= BASEURL+"worker/status"+status;	
	 	ResponseEntity<List> response=restTemplate.getForEntity(url, List.class);
		HttpHeaders headers= response.getHeaders();
		List<String> header= headers.get("desc");
		System.out.println(response.getStatusCodeValue()+"    "+header);
		return response.getBody();
 	}

	
	@Override
	public List<Workers> getAllWorkers(){
	 	String url= BASEURL+"worker/";	
	 	ResponseEntity<List> response=restTemplate.getForEntity(url, List.class);
		HttpHeaders headers= response.getHeaders();
		List<String> header= headers.get("desc");
		System.out.println(response.getStatusCodeValue()+"    "+header);
		return response.getBody();
 	}

	

	

	@Override
	public List<Workers> getByJobType(String jobType) {
		String url= BASEURL+"worker/jobtype"+jobType;	
	 	ResponseEntity<List> response=restTemplate.getForEntity(url, List.class);
		HttpHeaders headers= response.getHeaders();
		List<String> header= headers.get("desc");
		System.out.println(response.getStatusCodeValue()+"    "+header);
		return response.getBody();
	}

	@Override
	public String assignTaskToResource(int taskId, int workerId) {
		String url=BASEURL+"worker/jobtype";
		ResponseEntity<String> response=restTemplate.getForEntity(url, String.class);
		HttpHeaders headers= response.getHeaders();
		List<String> header= headers.get("desc");
		System.out.println(response.getStatusCodeValue()+"    "+header);
		return response.getBody();
		
		
		
	}

	

	@Override
	public String freeResource(int workerId) {
		String url=BASEURL;
		ResponseEntity<String> response=restTemplate.getForEntity(url, String.class);
		HttpHeaders headers= response.getHeaders();
		List<String> header= headers.get("desc");
		System.out.println(response.getStatusCodeValue()+"    "+header);
		return response.getBody();
		
	}
	

}
