package io.hustava.closures;

public class ThisReferenceExampleLambda {
    public void doProcess(int i, Process p){
        p.process(i);
    }

    public void execute(){
        doProcess(10, i -> {
            System.out.println("Value of i is " +i);
            //"this"will be in context of instance which will instantiate this class. eg: thisReferenceExampleLambda.
            System.out.println(this);

        });
    }

    public static void main(String[] args) {
        ThisReferenceExampleLambda thisReferenceExampleLambda = new ThisReferenceExampleLambda();
        thisReferenceExampleLambda.doProcess(10, i -> {
            System.out.println("Value of i is " +i);
            //System.out.println(this);
            //cant be used it's not refering to instance like anonym inner class, Refers to static context of main
            //Lambdas dont change the context of "this" like AIC
        });

        thisReferenceExampleLambda.execute();

    }}
