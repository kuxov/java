import java.util.Random;

public class studentGen implements Runnable
{
    private cabinet cabinet;
    private int students;

    public studentGen(cabinet c, int s)
    {
        setCabinet(c);
        setStudents(s);
    }

    private int getRandLoad()
    {
        int[] load = {10, 20, 100};
        Random r = new Random();
        return load[r.nextInt(load.length)];
    }

    private type getRandType()
    {
        Random r = new Random();
        return type.values()[r.nextInt(type.values().length)];
    }

    @Override
    public void run()
    {
        int c = 0;

        while (c < students)
        {
            Thread.currentThread().setName("Генератор_" + c);
            c++;

            cabinet.add(new student(getRandType(), getRandLoad()));

            try
            {
                Thread.sleep(1000);
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

    public void setStudents(int students)
    {
        this.students = students;
    }
}
