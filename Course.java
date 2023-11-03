public class Course {
    private String name;
    private String curriculum;
    private int courseCapacity;
    boolean beingTaught;


    public Course(String name, int courseCapacity) {
        this.beingTaught = beingTaught;
        this.name = name;
        this.curriculum = curriculum;
        this.courseCapacity = courseCapacity;
    }


    public String toString() {
        return "Course{" +
                "name='" + name;
    }


    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public int getCourseCapacity() {
        return courseCapacity;
    }

    public void setCourseCapacity(int courseCapacity) {
        this.courseCapacity = courseCapacity;
    }

    public String getName() {
        return name;
    }
}
