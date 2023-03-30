package com.task.planner.services;

import java.util.List;

import com.task.planner.dtos.SprintDTO;
import com.task.planner.dtos.TaskDTO;
import com.task.planner.dtos.UserDTO;
import com.task.planner.entities.Task;
import com.task.planner.enums.Priority;
import com.task.planner.enums.Status;
import com.task.planner.exceptions.NoRecordFoundException;

public interface TaskService {

	/**
	 * 
	 * @param taskDTO : Object of TaskDTO contains all details of task.
	 * @return : TaskDTO object that has been inserted into the database.
	 */
	public TaskDTO createTask(TaskDTO taskDTO);

	/**
	 * 
	 * @param taskId : Integer if which will be used to find task object in
	 *               database.
	 * @return : TaskDTO object that has been found into the database.
	 * @throws NoRecordFoundException : If Task object does not present then
	 *                                NoRecordFoundException exception will thrown
	 *                                at runtime.
	 */
	public TaskDTO getTaskById(Integer taskId) throws NoRecordFoundException;

	/**
	 * 
	 * @param taskId  : Integer if which will be used to find task object in
	 *                database.
	 * @param taskDTO : object of TaskDTO which contains details that needs to be
	 *                updated.
	 * @return : Updated taskDTO object.
	 * @throws NoRecordFoundException : If Task object does not present then
	 *                                NoRecordFoundException exception will thrown
	 *                                at runtime.
	 */
	public TaskDTO updateTask(Integer taskId, TaskDTO taskDTO) throws NoRecordFoundException;

	/**
	 * 
	 * @param taskId : Integer if which will be used to find task object in
	 *               database.
	 * @return : String message which contains information about the operation
	 *         weather it succeeded or not.
	 * @throws NoRecordFoundException : If Task object does not present then
	 *                                NoRecordFoundException exception will thrown
	 *                                at runtime.
	 */
	public String deleteTask(Integer taskId) throws NoRecordFoundException;

	/**
	 * 
	 * @return : List<TaskDTO> which contains all information about tasks.
	 * @throws NoRecordFoundException : If we don't found any task then we throw
	 *                                NoRecordFoundException.
	 */
	public List<TaskDTO> getAllTasks() throws NoRecordFoundException;

	/**
	 * 
	 * @param taskId : To find task in database.
	 * @return : User which belongs to particular task.
	 * @throws NoRecordFoundException : If task or user not found then
	 *                                NoRecordFoundException will be thrown.
	 */
	public UserDTO getUserByTaskId(Integer taskId) throws NoRecordFoundException;

	/**
	 * 
	 * @param taskId : To find task in database.
	 * @return : Sprint from which this task belongs.
	 * @throws NoRecordFoundException : If task or sprint not found then
	 *                                NoRecordFoundException will be thrown.
	 */
	public SprintDTO getSprintByTaskId(Integer taskId) throws NoRecordFoundException;

	/**
	 * 
	 * @param taskId : To find task in database.
	 * @return : String message contains information about operation.
	 * @throws NoRecordFoundException : If task not found then
	 *                                NoRecordFoundException will be thrown.
	 */
	public String changeStatusOfTask(Integer taskId, Status status) throws NoRecordFoundException;

	/**
	 * 
	 * @param taskId : To find task in database.
	 * @return : String message contains information about operation.
	 * @throws NoRecordFoundException : If task not found then
	 *                                NoRecordFoundException will be thrown.
	 */
	public String changePriorityOfTask(Integer taskId, Priority priority) throws NoRecordFoundException;

	/**
	 * 
	 * @return : List<Task> All tasks which does not assigned to any Sprint.
	 * @throws NoRecordFoundException : If no any task found then will throw
	 *                                NoRecordFoundException.
	 */
	public List<Task> getAllTasksWithoutSprint() throws NoRecordFoundException;

	/**
	 * 
	 * @param priority : To search as per provided priority.
	 * @return : List<Task> object with sorting order.
	 * @throws NoRecordFoundException : If no any task found the exception will be
	 *                                thrown at runtime.
	 */
	public List<Task> getAllTasksWithoutSprintSortByPriority(Priority priority) throws NoRecordFoundException;

}
