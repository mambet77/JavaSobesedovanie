import java.util.concurrent.*;

public class App
{
    public static void main(String[] args) throws Exception
    {
        Account acc1 = new Account(1000);
        Account acc2 = new Account(1100);

        ExecutorService service = Executors.newFixedThreadPool(100);
        ScheduledExecutorService statistic = Executors.newScheduledThreadPool(1);

        statistic.scheduleAtFixedRate(new Runnable()
        {	
            @Override
            public void run()
            {
                System.out.println("War nich erfolgreich "+Transfer.unsuccessTransaction());
                System.out.println("War erfolgreich "+Transfer.successTransaction());
            }
        }, 2l, 1l, TimeUnit.SECONDS);

        for (int i = 0; i < 1000; i++)
        {
            Future<Boolean> future = service.submit(new Transfer(acc1, acc2, 100));
            Future<Boolean> future2 = service.submit(new Transfer(acc2, acc1, 100));

             System.out.println(future.get()+"  "+future2.get());

        }
        service.shutdown();
        service.awaitTermination(100, TimeUnit.MILLISECONDS);
    }
}


