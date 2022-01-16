package io.hustava;

@FunctionalInterface
public interface Greeting {
    void perform();
}

//@FunctionalInterface helps us protect lambdas which use interfaces and can be broken by adding another method.
//We have to be really careful with updating/adding things in interfaces in general, cuz its hard to tell what is using it.
//from java 8 we can have default method implementation in interfaces