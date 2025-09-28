public class Question1 {
    public static void main(String[] args) {
        final int num = 10;
        try {
            // num = 20; compilation error
        } finally {
            System.out.println("Value of final variable: " + num);
        }
    }
}
