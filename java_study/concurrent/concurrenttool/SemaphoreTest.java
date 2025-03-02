package concurrent.concurrenttool;

import java.util.concurrent.Semaphore;

/**
 * Semaphore：是一个同步工具类，一个计数信号量，用来控制对资源的访问权限。
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);// 创建一个具有2个许可的信号量对象
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire(); //获取许可
                    System.out.println(Thread.currentThread().getName() + "获得锁");
                    Thread.sleep(1000);//模拟资源使用
                    System.out.println(Thread.currentThread().getName() + "释放锁");
                    semaphore.release();//释放许可
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
