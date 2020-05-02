import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main
{
    public static void main(String[] args)
    {
        int students = 100;

        cabinet cab = new cabinet();

        studentGen studentG = new studentGen(cab, students);

        robot r1 = new robot(type.Physics, cab);
        robot r2 = new robot(type.H_Math, cab);
        robot r3 = new robot(type.OOP, cab);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(studentG);

        service.execute(r1);
        service.execute(r2);
        service.execute(r3);
    }
}
