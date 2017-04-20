package com.huaweisoft.dao;

import java.util.List;

import com.huaweisoft.domain.User;
/**
 * 
 * @author tangzh
 *
 */
public interface UserDao {
    /**
     * ����ID��ѯ�û�
     * @param id
     * @return User
     */
    User selectByPrimaryKey(int id);
    /**
     * �����û�
     * @param user
     */
    void insert(User user);
    /**
     * ɾ���û�
     * @param id
     */
    void deleteByPrimaryKey(int id);
    /**
     * �����û�
     * @param user
     */
    void update(User user);
    /**
     * ��ѯ�����û�
     * @return
     * 
     */
    List<User> selectAll() ;
}
