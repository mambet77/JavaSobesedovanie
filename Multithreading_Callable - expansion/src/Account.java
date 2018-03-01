import java.lang.reflect.AnnotatedArrayType;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * Created by dimitrij.mackert on 14.02.2018.
 */
public class Account
{
    private Lock lock;
    private int Amount;

    public Logger logger;

    public Account(int amount)
    {
        Amount = amount;
        lock= new ReentrantLock();
        logger= Logger.getLogger("myLOgger");
    }


    public Lock getLock()
    {
        return lock;
    }


    public int getAmount()
    {
        return Amount;
    }


    public void minus(int value)
    {
        Amount -= value;
       logger.info(getAmount()+"");
    }


    public void plus(int value)
    {
        Amount += value;
        logger.info(getAmount()+"");
    }
}
