package com.huaweisoft.database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.huaweisoft.domain.ContactBook;
import com.huaweisoft.domain.User;

/**
 * 
 * @author tangzh
 *
 */
@Configuration
public class InitDatabase {
    /**
     * ��ʼ��User��
     * @return
     */
	
	@Bean("users")
    public static List<User> initUser(){
        List<User> userList=new ArrayList<User>();
        Date date=new Date();
        SimpleDateFormat timeFormat=new SimpleDateFormat("yyyy-MM-dd");
        
        User user1=new User(1, "name1", "��", timeFormat.format(date), 180);
        User user2=new User(2, "name2", "��", timeFormat.format(date), 190);
        userList.add(user1);
        userList.add(user2);
        
        return userList;
    }
    /**
     * ��ʼ��Contact_Book��
     * @return
     */
	@Bean("contactBooks")
    public static List<ContactBook> initContactBook(){
       List<ContactBook> listCB=new ArrayList<>();
        ContactBook book1=new ContactBook(1, 1, 1, "contact1");
        ContactBook book2=new ContactBook(2, 2, 2, "contact2");
        listCB.add(book1);
        listCB.add(book2);
        return listCB;        
    }

}
