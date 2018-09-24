
public class Employee implements SalesDepartment, AdvertisementDepartment, Union, Salary {
	
//declaring variables
	private String name;
	private long id;
	private String dateOfBirth;
	private String department;
	private boolean unionMember, adMember, salesMember = false;
	private double salary;
	private double originalSalary;
	
//default constructor
	public Employee(){}
	
//constructor with parameters
	public Employee(String name, long id, String dateOfBirth){
		this.name = name;
		this.id = id;
		this.dateOfBirth = dateOfBirth;
	}
	
//constructor with parameters
	public Employee(String name, long id, String dateOfBirth,
					boolean member, String department, double salary){
		this.name = name;
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.unionMember = member;
		this.department = department;
		this.salary = salary;		
	}
	
//getter for name
	public String getName() {
		return name;
	}

//setter for name
	public void setName(String name) {
		this.name = name;
	}

//getter for id
	public long getId() {
		return id;
	}

//setter for id
	public void setId(long id) {
		this.id = id;
	}

//getter for date of birth
	public String getDateOfBirth() {
		return dateOfBirth;
	}

//setter for date of birth
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

//setter for union membership
	@Override
	public void setUnionMembership(boolean unionMember) {
	     this.unionMember = unionMember;
		}
	
//getter for union membership
	@Override
	public boolean getUnionMembership() {
		return unionMember;
	}
	
//setter for advertisement membership
	@Override
	public void setAdvertisementMembership(boolean adMember) {
		this.adMember = adMember;
		}

//getter for advertisement membership
	@Override
	public boolean getAdvertisementMembership() {
		return adMember;
	}
	
//setter for sales membership
	@Override
	public void setSalesMembership(boolean salesMember) {
		this.salesMember = salesMember;
		}
	
//getter for sales membership
	@Override
	public boolean getSalesMembership() {
		return salesMember;
	}
	
//setter for monthly pay
	public void setMonthlyPay(double amount){
		this.salary = amount;
		}
	
//setter for hourly wage	
	public void setHourlyWage(double wage, double hours){
		this.salary = wage*hours;
		}
	
//setter for commission pay
	public void setCommisionPay(double percent, double sales){
		this.salary = (percent/100.0)*sales;
		}
	
//pay fees method to pay union membership fees	
	public void payFees(){
		originalSalary = salary;
		salary = salary - ((0.1/100)*salary);
	}

//getter for salary
	public double getSalary(){
		return salary;
	}
	
//setter for department
	public void setDepartment(){
		if(getAdvertisementMembership() == true){
			this.department = "Advertisement";
			}
		else
			this.department = "Sales";
	}
	
//getter for department
	public String getDepartment(){
		return department;
	}
	
//toStrig method
	public String toString(){
		if(unionMember== false){
		return "\nName: "+getName()+
				"\nId: "+getId()+
				"\nDate of Birth: "+getDateOfBirth()+
				"\nMember of Union: "+getUnionMembership()+
				"\nDepartment: "+getDepartment()+
				"\nSalary: $"+getSalary();}
		else return 
		"\nName: "+getName()+
		"\nId: "+getId()+
		"\nDate of Birth: "+getDateOfBirth()+
		"\nMember of Union: "+getUnionMembership()+
		"\nDepartment: "+getDepartment()+
		"\nSalary before deductiong Union membership fees: $"+originalSalary+
		"\nSalary: $"+getSalary();}


	}
				
	
	

