import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* READ THE PDF INSTRUCTION BEFORE GETTING STARTED!
 * 
 * Resources:
 * 	- Tutorial Series on Java Collections (ArrayList and HashMap):
 * 		https://www.eecs.yorku.ca/~jackie/teaching/tutorials/index.html#java_collections
 *	- Recording of lecture on implementing compareTo and using Arrays.sort(...):
 *		https://youtu.be/mDpDRLEy-7Y
 */

public class Database {
	/*
	 * Each entry in a 'departments' map contains
	 * a unique department id and its associated information object.
	 */
	HashMap<Integer, DepartmentInfo> departments;

	/*
	 * Each entry in a 'employees' map contains
	 * a unique employee id and its associated information object.
	 */
	HashMap<String, EmployeeInfo> employees;

	/**
	 * Initialize an empty database.
	 */
	public Database() {
		/* Your Task */
		departments = new HashMap<Integer, DepartmentInfo>();
		employees = new HashMap<String, EmployeeInfo>();
	}

	/**
	 * Add a new employee entry.
	 * @param id id of the new employee
	 * @param info information object of the new employee
	 * @throws IdAlreadyExistsExceptoin if 'id' is an existing employee id
	 */
	public void addEmployee(String id, EmployeeInfo info) throws IdAlreadyExistsExceptoin {
		/* Your Task */
		
		if(!employees.containsKey(id)){
			employees.put(id, info);
		}else{
			throw new IdAlreadyExistsExceptoin("");
		}
		
	}

	/**
	 * Remove an existing employee entry.
	 * @param id id of some employee
	 * @throws IdNotFoundException if 'id' is not an existing employee id
	 * @throws IdAlreadyExistsExceptoin 
	 */
	public void removeEmployee(String id) throws IdNotFoundException {
		/* Your Task */
		if(employees.containsKey(id)){
			employees.remove(id);
		}else{
			throw new IdNotFoundException("cannot remove");
		}
	}

	/**
	 * Add a new department entry.
	 * @param id id of the new department
	 * @param info information object of the new department
	 * @throws IdAlreadyExistsExceptoin if 'id' is an existing department id
	 */
	public void addDepartment(Integer id, DepartmentInfo info) throws IdAlreadyExistsExceptoin {
		/* Your Task */
		if(!departments.containsKey(id)){
			departments.put(id, info);
		}else{
			throw new IdAlreadyExistsExceptoin("");
		}
	}

	/**
	 * Remove an existing department entry.
	 * @param id id of some employee
	 * @throws IdNotFoundException if 'id' is not an existing employee id
	 */
	public void removeDepartment(Integer id) throws IdNotFoundException {
		/* Your Task */
		if(departments.containsKey(id)){
			departments.remove(id);
		}else{
			throw new IdNotFoundException("cannot remove");
		}
	}

	/**
	 * Change the department of employee with id 'eid' to a new department with id 'did'.
	 * 
	 * You can assume that 'did' denotes a department different from
	 * the current department of the employee denoted by 'eid'.
	 * @param eid id of some employee
	 * @param did id of some department
	 * @throws IdNotFoundException if either eid is a non-existing employee id or did is a non-existing department id.
	 */
	public void changeDepartment(String eid, Integer did) throws IdNotFoundException {
		/* Your Task */
		if(employees.containsKey(eid) && departments.containsKey(did)){
			employees.get(eid).setDepartmentId(did);
		}else{
			throw new IdNotFoundException("");
		}
		
	}

	/**
	 * Retrieve the name of employee with id 'id'.
	 * @param id id of some employee
	 * @return name of the employee with id 'id'
	 * @throws IdNotFoundException if 'id' is not an existing employee id
	 */
	public String getEmployeeName(String id) throws IdNotFoundException {
		/* Your Task */
		String name = "";
		if(employees.containsKey(id)){
			name = employees.get(id).getName();
		}else{
			throw new IdNotFoundException("");
		}
		return name;
	}

	/**
	 * Retrieve the names of all employees of the department with id 'id'.
	 * If 'id' a non-existing department id, then return an empty list.
	 * @param id id of some department
	 * @return List of names of employees whose home department has id 'id'
	 */
	public ArrayList<String> getEmployeeNames(Integer id) {
		/* Your Task */
		ArrayList<String> names = new ArrayList<String>();
		
		
		if(departments.containsKey(id)){ //if department id exists in hashmap
			   // go through every key equal to id
			for(String i: employees.keySet()){
				// if i equals id add the associated employees name to the array
				if(employees.get(i).getDepartmentId()==id){
					names.add(employees.get(i).getName());
				}
			}
			
		}else{
			return names;
		}
		
		return names;
	}

	/**
	 * Retrieve an employee's department's information object.  
	 * @param id id of some existing employee
	 * @return The information object of the employee's home department
	 * @throws IdNotFoundException if 'id' is not an existing employee id
	 */
	public DepartmentInfo getDepartmentInfo(String id) throws IdNotFoundException {
		/* Your Task */
		
		DepartmentInfo info = new DepartmentInfo("","");
		
		if(employees.containsKey(id)){ //if employee id exists
			// get his departmentid
			int departmentID = employees.get(id).getDepartmentId();
			info.setLocation(departments.get(departmentID).getLocation());
			info.setName(departments.get(departmentID).getName());//set his department id into info object
		}else{
			throw new IdNotFoundException("");
		}
		return info;
	}

	/**
	 * Retrieve a list, sorted in increasing order, 
	 * the information objects of all stored employees.
	 * 
	 * Hints: 
	 * 1. Override the 'comareTo' method in EmployeeInfo class. 
	 * 2. Look up the Arrays.sort method in Java API. 
	 * @return A sorted list of information objects of all employees.
	 */
	public EmployeeInfo[] getSortedEmployeeInfo() {
		/* Your Task */
		return null;
	}

	/**
	 * Retrieve the average salary of all employees in department with id 'id'.
	 * @param id id of some department 
	 * @return average salary of all employees in department with id 'id'
	 * @throws IdNotFoundException if id is not an existing department id
	 */
	public double getAverageSalary(Integer id) throws IdNotFoundException {
		/* Your Task */
		
		double totalSalary = 0;
		int counter = 0;
		//check if department exists
		
		if(departments.containsKey(id)){
			//loop through all keys
		for(String s:employees.keySet()){
			//if s equals 
			if(employees.get(s).getDepartmentId() == id){
			
			totalSalary = totalSalary + employees.get(s).getSalary();
			counter++;
			}
		}
		}else{
			throw new IdNotFoundException("");
		}
		
		double avgSalary = totalSalary /counter;
		
		return avgSalary;
	}
	
	/**
	 * Retrieve the information object of the department with the highest average salary among its employees.
	 * @return the information object of the department with the highest average salary among its employees
	 * 
	 * Hint: Use 'getAverageSalary(Integer id)' as a helper method.
	 */
	public DepartmentInfo getDepartmentOfHighestAverageSalary() {	
		/* Your Task */
		for(int s: departments.keySet()){
			double highestAvgSalary = 0;
			
			try{
				
			}catch(IdNotFoundException(e)){
				
			}finally{
				if(highestAvgSalary > getAverageSalary(s)){
					
				}
				
			}
			
			
		}
	}
}
