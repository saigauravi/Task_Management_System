package com.sb.sms.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.sms.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
