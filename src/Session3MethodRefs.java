import java.util.List;
import java.util.function.Supplier;

public class Session3MethodRefs {

    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        courses.stream().map(String::toUpperCase).forEach(System.out::println);

        Supplier<String> supplier = String::new;
    }
}
