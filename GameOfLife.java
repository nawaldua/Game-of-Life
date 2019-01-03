///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            GameOfLife
// Files:            GameOfLife.java
// Semester:         Fall 2015
//
// Author:           Nawal Dua
// Email:            ndua2@wisc.edu
// CS Login:         nawal
// Lecturer's Name:  Deb Deppeler
// Lab Section:      311
///////////////////////////////////////////////////////////////////////////////
/**
 * This game is based on John Conway's Game of Life as described in Wikipedia.
 * https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 */


// PUT import statements here
import java.util.Scanner;

import javax.print.DocFlavor.STRING;


//PUT CLASS HEADER HERE
public class GameOfLife {

	// DO NOT ADD STATIC FIELDS TO THIS CLASS
	// YOU MUST SOLVE ALL PARTS BY PASSING THE 
	// THE VALUES YOU NEED TO AND FROM METHODS.
	// WE WILL TEST ALL METHODS INDEPENDENT OF 
	// OTHER METHODS.  
	//
	// THAT CAN ONLY WORK IF YOU DEFINE EACH 
	// METHOD AS DESCRIBED.  YOU MAY NOT IMPLEMENT
	// YOUR OWN DESIGN EXCEPT TO ADD PRIVATE
	// HELPER METHODS AS YOU LIKE.  YOU MUST
	// STILL IMPLEMENT ALL PUBLIC METHODS
	// OF THIS CLASS.

	/**
	 * Program execution starts here.
	 * @param args UNUSED
	 */    
	public static void main(String[] args){

		//declare local variables
		Scanner scnr = new Scanner(System.in);
		int input = 0;
		// Display Welcome message  
		System.out.print("Welcome to the Game Of Life \n");

		//menu choices
		do {
			System.out.print("\nSelect a pattern of life for the world \n 1 - "
					+ "Glider\n 2 - Beacon \n 3 - Boat \n 4 - R-pentomino \n 5"
					+ " - Random\n 9 - Exit \n Choice: ");

			// check for integer input
			if (scnr.hasNextInt()){
				input = scnr.nextInt();
				//initialize the world based on the user's choice 
				if (input == 1){
					scnr.nextLine();
					int genNum = 0;
					boolean [][] gliderWorld = GameOfLife.createNewWorld(
							Config.WORLD_ROWS, Config.WORLD_COLUMNS);
					boolean [][] newGliderWorld = GameOfLife.createNewWorld(
							Config.WORLD_ROWS, Config.WORLD_COLUMNS);
					GameOfLife.clearWorld(gliderWorld);
					GameOfLife.initializeGlider(gliderWorld);
					GameOfLife.printWorld("Glider", gliderWorld, genNum);
					System.out.println("Options:\n(Enter: show next generation"
							+ "\nend(Enter): end this simulation\nChoice:");
					genNum++;
					String choice = scnr.nextLine();
					while (choice.equals("")){
						scnr.nextLine();
						GameOfLife.nextGeneration(gliderWorld, newGliderWorld);
						boolean [][] tempWorld = new boolean 
								[Config.WORLD_ROWS][Config.WORLD_COLUMNS];
						tempWorld = gliderWorld;
						gliderWorld = newGliderWorld;
						newGliderWorld= tempWorld;
						GameOfLife.printWorld("Glider", gliderWorld, genNum);
						System.out.println("Options:\n(Enter: show next "
								+ "generation\nend(Enter): end this simulation"
								+ "\nChoice:");
						genNum++;
						choice = scnr.nextLine();
					}
				}
				else if (input == 2){
					scnr.nextLine();
					int genNum = 0;
					boolean [][] beaconWorld = GameOfLife.createNewWorld(
							Config.WORLD_ROWS, Config.WORLD_COLUMNS);
					boolean [][] newBeaconWorld = GameOfLife.createNewWorld(
							Config.WORLD_ROWS, Config.WORLD_COLUMNS);
					GameOfLife.clearWorld(beaconWorld);
					GameOfLife.initializeBeacon(beaconWorld);
					GameOfLife.printWorld("Beacon", beaconWorld, genNum);
					System.out.println("Options:\n(Enter: show next generation"
							+ "\nend(Enter): end this simulation\nChoice:");
					genNum++;
					String choice = scnr.nextLine();
					while (choice.equals("")){
						scnr.nextLine();
						GameOfLife.nextGeneration(beaconWorld, newBeaconWorld);
						boolean [][] tempWorld = new boolean 
								[Config.WORLD_ROWS][Config.WORLD_COLUMNS];
						tempWorld = beaconWorld;
						beaconWorld = newBeaconWorld;
						newBeaconWorld= tempWorld;
						GameOfLife.printWorld("Beacon", beaconWorld, genNum);
						System.out.println("Options:\n(Enter: show next "
								+ "generation\nend(Enter): end this simulation"
								+ "\nChoice: \n");
						genNum++;
						choice = scnr.nextLine();
					}
				}
				else if (input == 3){
					scnr.nextLine();
					int genNum = 0;
					boolean [][] boatWorld = GameOfLife.createNewWorld(
							Config.WORLD_ROWS, Config.WORLD_COLUMNS);
					boolean [][] newBoatWorld = GameOfLife.createNewWorld(
							Config.WORLD_ROWS, Config.WORLD_COLUMNS);
					GameOfLife.clearWorld(boatWorld);
					GameOfLife.initializeBoat(boatWorld);
					GameOfLife.printWorld("Boat", boatWorld, genNum);
					System.out.println("Options:\n(Enter: show next generation"
							+ "\nend(Enter): end this simulation\nChoice:");
					genNum++;
					String choice = scnr.nextLine();
					while (choice.equals("")){
						scnr.nextLine();
						GameOfLife.nextGeneration(boatWorld, newBoatWorld);
						boolean [][] tempWorld = new boolean 
								[Config.WORLD_ROWS][Config.WORLD_COLUMNS];
						tempWorld = boatWorld;
						boatWorld = newBoatWorld;
						newBoatWorld= tempWorld;
						GameOfLife.printWorld("Boat", boatWorld, genNum);
						System.out.println("Options:\n(Enter: show next "
								+ "generation\nend(Enter): end this simulation"
								+ "\nChoice:");
						genNum++;
						choice = scnr.nextLine();
					}
				}
				else if (input == 4){
					scnr.nextLine();
					int genNum = 0;
					boolean [][] rPentominoWorld = GameOfLife.createNewWorld(
							Config.WORLD_ROWS, Config.WORLD_COLUMNS);
					boolean [][] newRPentominoWorld = GameOfLife.createNewWorld(
							Config.WORLD_ROWS, Config.WORLD_COLUMNS);
					GameOfLife.clearWorld(rPentominoWorld);
					GameOfLife.initializeRpentomino(rPentominoWorld);
					GameOfLife.printWorld("R-Pentomino", rPentominoWorld, 
							genNum);
					System.out.println("Options:\n(Enter: show next generation"
							+ "\nend(Enter): end this simulation\nChoice:");
					genNum++;
					String choice = scnr.nextLine();
					while (choice.equals("")){
						scnr.nextLine();
						GameOfLife.nextGeneration(rPentominoWorld, 
								newRPentominoWorld);
						boolean [][] tempWorld = new boolean 
								[Config.WORLD_ROWS][Config.WORLD_COLUMNS];
						tempWorld = rPentominoWorld;
						rPentominoWorld = newRPentominoWorld;
						newRPentominoWorld= tempWorld;
						GameOfLife.printWorld("R-Pentomino", rPentominoWorld, 
								genNum);
						System.out.println("Options:\n(Enter: show next "
								+ "generation\nend(Enter): end this simulation"
								+ "\nChoice:");
						genNum++;
						choice = scnr.nextLine();
					}
				}
				else if (input == 5){
					scnr.nextLine();
					int genNum = 0;
					boolean [][] randomWorld = GameOfLife.createNewWorld(
							Config.WORLD_ROWS, Config.WORLD_COLUMNS);
					boolean [][] newRandomWorld = GameOfLife.createNewWorld(
							Config.WORLD_ROWS, Config.WORLD_COLUMNS);
					GameOfLife.clearWorld(randomWorld);
					GameOfLife.initializeRandomWorld(randomWorld);
					GameOfLife.printWorld("Random", randomWorld, genNum);
					System.out.println("Options:\n(Enter: show next generation"
							+ "\nend(Enter): end this simulation\nChoice:");
					genNum++;
					String choice = scnr.nextLine();
					while (choice.equals("")){
						scnr.nextLine();
						GameOfLife.nextGeneration(randomWorld, newRandomWorld);
						boolean [][] tempWorld = new boolean 
								[Config.WORLD_ROWS][Config.WORLD_COLUMNS];
						tempWorld = randomWorld;
						randomWorld = newRandomWorld;
						newRandomWorld= tempWorld;
						GameOfLife.printWorld("Random", randomWorld, genNum);
						System.out.println("Options:\n(Enter: show next "
								+ "generation\nend(Enter): end this simulation"
								+ "\nChoice:");
						genNum++;
						choice = scnr.nextLine();
					}
				}
				else if (input == 9){
					System.out.print("End of Game Of Life.");
				}
				else {
					scnr.nextLine();
					System.out.print("Invalid input");
				}

				//loop to print out world and prompt for next generation or Exit  
			}
			else{
				System.out.print("Invalid input");
				scnr.nextLine();
			}
		}
		while (input != 9);
		scnr.close();
		System.exit(0);
	} 	

	/**
	 * Create a new world
	 * @param numRows The number of rows to be in the created world
	 * @param numColumns  The number of columns to be in the created world
	 * @return A double dimension array of boolean that is numRows by 
	 * numColumns in size and initialized to all false values. 
	 */
	public static boolean[][] createNewWorld( int numRows, int numColumns) {

		// TODO: Implement this method		
		//create the world of the proper size
		boolean [][] newWorld = new boolean [numRows][numColumns];
		return newWorld;
	}

	/**
	 * Sets all the cells in the world to not alive (false).
	 * @param world 
	 */
	public static void clearWorld( boolean[][]world) {

		// TODO: Implement this method		
		for (int i = 0; i < world.length; i++){
			for (int j = 0; j < world[i].length; j++){
				world[i][j] = false;
			}
		}
	}	

	/**
	 * Initializes the world to the Glider pattern.
	 * <pre>
	 * ..........
	 * .@........
	 * ..@@......
	 * .@@.......
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * </pre>
	 * @param world  the existing double dimension array that will be 
	 * reinitialized to the Glider pattern. 
	 */
	public static void initializeGlider(boolean[][]world) {

		// TODO: Implement this method		

		//initialize to all false values
		GameOfLife.clearWorld(world); 

		//in the world set specific cells to true that are alive for the 
		//glider pattern
		world[1][1] = true;
		world[2][2] = true;
		world[2][3] = true;
		world[3][1] = true;
		world[3][2] = true;

	}

	/**
	 * Initializes the world to the Beacon pattern.
	 * <pre>
	 * ..........
	 * .@@.......
	 * .@........
	 * ....@.....
	 * ...@@.....
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * </pre> 
	 * @param world the existing double dimension array that will be 
	 * reinitialized to the Beacon pattern.
	 */		
	public static void initializeBeacon(boolean[][] world) {

		// TODO: Implement this method				
		//initialize to all false values
		GameOfLife.clearWorld(world); 
		//in the world set the cells to true that are alive for the 
		// Beacon pattern.
		world[1][1] = true;
		world[1][2] = true;
		world[2][1] = true;
		world[3][4] = true;
		world[4][3] = true;
		world[4][4] = true;

	}

	/**
	 * Initializes the world to the Boat pattern.
	 * <pre>
	 * ..........
	 * .@@.......
	 * .@.@......
	 * ..@.......
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * </pre> 
	 * @param world the existing double dimension array that will be 
	 * reinitialized to the Boat pattern.
	 */		
	public static void initializeBoat(boolean[][] world) {
		// TODO: Implement this method
		//initialize to all false values
		GameOfLife.clearWorld(world); 

		//in the world set the cells to true that are alive for the 
		// Boat pattern.		
		world[1][1] = true;
		world[1][2] = true;
		world[2][1] = true;
		world[2][3] = true;
		world[3][2] = true;

	}	
	/**
	 * Initializes the world to the R-pentomino pattern.
	 * <pre>
	 * ..........
	 * ..@@......
	 * .@@.......
	 * ..@.......
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * </pre> 
	 * @param world the existing double dimension array that will be 
	 * reinitialized to the R-pentomino pattern.
	 */		
	public static void initializeRpentomino(boolean[][] world) {
		// TODO: Implement this method
		//initialize to all false values
		GameOfLife.clearWorld(world); 

		//in the world set the cells to true that are alive for the 
		// R-pentomino pattern.		
		world[1][2] = true;
		world[1][3] = true;
		world[2][1] = true;
		world[2][2] = true;
		world[3][2] = true;

	}	
	/**
	 * Initialize the GameOfLife world with a random selection of cells alive. 
	 * 
	 * @param world  the existing double dimension array that will be 
	 * reinitialized to a Random pattern.
	 */	
	public static void initializeRandomWorld(boolean[][] world){
		// TODO: Implement this method	    	

		//initialize to all false values
		GameOfLife.clearWorld(world);
		//loop through every row
		for (int i = 0; i < world.length; i++){
			//here we are within a row, so loop through every column
			for (int j = 0; j < world[i].length; j++){
				//for the cell in the specific row and column, give it a 
				//true value 'Config.CHANCE_ALIVE' percent of the time.
				//(hint: if Config.CHANCE_ALIVE is 0.25, then there should be 
				// about a 25% chance this cell is alive.  
				// Recall that the nextDouble() method from the java.util.Random 
				// class returns a uniformly distributed double value between 
				// 0.0 and 1.0.)            	

				if( Config.RNG.nextDouble() < Config.CHANCE_ALIVE) {
					//set cell to be alive
					world[i][j] = true;
				}
			}
		}
	}

	/** 
	 * Whether a cell is living in the next generation of the game.
	 * 
	 * The rules of the game are as follows:
	 * 1) Any live cell with fewer than two live neighbors dies, as if caused
	 *    by under-population.
	 * 2) Any live cell with two or three live neighbors lives on to the next 
	 *    generation.
	 * 3) Any live cell with more than three live neighbors dies, as if by 
	 *    overcrowding.
	 * 4) Any dead cell with exactly three live neighbors becomes a live cell, 
	 *    as if by reproduction.
	 * 
	 * @param numLivingNeighbors The number of neighbors that are currently
	 *        living.
	 * @param cellCurrentlyLiving Whether the cell is currently living.
	 * 
	 * @return True if this cell is living in the next generation.    
	 */
	public static boolean isCellLivingInNextGeneration( int numLivingNeighbors, 
			boolean cellCurrentlyLiving) {
		// TODO: Implement this method
		if ((cellCurrentlyLiving == true) && (numLivingNeighbors < 2 || 
				numLivingNeighbors > 3)){
			return false;
		}
		else if ((cellCurrentlyLiving == true)&&(numLivingNeighbors == 2||
				numLivingNeighbors == 3)){
			return true;
		}
		else if((cellCurrentlyLiving == false)&&(numLivingNeighbors == 3)){
			return true;
		}
		else return false;

	}


	/**
	 * Whether a specific neighbor is alive.
	 *
	 * Check whether the specific cell is alive or dead.
	 * 
	 * Note that cellRow and cellColumn may not be valid. If the cellRow is 
	 * less than 0 or greater than the number of rows -1 
	 * then the cell is outside the world. If the cellColumn is less than 0 
	 * or is greater than the number of columns -1 then 
	 * the cell is outside the world. Return false for any cell outside the 
	 * world.
	 * 
	 * @param world The current world.
	 * @param neighborCellRow The row of the cell which we are wanting to know
	 *  is alive.
	 * @param neighborCellColumn The column of the cell for which we are wanting
	 *  to know is alive.
	 * 
	 * @return Whether the cell is alive.
	 */	
	public static boolean isNeighborAlive(boolean [][]world, int 
			neighborCellRow, 
			int neighborCellColumn) {

		// TODO: Implement this method    	
		//if valid row index
		if (neighborCellRow < 0 || neighborCellRow > (world.length - 1)){
			return false;	
		}
		//if valid column index
		if (neighborCellColumn < 0 || neighborCellColumn > 
		(world[0].length - 1)){
			return false;	
		}

		else if (world[neighborCellRow][neighborCellColumn] == true){
			return true;
		}
		else return false;

	}

	/**
	 * Counts the number of neighbors that are currently living around the 
	 * specified cell.
	 *
	 * A cell has eight neighbors. The neighbors are the cells that are 
	 * horizontally, vertically and diagonally adjacent.
	 * 
	 * Note that if a specific cell is on the edge of the world then it may not 
	 * have neighboring cells.  For example: for the 0'th row (top row) of the 
	 * world there are not any rows above it.
	 * Assume all those cells are dead (have false values).
	 * 
	 * @param world The current world.
	 * @param cellRow The row of the cell for which we are looking for neighbors.
	 * @param cellColumn The column of the cell for which we are looking for 
	 * neighbors.
	 * 
	 * @return The number of neighbor cells that are currently living.
	 */
	public static int numNeighborsAlive(boolean[][] world, int cellRow, 
			int cellColumn) {
		// TODO: Implement this method		
		int aliveNeighbors = 0;
		//neighbors in the row above
		if (GameOfLife.isNeighborAlive(world, cellRow-1, cellColumn-1)){
			aliveNeighbors++;
		}
		if (GameOfLife.isNeighborAlive(world, cellRow-1, cellColumn)){
			aliveNeighbors++;
		}
		if (GameOfLife.isNeighborAlive(world, cellRow-1, cellColumn+1)){
			aliveNeighbors++;
		}
		//neighbors in the row below
		if (GameOfLife.isNeighborAlive(world, cellRow+1, cellColumn-1)){
			aliveNeighbors++;
		}
		if (GameOfLife.isNeighborAlive(world, cellRow+1, cellColumn)){
			aliveNeighbors++;
		}
		if (GameOfLife.isNeighborAlive(world, cellRow+1, cellColumn+1)){
			aliveNeighbors++;
		}
		//neighbor to the left
		if (GameOfLife.isNeighborAlive(world, cellRow, cellColumn-1)){
			aliveNeighbors++;
		}
		//neighbor to the right
		if (GameOfLife.isNeighborAlive(world, cellRow, cellColumn+1)){
			aliveNeighbors++;
		}
		return aliveNeighbors;
	}

	/**
	 * Determines the next generation of the world.
	 * 
	 * @param currentWorld The world currently shown. 
	 * @param newWorld The new world to determine by looking at
	 * each cells neighbors in the current world. 
	 */
	public static void nextGeneration(boolean[][] currentWorld, boolean[][] 
			newWorld) {
		// TODO: Implement this method		
		//for each row
		for (int row = 0; row < currentWorld.length; row++){
			//for each column
			for (int column = 0; column < currentWorld[row].length; column++){
				//determine the number of neighbors that are alive for the 
				//specific cell
				int numAliveNeighbors = GameOfLife.numNeighborsAlive(
						currentWorld, row, column);
				//determine whether the cell should be alive the next generation
				boolean nextGenAlive = GameOfLife.isCellLivingInNextGeneration(
						numAliveNeighbors, currentWorld[row][column]);
				newWorld[row][column] = nextGenAlive;
			}
		}

		//determine whether the cell should be alive the next generation

	}

	/**
	 * Prints out the world showing each cell as alive or dead.
	 * 
	 * Loops through every cell of the world. If a cell is alive, print out
	 * the Config.ALIVE character, otherwise the Config.DEAD character. 
	 * 
	 * Tracks how many cells are alive and prints out the number of cells alive
	 * or that no cells are alive.
	 * 
	 * @param patternName The name of the pattern chosen by the user. 
	 * @param world The array representation of the current world. 
	 * @param generationNum The number of the current generation.  
	 */    
	public static void printWorld( String patternName, boolean[][] world, 
			int generationNum) {
		// TODO: Implement this method    	
		//declare and initialize local variables
		int numberAlive = 0;
		//print out pattern and generation
		System.out.println("\n"+patternName+" generation: "+generationNum);
		//for each row in the world
		for (int i = 0; i < world.length; i++){
			//for each column in the world
			for (int j = 0; j < world[i].length; j++){
				//if the cell is alive
				if (world[i][j] == true){
					System.out.print(Config.ALIVE);
					numberAlive++;
				}
				//otherwise if the cell is dead.
				else if (world[i][j] == false){
					System.out.print(Config.DEAD);
					;
				}
			}
			System.out.print("\n");
		}
		//print out the number of cells alive.
		System.out.println(numberAlive+" cells are alive\n");
	}
}