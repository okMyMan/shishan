package com.zhss.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhss.springboot.domain.User;

/**
 * 用户管理模块的Mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface UserMapper {

	/**
	 * 查询所有用户
	 * @return 用户信息
	 */
	@Select("SELECT * FROM user")  
	@Results({
		@Result(property = "id", column = "id", id = true),
		@Result(property = "name", column = "name"),
		@Result(property = "age", column = "age")  
	})
	List<User> listUsers();
	
	/**
	 * 根据ID查询用户
	 * @param id 用户ID
	 * @return 用户信息
	 */
	@Select("SELECT * FROM user WHERE id=#{id}")
	@Results({
		@Result(property = "id", column = "id", id = true),
		@Result(property = "name", column = "name"),
		@Result(property = "age", column = "age")  
	})
	User getUserById(@Param("id") Long id);
	
	/**
	 * 新增用户
	 * @param user 用户信息
	 */
	@Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")  
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void saveUser(User user);
	
	/**
	 * 更新用户
	 * @param user 用户信息
	 */
	@Update("UPDATE user SET name=#{name}, age=#{age} WHERE id=#{id}")  
	void updateUser(User user);
	
	/**
	 * 删除用户
	 * @param id 用户ID
	 */
	@Delete("DELETE FROM user WHERE id=#{id}")
	void removeUser(@Param("id") Long id);
	
}
