package org.example;
import jdk.jfr.DataAmount;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Slf4j


public class Employee {

    private String name;
    private double salary;

    private LocalDate hireDay;
    private List<LocalDate>daysOffs;





    public void setSalary(double salary){
        if(salary <= 0){
            throw new IllegalArgumentException("negative salary");
        }

            this.salary = salary;

    }

    public double getSalary() {
        return salary;
    }



    public List<LocalDate>getDaysOffs(){
        return new ArrayList<>(daysOffs);
    }

    public void saveToFile(String filePath){
       try {
           Files.writeString(Path.of(filePath),toString());
       }catch (Exception e){
           log.info("Failed to save an employee to {}",filePath);
       }
    }
    @Override
public String toString(){
    return "Employee" + name;
    }
}


