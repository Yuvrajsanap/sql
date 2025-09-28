public class Question2 {
    public static void main(String[] args) {
        try {
            System.out.println("Resource opened.");
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero.");
        } finally {
            System.out.println("Resource closed.");
        }
    }
}
