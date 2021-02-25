package mappe.del1.hospital;
import mappe.del1.hospital.healthpersonal.Nurse;
import mappe.del1.hospital.healthpersonal.doctor.GeneralPractitioner;
import mappe.del1.hospital.healthpersonal.doctor.Surgeon;
public class HospitalTestData {
    /**
     * Fills the hospital provided as a parameter with
     * departments and some employees and patients.
     *
     * @param hospital the hospital to be populated with testdata
     */
    public static void fillRegisterWithTestData(final Hospital hospital) {
        // Add some departments
        Department emergencyRoom = new Department("Akutten");
        emergencyRoom.addEmployee(new Employee("Odd Even", "Primtallet", "1234567890"));
        emergencyRoom.addEmployee(new Employee("Huppasahn", "DelFinito", "2345678901"));
        emergencyRoom.addEmployee(new Nurse("Rigmor", "Mortis", "3456789012"));
        emergencyRoom.addEmployee(new GeneralPractitioner("Inco", "Gnito", "4567890123"));
        emergencyRoom.addEmployee(new Surgeon("Inco", "Gnito", "5678901234"));
        emergencyRoom.addPatient(new Patient("Nina", "Teknologi", "6789012345"));
        emergencyRoom.addPatient(new Patient("Ove", "Ralt", "7890123456"));
        hospital.addDepartment(emergencyRoom);
        Department childrensPolyclinic = new Department("Barne poliklinikk");
        childrensPolyclinic.addEmployee(new Employee("Salti", "Kaffen", "8901234567"));
        childrensPolyclinic.addEmployee(new Employee("Nidel V.", "Elvefølger", "9012345678"));
        childrensPolyclinic.addEmployee(new Nurse("Anton", "Nym", "0123456789"));
        childrensPolyclinic.addEmployee(new GeneralPractitioner("Gene", "Sis", "0987654321"));
        childrensPolyclinic.addPatient(new Patient("Nanna", "Na", "9876543210"));
        childrensPolyclinic.addPatient(new Patient("Nora", "Toriet", "8765432109"));
        hospital.addDepartment(childrensPolyclinic);
    }
}