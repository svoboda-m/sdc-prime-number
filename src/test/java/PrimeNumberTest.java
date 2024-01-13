import cz.svoboda.primenum.app.PrimeNumber;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PrimeNumberTest {
    // corner case
    @Test
    void OneIsNotPrimeNumber() {
        PrimeNumber primeNumber = new PrimeNumber();
        assertFalse(primeNumber.isPrime(1));
    }

    @Test
    void NegativeNumberIsNotPrimeNumber() {
        PrimeNumber primeNumber = new PrimeNumber();
        assertFalse(primeNumber.isPrime(-7));
    }

    @Test
    void SevenIsPrimeNumber() {
        PrimeNumber primeNumber = new PrimeNumber();
        assertTrue(primeNumber.isPrime(7));
    }

    @Test
    void TwelveIsNotPrimeNumber() {
        PrimeNumber primeNumber = new PrimeNumber();
        assertFalse(primeNumber.isPrime(12));
    }
}
