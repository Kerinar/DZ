package DZ_4.Livelock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Livelock {
    void main(){
        Lock first = new ReentrantLock();
        Lock second = new ReentrantLock();

        Runnable locker1 = () -> {
            boolean firstLocked = false;
            boolean secondLocked = false;

            try {
                while (!firstLocked || !secondLocked) {
                    firstLocked = first.tryLock(100, TimeUnit.MILLISECONDS);
                    IO.println("Thread1, First locked: " + firstLocked);

                    secondLocked = second.tryLock(100, TimeUnit.MILLISECONDS);
                    IO.println("Thread1, Second locked: " + secondLocked);
                }
                first.unlock();
                second.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable locker2 = () -> {
            boolean firstLocked = false;
            boolean secondLocked = false;

            try {
                while (!firstLocked || !secondLocked) {
                    firstLocked = second.tryLock(100, TimeUnit.MILLISECONDS);
                    IO.println("Thread2, Second locked: " + firstLocked);

                    secondLocked = first.tryLock(100, TimeUnit.MILLISECONDS);
                    IO.println("Thread2, First locked: " + secondLocked);
                }
                first.unlock();
                second.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(locker1).start();
        new Thread(locker2).start();

        IO.println("main");
    }
}
