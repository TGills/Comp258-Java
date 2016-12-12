package lab01.review;
/*
 * @author guillaume2127
 */
public abstract class BankAccount {
    
    private int AccountNumber;
    private float Balance;
    private ArrayManager customer;
    
    public BankAccount(){       
        customer = new ArrayManager();   
    }
    
    public BankAccount(int AccountNumber, float Balance){
        setAccountNumber(AccountNumber);
        setBalance(Balance);
    }
    
    public BankAccount(int AccountNumber, float Balance, ArrayManager customer){
        setAccountNumber(AccountNumber);
        setBalance(Balance);
        setCustomer(customer);
    }
    
    public void deposit(float amount){        
        if(amount > 0){
            Balance += amount;
            System.out.println("New Balance" + Balance);
        }      
    }
    public abstract void withdraw(float amount) throws Exception;
    public void transfer(BankAccount account, float amount) throws Exception{
        float bal = account.getBalance();
        account.withdraw(amount);
        if(bal != account.getBalance()){
            deposit(amount);
            System.out.println("New Balance: " + account.getBalance());
        }
        else{
            throw new Exception();
        }
        
    }        
    
    public void setCustomer(ArrayManager customer){
        this.customer = customer;
    }
    public ArrayManager getCustomer(){
        return customer;
    }
            
            
            
            
    public int getAccountNumber() {
        return AccountNumber;
    }
    public void setAccountNumber(int AccountNumber) {
        this.AccountNumber = AccountNumber;
    }    
    public float getBalance() {
        return Balance;
    }    
    public void setBalance(float Balance) {
        this.Balance = Balance;
    }
       
    
    
}