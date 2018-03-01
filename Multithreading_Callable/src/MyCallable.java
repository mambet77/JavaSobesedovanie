
import java.util.concurrent.Callable;


/**
 * Created by dimitrij.mackert on 23.01.2018.
 */
public class MyCallable implements Callable<Integer>
{

private static int count=0;

    @Override
    public Integer call() throws Exception
    {

        Thread.sleep(1000);
        return count++;
    }
}


