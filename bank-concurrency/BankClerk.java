


/**
 * This class represents a bank clerk which handles transaction of bank accounts.
 * @author Amit
 */
public class BankClerk extends Thread {
    
    // points to list of transactions
    private TransactionList transactionList;
        
    // stores bank accounts in order of their ids
    private final BankAccount[] accountList;
    
    /** 
     * Initializes transaction list and account list.
     * @param transactionList
     * @param accountList 
     */
    public BankClerk(TransactionList transactionList, BankAccount[] accountList){
        this.transactionList = transactionList;
        this.accountList = accountList;
    }
    
    /** 
     * Perform transactions in the transaction list
     */
    @Override
    public void run(){
        super.run();
        
        // contains false if there are still transactions to proccess
        boolean stop = false;
        
        // as long as there are transactions perform the next one
        while(!stop){
            
            
            
            // get next transaction
            int[] transaction = transactionList.getTransaction();
        
            // if there was a next transaction, then perform it
            if(transaction != null){
                accountList[transaction[0]].makeTransaction(transaction[1]);
            }
            // if there wasn't a next transaction stop loop
            else stop = true;                
        }         
    }     
}
