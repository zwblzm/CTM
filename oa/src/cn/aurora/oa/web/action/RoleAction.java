package cn.aurora.oa.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.aurora.oa.base.BaseAction;
import cn.aurora.oa.vo.RoleModel;
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<RoleModel>{
	
	
	
	public String roleList() {
		List<RoleModel> roleList =  roleEbi.findAllRole();
		ActionContext.getContext().getValueStack().set("roleList", roleList);
		return "roleList";
	}
	
	/**
	 * 新建岗位界面
	 * @return
	 */
	public String roleSavePage() {
		return "roleSavePage";
	}
	/**
	 * 添加新建岗位
	 * @return
	 */
	public String roleSave() {
		roleEbi.roleSave(model);
		return "roleSaveSuccess";
	}
	/**
	 * 删除岗位信息
	 * @return
	 */
	public String roleDelete() {
		
		roleEbi.roleDelete(model.getId());
		return "roleDeleteSuccess";
	}
	
	public String roleUpdate() {
		roleEbi.roleUpdate(model);
		return "roleUpdateSuccess";
	}
	
	public String roleUpdatePage() {
		RoleModel role = roleEbi.roleFindById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "roleUpdatePage";
	}
	
	
	
	public String privilegeUIPage() {
		return "privilegeUIPage";
	}

}
