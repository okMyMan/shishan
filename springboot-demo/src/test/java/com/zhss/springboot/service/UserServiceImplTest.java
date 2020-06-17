package com.zhss.springboot.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhss.springboot.dao.UserDAO;
import com.zhss.springboot.domain.User;

/**
 * 用户管理模块的service组件的单元测试类
 * @author zhonghuashishan
 *
 */
/*
 * 这个注解是说，在执行单元测试的时候，不是直接去执行里面的单元测试的方法
 * 因为那些方法执行之前，是需要做一些准备工作的，它是需要先初始化一个spring容器的
 * 所以得找这个SpringRunner这个类，来先准备好spring容器，再执行各个测试方法
 */
@RunWith(SpringRunner.class) 
/*
 * 这个是说，会从最顶层的包结构开始招，com.zhss.springboot
 * 找到一个标注了@SpringBootApplication注解的一个类，算是启动类
 * 然后会执行这个启动类的main方法，就可以创建spring容器，给后面的单元测试提供完整的这个环境
 */
@SpringBootTest
/*
 * @Transactional注解加了之后，就可以让每个方法都是放在一个事务里面
 * 接着是这样子，比如我们要执行一些数据库相关的操作，比如说测试mapper，是需要实际操作数据库的
 * 那么在测试查询操作的时候，我们需要通过程序预先灌入一些数据，再测试能否查询到这些数据
 * 接着测试完之后，其实应该让这个事务要回滚，就可以自动取消我们插入的那些数据了
 * 让单元测试方法执行的这些增删改的操作，都是一次性的
 */
//@Transactional 
//@Rollback(true)
public class UserServiceImplTest {

	/**
	 * 用户管理模块的service组件
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * 这里加了@MockBean的注解
	 * 就代表了说，这个UserDAO就不会用我们定义的那个userDAO了
	 * 这里会由spring boot整合mockito框架，然后创建一个实现了UserDAO接口的匿名实现类
	 * 然后将这个模拟出来实现了UserDAO接口的类的实例bean，放入spring容器中
	 * 替代我们自己的那个UserDAO
	 */
	@MockBean
	private UserDAO userDAO;
	
	/**
	 * 测试用例：查询所有用户信息
	 */
	@Test
	public void testListUsers() {
		// 准备好mock userDAO的返回数据
		List<User> users = new ArrayList<User>();
		
		User user = new User();
		user.setId(1L);
		user.setName("测试用户");  
		user.setAge(20);
		
		users.add(user);
		
		// 对userDAO进行mock逻辑设置
		when(userDAO.listUsers()).thenReturn(users);
		
		// 测试UserSerivce的listUsers()方法
		List<User> resultUsers = userService.listUsers();
		
		// 对测试结果进行断言
		assertEquals(users, resultUsers);  
	}
	
	/**
	 * 测试用例：根据ID查询一个用户
	 */
	@Test
	public void testGetUserById() {
		Long userId = 1L;
		
		User user = new User();
		user.setId(userId);
		user.setName("测试用户");  
		user.setAge(20);
		
		when(userDAO.getUserById(userId)).thenReturn(user);
		User resultUser = userService.getUserById(userId);
		
		assertEquals(user, resultUser);  
	}
	
	/**
	 * 测试用例：新增用户
	 */
	@Test
	public void testSaveUser() {
		Long userId = 1L;
		
		User user = new User();
		user.setName("测试用户");  
		user.setAge(20);
		
		when(userDAO.saveUser(user)).thenReturn(userId);
		
		Long resultUserId = userService.saveUser(user);
		
		assertEquals(userId, resultUserId);
	}
	
	/**
	 * 测试用例：修改用户
	 */
	@Test
	public void testUpdateUser() {
		Long userId = 1L;
		
		User user = new User();
		user.setId(userId);
		user.setName("测试用户");  
		user.setAge(20);
		
		when(userDAO.updateUser(user)).thenReturn(true);
		
		Boolean updateResult = userService.updateUser(user);
		
		assertTrue(updateResult); 
	}
	
	/**
	 * 测试用例：删除用户
	 */
	@Test
	public void testRemoveUser() {
		Long userId = 1L;
		when(userDAO.removeUser(userId)).thenReturn(true);
		Boolean removeResult = userService.removeUser(userId);
		assertTrue(removeResult);
	}
	
}
