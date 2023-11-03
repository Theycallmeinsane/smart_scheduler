public class Class {
    Slots timeSlot;
    Professor professor;
    Course course;
    ClassRoom classRoom;
    String Day;
    boolean availabilityTime;

    public Class(String Day, Slots timeSlot, ClassRoom classRoom) {
        this.Day = Day;
        this.timeSlot = timeSlot;
        this.classRoom = classRoom;
    }

    public Class(String Day, Slots timeSlot, Professor professor, Course course, ClassRoom classRoom) {
        this.timeSlot = timeSlot;
        this.professor = professor;
        this.course = course;
        this.classRoom = classRoom;
        this.Day = Day;
    }

    public Slots getTimeSlot() {
        return timeSlot;
    }

    public boolean isAvailabilityTime() {
        return availabilityTime;
    }

    public void setAvailabilityTime(boolean availabilityTime) {
        this.availabilityTime = availabilityTime;
    }

    public void setTimeSlot(Slots timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }
    

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public String toString() {
        return "Class{" + "Day=" + Day +
                ", timeSlot=" + timeSlot +
                ", professor=" + professor +
                ", course=" + course +
                ", classRoom=" + classRoom +
                '}';
    }
}
