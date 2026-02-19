package Lab3;
//Q3
class Apple {
    void show() {
        System.out.println("This is an apple");
    }
}

class Banana extends Apple {
    void show() {
        System.out.println("This is a banana");
    }
}

class Cherry extends Apple {
    void show() {
        System.out.println("This is a cherry");
    }
}

public class FruitDemo extends Cherry{
    public static void main(String[] args) {
        Apple a = new Apple();
        Banana b = new Banana();
        Cherry c = new Cherry();

        a.show();
        b.show();
        c.show();
    }
}
