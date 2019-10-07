// CommissionWorker class derived from Employee
//My Details
//ID:17473436
//Name:Ross Creaven


public final class CommissionWorker extends Employee {

    private double salary; // base salary per week
    private double commission; // amount per item sold
    private int quantity; // total items sold for week

    // constructor for class CommissionWorker
    public CommissionWorker(String first, String last,String date,double salary, double commission, int quantity) throws InvalidDateException {
        super(first, last,date); // call superclass constructor
        setSalary(salary);
        setCommission(commission);
        setQuantity(quantity);
    }

    // set CommissionWorker's weekly base salary
    public void setSalary(double weeklySalary) {
        salary = (weeklySalary > 0 ? weeklySalary : 0);
    }

    // set CommissionWorker's commission
    public void setCommission(double itemCommission) {
        commission = (itemCommission > 0 ? itemCommission : 0);
    }

    // set CommissionWorker's quantity sold
    public void setQuantity(int totalSold) {
        quantity = (totalSold > 0 ? totalSold : 0);
    }


   

    // get String representation of CommissionWorker's name
    public String toString() {
        return "Commission worker: " + super.toString();
    }
    
    // determine CommissionWorker's earnings
    @Override
    public double earnings() throws Minimum_Wage_Exception {
    	//calculates the payable and checks it for minimum wage and bonus
        set_Payable(salary + commission * quantity);
        //calls earnings in employee
        super.earnings();
        return get_Payable();
    }
} // end class CommissionWorker
