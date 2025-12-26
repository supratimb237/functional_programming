import java.util.List;


public class Session1 {
    public static void main(String[] args) {

         //Print each number in a list
        List<Integer> numbers = List.of(1, 12, 15, 12, 6, 7, 8, 9, 1, 76);
        //Purpose of stream --> converts a list of numbers into stream of nos
        //eg [1,2,65] --> 1 2 65
        //Main::showEachValue --> This is method reference
       /* printEachElement(numbers);
        System.out.println("Printing even nos");
        printOnlyEvenElements(numbers);*/
        System.out.println("Print odd nos");
        printOnlyOddElements(numbers);
        System.out.println("Print squares of odd numbers");
        printSquareOfOddNos(numbers);
        System.out.println("Print cubes of odd numbers");
        printCubesOfOddNos(numbers);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        printCoursesWithWord(courses);
        printCoursesBasedOnLength(courses);
        System.out.println("Print characters of each course");
        printCharacterLengthOfEachCourse(courses);

    }

    private static void printCharacterLengthOfEachCourse(List<String> courses) {
        courses.stream().map(String::length).forEach(System.out::println);
    }

    private static void printCubesOfOddNos(List<Integer> numbers) {
        numbers.stream().filter(num -> num%2!=0).map(num -> num * num * num).forEach(System.out::println);
    }

    private static void printSquareOfOddNos(List<Integer> numbers) {
        numbers.stream().filter(num -> num%2!=0).map(num -> num * num).forEach(System.out::println);
    }

    private static void printCoursesBasedOnLength(List<String> courses) {
        courses.stream().filter(course -> course.length()>=4).forEach(System.out::println);
    }

    private static void printCoursesWithWord(List<String> courses) {
        courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);
    }

    private static void printOnlyOddElements(List<Integer> numbers) {
        numbers.stream().filter(number -> number % 2!=0).forEach(System.out::println);
    }

    private static void printOnlyEvenElements(List<Integer> numbers) {
        numbers.stream()
                //.filter(Main::isEven)
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);
    }

    private static boolean isEven(int i){
        return i%2==0;
    }

    private static void printEachElement(List<Integer> numbers) {
        numbers.forEach(Session1::showEachValue);
        //Alternative
        numbers.forEach(System.out::println);
    }

    public static void showEachValue(int i){
        System.out.println(i);
    }
}