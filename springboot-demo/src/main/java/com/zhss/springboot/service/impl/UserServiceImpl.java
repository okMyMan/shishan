package com.zhss.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.springboot.dao.UserDAO;
import com.zhss.springboot.domain.User;
import com.zhss.springboot.service.UserService;

/**
 * 用户管理模块的service组件实现类
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	/**
	 * 用户管理模块的DAO组件
	 */
	@Autowired
	private UserDAO userDAO;
	
	/**
	 * 查询所有用户
	 * @return 用户信息
	 */
	public List<User> listUsers() {
		return userDAO.listUsers();
	}
	
	/**
	 * 根据ID查询用户
	 * @param id 用户ID
	 * @return 用户信息
	 */
	public User getUserById(Long id) {
		return userDAO.getUserById(id);
	}
	
	/**
	 * 新增用户
	 * @param user 用户信息
	 */
	public Long saveUser(User user) {
		return userDAO.saveUser(user); 
	}
	
	/**
	 * 更新用户
	 * @param user 用户信息
	 */
	public Boolean updateUser(User user) {
		return userDAO.updateUser(user); 
	}
	
	/**
	 * 删除用户
	 * @param id 用户ID
	 */
	public Boolean removeUser(Long id) {
		return userDAO.removeUser(id); 
	}
	
}
