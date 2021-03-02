package mappe.del1.hospital;

import mappe.del1.hospital.exception.RemoveException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A department is a section of the hospital.
 * This class manages the patients admitted to
 * the department in the hospital, and the
 * employees working there.
 */
public class Department {
    private String departmentName;
    private final HashMap<String, Employee> employees;
    private final HashMap<String, Patient> patients;

    /**
     * Creates an object of the department class
     * @param departmentName {@code String} name of the department.
     */
    public Department(String departmentName) {
        setDepartmentName(departmentName);
        this.employees = new HashMap<>();
        this.patients = new HashMap<>();
    }

    /**
     * Changes the name of the department.
     * @param departmentName {@code String} name of the department.
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Returns the name of the department.
     * @return {@code String} name of the department.
     */
    public String getDepartmentName() {
        return this.departmentName;
    }

    /**
     * Returns a list containing
     * all the employees in the department.
     * @return {@code List<Employee>} of employees in the department.
     */
    public List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<>(this.employees.values());
        employeeList.sort((o1, o2) -> o1.toString().compareToIgnoreCase(o2.toString()));
        return employeeList;
    }

    /**
     * Adds an employee to the department.
     * @param employee the {@code Employee} to be added.
     */
    public void addEmployee(Employee employee) {
        if (!this.employees.containsKey(employee.getSocialSecurityNumber())) {
            this.employees.put(employee.getSocialSecurityNumber(), employee);
        }
    }

    /**
     * Returns a list of all patients in the department.
     * @return {@code List<Patient>} of all patients in the department.
     */
    public List<Patient> getPatients() {
        List<Patient> patientList = new ArrayList<>(this.patients.values());
        patientList.sort((o1, o2) -> o1.toString().compareToIgnoreCase(o2.toString()));
        return patientList;
    }

    /**
     * Adds a patient to the department.
     * @param patient the {@code Patient} to be added.
     */
    public void addPatient(Patient patient) {
        if (!this.patients.containsKey(patient.getSocialSecurityNumber())) {
            this.patients.put(patient.getSocialSecurityNumber(), patient);
        }
    }

    /**
     *
     * @return
     */
    public int hashCode() {
        //TODO: WAT DIS?
        return 1;
    }

    /**
     * Removes a person from the department; be they employee or patient.
     * @param person the {@code Person} to be removed.
     * @throws RemoveException
     */
    public void remove(Person person) throws RemoveException {
        this.employees.remove(person.getSocialSecurityNumber());
        this.patients.remove(person.getSocialSecurityNumber());
    }

    @Override
    public boolean equals(Object o) {
        return o.getClass() == this.getClass() && o.toString().equals(toString());
    }

    /**
     * Returns a String containing the name of the
     * department as well as listings of all
     * employees and patients in the department.
     * @return {@code String} of the Department name, employees and patients.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.departmentName).append("\nAnsatte: \n");
        for (Employee employee : getEmployees()) {
            sb.append(employee.toString()).append("\n");
        }
        sb.append("\nPasienter: \n");
        for (Patient patient : getPatients()) {
            sb.append(patient.toString()).append("\n");
        }
        return sb.toString();
    }
}
