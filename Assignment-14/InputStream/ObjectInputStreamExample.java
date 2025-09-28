import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ObjectInputStreamExample {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.dat"))) {
            MyClass obj = (MyClass) ois.readObject();
            System.out.println(obj);
        } catch (IOException | ClassNotFoundException e) {
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
