package lk.ravindu.ems.service.impl;

import lk.ravindu.ems.dto.EmployeeDto;
import lk.ravindu.ems.entity.Employee;
import lk.ravindu.ems.exception.ResourceNotFoundException;
import lk.ravindu.ems.mapper.EmployeeMapper;
import lk.ravindu.ems.repository.EmployeeRepository;
import lk.ravindu.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with the given id: "+ employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
