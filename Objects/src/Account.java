
// Compiler implicitly appends the instance variable with
// this keyword such that when object1 is calling the set data method,
// an instance variable is appended by its reference variable

public class Account
{
    private int a, b;

    public void setData(int c, int d)
    {
        a = c;
        b = d;
    }

    public void showData()
    {
        System.out.println("Value of A = " + a);
        System.out.println("Value of B = " + b);
    }
   
    public static void main (String[] args)
    {
        Account object1 = new Account();
        object1.setData(2, 3);
        object1.showData();
        Account object2 = new Account();
        object2.setData(4, 5);
        object2.showData();
    }
}