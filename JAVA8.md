
# APPUNTI JAVA 8
## **java.time** Clock class and  System.currentTimeMillis()
In Java 8, la classe Clock può essere utilizzata al posto di System.currentTimeMillis() per ottenere una data e un'ora. 
La classe Clock fa parte del pacchetto java.time e fornisce un modo più flessibile e orientato agli oggetti per ottenere 
l'ora corrente rispetto a System.currentTimeMillis().

```java
import java.time.Clock;
import java.time.Instant;

public class Main {
public static void main(String[] args) {
Clock clock = Clock.systemUTC();
Instant now = clock.instant();
System.out.println(now);
}
}
```
Il pacchetto java.time è stato introdotto in Java 8 come parte del JSR 310 per fornire una nuova API per la data e l'ora. 
Questo pacchetto include molte classi per gestire date, orari, istanti temporali e periodi di tempo in modo più semplice 
e intuitivo rispetto alle vecchie classi Date e Calendar presenti nel pacchetto java.util.

Alcune delle principali classi nel pacchetto java.time includono:

LocalDate
LocalTime
LocalDateTime
ZonedDateTime
Instant
Duration
Period
Clock
Questa API fornisce un'implementazione completa per le esigenze di manipolazione delle date e dei tempi, 
supportando il paradigma del tempo immutabile e thread-safe.

## Arrays.parallelSort

In Java 8, il metodo Arrays.parallelSort è stato introdotto per migliorare significativamente la velocità di ordinamento
su macchine multi-core. Questo metodo utilizza il parallelismo per dividere l'array in sottosegmenti, ordinare ciascun 
sottosegmento in parallelo utilizzando più thread e poi unire i risultati ordinati.
```java
import java.util.Arrays;

public class Main {
public static void main(String[] args) {
int[] array = {5, 3, 8, 1, 9, 6};

        // Ordinamento parallelo
        Arrays.parallelSort(array);

        // Stampa l'array ordinato
        System.out.println(Arrays.toString(array));
    }
}
```
## pipeline
Una pipeline in Java 8 è una sequenza di operazioni di stream, che permette di trasformare, filtrare e aggregare dati in modo dichiarativo e fluente

reduce negli stream



Lambda Expressions − a new language feature allowing us to treat actions as objects
Method References − enable us to define Lambda Expressions by referring to methods directly using their names
Optional − special wrapper class used for expressing optionality

Streams
Math functasion

Functional Interface – an interface with maximum one abstract method; implementation can be provided using a Lambda Expression
Default methods − give us the ability to add full implementations in interfaces besides abstract methods
Nashorn, JavaScript Engine − Java-based engine for executing and evaluating JavaScript code
Stream API − a special iterator class that allows us to process collections of objects in a functional manner
Date API − an improved, immutable JodaTime-inspired Date API