import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;
#hello
public class lab1
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        double from = 0;
        double to = 0;

        System.out.println("Enter a range of numbers:");

        try {
             System.out.print("from: ");
             from = sc.nextDouble();
             System.out.print("to: ");
             to = sc.nextDouble();
        } catch (Exception e)
        {
            System.out.println("illegal character!!!");
        }

        if(from < to)
        {
            from = Math.ceil(from);
            to = Math.floor(to);
            for (int i = (int) from; i < to + 1; i++)
            {
                if (i <= 1)
                {
                    i = 2;
                }

                if (isPrime(i))
                {
                    System.out.print(i + " ");
                }
            }
        }

        if(from > to)
        {
            from = Math.floor(from);
            to = Math.ceil(to);
            if (to <= 0)
            {
                to = 1;
            }

            for (int i = (int) from; i + 1 > to; i--)
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
        if (x == 1) return false;
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
