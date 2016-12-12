package lab01.review;
/*
 * @author guillaume2127
 */
public class FunWithRecursion {    
    //Adds all numbers from 1 to num
    public static int AddEmUp(int num){        
        if(num == 1){
        return num;
        }
        else{
            return num + AddEmUp(num-1);
        }
    }
    public void recPrint(NodeLearning n){
        if(n.next == null){
            System.out.println(n.getData());
        }
        else{
            recPrint(n.next);
            System.out.println(n.getData());
        }
    }
    public static void indentOTron(int levels, int  n){
        for(int i = 1; i < n ; i++){
            System.out.println("  ");
        }
            if(levels == 1){
                System.out.println(n);
                
                for(int i = 1; i < n; i++){
                    System.out.println("  ");
                    System.out.println(n);
                }
            }
            else{
                System.out.println(n);
                indentOTron(levels - 1, n + 1);
                System.out.println(n);
                for(int i = 1; i < n; i++){
                    System.out.println("  ");
                    System.out.println(n);
                }
            }        
    }
        
    public static void main(String args[]){
        NodeLearning a = new NodeLearning(7);
        NodeLearning b = new NodeLearning(6);
        NodeLearning c = new NodeLearning(5);
        NodeLearning d = new NodeLearning(4);
        NodeLearning e = new NodeLearning(3);  
        a = b.next;
        b = c.next;
        c = d.next;
        d = e.next;       
        
        System.out.println(AddEmUp(70));
        indentOTron(3,3); 
        
    }   
    
    
}