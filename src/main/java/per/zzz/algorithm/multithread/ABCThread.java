package per.zzz.algorithm.multithread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/15 9:39
 */
public class ABCThread {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (lock){
                    System.out.print("A");
                    try {
                        lock.notifyAll();
                        if (i < 4){
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        },"ThreadA").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (lock){
                    System.out.print("B");
                    try {
                        lock.notifyAll();
                        if (i < 4){
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"ThreadB").start();


//        new Thread(() -> {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            for (int i = 0; i < 10; i++) {
//                synchronized (lock){
//                    System.out.print("C");
//                    try {
//                        lock.notifyAll();
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        },"ThreadC").start();
    }
}
