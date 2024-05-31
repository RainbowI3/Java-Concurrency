import java.time.LocalDate;
import java.util.List;

public class Employee {

    private String name;
    private double salary;

    private LocalDate hireDay;


    public double getSalary(){
        return salary;
    }


    public void setSalary(double salary){
        if(salary <= 0){
            throw new IllegalArgumentException("negative salary");
        }

            this.salary = salary;

    }


    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
