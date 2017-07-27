package ru.multithreading;

public class Intro {
    public static void main(String[] args) {
        new Intro().doCounter();
    }

    private  int count = 0;

    private synchronized void increment() {
        count++;
    }

    private void doCounter() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; ++i) {
                    increment();
                }
                System.out.println(count + " = " + Thread.currentThread().getName());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; ++i) {
                    increment();
                }
                System.out.println(count + " = " + Thread.currentThread().getName());
            }
        });

        t1.start();
        t2.start();

//        while (t1.isAlive()||t2.isAlive()){
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(count);
    }
}



