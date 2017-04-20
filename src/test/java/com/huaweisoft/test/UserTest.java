package com.huaweisoft.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.huaweisoft.domain.User;
import com.huaweisoft.daoImpl.UserDaoImpl;
import com.huaweisoft.database.InitDatabase;

public class UserTest {
    User user;
    String path="com.huaweisoft.daoImpl";
    
    AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(path);
    
    UserDaoImpl userDaoImpl=context.getBean(UserDaoImpl.class);

    @Test
    public void testSelectByPrimaryKey() {
        assertEquals("failure - Users are not equal", InitDatabase.initUser().get(0),
                        new UserDaoImpl().selectByPrimaryKey(1));
        }
    
    @Test
    public void testSelectAll(){
        assertArrayEquals(InitDatabase.initUser().toArray(), new UserDaoImpl().selectAll().toArray());
    }
    
    @Test
    public void testInsert(){      
        user=new User(5,"name5","��","2001-01-01",166.6f);
        //userDaoImpl= new UserDaoImpl();
        
        userDaoImpl.insert(user);
        assertEquals(user,userDaoImpl.selectByPrimaryKey(5));
    }
    
    @Test
    public void testUpdate(){
        user=new User(1,"name1_change","��","2001-01-01",166.6f);        
        userDaoImpl.update(user);
        assertEquals(user, userDaoImpl.selectByPrimaryKey(user.getId()));
    }
    @Test
    public void testDelete(){       
        userDaoImpl.deleteByPrimaryKey(1);
        assertNull(userDaoImpl.selectByPrimaryKey(1));
    }
}
