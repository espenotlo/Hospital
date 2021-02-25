package hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hospital {
    private final String hospitalName;
    private HashMap<String, Department> departments;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalName() {
        return this.hospitalName;
    }

    public List<Department> getDepartments() {
        return new ArrayList<Department>(this.departments.values());
    }

    public void addDepartment(Department department) {
        if (!this.departments.containsKey(department.getDepartmentName())) {
            this.departments.put(department.getDepartmentName(), department);
        }
    }
    @Override
    public String toString() {
        return this.hospitalName;
    }
}
