package cn.aurora.oa.business.ebo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.aurora.oa.business.ebi.RoleEbi;
import cn.aurora.oa.dao.dao.RoleDao;
import cn.aurora.oa.utils.UUIDUtils;
import cn.aurora.oa.vo.RoleModel;
@Service
public class RoleEbo implements RoleEbi{
	@Resource
	private RoleDao roleDao;
	@Override
	public List<RoleModel> findAllRole() {
		
		return roleDao.findAll();
	}
	@Override
	public void roleSave(RoleModel model) {
		model.setId(UUIDUtils.getUUID());
		roleDao.saveModel(model);
		
	}
	@Override
	public void roleDelete(String id) {
		roleDao.deleteModelById(id);
		
	}
	@Override
	public void roleUpdate(RoleModel model) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public RoleModel roleFindById(String id) {
		RoleModel role = roleDao.findById(id);
		return role;
	}

}
