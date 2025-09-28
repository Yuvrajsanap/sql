//Multi-level 
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

class Labrador extends Dog {
    void color() {
        System.out.println("Labrador is golden in color");
    }
}

public class Question_2 {
    public static void main(String[] args) {
        Labrador myLabrador = new Labrador();
        myLabrador.eat();
        myLabrador.bark();
        myLabrador.color();
    }
}
