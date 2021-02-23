/**
 * A nurse in the hospital.
 */
public class Nurse extends Employee {

    /**
     * Creates an object of the Nurse class.
     *
     * @param firstName            first name of the nurse.
     * @param lastName             last name of the nurse.
     * @param socialSecurityNumber the nurse's social security number.
     */
    public Nurse(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
