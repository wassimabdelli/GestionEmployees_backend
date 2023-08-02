package com.example.Gestionemployee.Service;

import java.util.List;


import com.example.Gestionemployee.DTO.EmployeeDTO;
import com.example.Gestionemployee.DTO.EmployeeSaveDTO;
import com.example.Gestionemployee.DTO.EmployeeUpdateDTO;

public interface EmployeeService {

	String addEmployee(EmployeeSaveDTO employeeSaveDTO);

	List<EmployeeDTO> getAllEmployees();

	String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO );

	boolean deleteEmployee(int id);
	
	
	

}
