/**
 * A patient in the hospital.
 */
public class Patient extends Person implements Diagnosable{

    private String diagnosis = "";

    /**
     * Creates an object of the Patient class.
     *
     * @param firstName            first name of the patient.
     * @param lastName             last name of the patient.
     * @param socialSecurityNumber the patient's social security number.
     */
    protected Patient(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    /**
     * Returns the patient's diagnosis.
     * @return {@code String} diagnosis of the patient.
     */
    protected String getDiagnosis() {
        return this.diagnosis;
    }

    /**
     * Sets the patient's diagnosis.
     * @param diagnosis {@code String} diagnosis of the patient.
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * Returns the {@code String} identifier of the patient in the format "socialSecurityNumber, firstName lastName".
     * @return {@code String} identifier of the patient in the format "socialSecurityNumber, firstName lastName".
     */
    @Override
    public String toString() {
        return super.toString();
    }

}
