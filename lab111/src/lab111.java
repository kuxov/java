import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;

public class lab111
{

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int from = 0;
        int to = 0;


        try {
            from = sc.nextInt();
            to = sc.nextInt();
        } catch (IOError e)
        {
            System.out.println(e.getMessage());
        }

        if(from < to)
        {
            for (int i = from; i < to; i++)
            {
                if (i <= 1)
                {
                    continue;
                }

                if (isPrime(i))
                {
                    System.out.print(i + " ");
                }
            }
        }

        if(from > to)
        {
            if (to <= 0)
            {
                to = 1;
            }

            for (int i = from; i > to; i--)
            {
                if (isPrime(i))
                {
                    System.out.print(i + " ");
                }
            }
        }

    }

    public static boolean isPrime(int x)
    {
        for (int i = 2; i < x; i++)
        {
            if (x % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
