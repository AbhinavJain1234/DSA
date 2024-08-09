package recursion.stonghold;

public class poweronn {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (Math.abs(n) % 2 == 1) {
            if (n < 0) {
                double val = myPow(x, Math.abs(n) - 1);
                return 1 / (val * x);
            }
            double val = myPow(x, n - 1);
            return val * x;
        } else {
            if (n < 0) {
                double val = myPow(x, Math.abs(n) / 2);
                return 1 / (val * val);
            }
            double val = myPow(x, n / 2);
            return val * val;
        }
    }
}
