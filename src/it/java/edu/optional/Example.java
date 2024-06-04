package it.java.edu.optional;
import java.util.Optional;

public class Example {

    public static void main(String[] args) {
        // Esegui i due metodi per vedere la differenza
        useFlatMap();
        useMap();
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
        Optional<Optional<String>> name = person.map(Person::getName);

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
    }

    static class Car {
        private Optional<Insurance> insurance;

        public Car(Optional<Insurance> insurance) {
            this.insurance = insurance;
        }

        public Optional<Insurance> getInsurance() {
            return insurance;
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
    }
}
