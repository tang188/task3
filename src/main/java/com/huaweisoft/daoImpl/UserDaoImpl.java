package com.huaweisoft.daoImpl;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.huaweisoft.domain.User;
import com.huaweisoft.dao.UserDao;
import com.huaweisoft.database.InitDatabase;

/**
 * 
 * @author tangzh
 *
 */
@Service
public class UserDaoImpl implements UserDao {
	String path="com.huaweisoft.database";
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(path);
	
    @SuppressWarnings("unchecked")
	List<User> users = (List<User>) context.getBean("users");
    @Override
    public User selectByPrimaryKey(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    @Override
    public void insert(User user) {
        if (user != null)
            users.add(user);
    }
    @Override
    public void deleteByPrimaryKey(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
            }
        }
    }
    @Override
    public void update(User user) {
        if (user != null) {
            for (User user2 : users) {
                if (user2.getId() == user.getId()) {
                    user2.setName(user.getName());
                    user2.setSex(user.getSex());
                    user2.setHeight(user.getHeight());
                    user2.setBirthday(user.getBirthday());
                }
            }
        }
    }
    @Override
    public List<User> selectAll() {

        return InitDatabase.initUser();
    }

}
