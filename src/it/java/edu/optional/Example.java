package it.java.edu.optional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {

    public static void main(String[] args) {










         //mapAndFlatMap();
        //useFlatMap();
        //useMap();
    }
/**
 * La chiave per comprendere la differenza tra map e flatmap sta nel comprendere
 *
 * Conclusione
 * map(): Può applicare una funzione a ogni elemento, indipendentemente dal fatto che la funzione restituisca un singolo valore o uno stream.
 * flatMap(): Può essere applicato solo quando la funzione restituisce uno stream. Appiattisce tutti i stream risultanti in un singolo stream continuo.
 * Se ogni elemento non restituisce uno stream, non puoi applicare flatMap().
 * Quindi, è corretto dire che se vuoi usare flatMap(), la funzione applicata a ogni elemento deve restituire uno stream. Altrimenti, dovresti usare map().
 */

    private static void mapAndFlatMap() {
        List<List<String>> parole = Arrays.asList(
                Arrays.asList("prima","seconda","terza"),
                Arrays.asList("uno","dos","tres"),
                Arrays.asList("oneeeeeeee","twoooooooooo","threeeeeeeeeee")
        );

        List<String> lista2 = Arrays.asList("prima","seconda","terza");
        lista2.stream().flatMap(s -> Stream.of(s.toUpperCase())).toList().forEach(System.out::println);

        List<String> listaFinale10 = parole.stream()
                 .map(s -> s.stream()
                         .map(s2 -> s2.toUpperCase()).toList())
                 .flatMap(s3 -> s3.stream())
                 .toList();

        List<String> listaFinale4 = parole.stream()
                .map(s -> s.stream()
                        .map(s2 -> s2.toUpperCase())
                        .toList())
                .flatMap( s3 -> s3.stream() )
                .toList();

        listaFinale4.forEach(System.out::println);

        List<String> listaFinale2 = parole.stream()
                .map(lista -> lista.stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.toList()))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        List<String> listaFinale5 = parole.stream()
                .flatMap(lista -> lista.stream()
                        .map(s -> {
                            String newString = s.toUpperCase();
                            System.out.println("toUpperCase() = " + newString);
                            return newString;
                        }))
                .collect(Collectors.toList());

        List<String> listaFinale6 = parole.stream()
                .flatMap(lista -> {
                    for (int i = 0; i < lista.size(); i++) {
                        lista.set(i, lista.get(i).toUpperCase());
                    };
                    return lista.stream();
                }
                )
                .collect(Collectors.toList());
        listaFinale6.forEach(s -> System.out.println("elemento  :  " + s));
    }

    public static void useFlatMap() {
        Optional<Person> person = getPerson();

        Optional<String> insuranceName = person
                .flatMap(Person::getCar)            // Otteniamo Optional<Car>
                .flatMap(Car::getInsurance)         // Otteniamo Optional<Insurance>
                .map(Insurance::getName);           // Otteniamo Optional<String>

        System.out.println("Using flatMap:");
        insuranceName.ifPresent(System.out::println);
    }

    public static void useMap() {
        Optional<Person> person = getPerson();

        Optional<Optional<Car>> car = person.map(Person::getCar);
//        Optional<Optional<String>> name = person.map(Person::getName);

        Optional<Optional<Optional<Insurance>>> insurance = car.map(optCar -> optCar.map(Car::getInsurance));
        Optional<Optional<Optional<String>>> insuranceName = insurance.map(optInsurance -> optInsurance.map(optIns -> optIns.map(Insurance::getName)));

        // Appiattiamo manualmente il risultato finale
        Optional<String> flattenedInsuranceName = insuranceName
                .map(optOptStr -> optOptStr
                        .flatMap(optStr -> optStr))
                .flatMap(opt -> opt);

        System.out.println("Using map:");
        flattenedInsuranceName.ifPresent(System.out::println);
    }

    // Supponiamo che questi metodi siano già definiti
    public static Optional<Person> getPerson() {
        // Implementazione che restituisce un Optional<Person> con valori completi
        Insurance insurance = new Insurance("My Aseguracion ");
        Car car = new Car(Optional.of(insurance));
        Person person = new Person(Optional.of(car));
        return Optional.of(person);
    }

    static class Person {
        private Optional<Car> car;

        public Person(Optional<Car> car) {
            this.car = car;
        }

        public Optional<Car> getCar() {
            return car;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Person{");
            sb.append("car=").append(car);
            sb.append('}');
            return sb.toString();
        }
    }

    static class Car {
        private Optional<Insurance> insurance;

        public Car(Optional<Insurance> insurance) {
            this.insurance = insurance;
        }

        public Optional<Insurance> getInsurance() {
            return insurance;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Car{");
            sb.append("insurance=").append(insurance);
            sb.append('}');
            return sb.toString();
        }
    }

    static class Insurance {
        private String name;

        public Insurance(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Insurance{");
            sb.append("name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}

