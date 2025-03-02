package concurrent.concurrenttool;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier：是一个同步工具类，用来控制多个线程互相等待，直到全部到达。
 *与CountDownLatch不同的是，CyclicBarrier侧重于线程间的相互等待，而不是等待某些操作完成。
 */
public class CyclicBarrierTset {
    public static void main(String[] args) {
        int numberOfThreads = 3;
        // 创建一个循环屏障，用于协调多个线程之间的执行
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, ()->{
            System.out.println("所有线程都达到了屏障，继续执行后续操作");
        });
        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(1000); //模拟运行时间
                    barrier.await();  //等待其他线程到达屏障
                    System.out.println(Thread.currentThread().getName() + "到达屏障");
               } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
