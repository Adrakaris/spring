package hu.yijun.springtutorial1.repository;

import hu.yijun.springtutorial1.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Long> {  // <obj type, key type>

	// case sensitive
	public Department findByDepartmentName(String departmentName);  // this is autoimplemented based on the method signature
	// by JDBC

	public Optional<Department> findByDepartmentNameIgnoreCase(String departmentName);
	// if these signatures arent enough then we have to go by jpql queries

	// @Query("select u from User where u.firstname like %?1")
	// List<User> findByFirstnameEndsWith(String firstname);

	/*
	For jpql queries, ?n is the nth input, with ?1 being first
	For sql queries, in the query tag, can just
	@Query(value="...", nativeQuery=true)
	 */
}
