import java.math.BigInteger;
import java.util.Scanner;

public class Sol 
{
    public static void main(String[] args) 
    {
        Scanner ss3 = new Scanner(System.in);

        long m = ss3.nextLong();
        long w = ss3.nextLong();
        long p = ss3.nextLong();
        long n = ss3.nextLong();
        System.out.println(solve(m, w, p, n));
        ss3.close();
    }
    static long solve(long m, long w, long p, long n)
     {
        if (BigInteger.valueOf(m).multiply(BigInteger.valueOf(w)).compareTo(BigInteger.valueOf(n)) > 0) 
        {
            return 1;
        }
        long min_Pass = Long.MAX_VALUE;
        long current_Pass = 0;
        long prod = 0;
        while (true) 
        {
            long rPass = divideToCeil(n - prod, m * w);
            min_Pass = Math.min(min_Pass, current_Pass + rPass);

            if (rPass == 1) 
            {
                break;
            }

            if (prod < p) 
            {
                long extra_Pass = divideToCeil(p - prod, m * w);

                current_Pass += extra_Pass;
                prod += extra_Pass * m * w;

                if (prod >= n) 
                {
                    min_Pass = Math.min(min_Pass, current_Pass);
                    break;
                }
            }
            prod -= p;
            if (m <= w) 
            {
                m++;
            } else 
            {
                w++;
            }
        }
        return min_Pass;
    }
    static long divideToCeil(long x, long y)
     {
        return x / y + (x % y == 0 ? 0 : 1);
    }
}