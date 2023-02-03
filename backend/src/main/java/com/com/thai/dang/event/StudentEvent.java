package com.com.thai.dang.event;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.com.thai.dang.entity.EntityEvent;
import com.com.thai.dang.entity.Student;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;

public class StudentEvent implements EntityEvent<Student> {

	private static Log log = LogFactory.getLog(StudentEvent.class);

	@Override
	@PrePersist
	public void beforeAdd(Student t) {
		log.info("Before Add student: " + "ID:" + t.getPkIdStudent() + ", LastName:" + t.getLastName() + ", FirstName:"
				+ t.getFirstName());
	}

	@Override
	public void beforeUpdate(Student t) {
		// TODO Auto-generated method stub

	}

	@Override
	@PreRemove
	public void beforeDelete(Student t) {
		log.info("Before Remove student: " + "ID:" + t.getPkIdStudent() + ", LastName:" + t.getLastName()
				+ ", FirstName:" + t.getFirstName());
	}

	@Override
	@PostLoad
	public void afterLoad(Student t) {
		log.info("After Load student: " + "ID:" + t.getPkIdStudent() + ", LastName:" + t.getLastName() + ", FirstName:"
				+ t.getFirstName());
	}

	@Override
	@PostPersist
	public void afterSave(Student t) {
		log.info("After Add student: " + "ID:" + t.getPkIdStudent() + ", LastName:" + t.getLastName() + ", FirstName:"
				+ t.getFirstName());
	}

	@Override
	public void afterUpdate(Student t) {
		// TODO Auto-generated method stub

	}

	@Override
	@PostRemove
	public void afterDelete(Student t) {
		log.info("After Delete student: " + "ID:" + t.getPkIdStudent() + ", LastName:" + t.getLastName()
				+ ", FirstName:" + t.getFirstName());

	}

}
