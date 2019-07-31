package kulnaja.work.tracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import kulnaja.work.tracking.model.TaskModel;
import kulnaja.work.tracking.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	public void addTask() throws Exception {
		System.out.println("#### TaskService.addTask");
		taskRepository.addTask();
	}
	
	public String findTask(String name) throws Exception {
		List<TaskModel> list = null;
		String result = "";
		
		System.out.println("#### TaskService.findTask");
		
		if(name!=null && !name.equals("")) {
			list = taskRepository.findByName(name);
		} else {
			list = taskRepository.findAll();
		}
		
		if(list!=null) {
			Gson gson = new Gson();
			result = gson.toJson(list);
		} else {
			System.out.println("findTask list : null");
		}
		
		return result;
	}

}
