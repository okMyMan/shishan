package com.zhss.springboot.web;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer {
    
    // 拦截器
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new UserLoginInterceptor()).addPathPatterns("/**");
    }
    
    // 跨域访问配置
    // 一般浏览器之前都是不支持跨域的，就是一个页面不同同时访问多个网站或者系统
    // 但是现在都是支持了
    // 就是说，我们的这个系统，可能会被别的系统的页面发送请求给访问，那么此时我们可以设定哪些网站发送过来的请求，接收
    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/user/**")
//            .allowedOrigins("http://www.zhss.com")
//            .allowedMethods("POST", "GET");
    }
    
    // 格式化
    // 将数据从请求json中提取出来后注入咱们的方法入参bean
    // 如果遇到日期类型，按照我们定义的这个格式来转换
    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }
    
    // URI到视图的映射
    // 对于某些请求，不需要找controller
    // 直接将请求映射到对应的页面上去即可
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/addUserUI").setViewName("/addUser.jsp");
    }

	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> arg0) {
		
	}

	public void addResourceHandlers(ResourceHandlerRegistry arg0) {
		
	}

	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> arg0) {
		
	}

	public void configureAsyncSupport(AsyncSupportConfigurer arg0) {
		
	}

	public void configureContentNegotiation(ContentNegotiationConfigurer arg0) {
		
	}

	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer arg0) {
		
		
	}

	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> arg0) {
		
		
	}

	public void configureMessageConverters(List<HttpMessageConverter<?>> arg0) {
		
		
	}

	public void configurePathMatch(PathMatchConfigurer arg0) {
		
		
	}

	public void configureViewResolvers(ViewResolverRegistry arg0) {
		
		
	}

	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> arg0) {
		
		
	}

	public void extendMessageConverters(List<HttpMessageConverter<?>> arg0) {
		
		
	}

	public MessageCodesResolver getMessageCodesResolver() {
		
		return null;
	}

	public Validator getValidator() {
		
		return null;
	}
    
}