package com.zhss.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.zhss.springboot.config.DruidDataSourceConfig;

/*
 * 
 * 尽量不要用xml来配置
 * 如果一定要有一些配置的话，优先是用application.properties，application.yml
 * 在标注了@Configuration的类中，@Value注解将外部的一些配置加载到我们自己的类里面来，消除掉了依赖xml的配置
 * 
 * 思想，尽量将一个应用系统所有的配置，全部集中在一个application.properties配置文件中
 * 我们以前的话，用了一堆技术，十几种技术，配置文件，就有十几种配置文件，散落在各种不同的地方
 * 我们管理那么多分散开来的配置是很麻烦的
 * 
 * 将所有外部文件中的配置集中到一个application.properties中去，如果一定是需要做一些以前的xml完成的配置
 * 在spring的applicationContext.xml里面去配置各种bean，老土了，不要这么干
 * spring boot的思想是，对于类似上面的那种情况，全部基于注解来完成配置和相关的所有事情
 * 
 * application.properties和注解，完成所有的配置
 * 
 * @Configuration这个东东，其实就代替了以前的applicationContext.xml类似于这样的xml配置文件
 * 有些以前在xml配置文件里的东西，你就给它放到application.properties配置文件里去
 * @Configuration中，可以基于@Value注解将这些配置加载到类里面来
 * 同时@Configuration中，可以基于@Bean注解，直接在代码层面声明各种bean，包括bean与bean之间的依赖关系
 * 全部基于注解来完成装配
 * 
 */
// @Configuration
/*
 * 
 * 这个注解代表了spring boot中的核心功能，auto configuration
 * 
 * 它是说，确认可以启用这个auto configuration这个功能
 * auto configuration，就是我们后面在spring boot源码剖析的阶段，要给大家重点剖析的
 * auto configuration的核心思想，其实就是说，只要我们引入一个starter类的依赖，自动会根据我们引入了什么依赖
 * 然后来判断说，我们要干什么事情，接着就自动给我们完成所有的配置
 * 
 * 比如说spring-boot-starter-web，引入了这个依赖
 * 然后同时我们启用了auto configuration，此时就会根据说，我们引入了starter-web这个依赖
 * 就认为说我们要开发一个web系统
 * 此时就会自动给我们进行auto configuration，完成web系统需要的所有的配置
 * 包括了所有依赖包的引入，spring mvc的配置，web.xml的配置，spring mvc+spring的整合，tomcat的配置
 * 
 * auto configuration，要实现的就是，尽量他自动按照约定给我们搞定一些事情
 * 不需要我们去手动大量的配置xml
 * 
 */
// @EnableAutoConfiguration
/*
 * 
 * 这个注解是说，你如果启动应用程序之后，可以允许spring去自动扫描所有的包
 * 去看一看包里面有没有加上spring相关注解的一些类
 * 如果有相关的注解的话，就直接基于注解完成相关的bean创建以及依赖关系的装配
 * 完全用注解+自动扫描的方式，替代掉了之前在applicationContext.xml里面大量配置bean
 * 
 */
// @ComponentScan
/*
 * 
 * 梳理一下spring boot启动的一个过程
 * 
 * （1）auto configuration完成了所有的配置：spirng mvc、spring、tomcat
 * （2）会将内嵌的tomcat准备好，同时将我们的这个工程部署到内嵌的tomcat中去的
 * （3）接着就会启动内嵌的一个tomcat
 * （4）tomcat启动之后，就会初始化spring的核心容器，是跟spring mvc整合在一起的
 * （5）spring核心容器就会去扫描所有的包，有没有带@RestController之类的注解，如果有，则将这个controller初始化
 * （6）将我们的@RestController注解的类实例化成一个bean，注入自己的spirng容器
 * （7）此时spring mvc的核心servlet，去对外接收请求的，接收到请求之后，就会将请求转发给对应的controller bean
 * （8）controller bean处理完请求之后，spring mvc将请求结果，返回给浏览器
 * 
 */
/*
 * 
 * 这个注解相当于是@Configuration+@EnableAutoConfiguration+@ComponentScan的组合
 * 一般开发中，就是直接用一个@SpringBootApplication这个注解就可以了
 * 
 */
@SpringBootApplication
/*
 * 将数据源bean的配置类，导入进来，就相当于你以前搞多个xml的时候，将多个xml导入一个总的xml中
 */
@Import(DruidDataSourceConfig.class)
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
//		SpringApplication app = new SpringApplication(Application.class); 
//        app.addListeners(new MyApplicationStartedEventListener());
//        app.run(args);
	}
	
}
