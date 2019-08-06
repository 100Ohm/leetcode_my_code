package leetcode1114;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ohm
 */
public class Main {
    public static void main(String[] args){
        Foo foo = new Foo();
        new Thread(() -> {
            try {
                foo.first(() -> System.out.println("1"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.third(() -> System.out.println("3"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.second(() -> System.out.println("2"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
class Foo {
    volatile int n = 1;

    public void first(Runnable printFirst) throws InterruptedException {
        Thread.sleep(10);
        synchronized (this) {
            while(n != 1) {
                wait();
            }
            printFirst.run();
            n = 2;
            notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (n != 2) {
                wait();
            }
            printSecond.run();
            n = 3;
            notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (n != 3) {
                wait();
            }
            printThird.run();
        }
    }
}
