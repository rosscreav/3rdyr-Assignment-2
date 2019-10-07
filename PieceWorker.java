// PieceWorker class derived from Employee
//My Details
//ID:17473436
//Name:Ross Creaven


public final class PieceWorker extends Employee {

    private double wagePerPiece; // wage per piece output
    private int quantity; // output for week

    // constructor for class PieceWorker
    public PieceWorker(String first, String last,String date,double wage, int numberOfItems) throws InvalidDateException {
        super(first, last, date); // call superclass constructor
        setWage(wage);
        setQuantity(numberOfItems);
    }

    // set PieceWorker's wage
    public void setWage(double wage) {
        wagePerPiece = (wage > 0 ? wage : 0);
    }

    // set number of items output
    public void setQuantity(int numberOfItems) {
        quantity = (numberOfItems > 0 ? numberOfItems : 0);
    }

    // determine PieceWorker's earnings
//    public double earnings() {
//        return quantity * wagePerPiece;
//    }

    public String toString() {
        return "Piece worker: " + super.toString();
    }
    
    @Override
    public double earnings() throws Minimum_Wage_Exception {
    	//calculates the payable and checks it for minimum wage and bonus
        set_Payable(quantity * wagePerPiece);
        //calls earnings in employee
        super.earnings();
        return get_Payable();
    }
}
