package hu.yijun.springtutorial1.service;

import hu.yijun.springtutorial1.entity.Department;
import hu.yijun.springtutorial1.exception.DepartmentNotFoundException;
import hu.yijun.springtutorial1.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService {

	// autowire reference of department repository
	private final IDepartmentRepository departmentRepository;

	@Autowired
	public DepartmentService(IDepartmentRepository repository) {
		departmentRepository = repository;
	}

	@Override
	public Department saveDepartment(Department department) {
		// get
		return departmentRepository.save(department);  // default repo method
		// spring will automatically create table
	}

	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentByID(Long departmentID) throws DepartmentNotFoundException {
		Optional<Department> dept;
		if ((dept = departmentRepository.findById(departmentID)).isPresent()) {
			return dept.get();
		} else {
//			return null;
			throw new DepartmentNotFoundException("Department Not Available");
		}

	}

	@Override
	public void deleteDeptByID(Long departmentID) {
		departmentRepository.deleteById(departmentID);
	}

	@Override
	public Department updateDepartment(Long id, Department department1) {
		Optional<Department> deptOpt;
		Department fromRepo;
		if ((deptOpt = departmentRepository.findById(id)).isPresent()) {
			fromRepo = deptOpt.get();
		} else {
			return null;
		}

		if (Objects.nonNull(department1.getDepartmentName())  // not null
				&& !"".equalsIgnoreCase(department1.getDepartmentName())  // not blank
		) {
			fromRepo.setDepartmentName(department1.getDepartmentName());
		}
		if (Objects.nonNull(department1.getDepartmentCode())
				&& !"".equalsIgnoreCase(department1.getDepartmentCode())
		) {
			fromRepo.setDepartmentCode(department1.getDepartmentCode());
		}
		if (Objects.nonNull(department1.getDepartmentAddress())
				&& !"".equalsIgnoreCase(department1.getDepartmentAddress())
		) {
			fromRepo.setDepartmentAddress(department1.getDepartmentAddress());
		}

		return departmentRepository.save(fromRepo);
	}

	@Override
	public Department fetchDepartmentByName(String deptName) throws DepartmentNotFoundException {
		// no default method so we need to create one in the interface
		// return departmentRepository.findByDepartmentName(deptName);
		// note - this is case sensitive, thus

		Optional<Department> dept = departmentRepository.findByDepartmentNameIgnoreCase(deptName);

		if (dept.isEmpty()) {
			throw new DepartmentNotFoundException("Department Not Available");
		}

		return dept.get();
	}
}
