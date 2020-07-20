package cn.johnyu.initializer.impl;

import cn.johnyu.initializer.MyAppIntializer;
import cn.johnyu.servlet.MyServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyAppIntializerImpl implements MyAppIntializer {
    @Override
    public void onStartup(ServletContext ctx) throws ServletException {
        ServletRegistration.Dynamic servlet = ctx.addServlet("MyServlet", MyServlet.class.getName());
        servlet.addMapping(("/my"));
    }
}
