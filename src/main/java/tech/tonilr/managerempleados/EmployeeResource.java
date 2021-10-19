package tech.tonilr.managerempleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import tech.tonilr.managerempleados.entitys.Empleado;
import tech.tonilr.managerempleados.service.EmpleadoService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	
     private final EmpleadoService employeeService;

      @Autowired
    public EmployeeResource(EmpleadoService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Empleado>> getAllEmployees () {
        List<Empleado> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Empleado> getEmployeeById (@PathVariable("id") Long id) {
    	Empleado employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Empleado> addEmployee(@RequestBody Empleado employee) {
    	Empleado newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Empleado> updateEmployee(@RequestBody Empleado employee) {
    	Empleado updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}