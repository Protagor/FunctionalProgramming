package functionalinterface;

import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {

        System.out.println("incrementFunction result: "+incrementFunction.apply(0));

        System.out.println("increment result: "+increment(0));

    }

    //functional way
    static Function<Integer, Integer> incrementFunction = number -> ++number;

    //old way
    static int increment(int number) {
        return ++number;
    }
}
