package set.traversal.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用for-each循环和keySet()遍历Map的键
 */
public class KeySet {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "John");
        map.put("age", "30");
        map.put("city", "New York");

        //使用for-each循环和keySet()遍历Map的键
        for (String key : map.keySet()) {
            System.out.println(key);
        }
    }
}
