import mypackage.Adder;
import mypackage.Multiplier;

public class Question3 {
    public static void main(String[] args) {
        Adder adder = new Adder();
        Multiplier multiplier = new Multiplier();

        int sum = adder.add(3, 4);
        int product = multiplier.multiply(3, 4);

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
    }
}
