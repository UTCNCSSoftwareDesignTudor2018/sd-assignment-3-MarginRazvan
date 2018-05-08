package com.NewsAgency.business.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class SpringAplicationContext implements ApplicationContextAware{

	private static ApplicationContext CONTEXT;
	
	public static <T> T getBean(Class<T> bean)
	{
		return CONTEXT.getBean(bean);
	}
	
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		CONTEXT = arg0;
		
	}

}
