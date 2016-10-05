public class Homework1 {

    public static void main(String[] args) {

        byte byttie = 127;
        short shorty = 32767;
        int inty = 2147483647;
        long longy = 922337206;
        double doubly = 5555.012d;
        float floaty = 12.0f;
        char chary = 65535;
        boolean bool = false;
        System.out.println(calculate(1, 3, 5, 7));
        System.out.println(checkFromTenToTwelve(15, 4));
        System.out.println(checkFromTenToTwelve(15, 7));
        System.out.println(isLeapYear(2004));
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(1900));
        System.out.println(isLeapYear(1897));

    }

    private static int calculate(int a, int b, int c, int d) {

        return a * (b + (c / d));

    }

    private static boolean checkFromTenToTwelve(int a, int b){

        return ((a + b) >= 10 && (a + b) <= 20);

    }

    private static boolean isLeapYear(int year) {

        if (year % 400 == 0)
        {
            return true;
        }
        else if (year % 100 == 0)
        {
            return false;
        }
        else if (year % 4 == 0)
        {
            return true;
        }

        return false;

    }

}