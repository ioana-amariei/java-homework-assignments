package testing;


import java.util.List;
import java.util.Vector;

public abstract class MainDoi {
    public abstract void add();

    private MainDoi(){

    }
    static void method(StringBuilder s1, StringBuilder s2, int number) {
        s1.append("bc");
        s2 = new StringBuilder("yz");
        number = 123;
    }

    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("a");
        StringBuilder s2 = new StringBuilder("x");
        int n = 0;
        method(s1, s2, n);
        System.out.println(s1 + ", " + s2 + ", " + n);
        List list = new Vector();
    }
}
