package lk.ravindu.ems.repository;

import lk.ravindu.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// this EmployeeRepository will get CRUD methods to perform CRUD operations
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}