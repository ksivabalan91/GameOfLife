package life;

import java.io.*;
import java.util.*;

public class ReadWriteFile {

    public static List<String> readFile(File readFile) throws IOException{
        List<String> tempList = new LinkedList<String>();

        FileReader fr = new FileReader(readFile);
        BufferedReader br = new BufferedReader(fr);
        String line = "";

        while((line=br.readLine())!=null){
            tempList.add(line);
        }

        br.close();
        fr.close();

        System.out.println("File read");

        return tempList;        
    }

    public static void writeFile(File writeFile, List<String> writeList) throws IOException{
        FileWriter fw = new FileWriter(writeFile);
        BufferedWriter bw = new BufferedWriter(fw);
        
        for (String item:writeList){
            bw.write(item);
        }
        
        bw.close();
        fw.close();

        System.out.println("File saved");
    }
}
