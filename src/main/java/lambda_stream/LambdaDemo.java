package lambda_stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


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
        System.out.println();
        numbers.forEach(integer -> System.out.print(integer + " "));
        System.out.println();
        // znajdź wartość max liście I sposób
        List<Integer> maxValue = numbers.stream()
                // sortowanie wykorzystuje klasę Comparator(podstawa sortowania)
                // reversed() - odwraca kolejonść
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                // ograniczenie do jednej wartości
                .limit(1)
                // konwersja do listy
                .collect(Collectors.toList());
        System.out.println("maxValue = " + maxValue);

        // znajdź min element w liście II sposób
        Optional<Integer> minValue = numbers.stream().min(Integer::compareTo);
        if(minValue.isPresent()){      // sprawdzenie czy wartośc min value jest notnull
            System.out.println("minValueOptional: " + minValue);  // obiekt Optional<Integer>
            System.out.println("minValue: " + minValue.get());  // get pobiera zawartość Optionala
        }
        // znajdź wartość średnią z elementów listy
        OptionalDouble avgValue = numbers.stream().mapToDouble(Integer::doubleValue).average();
        if(avgValue.isPresent()){
            System.out.println("avgValue: " + avgValue.getAsDouble());
        }
        


    }
    
    
}
