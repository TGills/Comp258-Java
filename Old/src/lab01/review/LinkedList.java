package lab01.review;
import static java.time.Clock.system;
/*
 * @author guillaume2127
 */
public class LinkedList {    
    Node items;
    Node current; 
    class Node{    
        private Object data;
        public Node next;    
        public Node(){}
        public Node(Object data){
            setData(data);
        }    
        public void setData(Object data){
            this.data = data;
        }    
        public Object getData(){
            return data;
        }   
    }
    public void add(Object o){
        if(items == null){
            items = new Node(o);
            current = items;
        }
        else{
            Node temp = new Node(o);
            current.next = temp;
            current = temp;
        }     
    }    
    public void printList(){
        Node temp = items;
        while(temp!=null){
            System.out.println(temp.getData());
            temp = temp.next;           
        }
    }        
    public void addBefore(Object o){
        if(items==null){
            add(o);
        }        
        //Temp = items
        Node temp = items;   
        //Advance Temp so temp.next = current
        while(temp.next!=current){
            temp = temp.next;
        }        
        //Point o.next to current
        Node newNode = new Node(o);
        //Point temp.next to newNode
        newNode.next = current; 
        //Point current to o
        temp.next = newNode;        
        current = newNode;    
    }
    public Object getElementAt(int i){

        Node temp = items;
        for(int count=0; count<i;count++){
            temp = temp.next;
        }
        
        return temp.getData();
    }    
    public void start(){
    current = items;
}
    public void advance() throws OutOfBoundsException{
        if(current.next==null){
            throw new OutOfBoundsException();
        }
        else{
            current=current.next;
        }
}
    public void removeCurrent(){
        if(current == items){        
            items=items.next;
            current=items;        
        }
    }
    public void addAfter(Object o){
    if(items==null){
        items = new Node(o);
        current = items;
    }
    else{
        Node temp = new Node(o);
        temp.next = current.next;
        current.next=temp;
        current = temp;
    }
}
    public void advanceToEnd(){}
    public Object findMax(){
        Object max;
        max = items.getData();
        Node temp = items;
        while(temp.next!=null){
            if(((Comparable)(temp.getData())).compareTo(max) > 0){
                max =  temp.getData();
            }
            temp=temp.next;
        }
        
        return max;
    }    
    public void removeRange(int Start, int End){          
        Node temp = items;        
        for(int i = 0; i < Start; i++){
            temp = temp.next;
            Node temp2 = items;
            for(int j = 0; j < End; j++){
                temp2 = temp2.next;                
            }
            temp.next = temp2;
        }  
    }   
    public void insertAt(int pos, Object o){        
        Node temp = items;
        for(int i = 1; i < pos; i++){
            temp = temp.next;            
        }
        Node toAdd = new Node(o);
        toAdd.next = temp.next;
        temp.next = toAdd;
        
    }
    public void findAndReplace(Comparable target, Comparable source){     
        
       
            
        
        
        
        
        
    }
    public void addArray(int[] itemsToAdd, int pos){
        Node temp = items;
        for(int i = 1; i < pos; i++){
            temp = temp.next;            
        }
        for(int i = 0; i < itemsToAdd.length; i++){
            Node toAdd = new Node(itemsToAdd[i]);            
            toAdd.next = temp.next;
            temp.next = toAdd;
        }       
    }
    
    
    
    public static void main(String[] args) throws OutOfBoundsException{
        try{
            LinkedList list = new LinkedList();
            list.add(7);
            list.add(6);
            list.add(5);
            list.add(4);
            list.add(3);
            list.add(2);    
            list.add(1);
            list.printList(); 
            System.out.println("ORIGINAL************");
            //list.removeRange(2,4);
            list.printList(); 
            System.out.println("REMOVERANGE************");
            list.insertAt(0,"Insert At Test");
            list.printList(); 
            //list.start();
            //list.advance();
            //list.advance();        
            //list.addAfter(99);
            //list.printList();
            //list.advanceToEnd();
            //list.removeCurrent();
            System.out.println(); 
            
            System.out.println("ADDARRAY************");
            int [] itemsToAdd = {111,222};
            list.addArray(itemsToAdd, 1);
            list.printList();
            System.out.println("FINDANDREPLACE************");
            list.findAndReplace(2, "I've been replaced");
            list.printList();
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Invalid Advance");
            
        }
   // list.start();
   // list.removecurrent();
    }      
    
}