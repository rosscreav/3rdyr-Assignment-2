// Driver for Employee hierarchy

// Java core packages
import java.text.DecimalFormat;
// Java extension packages
import javax.swing.JOptionPane;
//ArrayList
import java.util.ArrayList;
//My Details
//ID:17473436
//Name:Ross Creaven

public class Test {
	

    // test Employee hierarchy
    public static void main(String args[]) throws Minimum_Wage_Exception, InvalidDateException {
        Employee employee; // superclass reference
        String output = "";
        Employee[] Employee_Array=new Employee[4];
        
        //Used to place into an array if they are not created
        Boss boss=null;
        CommissionWorker commissionWorker=null;
        PieceWorker pieceWorker=null;
        HourlyWorker hourlyWorker=null;

        //Creating all Employees
        //Try and catch while creating in case it encounters an invalid date
        //variable counts current place in the array to place the employee in
        int correct=0;
        try {
        	boss = new Boss("John", "Smith","1981-12-12T19:25:00", 800);
        	Employee_Array[correct]= boss;
        	correct++;}
        catch(Exception e) {e.printStackTrace();}
        try {
        	commissionWorker = new CommissionWorker("Sue", "Jones","2019-02-29T11:03:40", 400.0, 3.0, 150);
        	Employee_Array[correct]= commissionWorker;
        	correct++;}
        catch(Exception e) {e.printStackTrace();}
        try {
        	pieceWorker = new PieceWorker("Bob", "Lewis","1999-02-26T16:11:00", 2.5, 300);
        	Employee_Array[correct]= pieceWorker;
        	correct++;}
        catch(Exception e) {e.printStackTrace();}
        try {
        	hourlyWorker = new HourlyWorker("Karen", "Price","2015-07-08T16:37:00", 9.70, 60);
        	Employee_Array[correct]= hourlyWorker;
        	correct++;}
        catch(Exception e) {e.printStackTrace();}

        DecimalFormat precision2 = new DecimalFormat("0.00");
    	
    	//Creating arraylist to hold below minmum wage workers
    	ArrayList<Employee> Exception_Encountered=new ArrayList<Employee>();
        //Array Loop to calculate earnings
        for(Employee i:Employee_Array) {
        	//Loops the whole array so a try catch to ignore null pointers since there is nulls on the end
        	try {
        		//Makes sure the date is there as an extra check
        		if(i.get_Join_Date()!=null) {
		        	try {
		        		//Try calculate wage and check for min wage
		        		i.earnings();}
		        	catch(Exception Minimum_Wage_Exception) {
		        		//if encounters min wage then throw exception and set pay to min and try apply bonus
		        		Exception_Encountered.add(i);
		        		Minimum_Wage_Exception.printStackTrace();
		        		i.set_Payable(400);
		        		i.bonus_check();
	        	}}
        	}
        	catch(Exception e) {};
        }

        // Employee reference to a Boss
        try {
        employee = boss;
        output += employee.toString() + " earned $"
                + precision2.format(employee.get_Payable()) + "\n"
                + boss.toString() + " earned $"
                + precision2.format(boss.get_Payable()) + "\n";}
        catch(Exception e) {};

        // Employee reference to a CommissionWorker
        try {
        employee = commissionWorker;
        output += employee.toString() + " earned $"
                + precision2.format(employee.get_Payable()) + "\n"
                + commissionWorker.toString() + " earned $"
                + precision2.format(
                commissionWorker.get_Payable()) + "\n";}
        catch(Exception e) {};
        

        // Employee reference to a PieceWorker
        try {
        employee = pieceWorker;
        output += employee.toString() + " earned $"
                + precision2.format(employee.get_Payable()) + "\n"
                + pieceWorker.toString() + " earned $"
                + precision2.format(pieceWorker.get_Payable()) + "\n";}
        catch(Exception e) {};

        // Employee reference to an HourlyWorker
        try {
	        employee = hourlyWorker;
	        output += employee.toString() + " earned $"
	                + precision2.format(employee.get_Payable()) + "\n"
	                + hourlyWorker.toString() + " earned $"
	                + precision2.format(hourlyWorker.get_Payable()) + "\n";}
        catch(Exception e) {};
        
        //Joption pane for demenstaring polymorphism
        JOptionPane.showMessageDialog(null, output,"Demonstrating Polymorphism",JOptionPane.INFORMATION_MESSAGE);
        
        //My JOptionPane Output for employee being underpaid
        output="";
        if (!Exception_Encountered.isEmpty())  {      
	        for(Employee i:Exception_Encountered) {
	        	if(i.equals(null)==false) {
	        		output+=i.toString()+" was earning below minimum wage they have had their Payable ajusted to "
	        			   +i.get_Payable()+"\n";
	        	}
	        }
        	JOptionPane.showMessageDialog(null, output,"Exceptions Encountered",JOptionPane.INFORMATION_MESSAGE);
        }

        System.exit(0);
    }
} // end class Test
