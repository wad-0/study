package base.overloadingoverriding;

import java.util.logging.Logger;

/**
 * 重载：同一个类中，多个方法名相同，参数列表不同，返回类型可以相同也可以不同。
 */

public class OverloadingTest {
    Logger logger = Logger.getLogger(getClass().getName());
    public int test(){
        logger.info("test1");
        return 1;
    }
    /**
     * @param a 参数a
     */
    public void test(int a){
        logger.info("test2");
    }
    //以下两个参数类型顺序不同
    /**
    * @param s 参数s
     *@param a 参数a
    */
    public String test(int a,String s){
        logger.info("test3");
        return "returntest3";
    }
    /**
     * @param a 参数a
     * @param s 参数s
     */
    public String test(String s,int a){
        logger.info("test4");
        return "returntest4";
    }
    public static void main(String[] args){
        Logger logger = Logger.getLogger(OverloadingTest.class.getName());
        OverloadingTest o = new OverloadingTest();
        logger.info("main");
        o.test(1);// 调用对象o的test方法，传入参数1
        logger.info(o.test(1,"test3"));
        logger.info(o.test("test4",1));
    }
}
