import java.util.ArrayList;
import java.util.List;

public class cabinet
{
    private List<student> list;
    private int students;
    private final int MAX = 5;
    private final int MIN = 0;

    public cabinet()
    {
        list = new ArrayList<>();
    }

    public synchronized student get(type t)
    {
        try
        {
            if (students > MIN)
            {
                notifyAll();
                for (student s : list)
                {
                    if (t == s.getType())
                    {
                        students--;

                        System.out.println("Студентов: " + list.size() + "/ студент вышел " +
                                Thread.currentThread().getName() + "\t\t" + s.getLoad() + "\t\t" + s.getType());

                        list.remove(s);
                        return s;
                    }
                }
            } else System.out.println(Thread.currentThread().getName() + "/ студентов пригласили, никого не было");
            wait();
        } catch(InterruptedException error)
        {
            error.printStackTrace();
        }
        return null;
    }

    public synchronized void add(student s)
    {
        try
        {
            if (students < MAX)
            {
                notifyAll();

                list.add(s);

                System.out.println("Студентов: " + list.size() + "/ студент вошел в кабинет (" +
                        Thread.currentThread().getName() + ")\t\t" + s.getLoad() + "\t\t" + s.getType());
                students++;
            } else
                {
                System.out.println("Студентов : " + list.size() + "/ кабинет заполнен ("
                        + Thread.currentThread().getName() + ")");
                wait();
            }
        } catch(InterruptedException error)
        {
            error.printStackTrace();
        }
    }
}
