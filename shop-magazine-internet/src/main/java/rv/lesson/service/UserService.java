package rv.lesson.service;

import rv.lesson.model.User;
import rv.lesson.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User>{
	User getUserByEmail(String email);

}
