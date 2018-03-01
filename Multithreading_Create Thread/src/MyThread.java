/**
 * Created by dimitrij.mackert on 23.01.2018.
 */

public class MyThread extends Thread
{
    @Override
    public void run()
    {
        System.out.println("i'm running. MyNumber "+ Thread.currentThread().getId());
    }
}


