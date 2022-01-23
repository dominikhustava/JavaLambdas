package io.hustava.closures;

public class ThisReferenceExample {

    public void doProcess(int i, Process p){
        p.process(i);
    }

    public static void main(String[] args) {
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
        //I cant access "this reference" cuz im in static method (static context means it can be accessed without instance
        //System.out.println(this);
        thisReferenceExample.doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println("Value of i = " + i);
                // this refers to instance of anonymous inner class
                System.out.println(this);
            }

            @Override
            public String toString() {
                return "This is from annonymous inner class instance";
            }
        });
    }
}
