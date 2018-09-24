//contains the main method
//importing classes
import java.time.Year;
import java.util.*;
public class Driver {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

//declaring variables
		String firstName,lastName,name, dateOfBirth,department, payment;
		long id;
		int year,day,month;
		boolean unionMembership = false;
		int i =-1;
		double monthlySalary, sales, percentage,wage,hours;
		String answer = "yes";

//creating array list of employee
		ArrayList <Employee> employeeList = new ArrayList<Employee>();

//printing initial message
		System.out.println("************-----XYZ COMPANY-----************");

		while (answer.equals("yes")){

			i++;

//prompting the user to enter the details of the employee
		System.out.println("\nEnter the following details: "+
							"\n\nEMPLOYEE DETAILS ("+i+")");

	//first name
		System.out.print("\nFirst Name: ");
		firstName = in.next();

	//last name
		System.out.print("Last Name: ");
		lastName = in.next();

		name = firstName+" "+lastName;

	//id
		System.out.print("ID: ");
		id = in.nextLong();

	//date of birth
		System.out.println("Date of Birth");
		while(true){
		System.out.print("Year: ");
		year = in.nextInt();
		if(year < Year.now().getValue())
			break;
		else System.out.println("\nEnter a value less than "+Year.now().getValue());
		}

		while(true){
		System.out.print("Month: ");
		month = in.nextInt();
		if(month<=12 && month>0)
			break;
		else System.out.println("\nEnter a value between 1 and 12.");}

		while(true){
		System.out.print("Day: ");
		day = in.nextInt();
		if(day>0 && day<=31)
			break;
		else System.out.println("\nEnter a value between 1 and 31.");}

		dateOfBirth = year+" / "+month+" / "+day;

//creating employee object
		employeeList.add(new Employee (name, id, dateOfBirth));


//getting the details of the department the employee works for
		while(true){
		System.out.println("\nWhich department does the employee belong?"
				+ "\nsales or advertisement?");
		department = in.next();

		if(department.equals("sales")){
			employeeList.get(i).setSalesMembership(true);
			break;
		}
		else if (department.equals("advertisement")){
			employeeList.get(i).setAdvertisementMembership(true);
			break;
		}
		else
			System.out.println("invalid input!!");

	}
		employeeList.get(i).setDepartment();

//getting the details of the method of payment of salary to the employee
		while(true){
		System.out.println("\nHow is the employee payed?"+
				"\nmonthly, commision or hourly?");
		payment = in.next();

		if(payment.equals("monthly")){
			System.out.println("\nEnter the amount of monthly salary.");
			monthlySalary = in.nextDouble();
			employeeList.get(i).setMonthlyPay(monthlySalary);
			break;
		}

		else if(payment.equals("commision")){
			System.out.println("\nEnter the monthly sales in dollars");
			sales = in.nextDouble();
			System.out.println("Enter the commision rate in %.");
			percentage = in.nextDouble();
			employeeList.get(i).setCommisionPay(percentage, sales);
			break;
			}
		else if(payment.equals("hourly")){
			System.out.println("\nEnter the hourly wage.");
			wage = in.nextDouble();
			System.out.println("Enter the number of hours");
			hours = in.nextDouble();
			employeeList.get(i).setHourlyWage(wage, hours);
			break;
		}
		else
			System.out.println("Invalid input!!");
		}
//asking if the employee is a union member
		System.out.println("\nIs the employee a member of the union. true or false?");
		unionMembership = in.nextBoolean();

		while(unionMembership!= true && unionMembership!=false){
			System.out.println("Invalid input! Please try again!");
			System.out.println("\nIs the employee a member of the union. true or false?");
			unionMembership = in.nextBoolean();
					}

		if(unionMembership == true){
		employeeList.get(i).setUnionMembership(unionMembership);
		employeeList.get(i).payFees();

		}
		System.out.println("\nDo you want to create another Employee. yes/no?");
		answer = in.next();
		}



//printing the details of the employee
		for(int j = 0; j<employeeList.size(); j++){
System.out.println("\n***********  SUMMARY ***********"+
					"\nEMPLOYEE ("+j+")"+"\n"+
					employeeList.get(j).toString());}

//end message
System.out.println("************ END ***************");
}
}

