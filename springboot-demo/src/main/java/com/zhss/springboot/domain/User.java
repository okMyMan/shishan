package com.zhss.springboot.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.zhss.springboot.validator.Age;

/**
 * 一个领域模型类
 * @author zhonghuashishan
 *
 */
public class User {
    
	public interface Save {}
	public interface Update {}
	
	@Null(groups = {Save.class})  
	@NotNull(groups = {Update.class})  
    private Long id;
	@Size(min = 2, max = 20, groups = {Save.class, Update.class}) 
    private String name;
//	@Range(min = 18, max = 70, groups = {Save.class, Update.class})
	@Age(min = 18, max = 70, groups = {Save.class, Update.class})  
    private Integer age;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
    
}
