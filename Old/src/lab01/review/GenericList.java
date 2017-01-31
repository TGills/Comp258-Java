package lab01.review;
/*
 * @author guillaume2127
 */
public class GenericList<T> {
    private GenericNode<T> items;
    private GenericNode<T> current;
    
    public void add(T item){
        if(items == null){
            items = new GenericNode(items);
            current = items;
        }
        else{
            current.nextNode = new GenericNode(items);
            current = current.nextNode;
        }
    }
    public void print(){
        GenericNode<T> temp = items;
        while(temp!=null){
            System.out.println(temp.getData());
            temp = temp.nextNode;
    }    
}
    public T getElementAT(int i){
        GenericNode<T> temp = items;
        for(int count=0; count<i; count++){
            temp = temp.nextNode;
        }
        return temp.getData();
    }
    public T findMax(){
        T max;
        max = items.getData();
        GenericNode<T> temp = items;
        while(temp.nextNode!=null){
            if(((Comparable)(temp.getData())).compareTo(max) > 0){
                max = temp.getData();
            }
            temp = temp.nextNode;
        }
        
        return max;
    }
    
    
    public static void main(String args[]){
        GenericList<Customer> list = new GenericList<>();
        list.add(new Customer("Bob", "Bill", 'T', 1234));        
        
        
    }
    
    
    class GenericNode<T>{
        private T data;
	public GenericNode<T> nextNode;
	public GenericNode(T item){
		data=item;
	}
	public T getData(){
		return data;
	}        
        

    } 
    
    
    
    

}
