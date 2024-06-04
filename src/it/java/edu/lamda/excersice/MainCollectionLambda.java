package it.java.edu.lamda.excersice;

import java.util.*;
import java.util.stream.Collectors;

public class MainCollectionLambda {

    public static void main(String[] args) {
        MainCollectionLambda main = new MainCollectionLambda();

        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);
        List<String> list = Arrays.asList("one", "two", "three", "four", "five");
        List<String> words = Arrays.asList("apple", "banana", "cat", "dog","arancia","aguacate","bird","barco","casa","dado");

        main.ragruppamento(words);

        main.printList(list);
        main.filter(numberList);
        main.transform();
    }

    public  void transform() {
        List<String> strings = Arrays.asList("hello", "world", "java", "streams");

        List<String> result = strings.stream()
                .filter(s -> s.length() > 5)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(strings); // Output: [HELLO, WORLD, STREAMS]
        System.out.println(result); // Output: [HELLO, WORLD, STREAMS]
    }

    public void printList(List<String> list) {
                list.forEach(System.out::println);
    }

    public void filter(List<Integer> list) {
        List<Integer> result = list.stream().filter(x -> x%2 == 0).collect(Collectors.toList());
        result.forEach(System.out::print);
        int summa = list.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println("summa : " + summa);
    }

    public void ragruppamento(List<String> words){
        Map<Character, List<String>> wordsByFirstLetter = words.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));

        Map<String, Long> resultato = words.stream().collect(Collectors.groupingBy( x-> x.contains("a") ? "si a" : "no a", Collectors.counting()));

        Long count = words.stream().collect(Collectors.counting());
        System.out.println("count  : " +  count);
        System.out.println("count words : " +  resultato);
        System.out.println("words : " +  wordsByFirstLetter); // Stampa la mappa con raggruppamento per lettera iniziale
    }
}
