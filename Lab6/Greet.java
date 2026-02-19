package Lab6;

public class Greet {

    interface Greeting {
        void sayHello();
    }

    public static void main(String[] args) {

        Greeting g = new Greeting() {
            public void sayHello() {
                System.out.println("1 World!");
            }
        };
        g.sayHello();
    }
}
