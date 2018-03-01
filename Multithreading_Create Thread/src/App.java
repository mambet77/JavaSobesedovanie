import javax.xml.ws.Service;
import java.util.concurrent.*;

public class App
{
    public static void main(String[] args)
    {

        //region create Thread: Option 1
        Thread threadOne = new Thread(() -> {
            System.out.println("i'm running. MyNumber " + Thread.currentThread().getId());
        });
        threadOne.start();
        //endregion

        //region create Thread: Option 2
        MyThread myThread = new MyThread();
        myThread.start();
        //endregion

        //region create Thread: Option 3
        MyRunnable myRunnable = new MyRunnable();
        Thread threadTwo = new Thread(myRunnable);
        threadTwo.start();
        //endregion


        //region create Thread: Option 4

        MyThreadWithParameter myThreadWithParameter = new MyThreadWithParameter();
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future future = service.submit(myThreadWithParameter);

        try
        {
            Long processID= (Long)future.get();
            System.out.println("I getting ProzessId: "+processID);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        //endregion

    }
}


