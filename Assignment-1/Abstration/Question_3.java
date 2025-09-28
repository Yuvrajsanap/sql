abstract class Shape {
    public abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return 3.14 * radius * radius;// Math.PI
    }

}

public class Question_3 {
    public static void main(String[] args) {
        Circle circle = new Circle(2);

        System.out.println("Area of the circle: " + circle.calculateArea());
    }
}
