// Boss class derived from Employee.
//My Details
//ID:17473436
//Name:Ross Creaven


public final class Boss extends Employee {

    private double weeklySalary;

    // constructor for class Boss
    public Boss(String first, String last,String date, double salary) throws InvalidDateException {
        super(first, last, date); // call superclass constructor
        setWeeklySalary(salary);
    }

    // set Boss's salary
    public void setWeeklySalary(double salary) {
        weeklySalary = (salary > 0 ? salary : 0);
    }

    

    // get String representation of Boss's name
    public String toString() {
        return "Boss: " + super.toString();
    }
        
    // get Boss's pay
    @Override
    public double earnings() throws Minimum_Wage_Exception {
        //calculates the payable and checks it for minimum wage and bonus
        set_Payable(weeklySalary);
        //calls earnings in employee
        super.earnings();
        return get_Payable();
        
    }
} // end class Boss
