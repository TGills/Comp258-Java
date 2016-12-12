package lab01.review;
import java.util.Scanner;
/*
 * @author guillaume2127
 */
public class JavaBank {
    public Scanner input;
    private ArrayManager accounts;
    ArrayManager customer;
    public void initData(){
        
        customer = new ArrayManager(3);
        customer.add(new Customer("Bob", "Smith", 'J', 123));
        customer.add(new Customer("Sue", "Shard", 'S', 234));
        customer.add(new Customer("Pat", "Jones", 'R', 345));
        
  
        try{
        accounts = new ArrayManager(4);
        
        accounts.add(new SavingsAccount(111,345.45f,10f,0));
        
        Object[] accountHolders = 
            {customer.getElementAt(0), customer.getElementAt(2)};
        ((BankAccount)accounts.getElementAt(0)).setCustomer(new ArrayManager(accountHolders));
      
        accounts.add( new SavingsAccount(222,325.55f,10f,0));
        accountHolders = new Customer[1];
        accountHolders[0] = (customer.getElementAt(1));
        ((BankAccount)accounts.getElementAt(1)).setCustomer(new ArrayManager(accountHolders));
        
        accounts.add( new CheckingAccount(333,700.55f,2.25f,250f));
        accountHolders = new Customer[2];
        accountHolders[0] = customer.getElementAt(0);
        accountHolders[1] = customer.getElementAt(2);
         ((BankAccount)accounts.getElementAt(2)).setCustomer(new ArrayManager(accountHolders));
       
        
        accounts.add(new CheckingAccount(444,700.55f,2.25f,1000f));
        accountHolders = new Customer[1];
        accountHolders[0] = customer.getElementAt(1);
        ((BankAccount)accounts.getElementAt(3)).setCustomer(new ArrayManager(accountHolders));
       
        
         } catch (EmptyArrayManagerException eame) {
            System.out.println(eame.getMessage());
        } catch (OutOfBoundsException oobe) {
            System.out.println(oobe.getMessage());
        }
        
    }
    
    /*
    
    public void initData(){
        customer = new ArrayManager(3);
        customer.add(new Customer("Bob", "Smith", 'J', 123));
        customer.add( new Customer("Sue", "Shard", 'S', 234));
        customer.add(new Customer("Pat", "Jones", 'R', 345));
        try{
            accounts = new ArrayManager(4);
            
            Object[] accountHolders = {customer.getElementAt(0), customer.getElementAt(2)};
            ((BankAccount)accounts.getElementAt(0)).setCustomer((Customer[]) accountHolders);
            
        
            accounts.add(new SavingsAccount(111,345.45f,10f,0));            
            accountHolders = (Object[]) (customer.getElementAt(1));
            ((BankAccount)accounts.getElementAt(1)).setCustomer((Customer[]) accountHolders);
            
      
            accounts.add(new SavingsAccount(222,325.55f,10f,0));          
            accountHolders = (Object[])(customer.getElementAt(2));
            ((BankAccount)accounts.getElementAt(2)).setCustomer((Customer[]) accountHolders);
            
        
            accounts.add(new CheckingAccount(333,700.55f,2.25f,250f));
            accountHolders = (Object[])(customer.getElementAt(0))(customer.getElementAt(2));
                     
            accountHolders[0] = customer[0];
            accountHolders[1] = customer[2];           
            ((BankAccount)accounts.getElementAt(3)).setCustomer((Customer[]) accountHolders);
        
            
            accounts.add(new CheckingAccount(444,700.55f,2.25f,1000f));
            accountHolders = new Customer[1];
            accountHolders = (Object[])(customer.getElementAt(1));
            ((BankAccount)accounts.getElementAt(4)).setCustomer((Customer[]) accountHolders);
        }
        catch(EmptyArrayManagerException eame){
           System.out.println(eame.getMessage()); 
        }
        catch(OutOfBoundsException oobe){
            System.out.println(oobe.getMessage());
        }
        
    }
    */
    
    public static void main(String args[]) throws Exception{
        JavaBank jb = new JavaBank();
        jb.initData();
        jb.run();     
    }    
    public int showActionMenu(){
        int option = 0;
        System.out.println("1.....Deposit");
        System.out.println("2.....Withdraw");
        System.out.println("3.....Transfer");
        System.out.println("-->");
        option = input.nextInt();
        
        return option;
    }
    public BankAccount getBankAccountByAccountNumber(int accountNumber){
        
        BankAccount ba = null;
        try{
            for(int i = 0; i < accounts.size();i++){
                if(((BankAccount)accounts.getElementAt(i)).getAccountNumber()==accountNumber){
                    ba = ((BankAccount)accounts.getElementAt(i)); 
                }       
            }
        }
        catch(Exception e){
                e.printStackTrace();
                }
        return ba;   
    }
    public void displayAccountsByCustomerID(int customerId){
        try{
            for(int i = 0; i < accounts.size();i++){
                ArrayManager c = ((BankAccount)accounts.getElementAt(i)).getCustomer();
                for(int j=0; j<c.size(); j++){
                    if(((Customer)c.getElementAt(j)).getCustomerID()==customerId){
                        System.out.println(((BankAccount)accounts.getElementAt(i)).getAccountNumber());
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public Customer getCustomerByID(int id){
        Customer c = null;
        try{
            for(int i = 0; i < accounts.size();i++){
                if(((BankAccount)accounts.getElementAt(i)).getAccountNumber()==id){
                    c = ((Customer)accounts.getElementAt(i)); 
                }       
            }
        }
        catch(Exception e){
                e.printStackTrace();
                }
        return c;
    }

    public void executeAction(int action, BankAccount ba) throws Exception{
        if(action == 1){
            System.out.println("Starting balance: " + ba.getBalance());
            System.out.print("Deposit Amount: ");
            float amount = input.nextFloat();
            ba.deposit(amount);
        }
        else if(action == 2){
            System.out.println("Starting balance: " +  ba.getBalance());
            System.out.print("Withdraw Amount: ");
            float amount = input.nextFloat();
            ba.withdraw(amount);            
        }
        else if(action == 3){
            System.out.println("Starting balance: " + ba.getBalance());
            System.out.print("Which account would you like to transfer to: ");
            int bankAccount = input.nextInt();
            System.out.print("Amount to transfer: ");
            float tamount = input.nextFloat();
            //Some sort of error
            //ba.transfer(bankAccount, tamount);
            
        }
        else if(action == 4){
            System.out.println("Last Name: ");
            String lastName = input.next();
            System.out.println("First Name: ");
            String firstName = input.next();
            System.out.println("Middle Initial: ");
            char mid = input.next().charAt(0);
            System.out.print("Customer ID: ");
            int id = input.nextInt();
            
            Customer c = new Customer(lastName, firstName, mid, id);
            customer.add(c);
        }
        else if(action == 5){
            System.out.print("Account Number: ");
            int accountNum = input.nextInt();
            BankAccount account = getBankAccountByAccountNumber(accountNum);
            if(account != null){
                System.out.print("Customer ID: ");
                int id = input.nextInt();
                Customer cust = getCustomerByID(id);
                if(cust!=null){
                    account.getCustomer().add(cust);
                }
                else{
                    System.out.println("Customer not found");
                }
            }
            else{
                System.out.println("Account not found");
            }
        }
    }
    public void run() throws Exception{
        System.out.print("Enter customer id: ");        
        int custId = input.nextInt();        
        displayAccountsByCustomerID(custId);
        System.out.print("Select Account: ");
        int accountId = input.nextInt();
        BankAccount ba = getBankAccountByAccountNumber(accountId);
        int option = showActionMenu();
        executeAction(option, ba);
    }  
    public JavaBank(){
        input = new Scanner(System.in);
    }
}