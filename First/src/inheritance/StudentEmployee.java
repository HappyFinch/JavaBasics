package inheritance;

public class StudentEmployee extends Student {
    private String employeeId;
    private double hourlyRate;
    public StudentEmployee(String firstName, String lasName, String studentId, String employeeId, double hourlyRate) {
        super(firstName, lasName, studentId);
        this.employeeId = employeeId;
        this.hourlyRate = hourlyRate;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public double getHourlyRate() {
        return hourlyRate;
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    @Override
    public String toString() {
        return "StudentEmployee [employeeId=" + employeeId + ", hourlyRate=" + hourlyRate + ", toString()="
                + super.toString() + "]";
    }
}
