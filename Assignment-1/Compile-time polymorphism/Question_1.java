///Addition of Number

public class Question_1 {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static void main(String args[]) {
        System.out.println("Sum of 2 and 3: " + add(2, 3));
        System.out.println("Sum of 1, 2 and 3: " + add(1, 2, 3));
        System.out.println("Sum of 1.5 and 2.5: " + add(1.5, 2.5));

    }
}