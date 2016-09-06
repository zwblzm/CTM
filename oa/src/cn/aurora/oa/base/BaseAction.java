package cn.aurora.oa.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import cn.aurora.oa.business.ebi.DepartmentEbi;
import cn.aurora.oa.business.ebi.RoleEbi;
import cn.aurora.oa.business.ebi.UserEbi;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

	@Resource
	protected UserEbi userEbi;
	@Resource
	protected RoleEbi roleEbi;
	@Resource
	protected DepartmentEbi departmentEbi;
	
	protected T model;
	public BaseAction() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] types = type.getActualTypeArguments();
		Class<T> clazz = (Class<T>) types[0];
		try {
			model=clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	/**
	 * 将参数压到值栈中
	 * @param name
	 * @param obj
	 */
	
	public void setValueStack(String name, Object obj) {
		ActionContext.getContext().getValueStack().set(name, obj);
	}
	public void setPush(Object obj) {
		ActionContext.getContext().getValueStack().push(obj);
	}


	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	
	
	
	
	
}
