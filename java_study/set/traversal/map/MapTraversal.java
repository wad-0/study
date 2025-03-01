package set.traversal.map;

import java.util.HashMap;
import java.util.Map;
/**
 * Map遍历
 */
public class MapTraversal {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", "18");
        map.put("sex", "男");
        map.put("address", "北京");

        // 遍历
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
