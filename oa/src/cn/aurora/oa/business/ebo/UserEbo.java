package cn.aurora.oa.business.ebo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.aurora.oa.business.ebi.UserEbi;
import cn.aurora.oa.dao.dao.UserDao;
import cn.aurora.oa.vo.UserModel;
@Service
public class UserEbo implements UserEbi{
	@Resource
	private UserDao userDao;
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<UserModel> findAllUser() {
		List<UserModel> users = userDao.findAll();
		return users;
	}

}
