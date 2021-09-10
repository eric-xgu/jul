package com.ringo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.InputStream;
import java.util.logging.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test(){
        //1、获取jdk日志记录器
        Logger logger=Logger.getLogger("com.ringo.AppTest");
        //2、日志输出
        logger.info("你好");

        //通用的方法记录日志(枚举类型)
        logger.log(Level.INFO,"hello");
        String name="jack";
        int age=100;
        logger.log(Level.WARNING,"用户信息:{0},{1}",new Object[]{name,age});
        logger.log(Level.SEVERE,"hello1");
        logger.log(Level.CONFIG,"hello2");
        logger.log(Level.FINE,"hello3");
        logger.log(Level.FINER,"hello4");
        logger.log(Level.FINEST,"hello5");
        logger.log(Level.INFO,"hello5");
    }

    @Test
    public void test1 ()throws Exception{
        //1、获取jdk日志记录器
        Logger logger=Logger.getLogger("com.ringo.AppTest");
        //关闭系统默认配置
        logger.setUseParentHandlers(false);
        //创建handler对象,控制台handler
        ConsoleHandler handler=new ConsoleHandler();
        //创建格式
        SimpleFormatter simpleFormatter=new SimpleFormatter();
        handler.setFormatter(simpleFormatter);
        logger.addHandler(handler);


        //输出到文件中
        FileHandler fileHandler=new FileHandler("log/run.log");
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);

        //配置级别
        //logger.setLevel(Level.ALL);
        //handler.setLevel(Level.ALL);
        String name="jack";
        int age=100;
        logger.log(Level.WARNING,"用户信息:{0},{1}",new Object[]{name,age});
        logger.log(Level.SEVERE,"hello1");
        logger.log(Level.CONFIG,"hello2");
        logger.log(Level.FINE,"hello3");
        logger.log(Level.FINER,"hello4");
        logger.log(Level.FINEST,"hello5");
        logger.log(Level.INFO,"hello6");
    }

    @Test
    public void test2(){
        Logger logger=Logger.getLogger("com.ringo");
        Logger logger1=Logger.getLogger("com");
        System.out.println(logger.getParent()==logger1);
        System.out.println(logger.getParent().getName());
        //关闭系统默认配置
        logger1.setUseParentHandlers(false);
        //创建handler对象,控制台handler
        ConsoleHandler handler=new ConsoleHandler();

        //创建格式
        SimpleFormatter simpleFormatter=new SimpleFormatter();
        handler.setFormatter(simpleFormatter);
        logger1.addHandler(handler);
        logger1.setLevel(Level.ALL);
        handler.setLevel(Level.ALL);
        String name="jack";
        int age=100;
        logger.log(Level.WARNING,"用户信息:{0},{1}",new Object[]{name,age});
        logger.log(Level.SEVERE,"hello1");
        logger.log(Level.CONFIG,"hello2");
        logger.log(Level.FINE,"hello3");
        logger.log(Level.FINER,"hello4");
        logger.log(Level.FINEST,"hello5");
        logger.log(Level.INFO,"hello6");
    }
    @Test
    public void test3()throws Exception{
        //读取自定义配置文件
        InputStream ins=AppTest.class.getClassLoader().getResourceAsStream("logger.properties");
        LogManager logManager=LogManager.getLogManager();
        //创建LoggerManager对象
        logManager.readConfiguration(ins);

        String name="jack";
        int age=100;
        Logger logger=Logger.getLogger("com.ringo1");

        logger.warning("用户信息:{0},{1}");
        logger.severe("hello1");
        logger.info("hello2");
        logger.fine("hello3");
        logger.finer("hello4");
        logger.finest("hello5");
        logger.config("hello6");

        Logger logger1=Logger.getLogger("com.ringo");
        logger1.log(Level.FINE,"数据库是软件工业的基础");
        //通过LoggerManager加载配置文件
    }

    @Test
    public  void test4(){

    }

}
