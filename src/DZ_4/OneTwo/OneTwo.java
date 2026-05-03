package DZ_4.OneTwo;

public class OneTwo {
    void main(){
        Object lock = new Object();

        Thread one = new Thread(() -> {
            while (true){
                synchronized (lock){
                    IO.println("1");
                    lock.notify();
                    try{
                        lock.wait();
                    }catch(InterruptedException e){
                        IO.println("Thread1 Interrupted");
                    }
                }
            }
        });

        Thread two = new Thread(() -> {
            try{
                Thread.currentThread().sleep(2 * 1000);
            }catch(InterruptedException e){
                IO.println("Thread2 Interrupted");
            }

            while (true){
                synchronized (lock){
                    IO.println("2");
                    lock.notify();
                    try{
                        lock.wait();
                    }catch(InterruptedException e){
                        IO.println("Thread2 Interrupted");
                    }
                }
            }
        });

        one.start();
        two.start();
    }
}
