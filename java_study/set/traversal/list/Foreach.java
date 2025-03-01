package set.traversal.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用foreach遍历集合：一般不建议在foreach循环中直接修改正在遍历的List元素，可能会
 * 导致迭代异常。因为foreach循环底层是基于迭代器实现的。
 */
public class Foreach {
    public static void main(String[] args) {
        // 创建集合
        List<Integer> list = new ArrayList<>();
        // 添加元素
        list.add(1);
        list.add(2);
        list.add(3);
        // 使用foreach遍历集合
        for (Integer s : list) {
            list.set(list.indexOf(s), s * 2);
        }
        System.out.println(list);
    }
}
