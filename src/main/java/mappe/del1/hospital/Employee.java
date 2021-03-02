package mappe.del1.hospital;

import mappe.del1.hospital.Person;

/**
 * An abstraction of an employee in the hospital.
 * All employees have a more defined class,
 * but share the traits of this class.
 */
public class Employee extends Person {

    /**
     * Creates an object of the Employee class.
     *
     * @param firstName            first name of the employee.
     * @param lastName             last name of the employee.
     * @param socialSecurityNumber the employee's social security number.
     */
    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    /**
     * Returns the {@code String} identifier of the employee in the format "socialSecurityNumber, firstName lastName".
     * @return {@code String} identifier of the employee in the format "socialSecurityNumber, firstName lastName".
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
