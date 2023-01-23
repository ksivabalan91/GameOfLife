package life;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{

        // instantiate new board
        Board board = new Board();
        List<String> golList = new LinkedList<>();
        Console con = System.console();
        Scanner scan = new Scanner(System.in);

        // get location of GOL files
        String input = con.readLine("Enter GOL file name: ");

        Path golPath = Paths.get("GOLs\\"+input);
        File golFile = golPath.toFile();

        // check if files exists
        while(!golFile.exists()){
            input = con.readLine("File does not exist, please input correct file: ");
            golPath = Paths.get("GOLs\\"+input);
            golFile = golPath.toFile();
        }

        // read file
        golList =  ReadWriteFile.readFile(golFile);
        
        // initiallize board
        board.initiallize(golList);
        System.out.println("Generation 0");
        board.printGeneration();

        System.out.println("Enter number of generations to iterate: ");
        int generations = scan.nextInt();

        for(int i =0; i<generations;i++){
            board.nextGen();
            System.out.println("Generation"+(i+1));
            board.printGeneration();
        }
        System.out.println("Thats life");
        
    }    
}
