package com.lijinhuan.test;

import javax.crypto.SealedObject;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testScehmaExport {

	ApplicationContext applicationContext = (ApplicationContext) new ClassPathXmlApplicationContext("applicationContext.xml");
	SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
	@Test
	public void test() {
		
	}
}
