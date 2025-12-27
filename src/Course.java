public class Course {

    private String name;
    private String category;
    private int score;
    private int students;

    public Course() {
    }

    public Course(String name, String category, int score, int students) {
        this.name = name;
        this.category = category;
        this.score = score;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", score=" + score +
                ", students=" + students +
                '}';
    }
}
