package lab01.review;
/*
 * @author guillaume2127
 */
public class EmptyArrayManagerException extends OutOfBoundsException{
    public String operation;
    
   
    
    
    public EmptyArrayManagerException(){
        System.out.println("Empty array exception created");
    }
    public EmptyArrayManagerException(String operation){
        this.operation = operation;
        System.out.println("Empty array exception created");
    }         
    
    public String getMessage(){
        return super.getMessage() + "Your array manager is empty. Can't " + operation;
        
    }
}
