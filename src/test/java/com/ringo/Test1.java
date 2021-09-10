package com.ringo;


import org.apache.log4j.*;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

import java.util.logging.XMLFormatter;

public class Test1 {
    @Test
    public  void test4(){
        //配置信息初始化，内置信息
        LogLog.setInternalDebugging(true);
        BasicConfigurator.configure();
        Logger logger=Logger.getLogger(Logger.class);
            //详细加载配置的
            logger.fatal("严重错误"); //系统崩溃
            logger.error("错误信息"); //
            logger.warn("警告");
            logger.info("系统运行信息");
            logger.debug("记录在开发过程中的运行函数，参数");
            logger.trace("程序所有的流程");
            logger.info("hello");
            logger.info("yes");
            Logger logger2=Logger.getLogger(App.class);
            logger2.error("da pan zhi beng");
    }

}
