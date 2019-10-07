// Definition of class HourlyWorker
//My Details
//ID:17473436
//Name:Ross Creaven


public final class HourlyWorker extends Employee {

    private double wage; // wage per hour
    private double hours; // hours worked for week

    // constructor for class HourlyWorker
    public HourlyWorker(String first, String last,String date,double wagePerHour, double hoursWorked) throws InvalidDateException {
        super(first, last,date); // call superclass constructor
        setWage(wagePerHour);
        setHours(hoursWorked);
    }

    // Set the wage
    public void setWage(double wagePerHour) {
        wage = (wagePerHour > 0 ? wagePerHour : 0);
    }

    // Set the hours worked
    public void setHours(double hoursWorked) {
        hours = (hoursWorked >= 0 && hoursWorked < 168
                ? hoursWorked : 0);
    }

    
    

    public String toString() {
        return "Hourly worker: " + super.toString();
    }
    
 // Get the HourlyWorker's pay
    @Override
    public double earnings() throws Minimum_Wage_Exception {
    	//calculates the payable and checks it for minimum wage and bonus
        set_Payable(wage * hours);
        //calls earnings in employee
        super.earnings(); 
        return get_Payable();
    }
}
