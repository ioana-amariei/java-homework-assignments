package testing;//interface testing.A {
//    void test();
//}
//
//class testing.B implements testing.A {
//    void test() {
//        System.out.println("Test");
//    }
//}

class A {
    public A() {
        System.out.println("testing.A");
    }
}
class B extends A {
    public B() {
        System.out.println("testing.B");
    }
}
class C extends B {
    public C() {
        System.out.println("testing.C");
    }
}

public class Main {
    public static void main(String[] args) {
        C c = new C(); // testing.A testing.B testing.C (CU \n)
    }
}
