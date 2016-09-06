package cn.aurora.oa.business.ebi;

import java.util.List;

import cn.aurora.oa.vo.RoleModel;

public interface RoleEbi {

	List<RoleModel> findAllRole();

	void roleSave(RoleModel model);

	void roleDelete(String id);

	void roleUpdate(RoleModel model);

	RoleModel roleFindById(String id);

}
