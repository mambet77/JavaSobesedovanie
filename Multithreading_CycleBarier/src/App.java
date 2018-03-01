import javax.xml.ws.Service;
import java.util.concurrent.*;

public class App
{
    public static void main(String[] args) throws InterruptedException
    {

        CyclicBarrier barrier= new CyclicBarrier(3,new myRunnable());


        for(int i=0;i<10;i++)
        {
            new MyThread(barrier).start();
            Thread.sleep(1400);

        }


    }



}


