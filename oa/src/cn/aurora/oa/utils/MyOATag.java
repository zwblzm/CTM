package cn.aurora.oa.utils;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyOATag extends SimpleTagSupport{
	
	@Override
	public void doTag() throws JspException, IOException {
		PageContext context = (PageContext) getJspContext();
		
		getJspContext().getOut().write(context.getServletContext().getContextPath());
	}

}
