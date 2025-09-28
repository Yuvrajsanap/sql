import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutputStreamExample {
    public static void main(String[] args) {
        MyClass obj = new MyClass("John Doe", 30);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"))) {
            oos.writeObject(obj);
            System.out.println("Object has been serialized: " + obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyClass implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;

    MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyClass{name='" + name + "', age=" + age + "}";
    }
}
