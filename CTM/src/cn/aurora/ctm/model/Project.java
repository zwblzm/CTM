package cn.aurora.ctm.model;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private Long id;
	private String name;
	private List<TestSuite> suite = new ArrayList<TestSuite>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TestSuite> getSuite() {
		return suite;
	}
	public void setSuite(List<TestSuite> suite) {
		this.suite = suite;
	}
	
	
}
