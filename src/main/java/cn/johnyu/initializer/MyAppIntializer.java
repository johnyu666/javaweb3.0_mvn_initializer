package cn.johnyu.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * 此接口被cn.johnyu.MyContainerInitailizer中的@HandlesTypes标注
 */
public interface MyAppIntializer  {
    public void onStartup(ServletContext servletContext)
            throws ServletException ;
}
