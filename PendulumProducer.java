/** PendulumProducer.java
 *  Works as a Producer adding to a bounded blocking queue stored internally.
 *  The consumer simply calls the get() method here to grab the next position.
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PendulumProducer implements Runnable
{
    private Pendulum pendulum;
    private BlockingQueue<Data> queue;

    public PendulumProducer(Pendulum p, int capacity)
    {
        pendulum = p;
        queue = new LinkedBlockingQueue<Data>(capacity);
    }

    public Data get()
    {
        Data result = null;
        try
        {
            result = queue.take();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        return result;
    }

    public void run()
    {
        try
        {
            while (true)
            {
                pendulum.step();
                queue.put(pendulum.get());
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
