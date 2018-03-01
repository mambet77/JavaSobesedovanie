import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by dimitrij.mackert on 23.01.2018.
 */
public class Transfer implements Callable<Boolean>
{
    private Account from;
    private Account to;
    private int amount;
    private static AtomicInteger counter_succes=new AtomicInteger(0);
    private static AtomicInteger counter_unsucces=new AtomicInteger(0);


    public Transfer(Account from, Account to, int amount)
    {
        this.from = from;
        this.to = to;
        this.amount=amount;
    }


    public static int unsuccessTransaction()
    {
        return  counter_unsucces.get();
    }
    @Override
    public Boolean call() throws Exception
    {

        if(from.getLock().tryLock(100, TimeUnit.MILLISECONDS))
        {
            Thread.sleep(100);
            try
            {
                if(to.getLock().tryLock(100, TimeUnit.MILLISECONDS))
                {
                    try
                    {
                        if(from.getAmount() < amount)
                        {
                            throw new SecurityException();
                        }

                        Thread.sleep(100);
                        from.minus(amount);
                        to.plus(amount);
                        return true;
                    } finally
                    {
                        to.getLock().unlock();
                    }
                }
                else
                {
                    counter_unsucces.incrementAndGet();
                    return false;
                }
            } finally
            {
                from.getLock().unlock();
            }
        }
        else
        {
            counter_unsucces.incrementAndGet();
            return false;
        }
    }
}


