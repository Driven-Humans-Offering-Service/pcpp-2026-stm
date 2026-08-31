package exercises02;

public class test {
    public static boolean t = false;

    public void change() {
        t = true;
    }

    public static void main(String[] args) {
        test t = new test();
        test.t = true;
    }
}
