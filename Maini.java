import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Maini {
//Main method to test
	public static void main(String[] args) throws FileNotFoundException {

		// Creates a 11x16 array
		char[][] maze = new char[11][16];

		// Takes the file name
		Scanner scan = new Scanner(System.in);
		String filename = scan.next();
		scan.close();

		// Takes input as a .txt file
		FileInputStream ft = new FileInputStream(filename);
		Scanner bili = new Scanner(ft);

		// marks the visited paths
		boolean[][] visited = new boolean[11][16];
		int i = 0;

		// Turns the given text to char array
		while (bili.hasNext()) {
			maze[i] = bili.nextLine().toCharArray();
			i++;
		}
		bili.close();
		// Takes +,-,| and replaces them with W character to simplify it
				for (int a = 0; a < maze.length; a++) { 
					for (int j = 0; j < maze[0].length; j++) {
						if (maze[a][j] == '+' || maze[a][j] == '-' || maze[a][j] == '|') {
							maze[a][j] = 'W';
						}}}
				// It replaces dead ends with walls
				// Every time it is called by recursion, it checks the new dead ends.
				// So that there will be only available paths are left
				for ( i = 1; i < maze.length - 1; i++) { 
					for (int j = 0; j < maze[0].length - 1; j++) { 
						if (maze[i][j] != 'W') { 
							if (i == 1 && j == 0) 
								continue;
							if (maze[i][j] == 'E')
								continue;
							if (maze[i][j + 1] == 'W' && maze[i][j - 1] == 'W' && maze[i + 1][j] == 'W')
								maze[i][j] = 'W';
							if (maze[i][j + 1] == 'W' && maze[i][j - 1] == 'W' && maze[i - 1][j] == 'W')
								maze[i][j] = 'W';
							if (maze[i + 1][j] == 'W' && maze[i - 1][j] == 'W' && maze[i][j + 1] == 'W')
								maze[i][j] = 'W';
							if (maze[i + 1][j] == 'W' && maze[i - 1][j] == 'W' && maze[i][j - 1] == 'W')
								maze[i][j] = 'W';
						}}}	
		// Finds how many 'E' does the map have
		int treasureCount = 0;
		for (i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				if (maze[i][j] == 'E') {
					if (maze[i][j + 1] == 'W' && maze[i][j - 1] == 'W' && maze[i + 1][j] == 'W'
							&& maze[i - 1][j] == 'W') {
						treasureCount = 0;
						break;
					} else
						treasureCount++;
				}
			}
		}
	
		// Creates a queue instead of reversing the stack
		Queue result = new Queue();
		// Output lines
		if (treasureCount == 0) {
			System.out.println("0 treasures are found.");

		} else {

			System.out.println(treasureCount + " treasures are found.");
			System.out.println("Paths are: ");

			SolvingMaze a = new SolvingMaze(maze);
			// Calls the recursive method from starting point (1,0) with an empty string
			a.recursiveMaze(1, 0, maze, visited, 1, "");

			// Prints the output.
			for (int j = 0; j < treasureCount; j++) {
				String str = "" + (j + 1) + ") " + a.myPath.get(a.myPath.size() - (j + 1)).item;
				result.enqueue(str);
			}
			result.PrintQueue(result);
			 
		}
		
	}
}