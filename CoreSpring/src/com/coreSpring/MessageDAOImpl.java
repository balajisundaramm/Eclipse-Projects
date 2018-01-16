package com.coreSpring;

import org.springframework.stereotype.Repository;

@Repository
public class MessageDAOImpl implements MessageDAO {

	
	public MessageDAOImpl() {
		System.out.println("In DAOImpl--> no arg cons");
	}

	@Override
	public String getMesageFromDB() {
		System.out.println("In DAO impl--> getmsgFromDB()");
		return "This is joke.. ha ha ha";
	}

}
 