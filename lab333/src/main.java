import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class main {

    public static void main(String[] args) {

        System.out.println("роботы начали принимать студентов");
        try {

            cabinet studentLine = new cabinet();
            ExecutorService threads = Executors.newFixedThreadPool(4);
            threads.execute(new robot(data.subjects[0], studentLine));
            threads.execute(new robot(data.subjects[1], studentLine));
            threads.execute(new robot(data.subjects[2], studentLine));
            threads.submit(new generator(studentLine));
            threads.shutdown();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}