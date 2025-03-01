package set.traversal.list;

import java.util.ArrayList;
import java.util.List;

public class ForBianli {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) * 2);
        }
        System.out.println(list);
    }
}
