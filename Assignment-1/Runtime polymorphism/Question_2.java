class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}

public class Question_2 {
    public static void main(String[] args) {

        Circle circle = new Circle();
        circle.draw();

        Rectangle rect = new Rectangle();
        rect.draw();
    }
}
