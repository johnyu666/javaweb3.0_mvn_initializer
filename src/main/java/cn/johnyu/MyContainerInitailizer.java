package cn.johnyu;

import cn.johnyu.initializer.MyAppIntializer;
import cn.johnyu.servlet.MyServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.util.Arrays;
import java.util.Set;

//@HandlesTypes中只可以加入接口类型，它会扫描整个项目中的classPath,并将接口实现类添加到onStartup方法的第一上参数中
@HandlesTypes(MyAppIntializer.class)
public class MyContainerInitailizer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext ctx) throws ServletException {
        System.out.println("感兴趣的类型：");
        for(Class clz:set){
            //MyAppIntializer的子类型class将被扫描到，并注入到集合中
            try {
                MyAppIntializer intializer=(MyAppIntializer)clz.newInstance();
                intializer.onStartup(ctx);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        //可以在些注册，但为了更好的解藕合，可以转移到MyAppInitalizer中加以注册
//        ServletRegistration.Dynamic servlet= ctx.addServlet("MyServlet", MyServlet.class.getName());
//        servlet.addMapping(("/my"));


    }
}
