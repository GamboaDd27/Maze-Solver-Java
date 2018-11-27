import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
		String[] parameters=strArray[0].split(" ");
		int rows=Integer.parseInt(parameters[0]);
		int cols=Integer.parseInt(parameters[1]);
		int startRow=Integer.parseInt(parameters[2]);
		int startCol=Integer.parseInt(parameters[3]);
		int endRow=Integer.parseInt(parameters[4]);
		int endCol=Integer.parseInt(parameters[5]);
	
		System.out.println(rows+" "+cols+" "+ startRow+" "+startCol+" "+endRow+ " "+endCol );
		char[][] maze=new char[rows][cols];
		fillMaze(myPath,maze);
		
	}
	public static void fillMaze(Path path, char[][] maze) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(path.toString()));
			String line = reader.readLine();
			int i=0;
			while (line != null) {
				line = reader.readLine();
				if(i!=0 && line!=null) {
				System.out.println(line);
				// read next line
				
				for(int j=0;j<line.length();j++) {
					maze[i][j]=line.charAt(j);
				}
				}
				
				i++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
