package cn.aurora.oa.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.aurora.oa.base.BaseAction;
import cn.aurora.oa.vo.DepartmentModel;
@Controller
@Scope("prototype")
/**
 * 部门控制层
 * @author Administrator
 *
 */
public class DepartmentAction extends BaseAction<DepartmentModel>{
	
	/**
	 * 列表界面
	 * @return
	 */
	public String departmentListPage() {
		List<DepartmentModel> departments = departmentEbi.findAllDepartment();
		setValueStack("departments", departments);
		
		return "departmentListPage";
	}
	
	
	public String departmentDelete() throws IOException {
		DepartmentModel department = departmentEbi.departmentFindById(model.getId());
		if(null == department) {
			ServletActionContext.getPageContext().getOut().write("<script type='text/javascript'>alert('部门不存在')</script>");
		}
		return null;
	}
	
	public String departmentUpdatePage() {
		DepartmentModel department = departmentEbi.departmentFindById(model.getId());
		setPush(department);
		return "departmentUpdatePage";
	}
}
