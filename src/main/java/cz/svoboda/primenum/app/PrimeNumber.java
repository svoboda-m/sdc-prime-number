package cz.svoboda.primenum.app;

public class PrimeNumber {
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        // the number needs to be checked for divisors only up to the value of its square root
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
