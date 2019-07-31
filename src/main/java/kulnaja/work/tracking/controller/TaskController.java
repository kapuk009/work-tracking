package kulnaja.work.tracking.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import kulnaja.work.tracking.service.TaskService;

@RestController
@RequestMapping("Task")
public class TaskController {
	
	//logback slf4j
	//Logger logger = LoggerFactory.getLogger(TaskController.class);
	
	//log4j2
	Logger logger = LogManager.getLogger(TaskController.class);
	
//	@Value("${param.test1}")
//	private String test1;

	@Autowired
	TaskService taskService;
	
	public TaskController() {
		System.out.println("#### @RestController : Constructor TaskController()");
	}
	
	
	@RequestMapping("/")
    public String index() {
		String uuid = UUID.randomUUID().toString();
		ThreadContext.put("uuid", uuid);
		logger.info("UUID : " + uuid);
		
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
 
        return "Howdy! Check out the Logs to see the output...";
    }
	
	@RequestMapping("/AddTask")
	public String addTask() {
		String result = "";
		
		try {
			System.out.println("#### TaskController.addTask");
			taskService.addTask();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	

	@RequestMapping("/UpdateTask")
	public String updateTask() {
		String result = "";
		
		try {
//			DbUtil.getInstance().getConnectionMySql("MySql Naja");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	@RequestMapping("/DeleteTask")
	public String deleteTask() {
		String result = "";
		
		
		return result;
	}
	
	@RequestMapping("/MoveTask")
	public String moveTask() {
		String result = "";
		
		
		return result;
	}
	
	@RequestMapping("/FindTask")
	public String findTask(@RequestParam(value = "name", required=false) String name) {
		String result = "";
		String data = "";
		
		System.out.println("name : " + name);
		
		try {
			System.out.println("#### TaskController.findTask");
			data = taskService.findTask(name);			
			
			result = createSuccessResponseString(true, data,"Success");
			
		} catch (Exception e) {
			e.printStackTrace();
			result = createSuccessResponseString(true, data, e.toString());
		}
		
		return result;
	}
	
	
	private String createSuccessResponseString(boolean isSuccess, String jsonData, String description) {
		return "{\"success\":" + isSuccess + " ,\"code\": \"100\" ," + " \"data\": " + jsonData + ", \"description\":\"" + description + "\"}";
	}
	
	public static String createExceptionResponseString(boolean isSuccess,String code, String desc) {
		//LOGGER.error("error code: " + code);
		return "{\"success\":" + isSuccess + " ,\"code\":" + code + ", \"description\":\"" + desc + "\"}";
	}
	
}
