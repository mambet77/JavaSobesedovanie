import java.util.concurrent.*;

public class App
{
    public static void main(String[] args) throws Exception
    {

        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++)
        {
            Future<Integer> future = service.submit(new MyCallable());
            System.out.println(future.get());
        }
    }
}


