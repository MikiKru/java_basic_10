package lambda_stream;

import java.util.*;


public class LambdaDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(
            Arrays.asList(11,22,3,4,3,21,2)
        );
        // wypisanie wszystkich elementów listy
        for(Integer integer : numbers){
            System.out.print(integer + " ");
        }
        System.out.println();
        // wypisanie wszystkich elementów listy
        // lambda predicate -> CTRL + Space
        numbers.stream().forEach(integer -> System.out.print(integer + " "));
        numbers.forEach(integer -> System.out.print(integer + " "));

        // znajdź wartość max liście

    }
}
