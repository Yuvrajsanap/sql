//Area of circle and area of rectangle

class Question_3 {
    public static double area(int radius) { // circle
        return 3.14 * radius * radius;
    }

    public static double area(int length, int bredath) { // rectangle
        return length * bredath;
    }

    public static void main(String args[]) {
        System.out.println("Area of circle : " + area(2));
        System.out.println("Area of circle : " + area(2, 2));
    }
}
