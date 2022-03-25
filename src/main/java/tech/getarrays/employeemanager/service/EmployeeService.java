package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exceptions.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repository.EmployeeRepo;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("User by id"+id+"is not found"));
    }

}
