

public class FibonacciSequence
{
    private double[] f = new double[100];

    public double GetFib(int i, boolean memo)
    {
        f[0] = f[1] = 1;

        if(memo)
            return memoFib(i - 1);
        else
            return fib(i-1);
    }


    private double fib(int n)
    {
        if(n < 2)
            return 1;

        return fib(n-1) + fib(n-2);
    }

    private double memoFib(int n)
    {
        if(f[n] == 0)
            f[n] = memoFib(n-1 ) + memoFib(n-2);

        return f[n];
    }
}
