package com.huaweisoft.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.huaweisoft.domain.ContactBook;
import com.huaweisoft.domain.User;
import com.huaweisoft.dao.ContactBookDao;
/**
 * 
 * @author tangzh
 *
 */
@Service
public class ContactBookDaoImpl implements ContactBookDao {
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com.huaweisoft.database");	
	@SuppressWarnings("unchecked")
	List<ContactBook> list = (List<ContactBook>) context.getBean("contactBooks");
	@SuppressWarnings("unchecked")
	List<User> users = (List<User>) context.getBean("users");
	@Override
	public void insert(ContactBook book) {
		for (User user: users) {
			if (user.getId()==book.getUserId()) {
				list.add(book);
			}
		}		
	}
	@Override
	public void delete(int id) {

		for (ContactBook book : list) {
			if (book.getId() == id) {
				list.remove(book);
			}
		}
	}
	@Override
	public void update(ContactBook book) {

		for (ContactBook contactBook : list) {
			if (contactBook.getId() == book.getId()) {
				contactBook.setContact(book.getContact());
				contactBook.setType(book.getType());
			}
		}
	}
	@Override
	public List<ContactBook> selectByUserId(int id) {
		
		List<ContactBook> books = new ArrayList<ContactBook>();
		for (User user : users) {
			if (user.getId() == id) {
				for (ContactBook contactBook : list) {
					if (contactBook.getUserId() == id) {
						books.add(contactBook);
					}
					return books;
				}
			}
		}
		return null;
	}
	@Override
	public List<ContactBook> selectAll() {

		return list;
	}

}
