package cn.aurora.ctm.model;

import java.util.List;


public class TestCase {
	private Long id;
	private String name;
	private String description;
	private String[] premise;
	private String level;
	private String method;
	private String status;
	private String author;
	private Long createTime;
	private List<CaseStep> steps;
	
	private String version;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getPremise() {
		return premise;
	}

	public void setPremise(String[] premise) {
		this.premise = premise;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public List<CaseStep> getSteps() {
		return steps;
	}

	public void setSteps(List<CaseStep> steps) {
		this.steps = steps;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	
}
