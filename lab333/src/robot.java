public class robot implements Runnable
{
    private String subject;
    private cabinet cab;

    public robot(String subject, cabinet cabinet)
    {
        this.subject = subject;
        this.cab = cabinet;
    }

    @Override
    public void run()
    {
        try
        {
            while(true)
            {
                student s = null;
                synchronized (cab)
                {
                    if (!cab.g3t() && cab.getQueue().size() == 0) break;
                    while (cab.getQueue().size() == 0)
                    {
                        cab.wait();
                    }
                    if (cab.peek() != null)
                    {
                        if (cab.peek().subject.equals(subject))
                        {
                            s = cab.get();
                            cab.notifyAll();
                        }
                        else
                        {
                            cab.wait();
                        }
                    }
                }

                if (s != null)
                {
                    while (s.labs != 0)
                    {
                        System.out.println(subject + "робот принял " + s);
                        s.decLabs(5);
                        Thread.sleep(1000);
                    }
                    System.out.println(subject + " робот отпустил " + s);
                }
            }

        } catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
