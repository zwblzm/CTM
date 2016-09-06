package cn.aurora.oa.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.Source;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	
	@Resource(name="sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	Class<T> clazz;
	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] types = type.getActualTypeArguments();
		clazz = (Class<T>) types[0];
		
	}
	
	
	
	
	
	
	

	







	@Override
	public void saveModel(T model) {
		this.getHibernateTemplate().save(model);
		
	}

	@Override
	public void deleteModelById(String id) {
		this.getHibernateTemplate().delete(this.getSessionFactory().getCurrentSession().get(clazz, id));
		
		
		
	}

	@Override
	public void updateModel(T model) {
		this.getHibernateTemplate().update(model);
		
	}

	@Override
	public List<T> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
		List<T> Models = this.getHibernateTemplate().findByCriteria(criteria);
		return Models;
	}

	@Override
	public T findById(String id) {
		
		return (T) this.getSession().get(clazz, id);
	}

	@Override
	public List<T> findByIds(String[] ids) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
}
