import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Session2 {
    public static void main(String[] args) {

         //Sum of all the nos in a list
        List<Integer> numbers = List.of(1, 12, 15, 12, 6, 7, 8, 9, 1, 76);

        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("The sum of the elements is :: "+sum);

        System.out.println("Sum of squares of these elements");
        int sumSquares = 0;
        sumSquares = numbers.stream().map(a -> a*a).reduce(0 , (a,b) -> a+b);
        System.out.println(sumSquares);

        System.out.println("Sum of cubes of these elements");
        int sumCubes = 0;
        sumCubes = numbers.stream().map(a -> a*a*a).reduce(0 , (a,b) -> a+b);
        System.out.println(sumCubes);

        System.out.println("Sum of odd nos in list");
        int sumOddNos = 0;
        sumOddNos = numbers.stream().filter(a -> a%2!=0).reduce(0, Integer::sum);
        System.out.println(sumOddNos);

        System.out.println("Distinct nos in list");
        numbers.stream().distinct().forEach(System.out::println);

        System.out.println("Sorting the distinct nos in list");
        numbers.stream().distinct().sorted().forEach(System.out::println);

        //Using Comparator to sort the elements of a course alphabetically
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        System.out.println("Sorting the courses alphabetically");
        courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);

        System.out.println("Sorting the courses alphabetically in reverse order");
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        System.out.println("Sorting the courses on the basis of their course lengths");
        courses.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);

        //Using Collectors
        System.out.println("To store the squares of each element in a new list");
        List<Integer> collect = numbers.stream().map(x -> x * x).toList();
        System.out.println(collect);

        System.out.println("To create a list with the even numbers filtered out");
        List<Integer> collect1 = numbers.stream().filter(x -> x % 2 == 0).toList();
        System.out.println(collect1);

        System.out.println("To create a list with lengths of course titles");
        List<Integer> collect2 = courses.stream().map(String::length).toList();
        System.out.println(collect2);



    }
}