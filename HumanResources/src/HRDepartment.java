import java.util.Date;
import java.util.*;

public class HRDepartment {
	
	public ArrayList<Employee> employeeList;

	public void addEmployee (int employeeID, String name, int role) {
		
		Employee employee = new Employee(employeeID, name, role);
		employeeList.add(employee);
	}
	
	public void printAllEmployees() {
		
		for (Employee e: employeeList)
		{
			System.out.println(e.toString());
		}
	}
	
	public Employee findEmployee(int employeeID) {
		
		for (Employee e: employeeList)
		{
			if (e.getEmployeeId() == employeeID)
			{
				return e;
			}
		}
		System.out.println("Employee not found. ");
		return null;
		
	}
	
	public boolean recordEmployeeAppraisal (int employeeID, Date appraisalDate, int score) {
		
		if (findEmployee(employeeID) == null)
		{
			System.out.println("Employee not found. ");
			return false;
		}
		else 
		{	
			EmployeeAppraisal empAppr = new EmployeeAppraisal(appraisalDate, score);
			findEmployee(employeeID).getAppraisalHistory().add(empAppr);

			return true;
			
		}
	
	}
	
	public boolean promoteEmployee (int employeeID) {
		
		if (findEmployee(employeeID) == null)
		{
			System.out.println("Employee not found. ");
			return false;
		}
		else 
		{
			int size = findEmployee(employeeID).getAppraisalHistory().size();
			int lastAppraisalScore = findEmployee(employeeID).getAppraisalHistory().get(size - 1).getAppraisalScore();
			int secondLastAppraisalScore = findEmployee(employeeID).getAppraisalHistory().get(size - 2).getAppraisalScore();
			if (lastAppraisalScore == HRCodes.EXCEEDED_EXPECTATIONS && secondLastAppraisalScore == HRCodes.EXCEEDED_EXPECTATIONS)
			{
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date());
				calendar.add(Calendar.YEAR,-1);
				Date dateOneYearAgo = calendar.getTime();
				
				if (dateOneYearAgo.after(findEmployee(employeeID).getPromotionDate()))
				{
					findEmployee(employeeID).setRole(findEmployee(employeeID).getRole() - 1);
					Calendar calendar2 = Calendar.getInstance();
					calendar2.setTime(new Date());
					Date promotionDate = calendar2.getTime();
					findEmployee(employeeID).setPromotionDate(promotionDate);
				}
			}
			
			return true;
		}
		
	}
	
}
