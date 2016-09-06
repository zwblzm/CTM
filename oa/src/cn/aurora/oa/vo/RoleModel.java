package cn.aurora.oa.vo;

import java.util.LinkedHashSet;
import java.util.Set;

public class RoleModel {

	private String id;
	private String name;
	private String description;
	private Set<UserModel> users = new LinkedHashSet<UserModel>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<UserModel> getUsers() {
		return users;
	}
	public void setUsers(Set<UserModel> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "RoleModel [id=" + id + ", name=" + name + ", description="
				+ description + ", users=" + users + "]";
	}
	
	
	
	
	
	
}
 