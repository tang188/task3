package com.huaweisoft.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huaweisoft.daoImpl.UserDaoImpl;
import com.huaweisoft.domain.User;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserDaoImpl daoImpl;
	/**
	 * 
	 * 查询所有的用户
	 * @return
	 */
	@GetMapping(value = "/users")
	public List<User> userList() {
		return daoImpl.selectAll();
	}
	
	/**
	 * 添加用户
	 * 返回所有用户列表
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/users")
	public List<User> insert(@RequestParam(value = "id") Integer id,
								@RequestParam("name") String name,
								@RequestParam("sex") String sex,
								@RequestParam(value="birthday", required=false) String birthday,
								@RequestParam(value="height", required=false, defaultValue="1.75f") float height) {
		User user = new User(id, name, sex, birthday, height);
		daoImpl.insert(user);
		return daoImpl.selectAll();
	}
	
	/**
	 * 查询用户
	 * @param id
	 * @return
	 */
	@GetMapping("/users/{id}")
	public User userFindOne(@PathVariable("id") Integer id) {
		return daoImpl.selectByPrimaryKey(id);
	}
	
}
