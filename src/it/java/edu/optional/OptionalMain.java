package it.java.edu.optional;

import java.util.Optional;

public class OptionalMain {

    public static void main(String[] args) {
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
