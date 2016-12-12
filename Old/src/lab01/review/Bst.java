package lab01.review;
/*
 * @author guillaume2127
 */
public class Bst {
    
    public Bst(){}
    Node start;
    
    public void add(Comparable data){
        if(start == null){
            start = new Node(data);
        }
        else{
            addNode(start, data);
        }
    }
    public void addNode(Node current, Comparable data){
        if(data.compareTo(current.getData()) <= 0){
            if(current.left == null){
                current.left = new Node(data);
            }
            else{
                addNode(current.left, data);
            }
        }
        else{
            if(current.right == null){
                current.right = new Node(data);
            }
            else{
                addNode(current.right, data);
            }            
        }       
    }    
    public void printTree(Node node){
        if(node.left != null){
            printTree(node.left);
        }        
        System.out.println(node.getData() + " ");
        if(node.right != null){
            printTree(node.right);
        }
    }
    public void printTree(){
        printTree(start);
    }
    public boolean searchTree(Comparable data){
        return searchTree(start, data, 0);
    }
    public boolean searchTree(Node current, Comparable data, int calls){
        calls++;
        if(current.getData() == data){
            System.out.println("Searches: " + calls);
            return true;
        }
        else if(data.compareTo(current.getData()) < 0 && current.left != null){
            return searchTree(current.left, data, calls);
        }
        else if(data.compareTo(current.getData()) > 0 && current.right != null){
            return searchTree(current.right, data, calls);
        }
        else{
            return false;
        }
        
        
    }
    public void delete(Node current, Comparable target){
        if(current.getData().compareTo(target)>0 && current.left!=null){    
            if(current.left.getData().compareTo(target)==0) {
                System.out.println("Parent found: " + current.getData());
                if(current.right.left == null && current.right.right == null){
                    current.right = null;
                }
            }
            else{
                delete(current.left,target);
            }            
        }
        else if(current.getData().compareTo(target)<0 && current.right!= null){
            if(current.right.getData().compareTo(target)==0) {
                System.out.println("Parent found: " + current.getData());
                if(current.right.left == null && current.right.right == null){
                    current.right = null;
                }
            }
            else{
                delete(current.right, target);
            }            
        }
        else{
            System.out.println("Node found: " + current.getData());                 
        }
    }
    public void delete(Comparable target){
        delete(start, target);
    }
    
    
    
    public static void main(String[] args) {
        //java.util.Random r = new java.util.Random();
        Bst bst = new Bst();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(13);
        bst.add(35);
        bst.add(66);
        bst.add(85);
        bst.add(17);
        bst.add(90);
        bst.add(15);
        bst.add(18);
        bst.printTree();
        System.out.println("ORIGINAL******************");
        bst.delete(35);
        bst.printTree();
        
//        for(int i=0; i < 20; i++){
//            bst.add(r.nextInt(50));
//        }
//        bst.printTree();
//        if(bst.searchTree(1) == true){
//            System.out.println("True");
//        }
//        else{
//            System.out.println("False");
//        }        
    }
    
}


class Node{    
    private Comparable data;
    public Node left;
    public Node right;    
    public Node(){};    
    public Node(Comparable data){
        setData(data);
    }    
    public void setData(Comparable data){
        this.data=data;
    }
    public Comparable getData(){
        return data;
    }
}