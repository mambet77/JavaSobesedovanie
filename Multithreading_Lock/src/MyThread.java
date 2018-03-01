import java.util.concurrent.CountDownLatch;

/**
 * Created by dimitrij.mackert on 23.01.2018.
 */


public class MyThread extends Thread
{
    MyObject myObject;
    private CountDownLatch countDownLatch;


    public MyThread(MyObject myObject, CountDownLatch countDownLatch)
    {
        this.myObject=myObject;
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void run()
    {
        for(int i=0;i<100000;i++)
        {
            myObject.incrementWithLock();
            myObject.incrementWithOutLock();
        }

        countDownLatch.countDown();
    }
}


