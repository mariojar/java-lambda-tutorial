
# Guida alle Lambda Expression in Java

## Parte 1: Introduzione alle Lambda Expression

### 1.1 Cos'è una Lambda Expression?
Una Lambda Expression è un'espressione che rappresenta una funzione anonima (cioè, una funzione senza nome). 
Le Lambda Expression in Java sono utilizzate principalmente per passare comportamenti come argomenti ai metodi 
o per implementare interfacce funzionali.

Le espressioni lambda introdotte in Java 8 permettono di trattare il codice come dati

### 1.2 Sintassi di base
La sintassi di base di una lambda expression è:
```
(parameters) -> expression
```
Se il corpo contiene più espressioni, allora va racchiuso tra parentesi graffe:
```
(parameters) -> { statements; }
```
### 1.4 Esempio semplice
Lambda expressions don't support the use of break and continue statements if they're not part of a loop within the lambda.

### 1.5 Esempio semplice
Ecco un esempio di una lambda expression che prende un singolo parametro e restituisce il suo valore doppio:
```
(int x) -> x * 2
```

### Esercizio 1
Scrivi una lambda expression che prende due numeri interi e restituisce la loro somma. Prova a scriverlo da solo, 
poi confronta la tua risposta con la soluzione qui sotto.

### Soluzione
```
(int a, int b) -> a + b
```

## Parte 2: Utilizzo delle Lambda Expression

### 2.1 Interfacce funzionali
Una lambda expression può essere utilizzata solo con interfacce funzionali. Un'interfaccia funzionale è un'interfaccia 
che ha un solo metodo astratto. Ad esempio, l'interfaccia `Runnable` è un'interfaccia funzionale perché ha un solo metodo astratto, `run()`.

### 2.2 Vissibilita delle variabile nel contesto lamda  - **lexically scoped**
Le espressioni lambda in Java 8 sono lexically scoped (a scopo lessicale). Questo significa che le variabili all'interno 
di una lambda expression hanno la stessa visibilità e le stesse regole di accessibilità delle variabili definite nel blocco 
di codice circostante dove la lambda è stata definita.

Scoping Lessicale
Accesso alle variabili locali: Una lambda expression può accedere e utilizzare le variabili locali definite nel metodo 
che contiene la lambda, purché queste variabili siano final o "effettivamente finali".
Ambito: L'ambito di una lambda expression è determinato dalla sua posizione nel codice sorgente. Questo significa che 
una lambda può vedere e utilizzare tutte le variabili che sono visibili nel suo contesto di definizione.

### 2.3 break and continue statements
Lambda expressions don't support the use of break and continue statements if they're not part of a loop within the lambda.

### 2.4 Exceptions
Lambda expressions can throw exceptions, but if an exception is checked, it must be compatible with the exceptions listed in the throws clause of the functional interface method.
### 2.4 **this** statement
For a lambda expression, **this** resolves to the enclosing class where the lambda is written.
### 2.5 Where use Lambda 
Lambda expressions can be used in:
A variable declaration
An assignment
A return statement
An array initializer
As a method or constructor arguments
A ternary conditional expression
A cast expression

### 1.4 break and continue statements
Lambda expressions don't support the use of break and continue statements if they're not part of a loop within the lambda.

### 2.4 Esempio con interfaccia funzionale personalizzata
Definiamo un'interfaccia funzionale e utilizziamo una lambda expression per implementarla:
```java
@FunctionalInterface
interface MyFunctionalInterface {
    void myMethod(int a);
}

public class Main {
    public static void main(String[] args) {
        MyFunctionalInterface func = (int a) -> {
            System.out.println("Value: " + a);
        };
        func.myMethod(10);
    }
}
```

### Esercizio 2
Definisci un'interfaccia funzionale che ha un metodo astratto che prende due stringhe e restituisce una stringa concatenata. 
Implementa questa interfaccia usando una lambda expression.

### Soluzione
```java
@FunctionalInterface
interface StringConcat {
    String concat(String s1, String s2);
}

public class Main {
    public static void main(String[] args) {
        StringConcat sc = (s1, s2) -> s1 + s2;
        System.out.println(sc.concat("Hello, ", "World!"));
    }
}
```

## Parte 3: Lambda Expression Complesse

### 3.1 Utilizzo di lambda con collezioni
Le lambda expression sono spesso utilizzate con le collezioni per iterare, filtrare o trasformare dati. 
Ad esempio, possiamo usare le lambda expression con i metodi delle collezioni come `forEach`, `filter`, `map`, ecc.

### 3.2 Esempio con `forEach`
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", "two", "three", "four");
        list.forEach(s -> System.out.println(s));
    }
}
```

### 3.3 Esempio con `filter`
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", "two", "three", "four");
        List<String> filteredList = list.stream()
                                         .filter(s -> s.length() > 3)
                                         .collect(Collectors.toList());
        filteredList.forEach(s -> System.out.println(s));
    }
}
```

### Esercizio 3
Usa una lambda expression per filtrare una lista di numeri e mantenere solo quelli pari. Poi stampa i numeri pari.

### Soluzione
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenList = list.stream()
                                     .filter(n -> n % 2 == 0)
                                     .collect(Collectors.toList());
        evenList.forEach(n -> System.out.println(n));
    }
}
```



### Pate 5 - Le principali FunctionalInterface
### 5.1 Function - BiFunction
recibe algo y devuelve algo
```java
@FunctionalInteface
public interface Function<T, R> 
    R apply(T var1)

@FunctionalInteface
public interface BiFunction<T, U, R>
R apply(T var1, U var2)
```
### 5.2 Supplier 

```java
@FunctionalInteface
public interface Supplier<T> 
    T get()

```
### 5.2 Consumer
Recibe una variable, hace algo con ella pero no devuelve nada

BiConsumer tiene la misma idea pero con dos parametros in ingreso

```java
@FunctionalInteface
public interface Consumer<T> 
    void accept(T var1)
```
### 5.3 Predicate and BiPredicate
La clase Predicate tiene un método llamado test, que recibe un argumento y devuelve un booleano.
```java
@FunctionalInteface
public interface Predicate<T> 
    boolean test(T var1)
```
### 5.1 Function - BiFunction

Está definiendo el tipo permitido para esta interfaz, y como todos estos genéricos son la misma letra (T), 
significa que solo podemos trabajar con el mismo tipo de variables; nuestros argumentos y retornos deben ser del mismo 
tipo para funcionar en el UnaryOperator.
UnaryOperator tiene el mismo comportamiento que Function, pero solo funciona con los mismos tipos.

```java
@FunctionalInteface
public interface UnaryOperator<T> extends Function<T, T> 
    T apply(T var1)

@FunctionalInteface
public interface BinaryOperator<T> BiFunction<T, T, T>
R apply(T var1, T var2)
```

### Parte 6 - Note
- Il nuovo Streams API introdotto in Java 8 è disponibile nel pacchetto java.util.stream. Questa API permette di elaborare 
sequenze di elementi in modo dichiarativo e supporta operazioni di tipo functional programming, 
come il filtering, mapping, e riduzione su collezioni di dati.


TODO:

BIFUNCTION e lista delle funzione principalmente più predisposte, intertfaccie funzionali più conosciute
Consumer functional interface.


questa notazione
System.out::println

java
sequential and parallel aggregate
Optional