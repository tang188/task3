package com.huaweisoft.dao;

import java.util.List;

import com.huaweisoft.domain.ContactBook;


/**
 * s
 * @author tangzh
 *
 */
public interface ContactBookDao {
	/**
	 * ���contactbook
	 * @param book
	 */
	void insert(ContactBook book);
	/**
	 * ɾ�� 
	 * @param id
	 */
	void delete(int id);
	
	/**
	 * ����contact book
	 * @param book
	 */
	void update(ContactBook book);
	
	/**
	 * ��ѯ
	 * @param id userid
	 * @return
	 */
	List<ContactBook> selectByUserId(int id);
	/**
	 * ��ѯ���е�ContactBook
	 * @return
	 */
	List<ContactBook> selectAll();
}
