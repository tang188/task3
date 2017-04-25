package com.huaweisoft.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.huaweisoft.daoImpl.ContactBookDaoImpl;
import com.huaweisoft.domain.ContactBook;
/**
 * 
 * @author tangzh
 *
 */
@RestController
@RequestMapping("/contactbook")
public class ContactBookController {
	@Autowired
	ContactBookDaoImpl bookDaoImpl;
	/**
	 * 
	 * @return List<ContactBook>
	 */
	@GetMapping(value = "/contactbooks")
	public List<ContactBook> selectAll() {
		return bookDaoImpl.selectAll();
	}
	
	/**
	 * 
	 * @param userId
	 * @return List<ContactBook>
	 */
	@GetMapping("/contactbooks/{userId}")
	public List<ContactBook> selectByUserId(@PathVariable("userId") Integer userId) {
		return bookDaoImpl.selectByUserId(userId);
	}
	/**
	 * 
	 * @param id
	 * @param userId
	 * @param type
	 * @param contact
	 * @return List<ContactBook>
	 */
	@PostMapping(value = "/contactbooks")
	public List<ContactBook> insert(@RequestParam(value = "id") Integer id,
											@RequestParam(value = "userId") Integer userId,
											@RequestParam(value = "type") Integer type,
											@RequestParam(value = "contact") String contact) {
		ContactBook contactBook = new ContactBook(id, userId, type, contact);
		bookDaoImpl.insert(contactBook);
		return bookDaoImpl.selectAll();
	}
}
