package io.hustava.closures;

public class ClosuresExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 20; //effectively final - u dont need to put final there but u cant change it - it will throw compiler error. (when u change a variable value it not effectively final anymore
        doProcess(a, new Process() {
            @Override
            public void process(int i) {
               //b is not passed here as variable, but as value - frozen value, closure is a method that to variables like this (in logical context
                System.out.println(i + b);
            }
        });

        doProcess(a, i -> System.out.println(i + b));

    }


    public static void doProcess(int i, Process p){
        p.process(i);
    }

}

interface Process{
    void process(int i);
}
