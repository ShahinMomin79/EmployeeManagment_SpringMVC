package com.jspiders.SpringMVC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.SpringMVC.POJO.EmployeePOJO;
import com.jspiders.SpringMVC.Services.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private  EmployeeService Service;
	
	@GetMapping("/home")
	public String home(){
		return "Home";
	}
	//add page controller
	@GetMapping("/add")
	public String addPage(){
		return "Add";
	}
	
	
	@PostMapping("/add")
	public String add(@RequestParam String name,
			           @RequestParam String email,
			            @RequestParam long contact,
			            @RequestParam String designation,
			            @RequestParam double salary,
			            ModelMap map){
		EmployeePOJO employeePOJO=Service.addEmployee(name, email, contact, designation, salary);
		if (employeePOJO!=null) {
			//sucesss response
			map.addAttribute("msg","Data added succesfully");
			return "Add";
			
		}//failure response
		map.addAttribute("msg", "data not added succesfully");
		return "Add";
	}
	
	@GetMapping("/search")
	public String searchPage() {
		return "Search";
	}
	@PostMapping("/search")
	public String search(@RequestParam int id, ModelMap map) {
		EmployeePOJO employeePOJO=Service.search(id);
		if (employeePOJO!=null) {
			//success response 
			map.addAttribute("msg", "Employes record found sucessfully");
			map.addAttribute("emp", employeePOJO);
			return "Search";
		}
		//failure response
		map.addAttribute("emp", "record not found");
		return  "Search";
	}
	
	//search remove page controller
	@GetMapping("/remove")
	public String RemovePage(ModelMap map) {
		List<EmployeePOJO> emplist=Service.searchAllEmployess();
		map.addAttribute("empList", emplist);
		return "Remove";
	}
	
	//search Data controller
	@PostMapping("/remove")
	public String Remove(@RequestParam int id ,ModelMap map) {
		
		EmployeePOJO employeePOJO=Service.search(id);
		if (employeePOJO!=null) {
			//success response
			Service.remove(id);
			List<EmployeePOJO> emplist=Service.searchAllEmployess();
			map.addAttribute("empList", emplist);
			map.addAttribute("msg", "record removed succesfully");
			
			return "Remove";
		}
		//failure response
		List<EmployeePOJO> emplist=Service.searchAllEmployess();
		map.addAttribute("empList", emplist);
		map.addAttribute("msg", "record does not exist.....!");
		return "Remove";
	}
	
	//update Page Controller
	@GetMapping("/update")
	public String Update(ModelMap map) {
		List<EmployeePOJO> emplist=Service.searchAllEmployess();
		map.addAttribute("empList", emplist);
		return "Update";
		
		
	}
	//update form controller
	@PostMapping("/update")
	public String UpdateForm(@RequestParam int id,ModelMap map ) {
		EmployeePOJO employeePOJO=Service.search(id);
		if (employeePOJO!=null) {
			//sucess response
			 map.addAttribute("emp", employeePOJO);
				return "Update";
		}
		//failure response
		map.addAttribute("msg" ,"record not found.....!");
		return "Update";
		   
	}
	//update data controller
	@PostMapping("updateData")
	public String UpdateData() {
		return null;
	}

}
