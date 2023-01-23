package life;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Board {

    private int[][] board;

    public Board(){}
    
    public void initiallize(List<String> golList){
        int gridX=0;
        int gridY=0;
        int startX=0;
        int startY=0;
        List<List<String>> config = new LinkedList<>();

        for(int i = 0;i<golList.size();i++){
            if(golList.get(i).startsWith("#")){} //ignore            
            if(golList.get(i).startsWith("GRID")){
                gridX = Integer.parseInt(golList.get(i).split(" ",0)[1]);
                gridY = Integer.parseInt(golList.get(i).split(" ",0)[2]);
                // System.out.println("GRID X:"+gridX+" Y: "+gridY);
            }
            if(golList.get(i).startsWith("START")){
                startX = Integer.parseInt(golList.get(i).split(" ",0)[1]);
                startY = Integer.parseInt(golList.get(i).split(" ",0)[2]);
                // System.out.println("START X:"+startX+" Y: "+startY);
            }
            if(golList.get(i).startsWith("DATA")){
                
                for (int j = i+1; j<golList.size();j++){
                    config.add(Arrays.asList(golList.get(j).split("")));             
                }
                // System.out.println(config.toString());
            }            
        }
        
        this.board = new int[gridX][gridY];

        for(int i =0;i<config.size();i++){
            for(int j=0; j<config.get(i).size();j++){
                String charString = config.get(i).get(j).trim();
                if(charString.equals("*"))
                    this.board[startY+i][startX+j]=1;                
            }
        }
    }

    public void printGeneration(){
        for(int j=0; j<board.length;j++){
            for (int i : board[j]){
                if(i==1){
                    System.out.printf("*");
                } else{
                    System.out.printf("-");
                }
            }
            System.out.println("\n");
        }
        
    }    

    public void nextGen(){
        
    }
}
