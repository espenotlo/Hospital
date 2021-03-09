package hospital;

import mappe.del1.hospital.Department;
import mappe.del1.hospital.Employee;
import mappe.del1.hospital.exception.RemoveException;
import mappe.del1.hospital.healthpersonal.Nurse;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @org.junit.jupiter.api.Test
    void removePositiveTest() throws RemoveException {
        Employee person = new Nurse("John", "Doe", "01010122334");
        Department department = new Department("");
        department.addEmployee(person);

        assertTrue(department.getEmployees().contains(person));
        department.remove(person);
        assertFalse(department.getEmployees().contains(person));
    }
    @org.junit.jupiter.api.Test
    void whenExceptionThrown_thenAssertionSucceeds() {
        Exception exception = assertThrows(RemoveException.class, () -> {
            Integer.parseInt("1a");
        });

        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}