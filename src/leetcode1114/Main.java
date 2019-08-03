package leetcode1114;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ohm
 */
public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                synchronized (foo) {
                    while (foo.n != 1) {
                        foo.wait();
                    }
                    foo.f(foo.n++);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (foo) {
                        while (foo.n != 2) {
                            foo.wait();
                        }
                        foo.f(foo.n++);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (foo) {
                        while (foo.n != 3) {
                            foo.wait();
                        }
                        foo.f(foo.n++);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
class Foo {

    volatile int n = 1;
    public Foo() {

    }

    void f(int n) throws InterruptedException{
        if(n == 1) {
            first(new Runnable() {
                @Override
                public void run() {
                    System.out.println("one");
                }
            });
        } else if(n == 2) {
            second(new Runnable() {
                @Override
                public void run() {
                    System.out.println("two");
                }
            });
        } else if(n == 3) {
            second(new Runnable() {
                @Override
                public void run() {
                    System.out.println("three");
                }
            });
        }
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
