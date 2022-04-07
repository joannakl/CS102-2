package project3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

	/** Number of lines to be cleared in order to
	 * clear the screen in the terminal window. */
	public static final int SCREEN_HEIGHT = 80;

	/**
	 * This is the function that starts the program.
	 * @param args
	 *   specifies two arguments to the program :
	 *      1 - input file with the maze in it
	 *      2 - a keyword equal to "stack",  "queue", or "rec"
	 *      to indicate what method should be used in solving the maze
	 */
	public static void main ( String [] args ) {
		//make sure that the number of arguments to the program is correct

		if ( args.length < 2 ) {
			System.err.printf( "Error: Incorrect usage.%n" );
			System.err.printf( "\tUSAGE: java Simulation inputFile method%n" );
			System.err.printf( "\t   inputFile should contain the maze specification%n" );
			System.err.printf( "\t   method should be either `queue`, `stack` or `rec`.%n" );
			System.exit ( 1 );
		}

		//verify that the input file exists and can be read
		//then open it for reading
		File inputFile = new File ( args[0] );
		if (  !( inputFile.exists() && inputFile.canRead()  )  )
		{
			System.err.printf( "Error: Cannot read file %s.%n", args[0] );
			System.exit ( 1 );
		}
		Scanner in = null;

		try {
			in = new Scanner ( inputFile );
		} catch ( FileNotFoundException e ) {
			System.err.printf( "Error: Cannot read file %s.%n", args[0] );
			System.exit ( 1 );
		}


		//verify that the method is specified correctly
		if ( !(  args[1].startsWith( "queue" )
				|| args[1].startsWith( "stack" )
				|| args[1].startsWith( "rec" )
				 )  ) {
			System.err.printf( "Error: Incorrect usage.%n" );
			System.err.printf( "\tUSAGE: java Simulation inputFile method%n" );
			System.err.printf( "\n\n   Valid methods are 'queue', 'stack' or 'rec'.\n" );
			System.exit ( 1 );
		}

		//read the maze representation from the file
		char [][] charMazeFromFile = getCharMaze(  in  );
		in.close();

		//create maze object
		Labyrinth maze = null;
		try {
			maze = new Labyrinth( charMazeFromFile );
		}
		catch ( IllegalArgumentException ex  ) {

			System.err.printf( "Error: Invalid input file.%n" );
			System.err.printf( "\tProvided input file does not specify a valid maze.%n" );
			System.exit ( 1 );
		}

		//start the animation by clearing the screen and printing the maze
		clearScreen();
		System.out.println( maze );

		//use the algorithm indicated by the second command line argument
		if ( args[1].startsWith( "stack" ) ) {
			//run the search for way out algorithm using stack
			searchForWayOut( maze, new PossibleLocationsStack()   );
		}
		else if ( args[1].startsWith( "queue" )   ) {
			//run the search for way out algorithm using queue
			searchForWayOut( maze, new PossibleLocationsQueue()  );
		}
		else {
			//run the search for way out using a recursive algorithm
			searchForWayOut( maze );
		}
	}

	/**
	 * Reads in the maze data from the file and saves it as a 2D character array.
	 * @param in input file stream that contains maze data
	 * @return  2D character array representation of the maze
	 */
	public static char [][]  getCharMaze (  Scanner in  ) {
		StringBuffer mazeFromFile = new StringBuffer();
		//read the file content
		int rowsCount = 0;
		while (  in.hasNext()  ) {
			mazeFromFile.append(  in.nextLine() + "\n"  );
			rowsCount++;
		}
		//split into an array of rows
		String [] mazeFromFileMatrix = mazeFromFile.toString().split( "\n" );
		//convert into a 2D array of characters
		char [][] charMazeFromFile = new char[rowsCount] [] ;
		for ( int i = 0; i < rowsCount; i++ ) {
			charMazeFromFile[i] = mazeFromFileMatrix[i].toCharArray();
		}

		return charMazeFromFile;
	}



	/**
	 * This method implements a recursive version of the algorithm that finds a way out of the maze.
	 * @param maze maze object to navigate
	 * note to grader: I took "the implementation of the searchForWayOut method in the Simulation class" to mean the below method, as opposed to the recursive method which that implements
	 */
	public static void searchForWayOut ( Labyrinth maze )  {

		//set a random start position
		Location start = maze.generateStartPosition();;
		
		// Creates & Initializes unfinishedVisited, variable to store visited spaces with neighbors that have not been visited, starting with start's neighbors
		ArrayList<Location> unfinishedVisited = maze.getNeighbors(start);

		//use the recursive method to determine if there is a way out
		//this method continues the visual simulation
		boolean foundWayOut = searchForWayOut( maze, start, unfinishedVisited ) ;

		//display the final "screen"
		if ( foundWayOut ) {
			clearScreen();
			System.out.println( maze );
			System.out.println( "You found the way out!" );
		}
		else {
			System.out.println( "There is no way out of here!" );
		}
	}



	/*
	 * Private recursive method that implements the algorithm that finds a way out of the maze.
	 * @param maze maze object to navigate
	 * @param current the current location in the maze from which the way out should be found
	 * @param List of visited spaces with neighbors that have not been visited
	 * @return true if there is a way to find an exit from the current position, false otherwise
	 */
	private static boolean searchForWayOut( Labyrinth maze, Location current, ArrayList<Location> unfinishedVisited ) {

		// display the current state of the exploration on the screen
		clearScreen();
		System.out.println( maze );
		//after every step wait 200 milliseconds
		try {
			Thread.sleep( 200 );
		}
		catch( InterruptedException e ) {}

		//Sets square as visited at start of every program call, unless already visited, in which case check previously visited
		if (maze.getSquareType(current).isVisited() && unfinishedVisited.size() != 0) {
			Location tmp = new Location(unfinishedVisited.get(0).getRow(), unfinishedVisited.get(0).getColumn());
			unfinishedVisited.remove(0);
			return( searchForWayOut(maze, tmp, unfinishedVisited ) );
		}
			maze.setSquareToVisited( current );

		//Every neighbor of current square
		ArrayList<Location> neighbors = maze.getNeighbors( current );

		
		int neighborAmt = neighbors.size();
		
		for(int i = 0; i < neighborAmt; i++) {
			try {
				//currLocation: neighbor square of current that is being iterated on
				//i.e,  currLocation = neighbors.get(0) means the first neighbor in arrayList neighbors
				Location currLocation = neighbors.get(i);


				//If current square is exit, we have succeeded
				if (maze.getSquareType(currLocation).isWayOut()  ) {
					return true;
					// If square being looked at now hasn't been visited yet, get all its neighbors excluding current, then add to list of locations to revisit
					// Revisited locations do not repeat the process
					
					//if only one neighbor, we're cornered, so check alternates
				} else if  ( (neighborAmt == 1 && !maze.getSquareType(currLocation).isVisited()) ) {
					Location tmp = new Location(unfinishedVisited.get(0).getRow(), unfinishedVisited.get(0).getColumn());
					unfinishedVisited.remove(0);
					return( searchForWayOut(maze, tmp, unfinishedVisited ) );
					//if 2 options, there's only front and back, so check front
				} else if ( neighborAmt == 2 && !maze.getSquareType(currLocation).isVisited() ) {
					
					return( searchForWayOut( maze, neighbors.get( i ), unfinishedVisited ) );
					
				}  else if (!maze.getSquareType(currLocation).isVisited() && neighborAmt > 3) {
					//if neighborAmt is less than 1, there will be no possible spaces left unaccounted for, so don't do any complex stuff

					for( int j = 0; j < neighborAmt; j++ ) {
						if(maze.getSquareType(neighbors.get(j)).isVisited()) {
							neighbors.remove(j);
							continue;
						}
						if(!neighbors.get(j).equals(current) && !maze.getSquareType(neighbors.get(j)).isVisited() && i != j) {
							unfinishedVisited.add(neighbors.get(j));
						}
					}
					return(searchForWayOut(maze, neighbors.get(i), unfinishedVisited));
					//if no neighbors left, delete the first unfinished visit in list then start looking there
				} 

			} catch (Exception IndexOutOfBoundsException) {
				continue;
			}
		}


		return( searchForWayOut( maze, neighbors.get( 0 ), unfinishedVisited ) );
	}


	/**
	 * This method implements the algorithm that finds a way out of the maze.
	 * @param maze maze object to navigate
	 * @param listOfSquares object to be used as the list of spaces that need to be visited
	 *    ( depending on the structure used, the algorithm perform different search )
	 */
	public static void searchForWayOut ( Labyrinth maze,
			PossibleLocations listOfSquares  )  {
		//validate the arguments
		if ( listOfSquares == null || maze == null  )
			throw new NullPointerException();

		//set a random start position
		Location start = maze.generateStartPosition();

		//variables used in running of the algorithm
		Location current = null;
		ArrayList<Location> neighbors = null;
		boolean foundWayOut = false;

		//add the start position to the list of squares
		listOfSquares.add( start );

		// if the list is empty, the finish is unreachable;
		// terminate the algorithm.
		while ( !listOfSquares.isEmpty() ) {
			// grab a location from the list.
			current = listOfSquares.remove();
			if (  current == null  ) throw new LabyrinthSearchException ( "removed element null - this should not happen" );

			//if location has been visited then there is no need
			//to explore it again; this step is done.
			if ( maze.getSquareType( current ).isVisited() ) {
				continue;
			}
			//if location is a finish square, the finish
			//was reachable; terminate the algorithm.
			if ( maze.getSquareType( current ).isWayOut() ) {
				foundWayOut = true;
				break;
			}

			//Otherwise, it is a reachable non-finish location that we haven't seen
			//yet. So, explore it as follows:
			//   - compute all the adjacent locations that are inside the maze and
			//     aren't walls, and
			//   - add them to the list for later exploration.
			//Also, record the fact that you've explored this location so you won't
			//ever have to explore it again.
			neighbors = maze.getNeighbors( current );
			for ( int i = 0; i < neighbors.size(); i++ ) {
				listOfSquares.add( neighbors.get( i ) );
			}
			maze.setSquareToVisited( current );

			//redraw the maze for animation purposes
			clearScreen();
			System.out.println( maze );
			//after every step wait 200 milliseconds
			try {
				Thread.sleep( 200 );
			}
			catch( InterruptedException e ) {}
		}

		//display the final "screen"
		if ( foundWayOut ) {
			maze.setSquareToExit( current );
			clearScreen();
			System.out.println( maze );
			System.out.println( "You found the way out!" );
		}
		else {
			System.out.println( "There is no way out of here!" );
		}
	}

	/**
	 * Clears the "screen" of the terminal by printing SCREEN_HEIGHT number
	 * of blank lines.
	 */
	public static void clearScreen(   ) {
		for ( int i = 0; i < SCREEN_HEIGHT; i++ )		{
			System.out.println( " " );
		}
	}


}
