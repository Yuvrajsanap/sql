import java.util.Scanner;

public class Question_2 {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        Question_2 calculator = new Question_2();
        int a, b;
        Scanner sobj = new Scanner(System.in);
        System.out.println("Enter a and b : ");
        a = sobj.nextInt();
        b = sobj.nextInt();

        int sum = calculator.add(a, b);
        int difference = calculator.subtract(a, b);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
    }
}
