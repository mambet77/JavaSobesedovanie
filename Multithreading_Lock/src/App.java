import java.util.concurrent.*;

public class App
{
    public static void main(String[] args) throws InterruptedException
    {

        MyObject myObject = new MyObject();
        CountDownLatch countDownLatch= new CountDownLatch(4);


        MyThread myThread1 = new MyThread(myObject, countDownLatch);
        MyThread myThread2 = new MyThread(myObject, countDownLatch);
        MyThread myThread3 = new MyThread(myObject, countDownLatch);
        MyThread myThread4 = new MyThread(myObject, countDownLatch);

        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();

        countDownLatch.await();

        myObject.printCounter();
    }
}


