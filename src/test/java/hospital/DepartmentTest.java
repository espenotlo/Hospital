package hospital;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @org.junit.jupiter.api.Test
    void removePositiveAndNegativeTests() {
        Patient person = new Patient("John", "Doe", "01010122334");
        Department department = new Department("");
        department.addEmployee(person);

        assertTrue(department.getPatients().contains(person));
        department.remove(person);
        assertFalse(department.getPatients().contains(person));
        department.remove(person);
    }
}