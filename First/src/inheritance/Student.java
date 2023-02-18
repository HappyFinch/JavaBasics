package inheritance;

public class Student extends Person{
    private String studentId;
    public Student(String firstName, String lasName, String studentId) {
        super(firstName, lasName);
        this.studentId = studentId;
    }
    public String getStudentId(){
        return studentId;
    }
    public void setStudentId(String studentId){
        this.studentId = studentId;
    }
    @Override
    public String toString(){
        return super.toString() + " Student ID:" + studentId;
    }
}
