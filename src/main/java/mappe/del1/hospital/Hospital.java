package mappe.del1.hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Abstraction of a hospital.
 * A hospital consists of one or more departments,
 * each containing patients and employees.
 */
public class Hospital {
    private final String hospitalName;
    private final HashMap<String, Department> departments;

    /**
     * Creates an object of the class, with the name given in the parameter.
     * @param hospitalName {@code String} name of the hospital.
     */
    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.departments = new HashMap<>();
    }

    /**
     * Returns the name of the hospital.
     * @return {@code String} name of the hospital.
     */
    public String getHospitalName() {
        return this.hospitalName;
    }

    /**
     * Returns a list of all departments, sorted alphabetically.
     * @return {@code List<Department>} of all departments.
     */
    public List<Department> getDepartments() {
        List<Department> departmentList = new ArrayList<>(this.departments.values());
        departmentList.sort((o1, o2) -> o1.getDepartmentName().compareToIgnoreCase(o2.getDepartmentName()));
        return departmentList;
    }

    /**
     * Adds a department to the hospital.
     * @param department the {@code Department} to be added.
     */
    public void addDepartment(Department department) {
        if (!this.departments.containsKey(department.getDepartmentName())) {
            this.departments.put(department.getDepartmentName(), department);
        }
    }

    /**
     * Returns a String containing the name of the
     * hospital as well as listings of all
     * employees and patients in each department.
     * @return {@code String} of the Hospital name, departments and their employees and patients.
     */
    public String getAsString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.hospitalName).append("\n\n");
        for (Department department : getDepartments()) {
            sb.append(department.getAsString()).append("\n");
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        return this.hospitalName;
    }
}
