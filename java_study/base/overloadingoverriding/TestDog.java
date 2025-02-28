package base.overloadingoverriding;

import java.util.logging.Logger;

/**
 * 重写：子类重写父类的方法
 * 在重写中，需要用到super关键字
 */
class Animal{
    private Logger logger = Logger.getLogger(getClass().getName());
    public void move(){
        logger.info("动物可以移动");
    }
}

class Dog extends Animal{
     private Logger logger = Logger.getLogger(getClass().getName());
    @Override
    public void move(){
        super.move(); // 应用super类的方法
        logger.info("狗可以跑和走");
    }
}

public class TestDog{
    public static void main(String[] args){

        Animal b = new Dog(); // Dog 对象
        b.move(); //执行 Dog类的方法

    }
}