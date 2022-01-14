package io.hustava;

public class Greeter {

    public void greet(Greeting greeting){
        greeting.perform();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        HelloWorldGreeting hwg = new HelloWorldGreeting();
        greeter.greet(hwg);
        MyLambda myFirstLambdaFunction = () -> System.out.println("Hello World from lambda!");
        // if you already have an interface with appropriate method you can use it
        Greeting mySecondLambdafunction = () -> System.out.println("Hello World again!");
        myFirstLambdaFunction.foo();
        //------------------------------------------------------------------------------------

        Greeting helloWorldGreeting = new HelloWorldGreeting();
        Greeting lambdaGreeting = () -> System.out.println("Lambda greeting");
        Greeting innerClassGreeting = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Inner class greeting!");
            }
        };
        //they are very similar. it looks like lambdas are just shortcut to anonymous inner classes
        //implementation (not true). Can be passed as implementation to methods which accepts its parent interface.
        greeter.greet(lambdaGreeting);
        greeter.greet(innerClassGreeting);

    }
}

interface MyLambda{
    //nameDoesntMatterJustReturntypeAndArguments
    void foo();
    //cant have another method! must be functional interface
        }