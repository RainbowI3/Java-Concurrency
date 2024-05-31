import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    public void doesNotAllowToSetNegativeSalary(){
        Employee employee = new Employee();
        employee.setSalary(10);


        assertThrows(
                IllegalConnectorArgumentsException.class,
//
//                new Executable() {
//                    @Override
//                    public void execute() throws Throwable {
//                        employee.setSalary(-10);
//                    }
//                }
                  () -> employee.setSalary(-10)
        );
        assertEquals(10, employee.getSalary());
    }

}