package practice.lesson5;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Есть пять философов (потоки), которые могут либо обедать, либо размышлять. +
 * Каждый философ должен пообедать три раза. +
 * Каждый прием пищи длиться 500 миллисекунд +
 * После каждого приема пищи философ должен размышлять +
 * Не должно возникнуть общей блокировки +
 * Философы не должны есть больше одного раза подряд +
 * Одновременно не кушают???
 */

public class Hw5 {
    static CountDownLatch eat1 = new CountDownLatch(5);
    static CountDownLatch eat2 = new CountDownLatch(5);
    static CountDownLatch eat3 = new CountDownLatch(5);
    static String phThatEatBefore;
    static final Object fork = new Object();
    static final Random random = new Random();

    public static void main(String[] args) {

        Thread ph1 = new Thread(new Philosopher("Phil_1 "));
        Thread ph2 = new Thread(new Philosopher("Phil_2 "));
        Thread ph3 = new Thread(new Philosopher("Phil_3 "));
        Thread ph4 = new Thread(new Philosopher("Phil_4 "));
        Thread ph5 = new Thread(new Philosopher("Phil_5 "));


        ph1.start();
        ph2.start();
        ph3.start();
        ph4.start();
        ph5.start();

    }

    public static class Philosopher implements Runnable {
        String name;

        public Philosopher(String name) {

            this.name = name;

        }

        @Override
        public void run() {
            try {
                Thread.sleep(random.nextInt(10));
                eat(eat1, " eating...");
                skipWhoEatBefore();
                eat(eat2, " eating * ...");
                skipWhoEatBefore();
                eat(eat3, " eating ** ...");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void eat(CountDownLatch count, String eating) throws InterruptedException {
            synchronized (fork) {
                phThatEatBefore = name;
                System.out.println(name + eating);
                Thread.sleep(500);
                System.out.println(name + "philosophizing... ");
            }
            count.countDown();
            count.await();
        }

        public void skipWhoEatBefore() throws InterruptedException {

            while (Objects.equals(phThatEatBefore, name)) {
                Thread.sleep(1);
            }
        }
    }
}
