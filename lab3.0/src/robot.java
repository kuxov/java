public class robot implements Runnable
{
    private final int WORKS = 5;
    private type type;
    private cabinet cabinet;

    public robot(type t, cabinet c)
    {
        setType(t);
        setCabinet(c);
    }

    @Override
    public void run()
    {
        while (true)
        {
            try {
                Thread.currentThread().setName(getType() + "_робот");
                Thread.sleep(1000);

                student s = getCabinet().get(getType());

                if (s != null)
                {
                    while (s.checkProgress())
                    {
                        Thread.sleep(1000);
                        s.incProgress(WORKS);
                    }
                }
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void setCabinet(cabinet cabinet)
    {
        this.cabinet = cabinet;
    }

    public void setType(type type)
    {
        this.type = type;
    }

    public type getType()
    {
        return type;
    }

    public cabinet getCabinet()
    {
        return cabinet;
    }
}

