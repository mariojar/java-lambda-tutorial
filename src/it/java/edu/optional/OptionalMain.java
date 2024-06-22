package it.java.edu.optional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalMain {

    public static void main(String[] args) {
        OptionalMain main = new OptionalMain();
        //main.trigger();

//        filter2();

        Optional test = Optional.of("hello");
        System.out.println(test);

        List<Optional<String>> list = List.of(
                Optional.of("one"),
                Optional.empty(),
                Optional.of("three"),
                Optional.of("four")
        );

        Optional<String> result = list.stream()
                .flatMap(opt -> opt.map(Stream::of).orElseGet(Stream::empty))
                .filter(s -> s.length() > 3)
                .findFirst();

        System.out.println(result.orElse("Not Found"));

    }

    private static void filter2() {
        Optional<String> optional = Optional.of("Hello");
        String result = optional.filter(s -> s.startsWith("H")).orElse("Default");
        System.out.println(result);
    }

    private void nullableIfPresent() {
        Optional testNull =  Optional.ofNullable(null);
        Optional testFill =  Optional.ofNullable("Mario");
        System.out.println("stampa optiona null : " + testNull);
        try{
            System.out.println("stampa optiona null : " + testNull.get());
        }catch (Exception e){
            e.printStackTrace();
        }


        testNull.ifPresent(x -> System.out.println("aqui no entra : " + x));
        testFill.ifPresent(x -> System.out.println("porque aqui si entra : " + x));
    }

    public void trigger(){
        try {
            exceptionNull(Optional.ofNullable(null));
        } catch (MyException e) {
            e.printStackTrace();
        }

        try {
            exceptionNull(Optional.ofNullable("Mario J."));
        } catch (MyException e) {
            e.getMessage();
        }

        myEmptyTest();
        filter();
        mapOptional();
        nullableIfPresent();
    }


    public void myFlatMap(){
        Product product = new Product("Bicicleta Grande",454);

        // Esempio 1: Conversione del nome utente in maiuscolo
        Optional<String> nomeUtenteMaiuscolo = Optional.ofNullable(product)
                .flatMap(user -> Optional.ofNullable(user.getName()))
                .map(String::toUpperCase);

        if (nomeUtenteMaiuscolo.isPresent()) {
            System.out.println("Nome utente maiuscolo: " + nomeUtenteMaiuscolo.get());
        } else {
            System.out.println("Nome utente non disponibile");
        }

    }


    private static void filter() {
        String message = "Ciao Mondo con questo clima";
        Optional<String> optionalMessage = Optional.of(message);
        Optional<String> optional = optionalMessage.filter(s -> s.contains("x"));//crea l'optional se il predicate è true
        System.out.println("questo è il nuovo messaggio " + optional);
    }

    private static void myEmptyTest() {
        Optional<Object> empty = Optional.empty();
        System.out.println("Con Optional.empty() empty.isPresent() " + empty.isPresent()); // C'è qualcosa dentro ? false perchè è vuoto
        System.out.println("Con Optional.empty() empty.isEmpty " + empty.isEmpty());       // è vuoto ? si perchè non c'è niente
    }

    private static void exceptionNull(Optional<String> var) throws MyException {


        //String saluto = var.orElseThrow(() -> new MyException("non esiste il valore"));
        System.out.println(var.orElseThrow(() -> new MyException("non esiste il valore")));

    }

    public static void mapOptional(){
        Product product = new Product("Libro", 20.00);

        Optional<String> productName = Optional.ofNullable(product)
                .map(p -> p.getName());

        if (productName.isPresent()) {
            System.out.println("Nome del prodotto: " + productName.get());
        } else {
            System.out.println("Impossibile ottenere il nome del prodotto");
        }
    }

}

class MyException extends Exception {

    MyException(String message) {
        super(message);
    }

}

class Product {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }

    String name;
    double v;
    public Product(String name, double v) {
        this.name = name;
        this.v=v;
    }
}

class Persona{

    public Persona(String primoNome, String secondoNome, String primoCognome, String secondoCognome) {
        this.primoNome = primoNome;
        this.secondoNome = secondoNome;
        this.primoCognome = primoCognome;
        this.secondoCognome = secondoCognome;
    }

    private String primoNome;
    private String secondoNome;

    public String getPrimoNome() {
        return primoNome;
    }

    public void setPrimoNome(String primoNome) {
        this.primoNome = primoNome;
    }

    public String getSecondoNome() {
        return secondoNome;
    }

    public void setSecondoNome(String secondoNome) {
        this.secondoNome = secondoNome;
    }

    public String getPrimoCognome() {
        return primoCognome;
    }

    public void setPrimoCognome(String primoCognome) {
        this.primoCognome = primoCognome;
    }

    public String getSecondoCognome() {
        return secondoCognome;
    }

    public void setSecondoCognome(String secondoCognome) {
        this.secondoCognome = secondoCognome;
    }

    private String primoCognome;
    private String secondoCognome;
}
