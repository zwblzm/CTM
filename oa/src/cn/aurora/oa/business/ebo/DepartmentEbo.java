package cn.aurora.oa.business.ebo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.aurora.oa.business.ebi.DepartmentEbi;
import cn.aurora.oa.dao.dao.DepartmentDao;
import cn.aurora.oa.vo.DepartmentModel;
/**
 * 部门业务层实现类
 * @author Administrator
 *
 */
@Service
public class DepartmentEbo implements DepartmentEbi{
	@Resource
	private DepartmentDao departmentDao;

	@Override
	public List<DepartmentModel> findAllDepartment() {
		List<DepartmentModel> departments = departmentDao.findAll();
		return departments;
	}

	@Override
	public DepartmentModel departmentFindById(String id) {
		DepartmentModel department = departmentDao.findById(id);
		return department;
	}
	
	
	
}
