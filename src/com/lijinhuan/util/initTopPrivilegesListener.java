package com.lijinhuan.util;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lijinhuan.model.Privilege;
import com.lijinhuan.service.PrivilegeService;

public class initTopPrivilegesListener implements ServletContextListener {


	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		PrivilegeService privilegeService = (PrivilegeService) applicationContext.getBean("privilegeService");
		List<Privilege> topPrivileges = privilegeService.getTopPrivileges();
		sce.getServletContext().setAttribute("topPrivileges", topPrivileges);
	}

}
