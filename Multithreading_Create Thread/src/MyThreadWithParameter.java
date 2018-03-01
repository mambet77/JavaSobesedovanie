import java.util.Objects;
import java.util.concurrent.Callable;

/**
 * Created by dimitrij.mackert on 23.01.2018.
 */
public class MyThreadWithParameter implements Callable
{
    @Override
    public Object call() throws Exception
    {

        Thread.sleep(2000);
        return Thread.currentThread().getId();
    }
}
