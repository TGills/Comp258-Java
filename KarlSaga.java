/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karlsaga;

import java.util.AbstractQueue;
import java.util.*;

/**
 *
 * @author OSBORNE
 */
public class KarlSaga {

    /**
     * @param args the command line arguments
     */
    Scanner input;
    boolean found=false;
    int[][] maze1 = {{1,1,1,1,1,1,1,1,1,1},
                     {1,0,0,0,0,0,0,0,0,1},
                     {1,2,1,1,1,0,1,1,0,1},
                     {1,1,1,1,1,0,1,1,0,1},
                     {1,1,1,1,0,0,0,1,0,1},
                     {1,1,1,1,0,0,0,1,0,1},
                     {1,1,1,0,0,0,0,1,0,1},
                     {1,1,1,0,1,1,1,0,0,1},
                     {1,0,0,0,0,0,0,0,1,1},
                     {1,3,1,1,1,1,1,0,1,1},
                     {1,1,1,1,1,1,1,1,1,1}};
    
    LinkedList<Space> q; 
    LinkedList<Space> qv; 
    Stack<Space> path ;
    
    public static void main(String[] args) {
       
        
        KarlSaga ks = new KarlSaga();
        ks.drawMap();
        ks.navigate(2,1);
        
    }
    
    public KarlSaga(){
        q = new LinkedList<Space>();
        qv = new LinkedList<Space>();
        
        input = new Scanner(System.in);
    }
    
    public void navigate(int i, int j){
        
        
        
        
        
    }
    
    public void printPath(){
         System.out.println("path");
        while(path.size()>0){
            Space stop = path.pop();
            
             drawMap(stop.x,stop.y);
        }
        
    }
    
    public void printQueue(){
        
        for (Space item : qv) {
            System.out.print(item);
        }
        
    }
    
    public void drawMap(int ii, int jj ){
        
        for(int i=0; i<maze1.length; i++){
            for(int j =0; j<maze1[i].length; j++){
                if(i==ii && j==jj)
                {
                    System.out.print("K");
                }
                else  if(maze1[i][j]==2 || maze1[i][j]==0 ){
                    System.out.print(".");
                }
                else  if(maze1[i][j]==3){
                    System.out.print("X");
                }
                else{
                    System.out.print("#");
                }
        }
        System.out.println("");
        
    }
       System.out.println("--------------------------------");
    }
    
    public void drawMap(){
        
        for(int i=0; i<maze1.length; i++){
            for(int j =0; j<maze1[i].length; j++){
                if(maze1[i][j]==1){
                    System.out.print("#");
                }
                else  if(maze1[i][j]==2){
                    System.out.print("K");
                }
                else  if(maze1[i][j]==3){
                    System.out.print("X");
                }
                else{
                    System.out.print(".");
                }
        }
        System.out.println("");
        
    }
     
    }
    
    
    public void addSpaces(int[][] maze, int i, int j, Space adder){
        
        
    }
    
    
}
    
    

