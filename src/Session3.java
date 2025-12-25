import java.util.Comparator;
import java.util.List;
import java.util.function.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Session3 {
    public static void main(String[] args) {

        //Sum of all the nos in a list
        List<Integer> numbers = List.of(1, 12, 15, 12, 6, 7, 8, 9, 1, 76);

        //Supplier<Predicate<Integer>> predicateSupplier = () -> x -> x % 2 == 0;

        Function<Integer, Integer> integerIntegerFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        Predicate<Integer> integerPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x % 2 == 0;
            }
        };

        Consumer<Integer> print = new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };

        numbers.stream().filter(integerPredicate).map(integerIntegerFunction).forEach(print);

        //To find the Functional Interface for the 2nd argument of reduce method
        BinaryOperator<Integer> integerBinaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer aggregrate, Integer nextElement) {
                return aggregrate + nextElement;
            }
        };

        Integer reduce = numbers.stream().reduce(0, integerBinaryOperator);
        System.out.println("The sum is :: " + reduce);
    }
}