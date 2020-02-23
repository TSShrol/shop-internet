package rv.lesson.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import rv.lesson.dao.UserDao;
import rv.lesson.dao.impl.UserDaoImpl;
import rv.lesson.model.User;
import rv.lesson.service.UserService;

public class UserServiceImpl implements UserService {
	private static Logger logger = LogManager.getLogger(UserServiceImpl.class);
	private UserDao userDao;
	private static UserService userServiceImpl;
	private UserServiceImpl() {
		try {
			userDao = new UserDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			logger.error(e);
		}
	}
	public static  UserService getUserService() {
		if(userServiceImpl==null){
			userServiceImpl=new UserServiceImpl();
		}
		return userServiceImpl;
	}
	
	@Override
	public User create(User t) {
//		System.out.println(t);
		return userDao.create(t);
	}

	@Override
	public User read(Integer id){
		return userDao.read(id);
	}

	@Override
	public User update(User t) {
		return userDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}

	@Override
	public List<User> readAll() {
		return userDao.readAll();
	}
	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

}
