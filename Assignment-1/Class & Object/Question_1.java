public class Question_1 {
    String name;
    int age;

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {

        Question_1 person = new Question_1();
        person.name = "John";
        person.age = 25;
        person.display();
    }
}
