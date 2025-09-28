public class Question5 {
    int number;

    // Parameterized constructor
    public Question5(int num) {
        number = num;
    }

    // Odd number upto that number
    public void display() {
        for (int i = 1; i <= number; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Question5 obj = new Question5(30);
        obj.display();
    }
}
