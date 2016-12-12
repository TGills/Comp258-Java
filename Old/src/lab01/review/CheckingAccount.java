package lab01.review;

/*
 * @author guillaume2127
 */
public class CheckingAccount extends BankAccount {
    
    private float overDraftPenalty;
    private float overDraftLimit;

    public CheckingAccount(){}
    
    public CheckingAccount(int accountNumber, float balance,float overDraftPenalty, float overDraftLimity){
        super(accountNumber, balance);
        setOverDraftPenalty(overDraftPenalty);
        setOverDraftLimit(overDraftLimit);
    }
    
    public void withdraw(float amount) throws Exception{
        float fee = 0;
        if(amount > getBalance()){
            setBalance(getBalance() - amount);
        }
        else if(overDraftLimit + getBalance() < amount){
            setBalance(getBalance() - (amount + overDraftPenalty));
        }         
        else{
            throw new Exception();
        }
    }    
    public float getOverDraftPenalty() {
        return overDraftPenalty;
    }
    public void setOverDraftPenalty(float overDraftPenalty) {
        this.overDraftPenalty = overDraftPenalty;
    }    
    public float getOverDraftLimit() {
        return overDraftLimit;
    }
    public void setOverDraftLimit(float overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }
    
    
    
    
    
    
    
    
}