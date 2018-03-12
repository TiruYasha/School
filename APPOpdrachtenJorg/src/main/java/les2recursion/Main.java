package les2recursion;

public class Main {

    public static void main(String[] args) {
        System.out.println(reverse2("Hallo"));
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        else
            return fib(n-1) + fib(n-2);
    }

    public static int fact1(int n) {
        int total = 1;
        while(n > 0) {
            total *= n;
            n--;
        }
        return total;
    }

    public static int fact2(int n) {
        if (n == 1)
            return 1;
        else
            return fact2(n - 1) * n;
    }

    public static int som1(int n) {
        int total = 0;
        while(n > 0) {
            total += n;
            n--;
        }
        return total;
    }

    public static int som2(int n) {
        if (n == 1)
            return 1;
        else
            return fact2(n - 1) + n;
    }

    //7.23
    public static int onesInBinaryRepresentation(int n) {
        if (n == 1) {
            return 1;
        }
        if (n % 2 == 0) {
            return onesInBinaryRepresentation(n / 2);
        } else
            return 1 + onesInBinaryRepresentation(n / 2);
    }

    //7.50
    //a
    public static String reverse(String str) {
        if ((null == str) || (str.length() <= 1)) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
    //b
    public static String reverse2(String str) {
        String stringBuffer = reverse3(str);
        return stringBuffer;
    }

    private static String reverse3(String str) {
        if ((null == str) || (str.length() <= 1)) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }


}
