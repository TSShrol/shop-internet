package rv.lesson.dao;

import rv.lesson.model.User;
import rv.lesson.shared.AbstractCRUD;


public interface UserDao extends AbstractCRUD<User>{
	User getUserByEmail(String email);
}