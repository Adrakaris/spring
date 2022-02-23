package hu.yijun.springtutorial1.controller;

import hu.yijun.springtutorial1.entity.Department;
import hu.yijun.springtutorial1.exception.DepartmentNotFoundException;
import hu.yijun.springtutorial1.service.IDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

	// tell the spring to automatically create the thing
	// property-based constructor
	// note that autowired on a field is not recommended - better to do it through a constructor so that we can set
	// finals and stuff - field autowiring PREVENTS final
//	@Autowired
	private final IDepartmentService departmentService;

	// for a logger
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);  // slf4j

	@Autowired
	public DepartmentController(IDepartmentService service) {
		departmentService = service;
	}

	@PostMapping("/departments")
	// validation with the thign
	public Department saveDepartment(@Valid @RequestBody Department department) {
		// call serivce layer to pass data, service layer does business logic, and calls repo layer to save
		LOGGER.info("Saving department inside DepartmetnController");
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/departments")
	public List<Department> getAllDepartments() {
		return departmentService.fetchDepartmentList();
	}

	// the /{id} bit is a "path variable"
	@GetMapping("/departments/{id}")
	public Department getDeptByID(@PathVariable("id") Long departmentID) throws DepartmentNotFoundException {
		return departmentService.fetchDepartmentByID(departmentID);
	}

	@DeleteMapping("/departments/{id}")
	public String deleteDeptByID(@PathVariable("id") Long departmentID) {
		departmentService.deleteDeptByID(departmentID);
		return "Department deleted successfully";
	}

	@PutMapping("/departments/{id}")
	public Department updateDepartment(
			@PathVariable("id") Long departmentID,
			@RequestBody Department department
	) {
		return departmentService.updateDepartment(departmentID, department);
	}

	@GetMapping("/departments/name/{name}")
	public Department getDeptByName(@PathVariable("name") String deptName) throws DepartmentNotFoundException {
		return departmentService.fetchDepartmentByName(deptName);
	}
}
