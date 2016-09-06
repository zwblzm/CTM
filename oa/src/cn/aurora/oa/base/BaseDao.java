package cn.aurora.oa.base;

import java.util.List;

public interface BaseDao<T> {
	
	public void saveModel(T model);
	public void deleteModelById(String id);
	public void updateModel(T model);
	public List<T> findAll();
	public T findById(String id);
	public List<T> findByIds(String[] ids);

}
