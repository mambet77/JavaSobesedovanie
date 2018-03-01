import java.util.concurrent.Semaphore;

/**
 * Created by dimitrij.mackert on 23.01.2018.
 */


public class MyThread extends Thread
{
    private final Semaphore semaphore;

    private static long sleeper= 100;
    private long mySleeper;

    public MyThread(Semaphore semaphore)
    {
        this.semaphore = semaphore;
        sleeper+=2000;
        mySleeper=sleeper;
    }


    @Override
    public void run()
    {

        try
        {
            semaphore.acquire();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("i'm start. MyNumber "+ Thread.currentThread().getId());
        try
        {
            Thread.sleep(mySleeper);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        semaphore.release();
        System.out.println("i'm finish. MyNumber "+ Thread.currentThread().getId()+ " sleepr"+ mySleeper);
    }
}


