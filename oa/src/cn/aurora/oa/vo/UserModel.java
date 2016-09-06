package cn.aurora.oa.vo;

import java.util.LinkedHashSet;
import java.util.Set;

public class UserModel {
	private String id;
	private String realName;
	private String loginName;
	private Integer gender;
	private String telephone;
	private String email;
	private String remark;
	private DepartmentModel department;
	private Set<RoleModel> roles = new LinkedHashSet<RoleModel>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public DepartmentModel getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentModel department) {
		this.department = department;
	}
	public Set<RoleModel> getRoles() {
		return roles;
	}
	public void setRoles(Set<RoleModel> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", realName=" + realName
				+ ", loginName=" + loginName + ", gender=" + gender
				+ ", telephone=" + telephone + ", email=" + email + ", remark="
				+ remark + ", department=" + department + ", roles=" + roles
				+ "]";
	}
	
	
	
	
}
