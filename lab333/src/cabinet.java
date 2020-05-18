import java.util.concurrent.TimeUnit;
import java.util.concurrent.ArrayBlockingQueue;

public class cabinet
{
    private ArrayBlockingQueue<student> queue;
    private boolean bool;

    public cabinet()
    {
        this.queue = new ArrayBlockingQueue<student>(10);
        bool = true;
    }

    public ArrayBlockingQueue<student> getQueue()
    {
        return queue;
    }

    public student peek() throws InterruptedException
    {
        return queue.peek();
    }

    public void put(student s) throws InterruptedException
    {
        queue.put(s);
    }

    public student get() throws InterruptedException
    {
        return queue.poll(1,TimeUnit.SECONDS);
    }

    public void s3t(boolean n3w)
    {
        bool = n3w;
    }

    public boolean g3t()
    {
        return bool;
    }
}
