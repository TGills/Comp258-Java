package lab01.review;
/*
 * @author guillaume2127
 */
public class SavingsAccount extends BankAccount {    
    public static float getACTIVITY_PENALTY() {
        return ACTIVITY_PENALTY;
    }    
    public static int getACTIVITY_LIMIT() {
        return ACTIVITY_LIMIT;
    }
    
    private float minBalance;
    private int withdrawCount;
    
    private final static float ACTIVITY_PENALTY = 5f;
    private final static int ACTIVITY_LIMIT = 10;
    
    
    
    
    
    
    public SavingsAccount(int accountNumber, float balance, float minBalance, int withdrawCount){
        super(accountNumber, balance);
        setMinBalance(minBalance);
        setWithdrawCount(withdrawCount);
    }    
      
    
    public void withdraw(float amount) throws Exception{
        float fee = 0;
        if(getBalance() < minBalance && withdrawCount > ACTIVITY_LIMIT){
            fee += ACTIVITY_PENALTY;
        }
        if(amount > getBalance()){
            setBalance(getBalance() - (amount - fee));
        }   
        else{
            throw new Exception();
        }
        withdrawCount++;
    }    
    
    
    
    public float getMinBalance() {
        return minBalance;
    }    
    public void setMinBalance(float minBalance) {
        this.minBalance = minBalance;
    }
   
    public int getWithdrawCount() {
        return withdrawCount;
    }    
    public void setWithdrawCount(int withdrawCount) {
        this.withdrawCount = withdrawCount;
    }   
    
}