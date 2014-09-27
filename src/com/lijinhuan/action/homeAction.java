package com.lijinhuan.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
@Component
@Scope("prototype")
public class homeAction extends ActionSupport{

	public String index() {
		return "index";
	}
	public String left() {
		return "left";
	}
	public String right() {
		return "right";
	}
	public String head() {
		return "head";
	}
	public String tail() {
		return "tail";
	}
	
}
