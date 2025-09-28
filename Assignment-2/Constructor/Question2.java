public class Question2 {
    int a, b;

    public Question2(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void display() {
        System.out.println("Addition : " + (a + b));
    }

    public static void main(String[] args) {
        Question2 obj = new Question2(5, 2);
        obj.display();
    }
}
