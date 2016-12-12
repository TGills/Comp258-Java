package lab01.review;

import java.util.Arrays;
import java.util.Random;

/*
 * @author guillaume2127
 */
public class ArrayManager {   
    private Object[] data;
    private int count;    
    public ArrayManager(){
        data = new Object[10];//some arbitrary start size
        count = 0;
    }    
    public ArrayManager(int initSize){
        data = new Object[initSize];
        count = 0;
    }
    public ArrayManager(Object[] data){
        this.data = data;
        count = data.length;
    }    
    public void printArray(){
        for(int i = 0; i < count; i++){
            System.out.println(data[i]);
        }
    }
    public void delete(int pos)throws OutOfBoundsException{
        if(count == 0){
            throw new EmptyArrayManagerException("delete");
        }
        for(int i = pos; i < count - 1; i++){
            data[i] = data[i + 1];           
        }    
        count--;        
    }
    public void add(Object o){        
        if(count >= data.length){
            Object[] temp = new Object[data.length + 10];
            System.arraycopy(data, 0, temp, 0, data.length);
            data = temp;
        }
        data[count] = o;
        count++;        
    }
    public void addAt(Object o, int pos) throws OutOfBoundsException{        
        if(pos > count || pos < 0){
            throw new OutOfBoundsException();
        }
       if(count >= data.length){
            Object[] temp = new Object[data.length + 10];
            System.arraycopy(data, 0, temp, 0, data.length);
            data = temp;                              
        }  
       for(int i = count; i > pos; i--){
                data[i] = data[i - 1];                
            }
        data[pos] = o;
        count++;
    }
    public int size(){
        return count;
    }
    public boolean isEmpty(){
        return 0==count;
    }
    public Object getElementAt(int pos) throws OutOfBoundsException{
        return data[pos];
    } 
    public void removeRange(int start, int end) throws OutOfBoundsException{       
        for(int i = start; i <= end; i++){
            delete(start);           
        }    
    }
    public int countOccurances(Object o){
        int total = 0;
        for(int i = 0; i <= size(); i++){
            if(data[i] == o){
                total++;
            }
        }  
        System.out.println("*****************");
        System.out.println("Total = " + total);
        return total;
    }
    public void findAndRemove(Comparable target) throws OutOfBoundsException{
        int counter = 0;
        for(int i = 0; i <= size(); i++){
            if(data[i] == target){                 
                delete(i);
                counter++;                 
            }         
        }
        System.out.println("Amount deleted: " + counter);            
    }
    public void _trim()throws OutOfBoundsException{
        if(data.length > count){
            System.out.println("In the loop");
            for(int i = 0; i <= size(); i++){
                if(data[i] == null){
                    delete(i);
                }
            }
        }     
        else{
            System.out.println("Not in the loop");
        }
    }
    public boolean compareData(ArrayManager a){        
        boolean answer = true;       
        Object[] testArray = a.data;
        Object testvar1 = 0;
        Object testvar2 = 0;       
        if(testArray.length == data.length){
            System.out.println("In the loop");          
            for(int i = 0; i <= data.length; i++){
                testvar1 = data[i]; 
                testvar2 = testArray[i];
                if(testvar1 != testvar2){
                    answer = false;
                    break;
                }
            }           
        }
        else{
            System.out.println("Not in the loop");
            answer = false;            
        }
        return answer;
    }
    //**************************************************************************
    public void sort(){
        trim();
        Arrays.sort(data);       
    }
    public void trim(){
        if(data.length >= count){
            Object[] temp = new Object[count];
            System.arraycopy(data, 0, temp, 0, temp.length);
            data=temp;
        }      
    }
    public int binarySearch(int start, int end, int target, int checks){
        checks++;
        int middle = (start + end)/2;
        if(data[middle].equals(target)){
            System.out.println("Took " + checks + " checks to find");
            return middle;
        }
        else if(start >= end){
            System.out.println("Took " + checks + " checks to find");
            return -1;
        }
        else if( ((Comparable)data[middle]).compareTo(target) >0){
            return binarySearch(start, middle, target, checks);            
        }
        else{
            return binarySearch(middle, end, target, checks);
        }               
    }
    public int linearSearch(int target){
        int checks = 0;
        int spot = -1;
        for(int i = 0; i < count; i++){
            if(data[i].equals(target)){
                spot = i;
                break;
            }
            else if(spot == -1){
                checks++;
            }
        }
        System.out.println("Took " + checks + " checks to find");
        return spot;
    }
    
    
    
    
    
    
    public static void main(String args[]){        
        //Integer[] testData2 = {1,2,3,4,5};
        Object[] testData = {1,2,3,5,4, 2, 2, 2, 2};
        
        
        
        
//        Object[] vTrue = {1,2,4,2,3,"Test123","Test321",4,2,5, null, null};
//        Object[] vFalse = {1,2,4,2,3};
        
        ArrayManager am = new ArrayManager(testData); 
        
        
        
        java.util.Random r = new Random();
        for(int i = 0; i < 100000; i++){
            am.add(r.nextInt(100000));
        }
//        ArrayManager vt = new ArrayManager(vTrue);
//        ArrayManager vf = new ArrayManager(vFalse);
       // try{           
            //am.printArray();           
            //System.out.println("ORIGINAL************");
            //am.removeRange(1, 4);
            //am.printArray();
            //System.out.println("DELETEMULTIPLE************");
            // am.addAt("AddAt test", 1);
            //am.addAt(2,1);            
            //am.printArray();
            //am.countOccurances(2);           
            //am.findAndRemove(2);            
            //am.printArray();
            //System.out.println("TRIM******************");
            //am.trim();
            //am.printArray();
            //System.out.println("COMPAREDATATrue******************");
//            if(am.compareData(vt) == true){
//                System.out.println("True");
//            }
//            else{
//                System.out.println("False");
//            }
              am.sort();
              //am.printArray();
              int spot = am.binarySearch(0, am.size(), 1234, 0);
              System.out.println("Binary Search");
              am.linearSearch(1234);
              System.out.println("Linear Search");
              
              
             
              System.out.println("Spot = " + spot);
            
            
        //}
        //catch(EmptyArrayManagerException eame){
        //   System.out.println(eame.getMessage()); 
        //}
        //catch(OutOfBoundsException oobe){
        //    System.out.println(oobe.getMessage());
        //}                
    }   
}