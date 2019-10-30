package testing;

public class Test {
    interface A {}
    interface B extends A {}

    class AImpl implements A {}
    class BImpl extends AImpl implements A,B {}
}
