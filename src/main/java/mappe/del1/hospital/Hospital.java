package mappe.del1.hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hospital {
    private final String hospitalName;
    private final HashMap<String, Department> departments;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.departments = new HashMap<>();
    }

    public String getHospitalName() {
        return this.hospitalName;
    }

    public List<Department> getDepartments() {
        List<Department> departmentList = new ArrayList<Department>(this.departments.values());
        departmentList.sort((o1, o2) -> o1.getDepartmentName().compareToIgnoreCase(o2.getDepartmentName()));
        return departmentList;
    }

    public void addDepartment(Department department) {
        if (!this.departments.containsKey(department.getDepartmentName())) {
            this.departments.put(department.getDepartmentName(), department);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.hospitalName).append("\n\n");
        for (Department department : getDepartments()) {
            sb.append(department.toString()).append("\n");
        }
        return sb.toString();
    }
}
