/**
 * A General practitioner working with the hospital.
 */
public class GeneralPractitioner extends Doctor {

    /**
     * Creates an object of the GeneralPractitioner class.
     *
     * @param firstName            first name of the general practitioner.
     * @param lastName             last name of the general practitioner.
     * @param socialSecurityNumber the general practitioner's social security number.
     */
    public GeneralPractitioner(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    @Override
    void setDiagnosis(Patient patient, String diagnosis) {
        patient.setDiagnosis(diagnosis);
    }
}