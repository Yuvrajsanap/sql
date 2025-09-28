public class Question3 {
    int number;

    // Default constructor
    public Question3() {
        number = 0;
    }

    // Parameterized constructor
    public Question3(int num) {
        number = num;
    }

    public void display() {
        System.out.println("Number: " + number);
    }

    public static void main(String[] args) {
        Question3 obj1 = new Question3();
        Question3 obj2 = new Question3(20);
        obj1.display();
        obj2.display();
    }
}
