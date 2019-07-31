package kulnaja.work.tracking.repository.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import kulnaja.work.tracking.model.TaskModel;
import kulnaja.work.tracking.repository.TaskRepository;

@Repository
public class TaskRepositoryImp implements TaskRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public boolean addTask() throws Exception {
		System.out.println("#### TaskRepositoryImp.addTask");
		System.out.println("namedParameterJdbcTemplate : " + namedParameterJdbcTemplate);
		
		Date d = new Date();
		
		boolean result = false;
		StringBuilder sql = null;
		
		try {
			sql = new StringBuilder();
			sql.append("INSERT INTO KULTASK(TASK_ID, NAME, VALUE, CREATE_DATE, UPDATE_DATE)");
			sql.append("VALUES (:id, :name, :value, SYSDATE, SYSDATE)");
			
			System.out.println("sql.toString() :: "+sql.toString());
			
			SqlParameterSource namedParameters = new MapSqlParameterSource()
					.addValue("id", 1)
					.addValue("name", "test"+d.getTime())
					.addValue("value", "val"+d.getTime());
			
			int rec = namedParameterJdbcTemplate.update(sql.toString(), namedParameters);
			
			if (rec > 0) {
				result = true;
			}

		} catch(Exception e) {
			e.printStackTrace();
//			LOGGER.error(" insertTxnLogPad : " + e.getMessage());
//			throw e;
		}
		
		return result;
		
	}

	@Override
	public List<TaskModel> findAll() throws Exception {
		StringBuilder sqlBuild = null;
		List<TaskModel> taskModel = null;
		try {
			sqlBuild = new StringBuilder();
			sqlBuild.append("SELECT * FROM KULTASK ");
			
			taskModel = namedParameterJdbcTemplate.query(sqlBuild.toString(), new RowMapper<TaskModel>() {				
						@Override
						public TaskModel mapRow(ResultSet rs, int rowNum) throws SQLException {
							TaskModel taskModel = new TaskModel();
							taskModel.setTaskId(Integer.parseInt(rs.getString("TASK_ID")));
							taskModel.setName(rs.getString("NAME"));
							taskModel.setValue(rs.getString("VALUE"));
							taskModel.setCreateDate(rs.getString("CREATE_DATE"));
							taskModel.setUpdateDate(rs.getString("UPDATE_DATE"));
							
							return taskModel;
						}
					}
			);
		} catch (Exception e) {
			e.printStackTrace();
			//LOGGER.error("findDetailNationalparkByReserve Error : " + e.getMessage());
		}
		return taskModel;
	}

	@Override
	public List<TaskModel> findByName(String name) throws Exception {
		StringBuilder sqlBuild = null;
		List<TaskModel> taskModel = null;
		try {
			sqlBuild = new StringBuilder();
			sqlBuild.append("SELECT * FROM KULTASK WHERE NAME = :name ");
			
			SqlParameterSource namedParameters = new MapSqlParameterSource()
					.addValue("name", name);
			
			taskModel = namedParameterJdbcTemplate.query(sqlBuild.toString(), namedParameters, new RowMapper<TaskModel>() {			
						@Override
						public TaskModel mapRow(ResultSet rs, int rowNum) throws SQLException {
							TaskModel taskModel = new TaskModel();
							taskModel.setTaskId(Integer.parseInt(rs.getString("TASK_ID")));
							taskModel.setName(rs.getString("NAME"));
							taskModel.setValue(rs.getString("VALUE"));
							taskModel.setCreateDate(rs.getString("CREATE_DATE"));
							taskModel.setUpdateDate(rs.getString("UPDATE_DATE"));
							
							return taskModel;
						}
					}
			);
		} catch (Exception e) {
			e.printStackTrace();
			//LOGGER.error("findDetailNationalparkByReserve Error : " + e.getMessage());
		}
		return taskModel;
	}
	
	
	
//	@Override
//	public boolean insertLogpda(LogPdaModel logPdaModel) throws Exception {
//		StringBuilder sql = null;
//		boolean isSuccess = false;
//		try {
//			sql = new StringBuilder();
//			sql.append("INSERT INTO ").append(AppUtil.DB_SCHEMA).append("log_pda_entrance ( ");
//			sql.append("			entrance_Channel,PERFORM_ID, ROUND_TIME_ID, RESERVE_ID, status, user_id  ");
//			sql.append("		  , entrance_DATE  ");
//			sql.append("	) VALUES ( ");
//			sql.append("		  :entranceChannel , :performID , :roundtimeID, :reserveID, :status, :user_id  ");
//			sql.append("		, CURTIME() ");
//			sql.append(" )");
//			
//			SqlParameterSource namedParameters = new MapSqlParameterSource()
//					.addValue("entranceChannel", logPdaModel.getEntrance_Channel())
//					.addValue("performID", logPdaModel.getPERFORM_ID())
//					.addValue("roundtimeID", logPdaModel.getROUND_TIME_ID())
//					.addValue("reserveID", logPdaModel.getRESERVE_ID())
//					.addValue("status", logPdaModel.getStatus())
//					.addValue("user_id", logPdaModel.getUser_id());
//			
//			int rec = namedParameterJdbcTemplate.update(sql.toString(), namedParameters);
//			
//			System.out.println("sql.toString() :: "+sql.toString());
//			
//			if (rec > 0) {
//				isSuccess = true;
//			}
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOGGER.error(" insertTxnLogPad : " + e.getMessage());
//			throw e;
//		}
//		return isSuccess;
//	}

}
