package com.coreSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements MessageService {

	@Autowired
	MessageDAO dao;
	
	public ServiceImpl() {
		System.out.println("In serviceImpl--> no arg cons");
	}

	public String showMessage() {
		System.out.println("in serviceimpl--> showmsg()");

		return dao.getMesageFromDB();
	}

}
