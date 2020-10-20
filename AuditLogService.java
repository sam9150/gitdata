package com.rumango.service;

import java.net.InetAddress;
import java.sql.Timestamp;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rumango.controller.LoginController;
import com.rumango.dao.AuditLogRepository;
import com.rumango.model.AuditLog;

@Service
public class AuditLogService 
{
	@Autowired
	private AuditLogRepository repository;

	private final static Logger logger = Logger.getLogger(AuditLogService.class);

	public void saveAuditLog(String screenName,String action,String createdBy,String authBy, Timestamp startTime,Timestamp endTime)
	{
		AuditLog auditLog = new AuditLog();
		try {
			auditLog = new AuditLog();
			auditLog.setIpAddress(InetAddress.getLocalHost().getHostAddress());
			auditLog.setMachine(InetAddress.getLocalHost().getHostName());
			auditLog.setUserId(LoginController.loggedUser);
			auditLog.setAction(action);
			auditLog.setScreenName(screenName);
			auditLog.setStartTime(startTime);
			auditLog.setEndTime(endTime);
			auditLog.setCreatedBy(LoginController.loggedUser);
			auditLog.setAuthorizeBy(authBy);

			System.err.println(auditLog);

			repository.save(auditLog);
		} catch (Exception e) {
			if(LoginController.loggerSwitch.equals("true"))
			{
				logger.error("Exception occurred in saveAuditLog method ",e);
			}
		}

	}

	public List<AuditLog> getLogByScreenService(String screenName)
	{
		List<AuditLog> log = null;
		try
		{
			log = repository.getLogByScreen(screenName);
			System.err.println(log);
		}
		catch (Exception e) {
			if(LoginController.loggerSwitch.equals("true"))
			{
				logger.error("Exception occurred in getLogByScreenService method ",e);
			}
		}

		return log;

	}


}
