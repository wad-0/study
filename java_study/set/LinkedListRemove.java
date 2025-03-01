package set;

import java.util.LinkedList;


public class LinkedListRemove {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        //删除下标为1的元素
        list.remove(1);
        System.out.println(list);
    }
}
