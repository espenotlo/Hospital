/**
 * A tag signalling the associated class can be diagnosed by a doctor.
 */
public interface Diagnosable {
    /**
     * Sets the diagnosis for the patient.
     * @param diagnosis the diagnosis to be given.
     */
    void setDiagnosis(String diagnosis);
}
