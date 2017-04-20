package com.huaweisoft.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.huaweisoft.domain.ContactBook;
import com.huaweisoft.domain.User;
import com.huaweisoft.daoImpl.ContactBookDaoImpl;
import com.huaweisoft.database.InitDatabase;

public class ContactBookTest {
	String path="com.huaweisoft.daoImpl";
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(path);
    ContactBookDaoImpl contactBookDaoImpl=context.getBean(ContactBookDaoImpl.class);
    @Test
    public void testDelete(){        
        contactBookDaoImpl.delete(1);
        List<User> users=new ArrayList<User>(); 
        assertEquals(users,contactBookDaoImpl.selectByUserId(1));
    }
    @Test
    public void testSelectByUserId(){
        List<ContactBook> contactBooks=new ArrayList<>();
        for (ContactBook contactBook : InitDatabase.initContactBook()) {
            if(contactBook.getId()==1){
                contactBooks.add(contactBook);
            }
        }
        assertEquals(contactBooks, new ContactBookDaoImpl().selectByUserId(1));
    }
    @Test
    public void testSelectAll(){
        assertEquals(InitDatabase.initContactBook(), new ContactBookDaoImpl().selectAll());
        
    }
}
