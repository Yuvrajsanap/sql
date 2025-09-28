public class Question5 {
    public static void main(String[] args) {
        final int divisor = 0; // Define a final variable

        try {
            int result = 10 / divisor; // Attempt division
            System.out.println("Result: " + result); // This line won't be executed
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero.");
        } finally {
            System.out.println("Finalizing..."); // This will always be executed
        }
    }
}
