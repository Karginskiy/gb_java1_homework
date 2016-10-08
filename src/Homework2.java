import java.util.Scanner;

class Homework2 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] bits = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 1 };
        System.out.println("Массив до: ");
        printArray(bits);
        inverse(bits);
        System.out.println("Массив после: ");
        printArray(bits);


        System.out.println("//////////////////");
        int[] integers = fillArray(8);
        System.out.println("Полученный массив: ");
        printArray(integers);


        System.out.println("//////////////////");
        int[] mas = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Массив до: ");
        printArray(mas);
        changeArray(mas);
        System.out.println("Массив после: ");
        printArray(mas);


        System.out.println("//////////////////");
        System.out.println("Максимальное число в массиве - " + getMax(mas));
        System.out.println("Минимальное число в массиве - " + getMin(mas));


        System.out.println("//////////////////");
        System.out.println("Калькулятор v. 1.0. Console.");
        calculate();


        scanner.close();

    }

    static void inverse(int[] bitsArray) {

        for (int i = 0; i < bitsArray.length; i++) {
            bitsArray[i] = (bitsArray[i] == 0) ? 1 : 0;
        }

    }

    static int[] fillArray(int length) {

        System.out.println("Введите " + length + " чисел для заполнения массива.");

        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        return array;

    }

    static void changeArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            array[i] = (current < 6) ? current * 2 : current;
        }

    }

    static int getMax(int[] array) {

        int max = array[0];
        for (int value : array) {
            max = (value > max) ? value : max;
        }

        return max;

    }

    static int getMin(int[] array) {

        int min = array[0];
        for (int value : array) {
            min = (value < min) ? value : min;
        }

        return min;
    }

    static void calculate() {

        while (true) {

            System.out.println("Введите операцию: ");

            int first = scanner.nextInt();
            String operation = scanner.next();
            int second = scanner.nextInt();

            switch (operation) {
                case "+":
                    System.out.println(first + second);
                    break;
                case "-":
                    System.out.println(first - second);
                    break;
                case "*":
                    System.out.println(first * second);
                    break;
                case "/":
                    if (second == 0) {
                        System.out.println("На ноль делить нельзя! Введите заново!");
                        continue;
                    }
                    System.out.println(first / second);
                    break;
            }

            System.out.println("1 - Считать еще;");
            System.out.println("2 - Выйти");

            if (scanner.nextInt() == 2) break;

        }

    }

    static void printArray(int[] array) {

        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();

    }

}
