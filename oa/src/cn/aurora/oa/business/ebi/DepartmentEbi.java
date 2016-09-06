package cn.aurora.oa.business.ebi;

import java.util.List;

import cn.aurora.oa.vo.DepartmentModel;

public interface DepartmentEbi {

	List<DepartmentModel> findAllDepartment();

	DepartmentModel departmentFindById(String id);

}
