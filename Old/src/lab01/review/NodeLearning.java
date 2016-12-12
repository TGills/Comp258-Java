/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.review;

/**
 *
 * @author guillaume2127
 */
public class NodeLearning {
    private int data;    
    public NodeLearning next;   
    
    public int getData() {
        return data;
    }    
    public void setData(int data) {
        this.data = data;
    }    
    
    
    public NodeLearning(int data){
        setData(data);
    }
    
    public static void main(String args[]){
        NodeLearning a = new NodeLearning(7);
        NodeLearning b = new NodeLearning(6);
        NodeLearning c = new NodeLearning(5);
        NodeLearning d = new NodeLearning(4);
        NodeLearning e = new NodeLearning(3);
        
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        
        
        NodeLearning list = a;
        
        while(list!=null){
            System.out.println(list.getData());
            list = list.next;
        }
         System.out.println("**********************");
        
        NodeLearning f = new NodeLearning(99);
        f.next = b.next;//or C
        b.next = f;
        
        list = a;
        while(list!=null){
            System.out.println(list.getData());
            list = list.next;
        }
        
        
        b.next = f.next; 
    }
    
}
