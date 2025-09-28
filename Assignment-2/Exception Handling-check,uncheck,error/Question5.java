//uncheck

public class Question5 {
    public static void main(String[] args) {
        try {
            String str = "abc"; // This is not a valid integer
            int num = Integer.parseInt(str);
            System.out.println("Parsed integer: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Error: Number format exception. Cannot parse the string into an integer.");
        }
    }
}
