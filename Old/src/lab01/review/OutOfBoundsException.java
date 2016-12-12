package lab01.review;
/*
 * @author guillaume2127
 */
public class OutOfBoundsException extends Exception{
    
    public OutOfBoundsException(){
        System.out.println("Out of bounds exception created");
    }
    public String getMessage(){        
        return("An index was referenced outside the bounds of the array");
    }   
}