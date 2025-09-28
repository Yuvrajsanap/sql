//Identify which one integer and which one double

class Question_2 {
    public static void display(int a) {
        System.out.println("Got an integer: " + a);
    }

    public static void display(double a) {
        System.out.println("Got a double: " + a);
    }

    public static void main(String args[]) {
        display(10);
        display(10.5);
    }
}
