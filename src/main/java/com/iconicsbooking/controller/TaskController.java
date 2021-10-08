package com.iconicsbooking.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iconicsbooking.model.Status;
import com.iconicsbooking.model.Task;
import com.iconicsbooking.model.Workers;
import com.iconicsbooking.service.ITaskService;

@RestController
@RequestMapping("/task-api")
public class TaskController {
	
	@Autowired
	ITaskService taskService;
	
	@GetMapping("/tasks")
	public List<Task> getAllTasks(){
		return taskService.getAllTasks();
	}

	@PostMapping("/tasks")
	ResponseEntity<Task>addTask(@RequestBody Task task){
		Task ntask=taskService.addTask(task);
		HttpHeaders headers= new HttpHeaders();
		headers.add("desc","task added sucessFully");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(ntask);
	}
	
	@GetMapping("tasks/taskId/{taskId}")
	ResponseEntity<Task> getBytaskId(@PathVariable("taskId") int taskId) {
		Task ntaskId=taskService.getBytaskId(taskId);
		return ResponseEntity.status(HttpStatus.OK).body(ntaskId);	
	}
	
	@GetMapping("tasks/delete/{taskId}")
	ResponseEntity<String> deleteTask(@PathVariable("taskId")int taskId){
		taskService.deleteTask(taskId);
		return ResponseEntity.status(HttpStatus.OK).body("deleted successfully");	
		
	}
//	Task updateTask(Task taskService);
//	
	@GetMapping("tasks/taskName/{name}")
	ResponseEntity<List<Task>> getByTaskName(@PathVariable("name")String taskName){
		List<Task> ntaskName=taskService.getByTaskName(taskName);
		return ResponseEntity.status(HttpStatus.OK).body(ntaskName);
		
	}
//	
//	List<Task>getByTaskStartDate(LocalDate startDate);
	
	@GetMapping("tasks/stratDate/{date}")
	ResponseEntity<List<Task>> getByTaskStartDate(@PathVariable("date")LocalDate startDate){
		List<Task> localDates=taskService.getByTaskStartDate(startDate);
		return ResponseEntity.status(HttpStatus.OK).body(localDates);
		
	}
//	List<Task>getByTaskEndDate(LocalDate endDate);
	
	@GetMapping("tasks/endDate/{date}")
	ResponseEntity<List<Task>> getByTaskEndDate(@PathVariable("date")LocalDate endDate){
		List<Task> localDates=taskService.getByTaskEndDate(endDate);
		return ResponseEntity.status(HttpStatus.OK).body(localDates);
		
	}
//	List<Task>getByRating(double rating);
	
	@GetMapping("tasks/rating/{rating}")
	ResponseEntity<List<Task>> getByRating(@PathVariable("rating")double rating){
		List<Task> ratings=taskService.getByRating(rating);
		return ResponseEntity.status(HttpStatus.OK).body(ratings);
		
	}
//	List<Task>getByStatus(Status status);
	

	@GetMapping("tasks/status/{status}")
	ResponseEntity<List<Task>> getByStatus(@PathVariable("status")Status status){
		List<Task> statuses=taskService.getByStatus(status);
		return ResponseEntity.status(HttpStatus.OK).body(statuses);
		
	}
	
	
	
	
	@GetMapping("/tasks/organiser/{organiser}")
	public ResponseEntity<List<Task>> getByOrganiser(@PathVariable("organiser") String organizerName){
		List<Task> organiserList=taskService.getByOrganiser(organizerName);
		return ResponseEntity.status(HttpStatus.OK).body(organiserList);
	}
	
	@GetMapping("/tasks/workerstatus/{workerstatus}")
	public ResponseEntity<List<Workers>> getByWorkerStatus(@PathVariable("workerstaus") String workerstatus){
		List<Workers> workerStatusList=taskService.getByWorkerStatus(workerstatus);
		return ResponseEntity.status(HttpStatus.OK).body(workerStatusList);
	}
	

	@GetMapping("/tasks/workers")
	public ResponseEntity<List<Workers>> getAllWorkers(){
		List<Workers> workersList=taskService.getAllWorkers();
		return ResponseEntity.status(HttpStatus.OK).body(workersList);
	}
	
	@GetMapping("/tasks/workers/jobtype/{type}")
	public ResponseEntity<List<Workers>> getByJobType(@PathVariable("type") String type){
		List<Workers> jobType=taskService.getByJobType(type);
		return ResponseEntity.status(HttpStatus.OK).body(jobType);
	}
//	
	@GetMapping("/tasks/workers/taskId/{taskId}/workerId/{workerId}")
	public ResponseEntity<String> assignTaskToResource(@PathVariable("taskId") int taskId, @PathVariable("workerId") int workerId){
		 String message=taskService.assignTaskToResource(taskId, workerId);
		 return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	@GetMapping("/tasks/workers/workerId/{workerId}")
	public ResponseEntity<String> freeResource(@PathVariable("workerId") int workerId) {
		String message=taskService.freeResource(workerId);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	}

	

