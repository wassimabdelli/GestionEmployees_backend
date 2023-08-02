package com.example.Gestionemployee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gestionemployee.DTO.EmployeeDTO;
import com.example.Gestionemployee.DTO.EmployeeSaveDTO;
import com.example.Gestionemployee.DTO.EmployeeUpdateDTO;
import com.example.Gestionemployee.Entity.Employee;
import com.example.Gestionemployee.Service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(path = "/save")
	public String save(@RequestBody EmployeeSaveDTO employeeSaveDTO )
	{
		String id = employeeService.addEmployee(employeeSaveDTO);
		return id;
	}
	
	@GetMapping(path = "/getAllEmployees")
	public List<EmployeeDTO> getAllEmployee()
	{
		List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
		return allEmployees;
	}
	
	@PutMapping(path = "/UpdateEmployees")
	public String UpdateEmployee(@RequestBody EmployeeUpdateDTO employeeUpdateDTO )
	{
		String id = employeeService.updateEmployee(employeeUpdateDTO);
		return id;
	}

	
	@DeleteMapping(path = "/delete/{id}")
	public String DeleteEmployee(@PathVariable (value = "id") int id)
	{
		boolean deleteEmployee = employeeService.deleteEmployee(id);
		return "deleted";
	}
	
}
