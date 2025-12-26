import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;


public class Session3BP {
    public static void main(String[] args) {

        //Sum of all the nos in a list
        List<Integer> numbers = List.of(1, 12, 15, 12, 6, 7, 8, 9, 1, 76);

        //Trying Behaviour Parameterization

        //Predicate<Integer> integerPredicate = x -> x % 2 == 0;
        //This is behaviour parameterization -> we are directly passing the lambda expression in the method params
        //To print the even nos
        filterNumbersByRule(numbers, x -> x%2==0);
        //To print the odd nos
        filterNumbersByRule(numbers, x -> x%2!=0);

        //Function<Integer, Integer> integerIntegerFunction = x -> x * x;
        //Using Behaviour Parameterization for Maps
        mapTheNumbersBasedOnBehaviour(numbers, x -> x * x);
    }

    private static void mapTheNumbersBasedOnBehaviour(List<Integer> numbers, Function<Integer, Integer> integerIntegerFunction) {
        List<Integer> collect = numbers.stream().map(integerIntegerFunction).toList();
        System.out.println(collect);
    }

    private static void filterNumbersByRule(List<Integer> numbers, Predicate<Integer> integerPredicate) {
        numbers.stream().filter(integerPredicate).forEach(System.out::println);
    }
}