package concurrent.concurrenttool;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch：是一个同步工具类，用来控制一个或者多个线程等待多个线程。
 * 它使用一个计数器进行初始化，调用countDown()方法可以递减计数器，调用await()方法可以阻塞当前线程，直到计数器为0。
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException{
        // TODO Auto-generated method stub
        int numberOfThreads = 3;
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        //创建并启动三个线程
        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(()->{
                System.out.println("Thread " + Thread.currentThread().getName() + " 正在工作 ");
                try {
                    Thread.sleep(1000); //模拟耗时操作
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                latch.countDown(); //完成工作，计数器减一
                System.out.println("Thread " + Thread.currentThread().getName() + " 完成工作");
            }).start();
        }
        System.out.println("主线程正在等待其他线程完成工作...");
        latch.await(); //等待所有线程完成工作，直到计数器为0
        System.out.println("所有工作线程已经完成，主线程继续执行...");
    }
}
