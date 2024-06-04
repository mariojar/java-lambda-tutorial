package it.java.edu.lamda.excersice;

import it.java.edu.lamda.excersice.functional.Concatenate;
import it.java.edu.lamda.excersice.functional.MathOperation;
import it.java.edu.lamda.excersice.functional.MyFunctionalInterface;
import it.java.edu.lamda.excersice.functional.Somma;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MainSimpleLambda {

    public static void main(String[] args) {
        MainSimpleLambda man = new MainSimpleLambda();

        man.duplicate();
        man.function();
        man.somma();
        man.biFunction();
        man.myFunctional();
        man.biFunctionString();
        man.myBiFuncion();

    }

    public void duplicate (){
        MathOperation operation = x -> x * 2;

        int i = operation.operate(5);
        System.out.println(i);
    }

    public void function(){
        Function<Integer,Integer> function =  x -> x * 2 ;
        int result = function.apply(3);
        System.out.println(result);
    }

    public  void somma(){
        Somma function = (x,y) -> x + y ;
        int result = function.somma(3,4);
        System.out.println(result);
    }

    public void biFunction(){
        BiFunction<Integer,Integer,Integer> bifunction = (a,b) -> a + b ;
        int result = bifunction.apply(3,8);
        System.out.println(result);

    }

    public void myFunctional(){
        MyFunctionalInterface my = (int x) -> {
            System.out.println("eccoci " + x);
        };
        my.myMethod(5);
    }

  public void biFunctionString(){
        BiFunction<String,String,String> concatenate = (a,b) -> a + " " +  b;
        String result = concatenate.apply("Ciao" , "Mondo");
      System.out.println(result);
  }

  public void myBiFuncion(){
      Concatenate myBifunction= (a, b) -> a + " " + b;
      String result = myBifunction.apply("hello","world");
      System.out.println(result);
  }
}
