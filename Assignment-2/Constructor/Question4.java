public class Question4 {
    int number;

    // Parameterized constructor
    public Question4(int num) {
        number = num;
    }

    // Even number upto that number
    public void display() {
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Question4 obj = new Question4(30);
        obj.display();
    }
}
