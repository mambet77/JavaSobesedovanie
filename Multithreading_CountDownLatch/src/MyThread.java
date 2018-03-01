import java.util.concurrent.CountDownLatch;

/**
 * Created by dimitrij.mackert on 23.01.2018.
 */

public class MyThread extends Thread
{
    private final CountDownLatch countDownLatch;
    private static int counter=0;


    public MyThread(CountDownLatch countDownLatch)
    {
        this.countDownLatch = countDownLatch;
        counter++;
    }


    @Override
    public void run()
    {
        System.out.println("i'm start. MyNumber "+ Thread.currentThread().getId());

        try
        {
            countDownLatch.countDown();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            countDownLatch.await();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("i'm finish. MyNumber "+ Thread.currentThread().getId());
    }
}


