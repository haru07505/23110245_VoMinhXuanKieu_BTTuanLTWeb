package haru.kieu.service;

import haru.kieu.model.User;

public interface UserService {
	User login(String username, String password);
	User findByUserName(String username);
}
