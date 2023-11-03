import java.util.ArrayList;

public class ClassRoom {
    private String classRoomNo;

    ArrayList<Slots> classesTiming = new ArrayList<>();
    private int classRoomCapacity;

    public ClassRoom(String classRoomNo, int classRoomCapacity) {
        this.classRoomNo = classRoomNo;
        this.classRoomCapacity = classRoomCapacity;

    }

    public String getClassRoomNo() {
        return classRoomNo;
    }

    public void setClassesTiming(Slots Time) {
        this.classesTiming.add(Time);
    }

 
    public int getClassRoomCapacity() {
        return classRoomCapacity;
    }


    public String toString() {
        return "ClassRoom{" +
                classRoomNo + "}";


    }
}
