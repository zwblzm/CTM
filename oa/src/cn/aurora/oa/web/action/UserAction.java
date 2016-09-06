package cn.aurora.oa.web.action;

import java.util.List;

import cn.aurora.oa.base.BaseAction;
import cn.aurora.oa.vo.UserModel;

public class UserAction extends BaseAction<UserModel>{
	
	public String userList() {
		List<UserModel> users = userEbi.findAllUser();
		return null;
	}

}
