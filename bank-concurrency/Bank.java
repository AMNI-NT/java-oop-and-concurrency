/**
 * This class represents a bank
 * @author Amit
 */
public class Bank {
    
    public static void main(String[] args){
        
        // initialize bankers
        BankAccount b1 = new BankAccount(0, 0);
        BankAccount b2 = new BankAccount(1, 0);
        BankAccount b3 = new BankAccount(2, 0);
        BankAccount b4 = new BankAccount(3, 0);
        BankAccount b5 = new BankAccount(4, 0);
        
        // contains an array of transactions which represents in first cell the 
        // id of the banker and on the second one the amount to be added
        int[][] l = {
            {1,-5},
            {1,10},
            {1,-100},
            {2, -658},
            {0, 831},
            {1, 137},
            {4, 992},
            {3, -422},
            {0, 547},
            {4, 734},
            {1, -110},
            {2, 912},
            {3, -674},
            {1, 543},
            {0, -981},
            {3, 356},
            {4, -324},
            {2, 486},
            {0, -564},
            {3, 912},
            {4, -115},
            {1, -672},
            {2, -141},
            {0, 200},
            {1,300}
        };
        
                
        // initialize transaction list
        TransactionList list = new TransactionList(l);
        
        // create list of bank accounts
        BankAccount[] bAList = {b1, b2, b3, b4, b5};
        
               
        // initialize bank clerks
        BankClerk bankClerk1 = new BankClerk(list, bAList);
        BankClerk bankClerk2= new BankClerk(list, bAList);
        BankClerk bankClerk3= new BankClerk(list, bAList);
        BankClerk bankClerk4= new BankClerk(list, bAList);
        BankClerk bankClerk5= new BankClerk(list, bAList);
        BankClerk bankClerk6= new BankClerk(list, bAList);
        BankClerk bankClerk7= new BankClerk(list, bAList);
        BankClerk bankClerk8= new BankClerk(list, bAList);
        BankClerk bankClerk9= new BankClerk(list, bAList);
        BankClerk bankClerk10 = new BankClerk(list, bAList);
        
        // start performing transactions
        bankClerk1.start();
        bankClerk2.start();
        bankClerk3.start();
        bankClerk4.start();
        bankClerk5.start();
        bankClerk6.start();
        bankClerk7.start();
        bankClerk8.start();
        bankClerk9.start();
        bankClerk10.start();
    }

}
