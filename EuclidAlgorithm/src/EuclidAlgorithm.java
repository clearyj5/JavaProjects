import java.util.Scanner;

public class EuclidAlgorithm
{
    // recursive implementation
    public static int gcd(int p, int q)
    {
        if (q == 0) 
        {
        	return p;
       	}
        else
        {
        	return gcd(q, p % q);
        }
    }

    // non-recursive implementation
    public static int gcd2(int p, int q)
    {
        while (q != 0)
        {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

    public static void main(String[] args)
    {
    	System.out.print("Enter two integers to calculate gcd: ");
    	Scanner input = new Scanner(System.in);
        int p = input.nextInt();
        int q = input.nextInt();

        int d  = gcd(p, q);
        int d2 = gcd2(p, q);

        System.out.println("gcd(" + p + ", " + q + ") = " + d);
        System.out.println("gcd(" + p + ", " + q + ") = " + d2);
    }

}
