package com.uttara.spring;

import org.springframework.stereotype.Component;

@Component
public class MVCServiceImpl implements MVCService {

	public MVCServiceImpl() {
		System.out.println("in MVCServiceImpl->no-arg constr");
	}
	public String getWelcomeMessage(InputBean bean) {
		
		System.out.println("in MVCServiceImpl->getWelcomeMessage() bean = "+bean);
		
		String msg = "Welcome "+bean.getUname();
		if(bean.getAge() < 40)
			msg = msg + ", howdy Youngster?!";
		else
			msg = msg +", namasthe oldie-goldie";
		
		return msg;
	}

}
