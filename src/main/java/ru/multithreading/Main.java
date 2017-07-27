package ru.multithreading;

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("new thread");
        System.out.println(Thread.currentThread().getName());
        someMethod();
    }
    private void someMethod(){
        throw new RuntimeException();
    }
}



