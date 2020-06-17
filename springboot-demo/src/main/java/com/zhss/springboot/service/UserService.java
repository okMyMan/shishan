package com.zhss.springboot.service;

import java.util.List;

import com.zhss.springboot.domain.User;

/**
 * 用户管理模块的service组件接口
 * @author zhonghuashishan
 *
 */
public interface UserService {

	/**
	 * 查询所有用户
	 * @return 用户信息
	 */
	List<User> listUsers();
	
	/**
	 * 根据ID查询用户
	 * @param id 用户ID
	 * @return 用户信息
	 */
	User getUserById(Long id);
	
	/**
	 * 新增用户
	 * @param user 用户信息
	 */
	Long saveUser(User user);
	
	/**
	 * 更新用户
	 * @param user 用户信息
	 */
	Boolean updateUser(User user);
	
	/**
	 * 删除用户
	 * @param id 用户ID
	 */
	Boolean removeUser(Long id);
	
}
