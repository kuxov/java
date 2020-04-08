import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;

public class lab1
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int from = 0;
        int to = 0;

        System.out.println("Enter a range of numbers:");

        try {
             System.out.print("from: ");
             from = sc.nextInt();
             System.out.print("to: ");
             to = sc.nextInt();
        } catch (Exception e)
        {
            System.out.println("illegal character!!!");
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
