package org.example;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static java.nio.file.Files.exists;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    public void doesNotAllowToSetNegativeSalary(){
        Employee employee = new Employee();
        employee.setSalary(10);

        assertThatThrownBy(() -> employee.setSalary(-10))
                .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("negative salary");

//        Assertions.assertThrows(
//                IllegalConnectorArgumentsException.class,
//
//               new Executable() {
//                    @Override
//                   public void execute() throws Throwable {
//                       employee.setSalary(-10);
//                    }
//                }
//                () -> employee.setSalary(-10)
//        );
//        Assertions.assertEquals(10, employee.getSalary());
        assertThat(employee.getSalary()).isEqualTo(10);
    }

    @Test
    public void savesToFile() throws IOException {
        Employee employee = new Employee();
        employee.setName("Nikol");
        employee.saveToFile("employee.txt");


      //  assertThat(Path.of("employee.txt")).exists();

        Files.delete(Path.of("employee.txt"));
    }

}