package DZ_4.Deadlock;

public class Deadlock {
    void main(){
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lock1){
                IO.println("thread1, lock1 synchronized");
                synchronized (lock2){
                    IO.println("thread1, lock2 synchronized");
                }
            }
            IO.println("thread1 finished");
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2){
                IO.println("thread2, lock2 synchronized");
                synchronized (lock1){
                    IO.println("thread2, lock1 synchronized");
                }
            }
            IO.println("thread2 finished");
        });

        thread1.start();
        thread2.start();
    }
}
