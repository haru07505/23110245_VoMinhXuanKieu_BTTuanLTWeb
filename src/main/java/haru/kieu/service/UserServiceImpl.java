package haru.kieu.service;

import haru.kieu.dao.UserDao;
import haru.kieu.dao.UserDaoImpl;
import haru.kieu.model.User;
import haru.kieu.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();

	@Override
	public User login(String username, String password) {
		User user = this.findByUserName(username.trim());
		if (user != null && password.trim().equals(user.getPassWord().trim())) {
			return user;
		}
		return null;
	}

	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(username);
	}

}
