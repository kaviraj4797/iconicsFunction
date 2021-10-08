package com.iconicsbooking.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iconicsbooking.model.Status;
import com.iconicsbooking.model.Task;

@Repository
public interface TaskServiceRepository extends JpaRepository<Task,Integer>{
	
	List<Task> findByOrganiser(String organiserName);
	List<Task> findByTaskName(String taskName);
	
	
	List<Task> findByStartDate(LocalDate startDate);
	List<Task> findByEndDate(LocalDate endDate);
	List<Task> findByRating(double rating);
	List<Task> findByStatus(Status status);
//	@Modifying
//	@Query(value="update task set status=?1 where task_id=?2",nativeQuery=true)
//	int changeStatus(Status status,int taskId);
//	@Modifying
//	@Query(value="update task_service set event_id=?1 where task_id=?2",nativeQuery = true)
//	int assignTask(int eventId, int taskId);
}










