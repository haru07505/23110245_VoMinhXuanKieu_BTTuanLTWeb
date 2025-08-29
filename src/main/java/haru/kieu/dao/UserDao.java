package haru.kieu.dao;

import haru.kieu.model.User;

public interface UserDao {
	User findByUserName(String username);
	boolean updatePassword(int id, String newPassword);
}
