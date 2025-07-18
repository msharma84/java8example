package streams;

@FunctionalInterface
interface A {
    void show();
}
public class LamdaDemo {

    public static void main(String[] args) {
        A obj = () -> System.out.println("Hello World !");
        obj.show();
    }
}
