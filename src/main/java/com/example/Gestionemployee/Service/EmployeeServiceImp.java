package com.example.Gestionemployee.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestionemployee.DTO.EmployeeDTO;
import com.example.Gestionemployee.DTO.EmployeeSaveDTO;
import com.example.Gestionemployee.DTO.EmployeeUpdateDTO;
import com.example.Gestionemployee.Entity.Employee;
import com.example.Gestionemployee.Repository.EmployeeRepo;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	
	@Override
	public String addEmployee(EmployeeSaveDTO employeeSaveDTO) {
		
		Employee employee = new Employee(
			
				employeeSaveDTO.getEmployeename(),
				employeeSaveDTO.getEmployeeaddress(),
				employeeSaveDTO.getMobile()
				);
		
		employeeRepo.save(employee);
		
		return employee.getEmployeename();
		
	}


	@Override
	public List<EmployeeDTO> getAllEmployees() {
		 
		List<Employee> getEmployees = employeeRepo.findAll();
		
		List<EmployeeDTO> employeeDTOList = new ArrayList<>();
		
		for(Employee e: getEmployees )
		{
			EmployeeDTO employeeDTO = new EmployeeDTO(
					e.getEmployeeid(),
					e.getEmployeename(),
					e.getEmployeeaddress(),
					e.getMobile()
					);
			employeeDTOList.add(employeeDTO);
		}
		return employeeDTOList;
	}


	@Override 
	public String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO) {
		
		if(employeeRepo.existsById(employeeUpdateDTO.getEmployeeid()))
		{
			Employee employee = employeeRepo.getById(employeeUpdateDTO.getEmployeeid());
			employee.setEmployeename(employeeUpdateDTO.getEmployeename());
			employee.setEmployeeaddress(employeeUpdateDTO.getEmployeeaddress());
			employee.setMobile(employeeUpdateDTO.getMobile());
			employeeRepo.save(employee);
			
		}else {
			System.out.println("Employee ID not found");
		}
			
		return null;
	}


	@Override
	public boolean deleteEmployee(int id) {
		if(employeeRepo.existsById(id))
		{
			employeeRepo.deleteById(id);
		}else {
			System.out.println("Employee ID not found");
		}
		return true;
	}




}
