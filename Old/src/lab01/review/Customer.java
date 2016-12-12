package lab01.review;
/*
 * @author guillaume2127
 */
public class Customer extends Person {
    public int compareTo(Object o){
        if(getCustomerID() < ((Customer)o).getCustomerID()){
            return -1;
        }
        else if(getCustomerID() > ((Customer)o).getCustomerID()){
            return 1;
        }
        else{
            return 0;
        }       
    }
    private int customerID;

   public Customer(){
       super();
   }
   
   public Customer(String firstName, String lastName, char middleInit, int customerID){
       super(firstName, lastName, middleInit);
       setCustomerID(customerID);
   }
   
   public int getCustomerID() {
        return customerID;
    }    
   public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }    
    
}