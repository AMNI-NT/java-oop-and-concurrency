
/**
 * Represents a bank account, which is defined by it's id and balance 
 * @author Amit
 */
public class BankAccount {
 
    // accounts id
    private final int ID;
    
    // this account's balance
    private int balance;
    
    /** 
     * constructor for a bank account object
     * @param balance balance to be set
     * @param id new account's ID
     */
    public BankAccount(int id, int balance){
        this.ID = id;
        this.balance = balance;
    }
        
    /** 
     * makes a transaction of money from or to this account
     * @param amount amount of money to be added to this account (or subtracted if 
     * param is negative)
     */
    public synchronized void makeTransaction(int amount){
        
        notifyAll();
        
        System.out.println("\nBank account: " + ID + " has: " + balance + ", and"
                + " amount to be added is: " + amount + ".");
        
        while(this.balance + amount < 0){
            try{
                System.out.println(" Account " + ID + " is waiting for balance to be"
                        + " positive...");
                wait();
            }
            catch(InterruptedException e){
            }
        }
        
        
              
        this.balance += amount;
        
        System.out.println("\n -Balance of account: " + this.ID + " has been changed "
                + "to: " + this.balance);
    }
    
        
    /** 
     * @return this account's balance
     */
    public synchronized int getBalance(){return this.balance;}
}
