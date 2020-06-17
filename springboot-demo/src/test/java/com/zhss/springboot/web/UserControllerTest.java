package com.zhss.springboot.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.alibaba.fastjson.JSONObject;
import com.zhss.springboot.domain.User;
import com.zhss.springboot.service.UserService;

import net.minidev.json.JSONArray;

/**
 * 用户管理模块的控制器组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class)
/*
 * 通过这个注解表明，你要测试的controller是谁
 */
@WebMvcTest(UserController.class)  
public class UserControllerTest {

	/**
	 * 注入一个MockMvc，模拟对controller发起http请求
	 */
	@Autowired
	private MockMvc mockMvc;
	/**
	 * 模拟userService组件
	 */
	@MockBean
	private UserService userService;
	
	/**
	 * 测试用例：查询所有用户信息
	 */
	@Test
	public void testListUsers() {
		try {
			List<User> users = new ArrayList<User>();
			
			User user = new User();
			user.setId(1L);
			user.setName("测试用户");  
			user.setAge(20);
			
			users.add(user);
			
			when(userService.listUsers()).thenReturn(users);
			
			mockMvc.perform(get("/api/v1.0/user/"))
					.andExpect(content().json(JSONArray.toJSONString(users))); 
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	/**
	 * 测试用例：根据ID查询一个用户
	 */
	@Test
	public void testGetUserById() {
		try {
			Long userId = 1L;
			
			User user = new User();
			user.setId(userId);
			user.setName("测试用户");  
			user.setAge(20);
			
			when(userService.getUserById(userId)).thenReturn(user);
			
			mockMvc.perform(get("/api/v1.0/user/{id}", userId))  
					.andExpect(content().json(JSONObject.toJSONString(user)));  
		} catch (Exception e) {
			e.printStackTrace(); 
		}
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
		
		when(userService.saveUser(user)).thenReturn(userId);
		
		try {
			mockMvc.perform(post("/api/v1.0/user/").contentType("application/json").content(JSONObject.toJSONString(user)))  
					.andExpect(content().json("{'status': 'success', 'message': '新增用户ID为" + user.getId() + "'}"));   
		} catch (Exception e) {
			e.printStackTrace(); 
		}
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
		
		when(userService.updateUser(user)).thenReturn(true);
		
		try {
			mockMvc.perform(put("/api/v1.0/user/{id}", userId).contentType("application/json").content(JSONObject.toJSONString(user)))  
					.andExpect(content().string("success"));     
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	/**
	 * 测试用例：删除用户
	 */
	@Test
	public void testRemoveUser() {
		Long userId = 1L;

		when(userService.removeUser(userId)).thenReturn(true);  
		
		try {
			mockMvc.perform(delete("/api/v1.0/user/{id}", userId))   
					.andExpect(content().string("success"));     
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
}
