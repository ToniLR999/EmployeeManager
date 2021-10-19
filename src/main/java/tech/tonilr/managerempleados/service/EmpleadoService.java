package tech.tonilr.managerempleados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tech.tonilr.managerempleados.entitys.Empleado;
import tech.tonilr.managerempleados.exceptions.UserNotFoundException;
import tech.tonilr.managerempleados.repo.EmpleadoRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class EmpleadoService {
	
	
	private final EmpleadoRepo employeeRepo;

	@Autowired
    public EmpleadoService(EmpleadoRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Empleado addEmployee(Empleado employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Empleado> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Empleado updateEmployee(Empleado employee) {
        return employeeRepo.save(employee);
    }

    public Empleado findEmployeeById(Long id) {
        return employeeRepo.findEmpleadoById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmpleadoById(id);
    }
}