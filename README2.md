# Study_java_2.set
## 概念
### 1、数组与集合的区别
    数组是固定长度的数据机构，一旦创建长度就无法改变，而集合是动态数据结构，可以动态增删元素
    数组可以包含基本数据类型，集合只能包含对象
    数组可以直接访问元素，集合需要通过索引访问元素
### 2、集合类
    Collection：集合类，是所有集合类的父接口，它定义了集合类的基本操作方法，如add、remove、size等。
    1、ArrayList：动态数组，实现了List接口，支持动态增长。
    2、LinkedList：双向链表，实现了List接口，支持快速插入和删除操作。
    3、HashSet：哈希集合，实现了Set接口，使用哈希算法实现快速查找。用于存储唯一元素
    4、TreeSet：红黑树集合，实现了SortedSet接口，支持排序和查找操作。
    5、HashMap：哈希表，实现了Map接口，使用哈希算法实现快速查找。用于存储键值对
注意：集合类中的元素不能为null，如果集合类中有null元素，则抛出NullPointerException异常；集合类中的元素不能重复，如果集合类中有重复元素，则抛出IllegalArgumentException异常。
### 3、线程安全的集合是什么*
    线程安全的集合是指在多线程环境下，能够保证集合操作的原子性，即多个线程同时操作同一个集合时，不会出现数据不一致的情况。常见的线程安全集合类有：
    1、Vector：Vector是线程安全的，它实现了List接口，支持线程安全操作。
    2、HashTable：HashTable是线程安全的，它实现了Map接口，支持线程安全操作。
### 4、Collections和Collection的区别
    1、Collections是java.util包下的一个类，它提供了一些静态方法，用于操作集合类。Collections类中的方法包括排序、查找、修改、合并等操作。
        这些方法可以对实现了Collection接口的集合进行操作，包括List、Set、Queue等。
    2、Collection是java.util包下的一个接口，它定义了集合类的基本操作方法，如add、remove、size等。Collection接口中的方法包括添加、删除、修改、遍历等操作。
### 5、集合遍历的方法有哪些##
    1、for循环遍历：for循环遍历集合中的元素，通过索引访问集合中的元素。
    例如：for(int i=0;i<list.size();i++){
            String str=list.get(i);
            System.out.println(str);}
    2、forEach循环遍历：foreach循环遍历集合中的元素，通过集合中的元素访问集合中的元素。
    例如：list.forEach(str-> System.out.println(str));
    3、迭代器遍历：迭代器遍历集合中的元素，通过迭代器获取集合中的元素。
    例如：Iterator<String> iterator=list.iterator();
        while(iterator.hasNext()){
            String str=iterator.next();
            System.out.println(str);}
    4、ListIterator遍历：ListIterator遍历集合中的元素，通过ListIterator获取集合中的元素。
    例如：ListIterator<String> listIterator=list.listIterator();
          while(listIterator.hasNext()){
              String str=listIterator.next();
              System.out.println(str);}
## List
### 1、Java中List的集中实现
    List接口是最常用的集合类型之一，它提供了一种有序的集合，可以重复存储元素。
    1、ArrayList：动态数组，实现了List接口，支持动态增长。
    快速随机访问：由于基于数组，ArrayList 支持通过索引快速访问元素。这使得读取操作非常高效。
    例如：List<String> arrayList = new ArrayList<>();
         arrayList.add("苹果");
         arrayList.add("香蕉");
         arrayList.add("橙子");
         String fruit = arrayList.get(1); // 快速访问第二个元素
    2、LinkedList：双向链表，实现了List接口，支持快速插入和删除操作。
    快速插入和删除：由于基于链表，LinkedList 支持快速插入和删除操作，使得在添加或删除元素时，性能比ArrayList 更好。
    例如：List<String> linkedList = new LinkedList<>();
         linkedList.add("苹果");
         linkedList.add("香蕉");
         linkedList.add("橙子");
         linkedList.add(1, "葡萄"); // 在第二个位置插入元素
         linkedList.remove(0); // 移除第一个元素
### 2、list可以一边遍历一边修改元素吗
    分几种情况：
    1、使用普通for循环遍历，可以修改元素，但是不能删除元素。
    2、使用forEach循环遍历，不可以修改元素，但是可以删除元素。
    3、使用迭代器遍历，可以修改元素，但是不能删除元素。
### 3、list如何快速删除某个指定下标的元素
    使用remove(index)方法即可。
    示例：public class LinkedListRemove {
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
### 4、ArrayList和LinkedList的区别
    1、ArrayList和LinkedList都是Java集合类，都是实现了List接口。
    2、ArrayList基于数组实现，LinkedList基于链表实现。
    3、ArrayList的插入和删除操作效率较低，因为它基于数组实现，所以插入和删除操作需要移动数组中的元素。
    4、LinkedList的插入和删除操作效率较高，因为它基于链表实现，所以插入和删除操作只需要修改链表节点的指向。
    5、这两个集合都不是线程安全的。
### 5、把ArrayList变成线程安全的方法有哪些*
    1、Collections.synchronizedList(new ArrayList<>())：使用Collections.synchronizedList方法，可以将ArrayList变成线程安全的。
    2、使用Vector：Vector是线程安全的，它实现了List接口，支持线程安全操作。
    3、使用CopyOnWriteArrayList：CopyOnWriteArrayList是线程安全的，它实现了List接口，支持线程安全操作。
### 6、为什么ArrayList不是线程安全的，具体来说哪里不安全**
    在高并发添加数据下，ArrayList会暴露三个问题：
    1、部分值为null
    2、索引越界异常
    3、size与我们add的数量不符
### 7、ArrayList和LinkedList的应用场景
    1、ArrayList适用于随机访问的场景，比如查询某个位置的元素。
    2、LinkedList适用于频繁插入和删除的场景，比如在链表的首尾添加元素。
### 8、ArrayList的扩容机制*
    ArrayList在添加元素时，如果当前元素个数已经达到了内部数组的容量上限，就会出发扩容操作。    
    操作包括下面三个步骤：
    1、计算新的容量：新的容量等于当前容量的1.5倍。
    2、创建新的内部数组：创建一个新数组，长度为新的容量。
    3、将旧数组中的元素复制到新数组中：将旧数组中的元素复制到新数组中，新数组的索引从0开始。   
    4、更新引用：将新数组的引用赋值给ArrayList的internalArray变量。
    5、完成扩容：完成扩容操作，ArrayList的容量变为新的容量。
### 9、CopyonWriteArrayList是如何实现线程安全的**
    CopyOnWriteArrayList是线程安全的，它使用了一种称为写时复制（Write-time Copy）的技术。
    写时复制（Write-time Copy）是一种优化策略，它允许多个线程同时读取数据，但只允许一个线程写入数据。
## Map
    常见的Map集合（非线程安全）
    1、HashMap：基于哈希表的集合，它不保证元素的顺序。当多个线程同时对HashMap进行写操作时，可能会导致数据不一致或死循环。
    2、LinkedHashMap：基于哈希表的集合，它保证元素的顺序，通过维护一个双向链表来记录元素的插入顺序。当多个线程同时对LinkedHashMap进行写操作时，可能会导致数据不一致或死循环。
    3、TreeMap：基于红黑树的集合，它保证元素的顺序，通过比较元素的键来确定元素的插入顺序。当多个线程同时对TreeMap进行写操作时，可能会导致数据不一致或死循环。
    常见的Map集合（线程安全）
    1、ConcurrentHashMap：基于分段锁的集合，它保证元素的顺序，通过分段锁来保证并发操作的安全性。当多个线程同时对ConcurrentHashMap进行写操作时，不会出现数据不一致的情况，但可能会出现死循环。
    2、Collections.synchronizedMap(new HashMap<>())：使用Collections.synchronizedMap方法，可以将HashMap变成线程安全的。
    3、Hashtable：基于哈希表的集合，它不保证元素的顺序，但可以保证线程安全。当多个线程同时
### 1、如何对map进行遍历
    使用for-each循环和entrySet()方法：这是一种简便的遍历方式，可以同时获取Map中的键和值
    使用Iterator迭代器：这是一种更底层的遍历方式，可以获取Map中的键和值，但需要手动处理迭代器。
    使用for-each循环和entrySet()方法：这是一种简便的遍历方式，可以同时获取Map中的键和值。
    *使用Lambda表达式：这是一种更简洁的遍历方式，可以同时获取Map中的键和值。
    *使用Stream API：这是一种更灵活的遍历方式，可以同时获取Map中的键和值，并支持各种操作。
### 2、HashMap实现原理*
    HashMap的实现原理是哈希表，它使用哈希函数将键映射到一个索引，然后使用链表或红黑树等数据结构来存储具有相同索引的键值对。
### 3、HashMap是线程安全的吗
    HashMap不是线程安全的，它不保证元素的顺序，并且多个线程同时对HashMap进行写操作时，可能会导致数据不一致或死循环。
    如果要保证线程安全，可以使用ConcurrentHashMap或者Collections.synchronizedMap(new HashMap<>())等方法。
### 3、HashMap的put过程***
    HashMap的put过程包括下面几个步骤：
    1、计算哈希值：使用键的hashCode()方法计算出键的哈希值，然后对哈希值进行取模操作，得到一个索引。
    2、查找链表：在哈希桶中查找链表，如果链表为空，则创建一个新链表，并将键值对添加到链表中。
    3、如果链表不为空，则遍历链表，如果找到相同键的键值对，则更新值，如果找不到相同键的键值对，则将键值对添加到链表中。





























