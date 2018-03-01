import javax.xml.ws.Service;
import java.util.concurrent.*;

public class App
{
    public static void main(String[] args) throws InterruptedException
    {

        CountDownLatch countDownLatch= new CountDownLatch(3);


        for(int i=0;i<10;i++)
        {
            new MyThread(countDownLatch).start();
            Thread.sleep(1400);

        }


    }

}


