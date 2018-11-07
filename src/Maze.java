import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Maze {

	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		System.out.println("Enter a file name for a maze");
		String fileName=in.nextLine();
		 File directory = new File("./"); //gets the path of the project
		Path myPath = Paths.get(directory.getAbsolutePath()+"/src/"+fileName); //Generates absolute path to the maze file; works in all operating systems
		String[] strArray = Files.lines(myPath) //parses the first line of the file
		    .map(s -> s.split(","))
		    .findFirst()
		    .get(); 
		
		
		for(int i=0; i<strArray.length;i++) {
			System.out.println(strArray[i]);
		}
	}
	

}
