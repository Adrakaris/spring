package hu.yijun.springtutorial1.service;

import hu.yijun.springtutorial1.entity.Department;
import hu.yijun.springtutorial1.exception.DepartmentNotFoundException;

import java.util.List;

public interface IDepartmentService {
	// modifier public is unnecessary
	Department saveDepartment(Department department);

	List<Department> fetchDepartmentList();

	Department fetchDepartmentByID(Long departmentID) throws DepartmentNotFoundException;

	void deleteDeptByID(Long departmentID);

	Department updateDepartment(Long id, Department department1);

	Department fetchDepartmentByName(String deptName) throws DepartmentNotFoundException;
}
