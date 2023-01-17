package life;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException{

        // Console con = System.console();
        // String file = con.readLine("Enter GOL file name: ");

        String file = "glider.gol";        
        List<String> golList = new LinkedList<>();        
        File golFile = new File("GOLs\\"+file);

        golList =  ReadWriteFile.readFile(golFile);       
        golList.forEach(item->System.out.println(item));

        System.out.println(Arrays.deepToString(Initiator.initiallize(golList)));
        
    }    
}
