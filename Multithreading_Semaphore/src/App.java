import javax.xml.ws.Service;
import java.util.concurrent.*;

public class App
{
    public static void main(String[] args) throws InterruptedException
    {
        Semaphore semaphore= new Semaphore(3);
        for(int i=0;i<10;i++)
        {
            new MyThread(semaphore).start();
        }
    }



}


