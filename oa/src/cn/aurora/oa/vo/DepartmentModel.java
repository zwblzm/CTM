package cn.aurora.oa.vo;

import java.util.LinkedHashSet;
import java.util.Set;

public class DepartmentModel {
     private String id;
	 private String name;
	 private String description;
	 private DepartmentModel parent;
	 private Set<DepartmentModel> childrens = new LinkedHashSet<DepartmentModel>();
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
	public DepartmentModel getParent() {
		return parent;
	}
	public void setParent(DepartmentModel parent) {
		this.parent = parent;
	}
	public Set<DepartmentModel> getChildrens() {
		return childrens;
	}
	public void setChildrens(Set<DepartmentModel> childrens) {
		this.childrens = childrens;
	}
	@Override
	public String toString() {
		return "DepartmentModel [id=" + id + ", name=" + name
				+ ", description=" + description + ", parent=" + parent
				+ ", childrens=" + childrens + "]";
	}
	 
	 
	 
	
}
