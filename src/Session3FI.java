import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Session3FI {


    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 5, 1, 12, 12, 15, 16, 8, 9, 8, 16, 7, 2, 3, 8, 10);

        //A Predicate is used to do an operation that returns a boolean value
        //<Integer> --> The input is an Integer
        Predicate<Integer> integerPredicate = x -> x % 2 == 0;

        //A Function is used to perform any operation on an element
        //<Integer, Integer> --> Both the input and output are Integers
        Function<Integer, Integer> integerIntegerFunction = x -> x * x;


        //This is used in case of performing operations on two elements
        //Here, <Integer> --> The type of Input vars are same as output
        BinaryOperator<Integer> integerBinaryOperator = (x, y) -> x + y;

        //Consumer
        //Takes some input but result is void i.e. to store this value i.e. no return type
        Consumer<Integer> consumer = System.out::println;

        //Supplier
        //Here, no inputs are provided, but we still get an output
        //Factory pattern
        Supplier<Integer> supplier = () -> {
            Random random = new Random();
            return random.nextInt(100);
        };

        //Unary Operator
        //Operates on only 1 variable/parameter
        UnaryOperator<Integer> unaryOperator = x -> x*3;

        //BiPredicate
        BiPredicate<Integer,String> biPredicate = (x,s) -> {
            return x>10 && s.equalsIgnoreCase("test");
        };

        //BiFunction
        BiFunction<Integer,String,String> biFunction = (x,y) -> x + " " + y;

        //BiConsumer
        BiConsumer<Integer,String> biConsumer = (x,y) -> {
            System.out.println(x);
            System.out.println(y);
        };

        System.out.println(numbers.stream()
                .filter(integerPredicate)
                .map(integerIntegerFunction)
                .reduce(0, integerBinaryOperator));
    }
}
