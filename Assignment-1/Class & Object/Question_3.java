public class Question_3 {
    String name;
    int age;

    public Question_3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        // Creating an object using the constructor
        Question_3 person = new Question_3("Aniket", 22);
        person.display();
    }
}
