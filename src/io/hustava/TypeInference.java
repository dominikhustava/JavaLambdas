package io.hustava;

public class TypeInference {
    public static void main(String[] args) {
        StringLengthLambda myLambda = (String s) -> s.length();
        //type inference
        StringLengthLambda myLambda2 = s -> s.length();

        System.out.println(myLambda.getLength("ahoj"));

        //example that it can be taken as argument
        printLambda(s -> s.length());

    }

    public static void printLambda(StringLengthLambda l){
        System.out.println(l.getLength("hello lambda"));
    }

    interface StringLengthLambda{
        int getLength(String s);
    }
}
