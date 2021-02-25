package hospital;

import com.sun.jdi.Value;
import hospital.healthpersonal.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Department {
    private String departmentName;
    private HashMap<String, Employee> employees;
    private HashMap<String, Patient> patients;

    public Department(String departmentName) {
        setDepartmentName(departmentName);
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(this.employees.values());
    }

    public void addEmployee(Employee employee) {
        if (!this.employees.containsKey(employee.getSocialSecurityNumber())) {
            this.employees.put(employee.getSocialSecurityNumber(), employee);
        }
    }
    public List<Patient> getPatients() {
        return new ArrayList<>(this.patients.values());
    }

    public void addEmployee(Patient patient) {
        if (!this.patients.containsKey(patient.getSocialSecurityNumber())) {
            this.patients.put(patient.getSocialSecurityNumber(), patient);
        }
    }

    public int hashCode() {
        //TODO: WAT DIS?
        return 1;
    }

    public void remove(Person person) {
        try {
            this.employees.remove(person.getSocialSecurityNumber());
        } catch (Exception RemoveException) {
            System.out.println(RemoveException.getMessage());
        }
        try {
            this.patients.remove(person.getSocialSecurityNumber());
        } catch (Exception RemoveException) {
            System.out.println(RemoveException.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        return o.getClass() == this.getClass() && o.toString().equals(toString());
    }
}
