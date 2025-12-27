import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Session4 {

    public static void main(String[] args) {

        List<Course> courses = List.of(new Course("Spring", "Framework", 98, 1000),
                new Course("Spring Boot", "Framework", 95, 4000),
                new Course("API", "REST Web Services", 92, 2000),
                new Course("Microservices", "Microservices", 91, 1000),
                new Course("AWS", "Cloud", 97, 3000),
                new Course("Docker", "CICD", 91, 1000));

        //Using allMatch
        //To understand if all the courses satisfy a given criteria
        System.out.println(courses.stream().allMatch(course -> course.getScore() > 95));
        System.out.println(courses.stream().allMatch(course -> course.getScore() > 90));

        //Using noneMatch
        //To understand if none of these courses are satisfying a given criteria
        System.out.println(courses.stream().noneMatch(course -> course.getScore() > 95));

        //Using anyMatch
        //To understand if atleast 1 of the courses satisfy a given criteria
        System.out.println(courses.stream().anyMatch(course -> course.getScore() > 95));

        //Using Comparators to sort the courses based on criteria
        System.out.println(courses.stream()
                .sorted(Comparator.comparing(Course::getStudents))
                .collect(Collectors.toList()));

        //Now, to sort in decreasing order
        System.out.println(courses.stream()
                .sorted(Comparator.comparing(Course::getStudents).reversed())
                .collect(Collectors.toList()));

        //Now, to sort both the no of students and then on the basis of review score in descending order
        System.out.println("The values are :::: " + courses.stream()
                .sorted(Comparator.comparing(Course::getStudents)
                        .thenComparing(Course::getScore).reversed())
                .toList());


        //Note: Here, instead of using comparing, we can also use comparingInt, for primitives and for bypassing the autoboxing scenario.

        //Here, if we want to skip the first 3 results
        System.out.println(courses.stream()
                .sorted(Comparator.comparing(Course::getStudents)
                        .thenComparing(Course::getScore).reversed())
                .skip(3)
                .collect(Collectors.toList()));

        //If we only want to show the top 5 results
        System.out.println(courses.stream()
                .sorted(Comparator.comparing(Course::getStudents)
                        .thenComparing(Course::getScore).reversed())
                .limit(5)
                .collect(Collectors.toList()));

        //Show the list of courses until you reach the first score that does not match the criterion
        //Using takeWhile
        System.out.println(courses.stream()
                .takeWhile(course -> course.getScore() >= 95)
                .collect(Collectors.toList()));

        //Now to show the elements starting from the one which does not satisfy the given criterion
        //Using dropWhile
        System.out.println(courses.stream()
                .dropWhile(course -> course.getScore() >= 95)
                .collect(Collectors.toList()));

        //Using max and min
        System.out.println(courses.stream().min(Comparator.comparing(Course::getScore)));
        System.out.println(courses.stream().max(Comparator.comparing(Course::getScore)));

        //To find the first course that satisfies the given criterion
        System.out.println(courses.stream().filter(course -> course.getScore() >= 95).findFirst());

        //To find out any particular course that satisfies the given criterion
        System.out.println(courses.stream().filter(course -> course.getScore() >= 95).findAny());

        //Using some more aggregrate functions
        System.out.println(courses.stream().filter(course -> course.getScore() >= 95).mapToInt(Course::getScore).sum());
        System.out.println(courses.stream().filter(course -> course.getScore() >= 95).mapToInt(Course::getScore).average());
        System.out.println(courses.stream().filter(course -> course.getScore() >= 95).mapToInt(Course::getScore).count());

        //Using groupingBy
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));

        //To also get the count for each category
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));

        //To get the course with the max score
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getScore)))));

        //To show the list of course names for each category
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory,
                Collectors.mapping(Course::getName, Collectors.toList()))));

        

    }


}
