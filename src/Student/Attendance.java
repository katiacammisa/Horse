package Student;

public class Attendance {

    private Integer totalClasses;
    private Integer assistedClasses;
    private Integer percentage;

    public Attendance() {

    }

    public void didAttend(){
        totalClasses += 1;
        assistedClasses +=1;

        percentage = (assistedClasses * 100) / totalClasses;
    }

    public void didNotAttend(){
        totalClasses += 1;

        percentage = (assistedClasses * 100) / totalClasses;
    }

    public Integer getPercentage() {
        return percentage;
    }
}
