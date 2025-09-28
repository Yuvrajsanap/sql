public class Question4 {
    public static void main(String[] args) {
        final int number;
        try {
            number = Integer.parseInt("123");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format");
            return;
        }
        System.out.println("Parsed number: " + number);
    }
}
