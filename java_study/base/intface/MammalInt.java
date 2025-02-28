package base.intface;

import java.util.logging.Logger;

/* 文件名 : MammalInt.java
* 实现接口，通过关键字 implements来继承Animal接口并实现Animal接口中的方法
*/
public class MammalInt implements Animal{
    Logger logger = Logger.getLogger(MammalInt.class.getName());
    public void eat(){
        logger.info("Mammal eats");
    }

    public void travel(){
        logger.info("Mammal travels");
    }

    public int noOfLegs(){
        return 0;
    }

    public static void main(String[] args){
        MammalInt m = new MammalInt();
        m.eat();
        m.travel();
    }
}
