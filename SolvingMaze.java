public class SolvingMaze {
	char maze[][];
	Node currentPosition; // current position of James Bond
	Node endingPoint; // Maze ends when 'E' is found
	Node wall; // Node to hold walls
	Node right, left, up, down; // Moving nodes

	static Stack myPath = new Stack(); // this stack holds the path

	public SolvingMaze(char[][] maze) { // Constructor
		endingPoint = new Node("E");
		wall = new Node("W");
	}

	boolean isvisited[][]; // It is a double array to collect visited paths.
	String waysToGo = ""; //A starting string to change char array to a single string.
	
	
// A recursive method which controls the movement, and also counts how many possible paths are there.
	public static void recursiveMaze(int row, int column, char[][] maze, boolean[][] isvisited,int step, String waysToGo) {
		
		// Takes +,-,| and replaces them with W character to simplify it
		for (int a = 0; a < maze.length; a++) { 
			for (int j = 0; j < maze[0].length; j++) {
				if (maze[a][j] == '+' || maze[a][j] == '-' || maze[a][j] == '|') {
					maze[a][j] = 'W';
				}}}
		
		//If it is the starting point, method continues
		if (row == 1 && column == 0) {} 
		
		//If it is out of bonds, a wall or a visited character, it ends the recursion
		else if (row <= 0 || column <= 0) {
			return;
		} else if (row >= maze.length - 1 || column >= maze[0].length - 1) {
			return;
		} else if (maze[row][column] == 'W') {
			return;
		} else if (isvisited[row][column] == true)
			return;
		
		// Finds how many 'E' does the map have
		int treasureCount = 0;
		for (int i = 0; i < maze.length; i++) { 
			for (int j = 0; j < maze[0].length; j++) {
				if (maze[i][j] == 'E') {
					treasureCount++;	
				}}}
		
		//It checks if every character is visited before reaching to an 'E'
		//If 'E' is found, it adds all the path to a string and pushes 
		//Everything to the String stack
		if (isvisited[row][column] = true) {
			if (maze[row][column] == 'E') {
				waysToGo += 'E';
				myPath.push( waysToGo);
}}
		if(treasureCount==0)
			return;
		//This checks when we are not on a wall or maze is valid
		//And then it calls the recursive method to check four directions from our current position
		//It checks up, left, right and down in this order
		//Checks if it's already visited or not, then if it is a lowercase letter it's added to the string
if(maze[row][column]!='W' && treasureCount!=0) {
		recursiveMaze(row - 1, column, maze, isvisited, step, "" + waysToGo + "" + maze[row][column]); //up
		recursiveMaze(row, column - 1, maze, isvisited, step,"" + waysToGo + "" + maze[row][column]); //left
		recursiveMaze(row, column + 1, maze, isvisited, step,"" + waysToGo + "" + maze[row][column]); //right
		recursiveMaze(row + 1, column, maze, isvisited, step,"" + waysToGo + "" + maze[row][column]); //down

}}

}
