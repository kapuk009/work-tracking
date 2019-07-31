package kulnaja.work.tracking.repository;

import java.util.List;

import kulnaja.work.tracking.model.TaskModel;

public interface TaskRepository {

		public boolean addTask() throws Exception ;
		public List<TaskModel> findAll() throws Exception ;
		public List<TaskModel> findByName(String name) throws Exception ;
}
