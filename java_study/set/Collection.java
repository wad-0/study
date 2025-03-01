package set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Collections 类提供了一些方法用于对集合进行操作，如排序、查找、修改等。
 * Collection 接口提供了一些静态方法，这些方法可以用于对集合进行操作，如排序、查找、修改等。
 *
 */
public class Collection {
    public static void main(String[] args) {
        // 创建一个 ArrayList 集合
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);

        // 使用 Collections 类的 sort 方法对集合进行排序
        Collections.sort(list);

        // 遍历集合并打印元素
        for (Integer num : list) {
            System.out.println(num);
        }

        // 使用 Collections 类的 max 方法获取集合中的最大值
        Integer max = Collections.max(list);
        System.out.println("Max value: " + max);

        // 使用 Collections 类的 unmodifiableList 方法创建一个不可修改的集合
        List<Integer> unmodifiableList = Collections.unmodifiableList(list);
        // 尝试修改不可修改的集合会抛出 UnsupportedOperationException 异常
        // unmodifiableList.add(4); // 会抛出异常
        for (Integer num : unmodifiableList) {
            System.out.println(num);
        }
    }
}
