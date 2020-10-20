package com.rumango.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.rumango.model.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Integer>{
	
	@Query("from AuditLog where screenName=:screenName")
	public List<AuditLog> getLogByScreen(@Param("screenName")String screenName);

}
