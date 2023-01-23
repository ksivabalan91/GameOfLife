package life;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Board {

    private int[][] board;

    // Constructors
    public Board(){}
    
    // methods
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
                    System.out.printf(" ");
                }
            }
            System.out.println("\n");
        }        
    }    
    public void printNumGeneration(){
        for(int j=0; j<board.length;j++){
            for (int i : board[j]){
                System.out.printf("%d",i);
            }
            System.out.println("\n");
        }        
    }           

    public void nextGen(){
        for(int j=0; j<board.length;j++){
            for (int i =0 ; i< board[j].length;i++){
                int occupancy = board[j][i];
                int sum = 0;
                
                switch(occupancy){
                    case 1:
                        sum = totalNeighbours(i, j, board);

                        if(sum==2||sum==3){board[j][i]=1;}
                        else{board[j][i]=0;}
                        break;

                    case 0:
                        sum = totalNeighbours(i, j, board);
                        if(sum>=3){board[j][i]=1;} 
                        else{board[j][i]=0;}                        
                        break;
                }
            }
        }
    }
    public static int totalNeighbours(int i, int j, int[][] board){
        int topLeft;
        if((i-1)>=0 && (j-1)>=0){topLeft=board[j-1][i-1];}
        else {topLeft=0;}

        int topCenter;
        if(j-1>=0){topCenter=board[j-1][i];}
        else {topCenter=0;}

        int topRight;
        if((i+1)<board[j].length && (j-1)>=0){topRight=board[j-1][i+1];}
        else {topRight=0;}

        int left;
        if((i-1)>=0){left=board[j][i-1];}
        else {left=0;}

        int right;
        if((i+1)<board[j].length){right=board[j][i+1];}
        else {right=0;}

        int bottomLeft;
        if((i-1)>=0 && (j+1)<board.length){bottomLeft=board[j+1][i-1];}
        else {bottomLeft=0;}

        int bottomCenter;
        if(j+1<board.length){bottomCenter=board[j+1][i];}
        else {bottomCenter=0;}

        int bottomRight;
        if((i+1)<board[j].length && (j+1)<board.length){bottomRight=board[j+1][i+1];}
        else {bottomRight=0;}

        int sum =   topLeft +       topCenter +     topRight +
                    left +                          right +
                    bottomLeft +    bottomCenter +  bottomRight;
        return sum;
    }
}
