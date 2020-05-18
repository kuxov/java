public class generator implements Runnable
{
    private cabinet cab;

    public generator(cabinet cab)
    {
        this.cab = cab;
    }

    @Override
    public void run()
    {
        try
        {
            int i = 1;
            while (i <= 100)
            {
                if (cab.getQueue().size() != 10)
                {
                    student s = new student(i);
                    synchronized (cab)
                    {
                        cab.put(s);
                        System.out.println("+1 студент : " + s);
                        cab.notifyAll();
                    }
                    i += 1;
                }
            }
            cab.s3t(false);
            System.out.println("все зашли");

        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
