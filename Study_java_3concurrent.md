# Study_java_3.concurrent
## 多线程
    Java 给多线程编程提供了内置的支持。 一条线程指的是进程中一个单一顺序的控制流，
    一个进程中可以并发多个线程，每条线程并行执行不同的任务。
### 1、使用多线程要注意哪些问题
    要保证多线程的允许是安全的，即线程之间不会互相影响。
    Java的线程安全主要有三个方面：
    原子性：保证一个线程正在执行一个操作时，其他线程不能干扰，即一个线程正在执行一个操作时，其他线程不能执行任何操作。
    可见性：保证一个线程正在执行一个操作时，其他线程可以访问到该操作。
    有序性：一个线程观察其他线程中的指令执行顺序
### 2、保证数据的一致性有哪些方案呢
    事务管理: 保证数据的一致性
    锁机制：使用锁来实现对共享资源的互斥访问。
    版本控制：使用版本控制来保证数据的一致性。
### 3、线程的创建方式
    1、继承Thread类，重写run方法，创建线程对象，调用start方法启动线程。
    示例：class MyThread extends Thread{
            @Override
            public void run(){
                System.out.println("MyThread");}}
         public static void main(String[] args){
            MyThread myThread = new MyThread();
            myThread.start();}
    采用该方式，优点：简单，缺点：因为已经继承了Thread类，所以不能继承其他父类
    2、实现Runnable接口，创建线程对象，调用start方法启动线程。
    示例：class MyRunnable implements Runnable{
            @Override
            public void run(){
                System.out.println("MyRunnable");}}
         public static void main(String[] args){
             Thread thread = new Thread(new MyRunnable());
             thread.start();}
    采用该方式，优点：可以继承其他父类，缺点：编程稍微复杂，如果需要访问当前线程，必须使用Thread.currentThread()方法。
    3*、使用Callable接口，创建线程对象，调用FutureTask类，调用start方法启动线程。
    示例：class MyCallable implements Callable<Integer>{
            @Override
            public Integer call() throws Exception{
                //线程需要执行的代码，这里返回一个整型结果
                return 1;}}
         public static void main(String[] args){
            MyCallable task = new MyCallable();
            FutureTask<Integer> futureTask = new FutureTask<>(task);
            Thread thread = new Thread(futureTask); 
            thread.start();
            try{
                Integer result = futureTask.get();
                System.out.println("result:"+result);
            } catch (InterruptedException | ExecutionException e){
                e.printStackTrace();}}
    采用该方式，优点：可以继承其他父类，可以访问当前线程，缺点：编程稍微复杂。
    4*、采用线程池，创建线程对象，调用线程池的submit方法启动线程。
### 4、怎么启动线程
    启动线程的通过Thread类的start()方法
    示例：class MyThread extends Thread{
            @Override
            public void run(){
                System.out.println("MyThread");}}
         public static void main(String[] args){
             MyThread myThread1 = new MyThread();
             MyThread myThread2 = new MyThread();
             myThread1.start();
             myThread2.start();}
### 5、如何停止一个线程的运行
    1、使用Thread.stop()方法，但是该方法已经被废弃，不建议使用。
    2、使用Thread.interrupt()方法，该方法会设置线程的中断标志位，可以通过Thread.isInterrupted()方法判断线程是否被中断。
    3、使用Thread.sleep()方法，该方法会抛出InterruptedException异常，可以通过try-catch语句捕获异常。
    4、使用return停止线程，调用interrupt标记为终端状态后，在run方法中判断当前线程状态，如果为终端状态，则返回。
### 6、调用interrupt是如何让线程抛出异常的
    1、调用interrupt()方法，会设置当前线程的中断标志位，可以通过Thread.isInterrupted()方法判断线程是否被中断。
    `会根据实际情况做出相应的处理`
        如果该线程正在执行低级别的可中断方法（如sleep、wait、join等），则会抛出InterruptedException异常，
        否则Thread.interrupted()仅设置线程的中断状态，不会抛出异常。
### 7、Java进程的状态有哪些
    1、新建：当一个进程被创建，但还没有开始运行时，它的状态就是新建。NEW
    2、就绪：当一个进程被创建，但还没有被分配到CPU时，它的状态就是就绪。RUNNABLE
    3、等待监视器锁时，陷入阻塞状态。BLOCKED
    4、等待状态，陷入阻塞状态。WAITING
    5、终止状态。TERMINATED
### 8、blocked与waiting有啥区别
    1、blocked：当一个线程在等待一个锁时，该线程进入blocked状态。
    2、waiting：当一个线程正在等待另一个线程执行完一个某些操作时，进入waiting状态。线程在唤醒时需要被显式唤醒
### 9、notify和notifyAll的区别
    同样是唤醒等待的线程，同样最多只有一个线程能获得锁，同样不能控制那个线程获得锁。
    1、notify：唤醒一个等待的线程，该线程需要被显式唤醒。同时其他线程依然处于wait的等待唤醒状态
    2、notifyAll：唤醒所有等待的线程，开始竞争锁，但只有一个线程能抢到锁。
## 并发安全
### 1*、怎么保证多线程安全
    ~synchronized关键字：可以使用synchronized关键字来同步代码块，保证多线程安全。
                        对象锁是通过synchronized关键字锁定对象的监视器（monitor）来实现的
    ~ReentrantLock：可以使用ReentrantLock类来创建一个可重入锁，保证多线程安全。
    ~volatile关键字：可以使用volatile关键字来保证变量的可见性，保证多线程安全。
    ~原子类：Java并发库(java.util.concurrent.atomic)提供了原子类，可以使用原子类来保证变量的原子性，保证多线程安全。
    ~线程局部竞争：可以使用ThreadLocal类来保证变量的线程局部性，保证多线程安全。
    ~并发集合：Java并发库(java.util.concurrent)提供了并发集合，可以使用并发集合来保证集合的线程安全，保证多线程安全。
    ~JUC工具类
### 2*、Java中有哪些锁，在什么场景下适合使用
    1、内置锁(synchronized)：内置锁是Java并发编程中常用的一种锁，它使用对象监视器来实现同步。
    2、显式锁(ReentrantLock)：显式锁是Java并发编程中常用的一种锁，它使用Lock接口来实现同步。
    3、读写锁(ReadWriteLock)：读写锁是Java并发编程中常用的一种锁，它使用读写锁来实现并发访问。但只允许一个写入者
    4、乐观锁和悲观锁：乐观锁和悲观锁是Java并发编程中常用的两种锁，它们分别使用不同的策略来保证并发访问的安全性。内置锁和ReentrantLock都是悲观锁，而ReadWriteLock是乐观锁。
                    乐观锁通常不锁定资源
    5、自旋锁：自旋锁是Java并发编程中常用的一种锁，它使用循环来等待锁，直到获得锁为止。
### 3*、怎么在实践中用锁的
### 4、Java并发工具
    常用的并发工具，它们位于java.util.concurrent包中。
    1、CountDownLatch：是一个同步工具类，用来控制一个或者多个线程等待多个线程。
            它使用一个计数器进行初始化，调用countDown()方法可以递减计数器，调用await()方法可以阻塞当前线程，直到计数器为0。
    2、CyclicBarrier：是一个同步工具类，用来控制多个线程互相等待，直到全部到达。
            与CountDownLatch不同的是，CyclicBarrier侧重于线程间的相互等待，而不是等待某些操作完成。
    3、Semaphore：是一个同步工具类，一个计数信号量，用来控制对资源的访问权限。
    4、Future和Callable：Future是一个接口，它代表一个异步计算的结果。Callable是一个接口，它代表一个可以异步执行的任务。
### 5、synchronized 和 ReentrantLock 及其应用场景
    1、synchronized：synchronized是Java并发编程中常用的一种锁，它使用对象监视器来实现同步。
    synchronized是排他锁，当一个线程获得锁后，其他线程必须等待该线程释放后才能获得锁。使用synchronized之后
    会在编译之后在同步的代码块前后加上monitorenter和monitorexit字节码指令，所以编译之后会在字节码中生成一个监视器锁。
    深入到源码来说：synchronized实际上有两个队列waitSet和entryList
    a、当多个线程进入同步代码快时，首先进入到entryList
    b、当一个线程获得monitor锁后，就赋值给当前线程，并且计数器加1
    c、当一个线程释放monitor锁后，计数器减1，如果计数器为0，则从entryList中移除，进入waitSet
    2、ReentrantLock：ReentrantLock是Java并发编程中常用的一种锁，它使用Lock接口来实现同步
    ReentrantLock是可重入锁，它使用ReentrantLock接口来实现同步。ReentrantLock使用一个内部类ReentrantLock.Sync来维护锁的状态。
    不同的Sync子类实现了不同的锁机制，如可中断锁、不可中断锁、公平锁、非公平锁等。
    3*、应用场景的区别
    synchronized：简单同步需求、代码块同步、内置锁的使用
    ReentrantLock：复杂同步需求、性能优化、高级锁功能需求
    综上所述：synchronized是Java并发编程中常用的一种锁，它使用对象监视器来实现同步。而ReentrantLock是Java并发编程中常用的一种锁，它使用Lock接口来实现同步。
### 6、怎么理解可重入锁
    可重入锁是指同一个线程在获取锁之后，可以再次重复获得该锁而不会造成死锁或其他问题。
    ReentrantLock实现可重入锁的机制是基于线程持有锁的计数器。
        当一个线程第一次获取锁时，计数器加1，表示该线程持有了锁。在此之后，如果同一个线程再次获得
    锁，计数器会再次加1.每次线程成功获取锁时都会将计数器加1.
        当一个线程释放锁时，计数器减1，如果计数器为0，则表示该线程已经释放了锁。
### 7*、syncronized锁升级的过程
    具体升级过程是：无锁->偏向锁->轻量级锁->重量级锁
### 8*、JVM对synchronized锁的优化
### 9*、介绍AQS
    AQS(AbstractQueuedSynchronizer)是Java并发编程中常用的一种同步工具类，它实现了一个锁的抽象，是一个用于构建锁、同步器、协作工具类的工具类（框架）
    AQS核心思想是：通过维护一个队列，将等待资源的线程进行排队，然后通过 CLH队列的变体实现的，将暂时获取不到锁的线程加入到队列中
    
    CLH: Craig, Landin, and Hagersten队列，是单向链表，AQS中的队列是CLH变体的虚拟双线队列（FIFO），AQS是通过将每条请求共享资源的县城封装成一个节点来实现锁的分配。
    AQS通过一个Volatile变量state来表示锁的状态，state的值表示当前锁的拥有者。
    Sync是AQS的实现。AQS主要完成的任务：同步状态的原子性管理、线程的阻塞和解除阻塞、队列的管理

    AQS的原理：1、状态：state;2、控制线程枪锁的队列;3、期望协作工具类去实现的获取/释放锁的接口
### 10、Threadlocal作用，原理，具体里面存的key value是啥，会有什么问题，如何解决
    Threadlocal是Java中用于解决线程安全问题的一种很机制，它允许创建线程局部的变量。即每个线程都有自己独立的变量副本，从而避免线程间资源共享和同步问题
    Threadlocal的原理：Threadlocal通过ThreadLocalMap来实现线程的局部变量，ThreadLocalMap是一个线程安全的哈希表，用于存储线程的局部变量。
        -当调用ThreadLocal的get()方法时，ThreadLocalMap会从当前线程的ThreadLocalMap中获取对应的值，如果获取不到，则调用initialValue()方法来初始化值，并返回。
        -当调用ThreadLocal的set()方法时，ThreadLocalMap会更新当前线程的ThreadLocalMap中的值,即在当前线程的ThreadLocalMap中添加或更新对应的键值对。
         键是ThreadLocal的实例，值是线程局部变量的值。
        -当调用ThreadLocal的remove()方法时，ThreadLocalMap会从当前线程的ThreadLocalMap中移除对应的键值对。
    Threadlocal的使用场景：1、解决线程安全的问题，2、解决线程间数据共享的问题，3、解决线程间数据传递的问题
    Threadlocal的缺点：1、内存泄漏，2、性能问题，3、线程安全
### 11*、悲观锁和乐观锁的区别
    悲观锁：悲观锁是指在获取锁时，会阻止其他线程对资源的访问，直到当前线程释放锁。
    乐观锁：乐观锁是指在获取锁时，不会阻止其他线程对资源的访问，而是通过版本号来判断是否需要重新获取锁。
### 12、什么是公平锁，非公平锁
    公平锁：公平锁是指在获取锁时，会按照请求顺序依次获取锁，即先来的线程会先获取锁。
    非公平锁：非公平锁是指在获取锁时，不会按照请求顺序依次获取锁，而是会随机获取锁。
### 13*、什么情况下会产生死锁问题，如何解决
    死锁：死锁是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的现象，若无外力作用，它们将无法推进下去。
    解决死锁：1、避免死锁：避免两个进程同时请求同一资源。2、避免循环等待：避免一个进程请求另一个进程已经请求的资源。3、使用Timeout机制：设置一个超时时间，如果超过这个时间，则自动取消请求。4、使用死锁检测算法：使用死锁检测算法，可以检测出死锁的情况。5、使用死锁
    死锁产生的条件：1、互斥条件：指进程对资源的互斥使用，即一个资源一次只能被一个进程使用。2、请求和保持条件：指进程已经保持至少一个资源，在请求其他资源时，不释放已获取的资源。3、不剥夺条件：指进程已经获取到的资源，在未使用完之前，不能被
    4、循环等待条件：指进程之间存在循环等待资源关系，即A请求资源B，B请求资源A。
## 线程池***
    线程池是Java并发编程中常用的一种线程管理工具，它允许创建线程池，并在线程池中执行线程任务。线程池可以提高线程的复用率，减少线程创建和销毁的开销，提高程序性能。
### 1、线程池的参数有哪些
    --corePoolSize：线程池中核心线程的数量，即在创建线程池时，创建的线程数量。
    --maximumPoolSize：线程池中最大线程的数量，即线程池中允许创建的最大线程数量。
    --keepAliveTime：线程池中空闲线程的存活时间，即线程空闲了keepAliveTime时间后，线程会被回收。
    --unit：keepAliveTime的单位，可以是秒、毫秒、微秒等。
    --workQueue：线程池中的任务队列，即线程池中存放任务的队列。
    --threadFactory：线程工厂，用于创建线程。
    --handler：线程池中的拒绝策略，即当线程池中的任务队列满时，如何拒绝新任务。
### 2、线程池工作队列满了有哪些拒接策略？
    1、CallerRunsPolicy：调用者运行策略，即如果线程池中的任务队列满了，则调用者所在的线程会立即执行新任务。
    2、AbortPolicy：终止策略，即如果线程池中的任务队列满了，则抛出RejectedExecutionException异常。
    3、DiscardPolicy：丢弃策略，即如果线程池中的任务队列满了，则丢弃新任务。
    4、DiscardOldestPolicy：丢弃最老的任务策略，即如果线程池中的任务队列满了，则丢弃队列中最老的任务，并尝试执行新任务。























