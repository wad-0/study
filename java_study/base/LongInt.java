package base;

import java.util.logging.Logger;

public class LongInt {
    static Logger logger = Logger.getLogger(LongInt.class.getName());
    public static void main(String[] t) {
        int a = 10;
        long b = a;//int可以自动转换为long
        int c = (int)b;//long可以转换为int，但是要强制转换
        String str = String.valueOf(c);
        logger.info(str);
    }
}
