package set.traversal.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 使用迭代器遍历Map：通过获取Map的entrySet()方法获取到Set集合，再使用迭代器遍历Set集合。这种方式在需要
 * 删除元素等操作时比较有用
 */
public class Diedaiqi {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", "18");
        map.put("sex", "男");
        map.put("address", "北京");

        //使用迭代器遍历Map
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
