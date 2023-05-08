import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathNumbertheory {
    public static void main(String[] args) {



}
    public static int modAdd(int a, int b, int m) {
        return (a + b) % m;
    }

    public static int modSub(int a, int b, int m) {
        return (a - b + m) % m;
    }

    public static int modMul(int a, int b, int m) {
        return (a * b) % m;
    }

    public static int modDiv(int a, int b, int m) {
        return (a * modInverse(b, m)) % m;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 2) {
            factors.add(n);
        }
        return factors;
    }
    public static int modPow(int base, int exponent, int modulus) {
        int result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }
            exponent = exponent >> 1;
            base = (base * base) % modulus;
        }
        return result;
    }
    public static int chineseRemainder(int[] a, int[] m) {
        int M = 1;
        for (int i = 0; i < m.length; i++) {
            M *= m[i];
        }
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            int Mi = M / m[i];
            result = modAdd(result, modMul(modMul(a[i], Mi, M), modInverse(Mi, m[i]), M), M);
        }
        return result;
    }

    public Complex[] fft(Complex[] a) {
        int n = a.length;

        if (n == 1) {
            return new Complex[] {a[0]};
        }

        Complex[] even = new Complex[n / 2];
        Complex[] odd = new Complex[n / 2];
        for (int i = 0; i < n / 2; i++) {
            even[i] = a[2 * i];
            odd[i] = a[2 * i + 1];
        }

        Complex[] q = fft(even);
        Complex[] r = fft(odd);
        Complex[] y = new Complex[n];

        for (int i = 0; i < n / 2; i++) {
            double k = -2 * i * Math.PI / n;
            Complex wk = new Complex(Math.cos(k), Math.sin(k));
            y[i] = q[i].plus(wk.times(r[i]));
            y[i + n / 2] = q[i].minus(wk.times(r[i]));
        }

        return y;
    }



class Complex {
    double re, im;

    Complex(double real, double imag) {
        this.re = real;
        this.im = imag;
    }

    Complex plus(Complex b) {
        return new Complex(this.re + b.re, this.im + b.im);
    }

    Complex minus(Complex b) {
        return new Complex(this.re - b.re, this.im - b.im);
    }

    Complex times(Complex b) {
        return new Complex(this.re * b.re - this.im * b.im, this.re * b.im + this.im * b.re);
    }

    public String toString() {
        return String.format("(%f, %f)", re, im);
    }
}

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static int lcm(int[] arr) {
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lcm = lcm(lcm, arr[i]);
        }
        return lcm;
    }

    public static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    public static List<Integer> sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static boolean canSurvive(int m, int n, int x) {
        int a = Math.max(m, n);
        int b = Math.min(m, n);

        while (a <= x && b <= x) {
            if (a == x || b == x) {
                return true;
            }
            a += b;
            int temp = a;
            a = b;
            b = temp - b;
        }

        return false;
    }

    public static int modInverse(int a, int m) {
        int m0 = m;
        int y = 0, x = 1;

        if (m == 1) {
            return 0;
        }

        while (a > 1) {
            int q = a / m;
            int t = m;

            m = a % m;
            a = t;
            t = y;

            y = x - q * y;
            x = t;
        }

        if (x < 0) {
            x += m0;
        }

        return x;



}}
