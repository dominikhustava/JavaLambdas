package io.hustava;

public class RunnableExample {
    public static void main(String[] args) {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printed inside runnable");
            }
        });
        myThread.run();

        Thread myLambdaThread = new Thread(() -> System.out.println("printed inside lambda Runnable"));
        myLambdaThread.run();

        //example why is good that wasnt created new Type for lambdas. To be better backwards compatible
        //Thread was created far in past and can be used with lambdas without rewriting

    }}