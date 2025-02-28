package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class IntegerGenerics {
    static Logger logger = Logger.getLogger(IntegerGenerics.class.getName());
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        Collections.sort(list);//Collections.sort()方法只能对包装类进行排序，不能对基本数据类型进行排序
        String str = list.toString();
        logger.info(str);

    }
}
