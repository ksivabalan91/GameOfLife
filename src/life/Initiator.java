package life;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Initiator {

    private static int gridX;
    private static int gridY;
    private static int startX;
    private static int startY;
    
    public static int[][] initiallize(List<String> golList){
        for(int i = 0;i<golList.size();i++){
            if(golList.get(i).startsWith("#")){} //ignore            
            if(golList.get(i).startsWith("GRID")){
                gridX = Integer.parseInt(golList.get(i).split(" ",0)[1]);
                gridY = Integer.parseInt(golList.get(i).split(" ",0)[2]);
            }
            if(golList.get(i).startsWith("START")){
                startX = Integer.parseInt(golList.get(i).split(" ",0)[1]);
                startY = Integer.parseInt(golList.get(i).split(" ",0)[2]);
            }
            if(golList.get(i).startsWith("DATA")){
                List<List<String>> config = new LinkedList<>();
                for (int j = i+1; j<golList.size();j++){
                    config.add(Arrays.asList(golList.get(j).split("")));             
                }
                System.out.println(config.toString());
                System.out.println(config.size());
            }



            // switch
        }
        
        int[][] startingGrid = new int[gridX][gridY];

        return startingGrid;
    }

    
}
