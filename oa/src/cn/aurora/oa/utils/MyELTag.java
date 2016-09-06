package cn.aurora.oa.utils;

import org.apache.struts2.ServletActionContext;

public class MyELTag {

	public static String getPath() {
		
		return ServletActionContext.getServletContext().getContextPath(); 
	}
	
}
