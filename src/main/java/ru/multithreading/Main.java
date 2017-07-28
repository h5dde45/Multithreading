package ru.multithreading;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        resource.setI(5);

        MyThread myThread = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread.setName("1");
        myThread2.setName("2");
        myThread.setResource(resource);
        myThread2.setResource(resource);
        myThread.start();
        myThread2.start();
        myThread.join();
        myThread2.join();
        System.out.println(resource.getI());
        System.out.println(Thread.currentThread().getName());

    }
}

class MyThread extends Thread {
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.changeI();
        System.out.println(Thread.currentThread().getName()+" = "+resource.getI());
    }
}

class Resource {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public synchronized void changeI() {
          int i = this.i;
        if (Thread.currentThread().getName().equals("1")){
            Thread.yield();
        }
        i++;
        this.i = i;
    }
}



