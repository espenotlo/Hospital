package mappe.del1.hospital;

import mappe.del1.hospital.exception.RemoveException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Department {
    private String departmentName;
    private final HashMap<String, Employee> employees;
    private final HashMap<String, Patient> patients;

    public Department(String departmentName) {
        setDepartmentName(departmentName);
        this.employees = new HashMap<>();
        this.patients = new HashMap<>();
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<>(this.employees.values());
        employeeList.sort((o1, o2) -> o1.toString().compareToIgnoreCase(o2.toString()));
        return employeeList;
    }

    public void addEmployee(Employee employee) {
        if (!this.employees.containsKey(employee.getSocialSecurityNumber())) {
            this.employees.put(employee.getSocialSecurityNumber(), employee);
        }
    }
    public List<Patient> getPatients() {
        List<Patient> patientList = new ArrayList<>(this.patients.values());
        patientList.sort((o1, o2) -> o1.toString().compareToIgnoreCase(o2.toString()));
        return patientList;
    }

    public void addPatient(Patient patient) {
        if (!this.patients.containsKey(patient.getSocialSecurityNumber())) {
            this.patients.put(patient.getSocialSecurityNumber(), patient);
        }
    }

    public int hashCode() {
        //TODO: WAT DIS?
        return 1;
    }

    public void remove(Person person) throws RemoveException {
        this.employees.remove(person.getSocialSecurityNumber());
        this.patients.remove(person.getSocialSecurityNumber());
    }

    @Override
    public boolean equals(Object o) {
        return o.getClass() == this.getClass() && o.toString().equals(toString());
    }

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
