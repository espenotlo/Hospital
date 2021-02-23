/**
 * Represents a generic person.
 * This class stores only the most
 * basic information on a person,
 * and is to be implemented by the
 * more specialized person type classes.
 */
abstract class Person {

    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    /**
     * Creates an object of the Person class.
     * @param firstName first name of the person.
     * @param lastName last name of the person.
     * @param socialSecurityNumber the person's social security number.
     */
    public Person(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    /**
     * Returns the person's social security number.
     * @return {@code String} social security number of the person.
     */
    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    /**
     * Sets the person's social security number.
     * @param socialSecurityNumber {@code String} social security number of the person.
     */
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    /**
     * Returns the person's first name.
     * @return {@code String} first name of the person.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets the person's first name.
     * @param firstName {@code String} first name of the person.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the person's last name.
     * @return {@code String} last name of the person.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the person's last name.
     * @param lastName {@code String} last name of the person.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the person's full name in the format "last, first".
     * @return {@code String} full name of the person in the format "lastName, firstName".
     */
    public String getFullName() {
        return (this.lastName + ", " + this.firstName);
    }

    /**
     * Returns the {@code String} identifier of the person in the format "socialSecurityNumber, firstName lastName".
     * @return {@code String} identifier of the person in the format "socialSecurityNumber, firstName lastName".
     */
    @Override
    public String toString() {
        return (this.socialSecurityNumber +", "+ this.firstName + " " + this.lastName);
    }
}
