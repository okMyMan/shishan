package com.roncoo.eshop.inventory.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.roncoo.eshop.inventory.thread.RequestProcessorThreadPool;

/**
 * 系统初始化监听器
 * java web应用，做系统的初始化，一般在ServletContextListener
 * 会跟着整个web应用的而启动而启动
 *
 * 在 Servlet API 中有一个 ServletContextListener 接口，它能够监听 ServletContext 对象的生命周期，实际上就是监听 Web 应用的生命周期。
 *
 * 当Servlet 容器启动或终止Web 应用时，会触发ServletContextEvent 事件，该事件由ServletContextListener 来处理。
 * 在 ServletContextListener 接口中定义了处理ServletContextEvent 事件的两个方法。
 * @author Administrator
 *
 */
public class InitListener implements ServletContextListener {

	/**
	 * 当Servlet 容器启动Web 应用时调用该方法。在调用完该方法之后，容器再对Filter 初始化，
	 * 并且对那些在Web 应用启动时就需要被初始化的Servlet 进行初始化。
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 初始化工作线程池和内存队列
		RequestProcessorThreadPool.init();


// 还可以保存属性
//		ServletContext context = sce.getServletContext();
//		//从web.xml中获取web应用参数
//		String parameter = context.getInitParameter("parameter");
//		//设置web应用参数
//		context.setAttribute("parameter ", parameter );



	}

	/**
	 * 当Servlet 容器终止Web 应用时调用该方法。在调用该方法之前，容器会先销毁所有的Servlet 和Filter 过滤器。
	 * @param sce
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}

// 获取方法如下
//class GetParameter extends HttpServlet {
//	public void getParms() throws ServletException {
//		//获取listener里初始化的参数
//		String parameter = (String) getServletContext().getAttribute("parameter");
//		//获取web.xml中配置的servlet参数
//		String s1 = this.getInitParameter("servletParam");
//		//获取web.xml中配置的web应用参数
//		String s2 = this.getServletContext().getInitParameter("webParam");
//	}
//}