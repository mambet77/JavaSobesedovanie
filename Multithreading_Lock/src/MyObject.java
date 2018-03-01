import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dimitrij.mackert on 07.02.2018.
 */
public class MyObject
{
    private int counter=0;
    private int noLockCounter=0;
    private ReentrantLock lock;


    public MyObject()
    {
        this.lock = new ReentrantLock();
    }


    public void incrementWithLock()
    {
        lock.lock();
        counter++;
        lock.unlock();
    }
    public void incrementWithOutLock()
    {
        noLockCounter++;
    }

    public  void printCounter()
    {
        System.out.println("counter with lock"+counter);
        System.out.println("counter without lock"+ noLockCounter);
    }
}
