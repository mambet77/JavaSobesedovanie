import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by dimitrij.mackert on 23.01.2018.
 */
public class MyThread extends Thread
{
    private final CyclicBarrier barrier;


    public MyThread(CyclicBarrier barrier)
    {
        this.barrier = barrier;

    }


    @Override
    public void run()
    {
        System.out.println("i'm start. MyNumber " + Thread.currentThread().getId());
        try
        {
            barrier.await();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (BrokenBarrierException e)
        {
            e.printStackTrace();
        }



        System.out.println("i'm finish. MyNumber " + Thread.currentThread().getId());
    }
}


