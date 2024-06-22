package it.java.edu.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.valueOf;

public class MainStream {
    private List<User> users ;

    public static void main(String[] args) {
        MainStream mainStream = new MainStream();
        mainStream.triggerMethods(mainStream);
    }

    private void triggerMethods(MainStream mainStream){
        mainStream.setup();
        /*mainStream.printStream(mainStream.users.stream() , "STREAM INIZALE");
        mainStream.myMapStream(mainStream.users.stream());
        mainStream.myFilter(mainStream.users.stream());
        mainStream.findFirst(mainStream.users.stream());
        mainStream.myFlat();
        mainStream.myPeek(mainStream.users);
        myCount(mainStream.users.stream());
        mySkipAndLimitAndCount(mainStream.users.stream());
        mySorted(mainStream.users.stream());
        mySorted2(mainStream.users.stream());
        */

Optional op = Optional.of("a");
        System.out.println("applicanto : "  + Stream.empty().toList());

        //myReduceSenzaIdentita(mainStream.users.stream());
        //myReduceConIdentita(mainStream.users.stream());

        List<Optional<String>> optionals = Arrays.asList(
                Optional.of("a"),
                Optional.empty(),
                Optional.of("b")
        );

        List<String> result = optionals.stream()
                .flatMap(opt -> opt.map(Stream::of).orElseGet(Stream::empty))
                .collect(Collectors.toList());




        System.out.println(result);

    }

    private void myReduceSenzaIdentita(Stream<User> users){
        Optional<Integer> aggregator = users.map(User::getId).reduce( (s , p) -> s + p);
        System.out.println(aggregator.get());
    }

    private void myReduceConIdentita(Stream<User> users){
        //Optional<Integer> aggregator = users.map(User::getId).reduce( valueOf(2) , (s , p) -> s + p).describeConstable();
        int aggregator2 = users.map(User::getId).reduce( valueOf(2) , (s , p) -> s + p);
        //System.out.println(aggregator.get());
        System.out.println(aggregator2);
    }

    private void mySorted(Stream<User> users){
         List<User> list = users.sorted((a, b) -> a.getSurname().compareToIgnoreCase(b.getSurname()) ).toList();
        printStream(list.stream() , "LISTA ORDINATA PER COGNOME");
    }

    private void mySorted2(Stream<User> users){
        List<User> list = users.sorted(Comparator.comparing(u -> u.getName()) ).toList();
        printStream(list.stream() , "LISTA ORDINATA PER NOME");
    }


    private void mySkipAndLimitAndCount(Stream<User> users){
        long count = users.skip(5).limit(3).filter(s -> s.getSurname().equals("Jaramillo")).count();
        System.out.println("trovati Jaramillo nellintervallo 5-8 : " + count);
    }

    private void myCount(Stream<User> users){
        long count = users.filter(s -> s.getSurname().equals("Jaramillo")).count();
        System.out.println("numero di fratelli trovati : " + count);
    }

    /*Usa peek() per osservare o eseguire azioni su elementi senza modificarli, usa map() per trasformare gli elementi.*/
    private void myPeek(List<User> listUsers){
        List<User> list = listUsers.stream().peek(s -> {
            s.setName(s.getName().toUpperCase());
            return;
                }
        ).toList();

        List<User> list2 = listUsers.stream().map(s -> {
            s.setName(s.getName().toUpperCase());
            return s;
                }
        ).toList();
        printStream(list.stream() , "MAP in peek");
    }


    private void myMapStream(Stream<User> stream){
        List<String> list = stream.map( u -> u.getName()).toList();
        printStream(list.stream() , "MAP ESEGUITO PER PRENDERE SOLO I NOMI");
    }

    private void myFilter(Stream<User> stream){
        List<User> list = stream
                .filter( u -> u.getId() > 3 )
                .filter( u -> u.getSurname().length() >= 7 )
                .toList();
        printStream(list.stream() , "FILTER USER FILTRATI");
    }

    private void findFirst(Stream<User> stream){
        User user = stream
                .filter(u -> u.getSurname().equals("Jaramillo"))
                .findFirst()
                .orElse(new User(999,"Default","default"));

         printStream(Stream.of(user),"ECCO chi è il primo nella lista");
    }

    private void myFlat(){

        List<List<String>> nombresVariasListas = new ArrayList<List<String>>(
                Arrays.asList(
                        new ArrayList<String>( Arrays.asList("Alberto","Pedro","Maria")),
                        new ArrayList<String>( Arrays.asList("Alberto", "Juan","Plinio")),
                        new ArrayList<String>( Arrays.asList("Alberto", "Marco","Leo"))));

        List<String> nombresUnicaLista = nombresVariasListas.stream()
                .flatMap(e->e.stream())
                .collect(Collectors.toList());
        System.out.println("Eccoci nombresunicalista");
        nombresUnicaLista.stream().forEach(e->System.out.println(e));


        List<Stream<String>> nombresUnicaLista2 = nombresVariasListas.stream()
                .map(e->e.stream())
                .collect(Collectors.toList());
        System.out.println("Eccoci nombresunicalista 2 ");
        nombresUnicaLista2.stream().forEach(e->System.out.println(e));

    }



    private void setup(){
        users = new ArrayList<>();
        users.add(new User(1,"Alberto","Garcia"));
        users.add(new User(2,"Marta","Jacobs"));
        users.add(new User(3,"Maria","Mocetti"));
        users.add(new User(4,"Mario","Jaramillo"));
        users.add(new User(5,"Adolfo","Blanck"));
        users.add(new User(6,"Alberto","Barrera"));
        users.add(new User(4,"Viviana","Jaramillo"));
        users.add(new User(4,"Rocio","Jaramillo"));
        users.add(new User(4,"Adriana","Jaramillo"));
    }

    private <T> void  printStream(Stream<T> stream,String headMessage){
        System.out.println(" \n **** " + headMessage + " ****");
        stream.forEach(System.out::println);
    }
}


