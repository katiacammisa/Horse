package Student;

import java.util.List;

public class Student {

    private RegistrationID registrationID;
    private String commission;
    private List<Integer> grades;
    private Attendance attendance;

    public Student(RegistrationID registrationID, String commission) {
        this.registrationID = registrationID;
        this.commission = commission;
    }

    public void addGrade(Integer grade){
        if(grade > 0 && grade<=10){
            grades.add(grade);
        }
    }

    public void attend (boolean attended){
        if(attended){
            attendance.didAttend();
        }
        else{
            attendance.didNotAttend();
        }
    }

    public RegistrationID getRegistrationID() {
        return registrationID;
    }

    public String getCommission() {
        return commission;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public boolean canTakeFinal(){
        if(attendance.getPercentage()>= 75){
            for (int i = 0; i < grades.size(); i++) {
                if(grades.get(i) < 4){
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
