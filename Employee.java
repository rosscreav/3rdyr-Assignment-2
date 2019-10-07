
//My Imports
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.Years;
import org.joda.time.Months;
import org.joda.time.LocalTime;


// Abstract base class Employee.
//My Details
//ID:17473436
//Name:Ross Creaven


public abstract class Employee {
	//Variables associated with Employees
    private String firstName;
    private String lastName;
    private LocalDateTime Join_Date;
    //Keeps track of the amount of employees joined
    private static int Employee_Count=0; 
    //Holds the employees ID
    private final int Employee_ID=Employee_Count+1;
    //Holds the amount to be paid to the employee
    private double Payable;

    
    // constructor
    public Employee(String first, String last, String date) throws InvalidDateException {
        firstName = first;
        lastName = last;
        Join_Date= date_check(date);
        Employee_Count++;
    }

    // get first name
    public String getFirstName() {
        return firstName;
    }

    // get last name
    public String getLastName() {
        return lastName;
    }
    //get join date
    public LocalDateTime get_Join_Date() {
    	return Join_Date;
    }
    //get persons id
    public int get_id() {
    	return Employee_ID;
    }
    //get their amount payable
    public double get_Payable() {
    	return Payable;
    }
    //Converts object to a string in format "Firstname Lastname"
    public String toString() {
        return firstName + ' ' + lastName;
    }
    //Sets Payable amount
    public void set_Payable(double i){
    	Payable=i;
    }

    //Method to check if Payable is above 400 (40hours at 10 an hour) and throws exception if it is below it also calls the bonus check
    public double earnings() throws Minimum_Wage_Exception{
    	if(get_Payable()<400) {
    		String message=String.format("Employee %s %s is being paid below minimum wage. Pay=%g while minmum is Pay=400",getFirstName(),getLastName(),get_Payable());
    		throw new Minimum_Wage_Exception(message);
    	}
    	bonus_check();
    	return Payable;
    }
    
    
   
    //Method to check if worker has been here over 5 years and can apply the bonus
    public void bonus_check() {
    	LocalDateTime date=new LocalDateTime();
    	Years Diff=Years.yearsBetween(Join_Date,date);
    	int Int_Diff=Diff.getYears();
    	if (Int_Diff>4){
    		Payable=Payable+50.00;
    	}
    	}
    
    //Class used to validate a date and return it if valid
    public LocalDateTime date_check(String datestring) throws InvalidDateException{
    	//String created for exceptions
    	String errorplaceholder = String.format("%s join date %s is Invalid \n Reason:", toString(),datestring);
    	//incase the date cannot be parsed
    	LocalDateTime date = null;
    	boolean invalid=false;
    	//Trys to parse the date string to a LocalDateTime variable
    	try {
    		date=LocalDateTime.parse(datestring);
    	}
    	catch(Exception e){
    		//Adds the joda exception to my exception string and raises invalid flag
    		errorplaceholder+= e.toString();
    		invalid = true;
    	}
    	//If the date is parsed it is valid and will be tested
    	if(invalid==false) {
    		//Todays date
	    	LocalDateTime currdate=new LocalDateTime();
	    	//Date holder for the too old date
	    	LocalDateTime olddate=LocalDateTime.parse("1990-01-01T10:00:00");
	    	//Takes the hour out for the testing
	    	int join_time=date.getHourOfDay();
	    	//If it fails any test it will throw a custom exception with the reason
	    	if (date.isAfter(currdate)) {
	    		errorplaceholder+= "Date is in the future";
	    		throw new InvalidDateException(errorplaceholder);
	    	}
	    	else if(date.isBefore(olddate)) {
	    		errorplaceholder+= "Date is before 1990";
	    		throw new InvalidDateException(errorplaceholder);
	    	}
	    	else if(date.getMonthOfYear()>12 || date.getMonthOfYear()<0) {
	    		errorplaceholder+= "Months are not between 12 and 0";
	    		throw new InvalidDateException(errorplaceholder);
	    	}
	    	else if(join_time>=18 || join_time<9) {
	    		errorplaceholder+= "Time of day is outside working hours";
	    		throw new InvalidDateException(errorplaceholder);
	    	}
	    	else if(date.getDayOfWeek()>5) {
	    		errorplaceholder+= "Day is not a working day";
	    		throw new InvalidDateException(errorplaceholder);                        
	    	}
	    	
    	}
    	//Throws exception when triggered by a joda exception
    	else {
    		throw new InvalidDateException(errorplaceholder);  
    	}
    	//returns valid dates after being tested
    	return date;
    }
   
}
