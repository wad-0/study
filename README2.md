# Study_java_2.set
## 数据类型
### 1、long和int可以相互转化
    由于long类型的范围比int类型大，所以long可以转换为int，反之可能会导致溢出。
    int a = 10;
    long b = a;//int可以自动转换为long
    int c = (int)b;//long可以转换为int，但是要强制转换

### 2、数据类型转换方式
    1、自动类型转换（隐）：目标类型大于原类型时，Java自动将原类型转化为目标类型
    2、强制类型转换（显）：目标小于原类型，需要强制类型转化，会造成溢出，如long转int等
    3、字符串类型转换：将字符串表示的数据转换为其他类型数据的方法。如String转int用Integer.parseInt()方法实现

#### 3、为什么用bigDecimal 不用double 
    double和float在计算机中存储和计算都是浮点数，其精度是double是64位，float是32位，因此double和float的运
    算结果会有误差，而BigDecimal没有这个误差。使用BigDecimal可以确保精确的十进制数值计算。注意：创建BigDecimal对象
    应该使用字符串作为参数。
    例如：
    System.out.println(0.05+0.01);
    System.out.println(1.0-0.42);
    System.out.println(4.015*100);
    System.out.println(123.3/100);

### 4、装箱和拆箱
    1、装箱：将基本数据类型转换为对应的包装类对象 Integer i = 10; //装箱
    2、拆箱：将包装类对象转换为对应的基本数据类型 int j = i; //拆箱
    3、自动装箱：一种赋值时，一种在方法调用的时候；自动装箱的弊端是可能会创建多余的对象，影响效率。

### 5、Java为什么有Integer
    Integer类是一个包装类，它将基本数据类型int封装成对象，从而实现对int类型的封装和操作。
    对象封装有很多好处，可以把属性也就是数据跟处理这些数据的方法结合在一起。
    1、泛型中的应用：泛型中的类型必须是引用类型，不能是基本数据类型，所以Integer类是引用类型。
    例如：
    List<Integer> list = new ArrayList<>();
    list.add(3);
    list.add(1);
    list.add(2);
    Collections.sort(list);//Collections.sort()方法只能对包装类进行排序，不能对基本数据类型进行排序
    System.out.println(list);   
    2、转换中的应用：基本类型和引用类型不能直接进行转换，必须使用包装类来实现。
    例如：基本类型和引用类型不能直接进行转换，必须使用包装类来实现。
    int i = 10;
    Integer integer = new Integer(i);
    String str = integer.toString();
    System.out.println(str);
    3、集合中的应用：集合中只能存储引用类型，不能存储基本数据类型，所以Integer类是引用类型。

### 6、Integer相比int有什么优点
    1、Integer类是一个包装类，它将基本数据类型int封装成对象，从而实现对int类型的封装和操作。
    2、Integer类提供了许多静态方法，用于将字符串转换为整数，并将整数转换为字符串。
    3、空指针异常：Integer类提供了一些方法，用于防止空指针异常。

### 7、为什么保留int类型
    int类型是Java的基本数据类型，它具有固定的大小，在计算机中存储和计算都是整数，因此基本类型比包装类高效。

## 面向对象
### 面向对象及其三大特征
    概念：对象是现实Word中的实体，对象具有属性和方法。以对象为中心的设计思想。
    1、封装：将数据封装到对象中，对外隐藏内部
    2、继承：子类继承父类的属性和方法，子类可以重写父类的方法，也可以添加新的方法。
    3、多态：同一个方法可以有不同的实现，根据对象的类型调用不同的方法。
### 1、多态的实现方式
    1、方法重载：同一个类中，多个方法名相同，参数列表不同，返回类型可以相同也可以不同。
    例如：对于add方法，可以定义为add(int a, int b)，add(int a, int b, int c)等。
    2、方法重写：子类重写父类的方法，子类方法与父类方法名相同，参数列表相同，返回类型相同。JVM会根据对象的实际类型调用对应的方法。
    例如：对于一个动物类中，定义一个sound方法，子类Dog可以重写父类的sound方法以实现bark，而子类Cat可以重写父类的sound方法以实现meow。
    3、接口与实现：接口是抽象类的延伸，它不能被实例化，只能被实现。接口中的方法都是抽象方法，接口中的成员变量都是常量。
    例如：多个类（Dog，Cat）都实现了Animal接口，当用Animal接口来定义变量时，可以指向Dog或Cat对象。
    4、多态解决的问题：多态可以让代码更加灵活，减少代码重复，提高代码可维护性。
### 2、面向对象的设计原则：
    1、单一职责原则：一个类只做一件事情，一个类只做一件事情，一个类只做一件事情。
    2、里氏替换原则：子类可以替换父类，子类可以扩展父类的功能，但不能改变父类原有的功能。
    3、开放封闭原则：对扩展开放，对修改关闭。
    4、接口隔离原则：一个接口只做一件事情，一个接口只做一件事情，一个接口只做一件事情。
    5、依赖倒置原则：抽象不应该依赖于细节，细节应该依赖于抽象。
    6、最少知识原则：一个对象应该对其它对象有最少的了解。
### 3、重载和重写
    重载：同一个类中，多个方法名相同，参数列表不同，返回类型可以相同也可以不同。
        重载的规则：被重载的方法必须改变参数列表(参数个数或类型不一样)；
                被重载的方法可以改变返回类型；
                被重载的方法可以改变访问修饰符；
                被重载的方法可以声明新的或更广的检查异常；
                方法能够在同一个类中或者在一个子类中被重载。
                无法以返回值类型作为重载函数的区分标准。
    重写：子类重写父类的方法，子类方法与父类方法名相同，参数列表相同，返回类型相同。JVM会根据对象的实际类型调用对应的方法。同时要使用super方法调用父类方法
        重写的规则：参数列表与被重写方法的参数列表必须完全相同。
                父类的成员方法只能被它的子类重写。
                声明为 final 的方法不能被重写。
                声明为 static 的方法不能被重写，但是能够被再次声明。
                子类和父类在同一个包中，那么子类可以重写父类所有方法，除了声明为 private 和 final 的方法。
                子类和父类不在同一个包中，那么子类只能够重写父类的声明为 public 和 protected 的非 final 方法。
                构造方法不能被重写。
### 4、抽象类与普通类的区别
    实例化：抽象类不能实例化，只能被继承。普通类可以实例化。
    方法实现：抽象类中的方法可以没有实现，普通类中的方法必须实现。
    继承：一个类可以继承多个普通类，而且可以继承多个接口；一个类只能继承一个抽象类，但可以同时实现多个接口。
    实现限制：抽象类一般用于作为基类，被其他类继承和扩展使用。
### 5、接口与抽象类的区别
    1、接口：接口是一个特殊的抽象类，它不能被实例化，只能被实现。接口中的方法都是抽象方法，接口中的成员变量都是常量。
    2、抽象类：抽象类是一个特殊的类，它不能被实例化，只能被继承。抽象类中的方法可以有实现，也可以没有实现。
    二者区别：a、接口中的方法都是抽象方法，抽象类中的方法可以有实现，也可以没有实现。
            b、接口不能有成员变量，抽象类可以有成员变量。
            c、接口不能有构造方法，抽象类可以有构造方法。接口无法实例化，不需要构造函数
            d、接口不能有静态代码块，抽象类可以有静态代码块。
            e、抽象方法：抽象方法没有方法体，只有方法名，方法名后面没有大括号，被abstract修饰。
    3、接口与抽象类的应用场景：1、接口：当需要定义一个接口时，可以使用接口来定义一个规范，多个类可以同时实现这个接口，实现接口的类必须实现接口中的所有方法。
### 6、抽象类不能加final修饰
    抽象类是用来继承的，如果一个类被final修饰，则不能被继承，所以抽象类不能被final修饰。
### 7、接口
    当类继承接口时，需要使用关键字implements，而不是extends。
### 8、接口里可以定义哪些方法(类里面的public可省略)
    1、抽象方法：抽象方法没有方法体，只有方法名，方法名后面没有大括号，被abstract修饰。
    例如：public interface MyInterface {
            public void method();
            }
    2、默认方法：允许接口提供具体实现。实现类可以选择重写默认方法，也可以不重写。
    例如：public interface MyInterface {
            public default void method() {
                System.out.println("默认方法");
                }
            }
    3、静态方法：允许接口提供静态方法。实现类可以直接调用，而不需要实现类的对象。
    例如：public interface MyInterface {
            public static void method() {
                System.out.println("静态方法");
                }
            }
    4、私有方法：允许接口提供私有方法。私有方法只能在接口内部使用，不能在实现类中调用。
    例如：public interface MyInterface {
            private void method() {
                System.out.println("私有方法");
                }
            }
### 9、抽象类可以被实例化吗？
    抽象类本身是不能被实例化的，但是可以有子类继承它，子类可以实例化。
    这意味着不能使用new关键字直接创建抽象类的对象。抽象类的存在主要是为了被继承，它通常包含一个或多个抽象方法，这些方法需要被子类实现
    抽象类可以有构造器，这些构造器在子类实例化时会被调用。
    例如：public abstract class MyAbstractClass {
            public MyAbstractClass() {
                System.out.println("抽象类的构造器");
            }
            public abstract void myAbstractMethod();
        }
        public class ConcreteClass extends MyAbstractClass{
            public ConcreteClass() {
                super();//调用抽象类的构造器
            }
            @Override
            public void myAbstractMethod() {
                System.out.println("实现抽象方法的子类");
            }
        }
        //下面的代码可以运行
        ConcreteClass concreteClass = new ConcreteClass();
        上述例子中，ConcreteClass是抽象类的子类，它实现了抽象类的抽象方法，所以可以实例化。
### 10、静态变量和静态方法（通过static声明的变量和方法）
    静态变量：静态变量属于类，而不是对象。静态变量在类加载时创建，并且每个对象都共享同一个变量。
    静态方法：静态方法属于类，而不是对象。静态方法在类加载时创建，并且每个对象都可以调用。
        注意：静态方法可以在没有创建类实例的情况下调用。对于静态方法来说，不能直接访问非静态的成员变量或方法。
            同时静态方法不支持重写
    静态变量和静态方法在类加载时创建，并且每个对象都可以调用。
    例1：public class MyClass {
            //静态变量
            static int staticVariable = 10;
            public MyClass() {
                staticVariable++;//每次创建对象时，静态变量的值都会增加1}
            public static void printStaticVariable() {
                System.out.println("静态变量的值为：" + staticVariable);}
        }
        //使用示例
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        MyClass.printStaticVariable();//输出静态变量的值为：2
    例2：public class MyClass {
            //静态方法
            static int count = 0;
            public static void incrementCount() {
                count++;
            }
            public static void displayCount() {
                System.out.println("当前计数为：" + count);
            }
        }
        MyClass.incrementCount();//调用静态方法
        MyClass.incrementCount();//输出当前计数为：1
### 11、在有一个父类和子类，都有静态的成员变量、静态构造方法和静态方法，在我new一个子类的时候，加载顺序是什么样的
    具体加载顺序总结为：
    1、首先加载父类的静态变量、静态构造方法和静态方法。
    2、然后加载子类的静态变量、静态构造方法和静态方法。
    3、父类构造方法
    4、子类构造方法
    示例：
    public class Parent {
        static {
            System.out.println("父类静态代码块");}
        static int parentStaticVariable = 10;
        Parent() {
            System.out.println("父类构造方法");}
    }
    public class Child extends Parent {
        static {
            System.out.println("子类静态代码块");}
        static int childStaticVariable = 20;
        Child() {
            System.out.println("子类构造方法");}
    }
    public class Main {
        public static void main(String[] args) {
            Child child = new Child();}
    }
    从最终控制台输出结果来看，在创建Child对象时，首先执行父类的静态块，然后是子类的静态块，最后才是父类的构造方法和子类的构造方法。
### 12、深拷贝和浅拷贝
    浅拷贝：浅拷贝只复制对象本身，而不复制对象中的成员变量。如果对象中的成员变量是基本数据类型，那么浅拷贝就是复制了基本数据类型的值；
    如果对象中的成员变量是引用类型，那么浅拷贝只是复制了该引用类型的地址，而不复制该地址指向的对象。
    深拷贝：深拷贝不仅复制了对象本身，而且复制了对象中的成员变量。如果对象中的成员变量是基本数据类型，那么深拷贝就是复制了基本数据类型的值；
    如果对象中的成员变量是引用类型，那么深拷贝会复制该引用类型指向的对象，而不仅仅是复制该引用类型的地址。
### 13、Java中如何实现深拷贝？*
    1.使用序列化实现深拷贝：通过将对象序列化到字节数组中，然后再从字节数组中反序列化出对象，实现深拷贝。
    2.手动实现深拷贝：手动实现深拷贝，需要根据对象的成员变量类型，逐个复制。
    3.使用Cloneable接口和clone方法实现深拷贝：如果一个类实现了Cloneable接口，那么就可以使用clone方法进行深拷贝。
### 14、泛型
    泛型（Generics）是Java SE5引入的一个新特性，它允许在定义类、接口或方法时，使用类型形参来替代具体的实际类型。
    泛型的主要目的是在编译时进行类型检查，以减少运行时错误。
    泛型适用于多种数据类型执行相同的代码
    示例：private static int add(int a, int b){
            System.out.println(a + "+" + b + "=" + (a + b));
            return a + b;}
         private static float add(float a, float b){
            System.out.println(a + "+" + b + "=" + (a + b));
            return a + b;}
    如果没有泛型，要实现不同类性的函数，需要定义多个函数，这样代码就显得很乱。通过泛型，可以定义一个函数，该函数可以接受任意类型的参数，并在函数内部进行类型转换。
    示例：public static <T> T add(T a, T b){
            System.out.println(a + "+" + b + "=" + (a + b));
            return a + b;}
## 对象
### 1、对象创建的方式*
    1.通过new关键字创建对象，即通过类名调用构造方法创建对象。
    示例：MyClass myClass = new MyClass();
    2.使用Clss.newInstance()方法创建对象，即通过类对象调用newInstance()方法创建对象。
    示例：MyClass myClass = (MyClass) Class.forName("MyClass").newInstance();
    3.使用反射创建对象，即通过Class对象调用getConstructor()方法获取构造方法，再调用newInstance()方法创建对象。
    示例：MyClass myClass = (MyClass) clazz.getConstructor().newInstance();
    4.使用反序列化创建对象，即通过ObjectInputStream对象调用readObject()方法读取对象。
    示例：MyClass myClass = (MyClass) ois.readObject();
    5.使用clone()方法，前提是类实现了Cloneable接口，然后通过类对象调用clone()方法创建对象。
    示例：MyClass myClass = (MyClass) myClass.clone();
### 2、New出的对象什么时候回收
    在Java中，对象在第一次被创建后，会一直存在于内存中，直到被显式地回收（即被垃圾回收器清除）。
    当对象不再被引用时，它将被垃圾回收器回收，释放内存。
    回收时机*：a.引用计数法：当一个对象的引用计数为0时，该对象将被回收。
            b.引用跟踪法：当一个对象不再被任何引用所引用时，该对象将被回收。
            c.垃圾收集器：当垃圾收集器发现一个对象不再被任何引用所引用时，该对象将被回收。
            d.finalize()方法：当一个对象被回收前，它的finalize()方法会被调用。
            e.手动回收：可以通过显式地调用System.gc()方法来请求垃圾回收器进行垃圾回收。
## 反射*
    反射（Reflection）是Java SE5引入的一个新特性，它允许在运行时获取类的信息，包括类的成员变量、方法、构造方法等，并动态地调用这些成员。
    特性：
    1、运行时类信息访问：反射允许在运行时获取类的信息，包括类的成员变量、方法、构造方法等。
    2、动态调用：反射允许在运行时动态地调用类的成员，包括方法、构造方法等。
    通过调用Method类的invoke()方法，可以动态地调用类的方法。
    3、动态创建对象：反射允许在运行时动态地创建对象，而不需要知道对象的类型。
    通过调用Constructor类的newInstance()方法，可以动态地创建对象。
    4、访问和修改字段值：反射允许在运行时访问和修改类的字段值。
    通过Field类的get()和set()方法，可以获取和设置字段的值。
### 1、反射的应用场景
    加载数据库驱动：通过反射加载数据库驱动程序，而不需要知道具体的驱动程序类名。
    示例：Class.forName("com.mysql.jdbc.Driver");
    配置文件解析：通过反射解析配置文件，而不需要知道具体的配置文件格式。
    示例：
    动态代理：通过反射创建动态代理对象，而不需要知道具体的代理类。
## 注解
    注解（Annotation）是Java SE5引入的一个新特性，它允许在源代码中添加元数据，用于描述类的成员、方法、构造方法等。
    注解本质是一个继承了Annotation接口的特殊接口，它定义了一个@interface关键字，用于标识一个注解。
## 异常
    异常（Exception）是Java SE5引入的一个新特性，它允许在程序运行时处理错误和异常。
    异常体系主要基于两类：Throwable类及其子类Error类与Exception类。
    1、Error类：Error类是Throwable类的子类，它表示Java虚拟机在运行时发生的错误。
    2、Exception(异常)类：Exception类是Throwable类的子类，它表示Java程序在运行时发生的错误。
            异常分为两类：非运行时异常和运行时异常。
### 1、异常的处理方式有哪些
    1、try-catch-finally：try-catch-finally语句用于处理异常。
    示例：
    try {
        // 可能会抛出异常的代码
    } catch (Exception e) {
        // 处理异常的代码
    }finally {
        //  finally块中的代码总会被执行，即使try块中的代码抛出了异常。}
    2、throws：throws关键字用于声明异常。
    示例：
    public void method() throws IOException {
        // 方法体
    }
    3、throw语句：throw语句用于抛出异常。
    示例：
    throw new IOException("IO异常");
## object
### 1、== 与 equals有什么区别
    对于字符串变量来说：==与equals的比较方法不同，==比较的是两个字符串的引用是否相同，equals比较的是两个字符串的内容是否相同。
    对于非字符串变量来说，如果没有对equals方法进行重写，==与equals的比较方法相同，即比较两个对象的引用是否相同。
    == 属于数值比较
    equals 属于内容比较
### 2、StringBuilder与StringBuffer的区别
    String是Java中基础且重要的类，它提供了许多用于操作字符串的方法。被声明为final class，不能被继承。
    因为它的不可变性，所以拼接字符串时会产生很多无用的中间对象。
    -->StringBuffer就是为了解决大量拼接字符串时产生很多中间对象问题而提供的一个类。其提供了append和add方法，可以进行字符串的拼接。
        本质上是一个线程安全的可修改的字符序列。
    -->StringBuilder和StringBuffer本质上没有什么区别，就是去掉了保证线程安全的那部分，减少了开销
    线程安全：StringBuffer是线程安全的；
            StringBuilder是线程不安全的。
    使用场景：操作少量的数据使用String
            单线程操作大量数据使用StringBuilder
            多线程操作大量数据使用StringBuffer
## 序列化*
## 设计模式*
## I/O*




















