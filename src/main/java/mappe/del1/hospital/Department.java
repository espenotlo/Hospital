package mappe.del1.hospital;

import mappe.del1.hospital.exception.RemoveException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * A department is a section of the hospital.
 * This class manages the patients admitted to
 * the department in the hospital, and the
 * employees working there.
 */
public class Department {
    private String departmentName;
    private final HashMap<String, Person> persons;

    /**
     * Creates an object of the department class
     * @param departmentName {@code String} name of the department.
     */
    public Department(String departmentName) {
        setDepartmentName(departmentName);
        this.persons = new HashMap<>();
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
     * Returns an alphabetically sorted list of
     * all the employees in the department.
     * @return {@code ArrayList<Employee>} of employees in the department.
     */
    public List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        for (Person person : this.persons.values()) {
            if (person instanceof Employee) {
                employeeList.add((Employee) person);
            }
        }
        employeeList.sort((o1, o2) -> o1.toString().compareToIgnoreCase(o2.toString()));
        return employeeList;
    }

    /**
     * Adds an employee to the department.
     * @param employee the {@code Employee} to be added.
     */
    public void addEmployee(Employee employee) {
        if (!this.persons.containsKey(employee.getSocialSecurityNumber())) {
            this.persons.put(employee.getSocialSecurityNumber(), employee);
        }
    }

    /**
     * Returns an alphabetically sorted list of all patients in the department.
     * @return {@code ArrayList<Patient>} of all patients in the department.
     */
    public List<Patient> getPatients() {
        List<Patient> patientList = new ArrayList<>();
        for (Person person : this.persons.values()) {
            if (person instanceof Patient) {
                patientList.add((Patient) person);
            }
        }
        patientList.sort((o1, o2) -> o1.toString().compareToIgnoreCase(o2.toString()));
        return patientList;
    }

    /**
     * Adds a patient to the department.
     * @param patient the {@code Patient} to be added.
     */
    public void addPatient(Patient patient) {
        if (!this.persons.containsKey(patient.getSocialSecurityNumber())) {
            this.persons.put(patient.getSocialSecurityNumber(), patient);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, persons);
    }

    /**
     * Removes a person from the department; be they employee or patient.
     * @param person the {@code Person} to be removed.
     * @throws RemoveException if person is not in the hospital.
     */
    public void remove(Person person) throws RemoveException {
        if (this.persons.containsKey(person.getSocialSecurityNumber())) {
            if (person instanceof Employee) {
                if (persons.get(person.getSocialSecurityNumber()) instanceof Employee) {
                    Employee p = (Employee) this.persons.get(person.getSocialSecurityNumber());
                    this.persons.remove(p.getSocialSecurityNumber());
                    throw new RemoveException("Fjernet " + p.asString() + " fra sykehusregisteret.");
                }
            } else if (person instanceof Patient) {
                if (persons.get(person.getSocialSecurityNumber()) instanceof Patient) {
                    Patient p = (Patient) this.persons.get(person.getSocialSecurityNumber());
                    this.persons.remove(p.getSocialSecurityNumber());
                    throw new RemoveException("Fjernet " + p.asString() + " fra sykehusregisteret.");
                }
            }
        }
    }

    /**
     * Returns a String containing the name of the
     * department as well as listings of all
     * employees and patients in the department.
     * @return {@code String} of the Department name, employees and patients.
     */
    public String getAsString() {
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

    @Override
    public String toString() {
        return this.departmentName;
    }

    @Override
    public boolean equals(Object o) {
        return o.getClass() == this.getClass() && o.toString().equals(getAsString());
    }

    public List<Person> getPeople() {
        return new ArrayList<>(this.persons.values());
    }
}
