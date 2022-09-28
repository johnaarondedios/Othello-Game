//John De Dios period 3

import java.util.ArrayList;

public class BoundedGrid implements Grid
{
	private String[][] board;

	//----------------------------------------------------------------------------
	public BoundedGrid(int size)
	{

		board = new String[size][size];
	}
	//----------------------------------------------------------------------------
	//Precondition:
	//Postcondition: Returns the number of rows in this grid.
	public int getNumRows()
	{

		return board.length;
	}

	//----------------------------------------------------------------------------
	//Precondition:
	//Postcondition: Returns the number of columns in this grid.
	public int getNumCols()
	{

		return board[0].length;
	}

	//----------------------------------------------------------------------------
	//Precondition:  loc is not null
	//Postcondition: Returns true if loc is valid in this grid, false otherwise
	public boolean isValid(Location loc)
	{
		
		if (loc.getRow() >= 0 && loc.getRow() < getNumRows())
		{
			if (loc.getCol() >= 0 && loc.getCol() < getNumCols())
			{
				return true;
			}
		}
		
		return false;
		
		
	}
	//----------------------------------------------------------------------------
	//Precondition:  (1) loc is valid in this grid
	//				 (2) theColor is not null
	//Postcondition:  Puts the String object at loc.
	//				  Returns the object previously at that location.
	public String put(Location loc, String theColor)
	{

		String holdString = board[loc.getRow()][loc.getCol()];
		board[loc.getRow()][loc.getCol()] = theColor;
		
		return holdString;
	}
	//----------------------------------------------------------------------------
	//Precondition:  (1) loc is valid in this grid
    //Postcondition: Removes the object at loc.
    //				 returns the object that was removed or null if the location is unoccupied
    public String remove(Location loc)
    {

    	String holdString = board[loc.getRow()][loc.getCol()];
    	board[loc.getRow()][loc.getCol()] = null;
    	
    	return holdString;
    }

	//----------------------------------------------------------------------------
	//Precondition:  loc is valid in this grid
	//Postcondition: Returns the String at loc or null if the location is unoccupied.
	public String get(Location loc)
	{

		return board[loc.getRow()][loc.getCol()];
	}
	//----------------------------------------------------------------------------
	//Precondition:
	//Postcondition:  returns an ArrayList of all occupied locations in this grid
    public ArrayList<Location> getOccupiedLocs()
	{

    	ArrayList <Location> holdList = new ArrayList <Location>();
    	for (int r = 0; r < getNumRows(); r++)
    	{
    		for (int c = 0; c < getNumCols(); c++)
    		{
    			if (board[r][c] != null)
    			{
    				Location holdLoc = new Location(r, c);
    				holdList.add(holdLoc);
    			}
    		}
    	}
    	
    	return holdList;
	}

	//----------------------------------------------------------------------------
	//Precondition:  loc is valid in this grid
	//Postcondition: returns an ArrayList of valid locations adjacent to loc in
	//				 all eight compass directions (north, northeast, east, southeast,
	//				 south, southwest,west, and northwest).
	public ArrayList<Location> getValidAdjacentLocations(Location loc)
    {

		ArrayList <Location> holdList = new ArrayList <Location>();
		
		if(loc.getAdjacentLoc(Location.NORTH).getRow() >= 0 && loc.getAdjacentLoc(Location.NORTH).getRow() < board.length)
		{
			if(loc.getAdjacentLoc(Location.NORTH).getCol() >= 0 && loc.getAdjacentLoc(Location.NORTH).getCol() < board[0].length)
			{
				holdList.add(loc.getAdjacentLoc(Location.NORTH));
			}
		}
		
		if(loc.getAdjacentLoc(Location.SOUTH).getRow() >= 0 && loc.getAdjacentLoc(Location.SOUTH).getRow() < board.length)
		{
			if(loc.getAdjacentLoc(Location.SOUTH).getCol() >= 0 && loc.getAdjacentLoc(Location.SOUTH).getCol() < board[0].length)
			{
				holdList.add(loc.getAdjacentLoc(Location.SOUTH));
			}
		}
		
		if(loc.getAdjacentLoc(Location.EAST).getRow() >= 0 && loc.getAdjacentLoc(Location.EAST).getRow() < board.length)
		{
			if(loc.getAdjacentLoc(Location.EAST).getCol() >= 0 && loc.getAdjacentLoc(Location.EAST).getCol() < board[0].length)
			{
				holdList.add(loc.getAdjacentLoc(Location.EAST));
			}
		}
		
		if(loc.getAdjacentLoc(Location.WEST).getRow() >= 0 && loc.getAdjacentLoc(Location.WEST).getRow() < board.length)
		{
			if(loc.getAdjacentLoc(Location.WEST).getCol() >= 0 && loc.getAdjacentLoc(Location.WEST).getCol() < board[0].length)
			{
				holdList.add(loc.getAdjacentLoc(Location.WEST));
			}
		}
		
		if(loc.getAdjacentLoc(Location.NORTHEAST).getRow() >= 0 && loc.getAdjacentLoc(Location.NORTHEAST).getRow() < board.length)
		{
			if(loc.getAdjacentLoc(Location.NORTHEAST).getCol() >= 0 && loc.getAdjacentLoc(Location.NORTHEAST).getCol() < board[0].length)
			{
				holdList.add(loc.getAdjacentLoc(Location.NORTHEAST));
			}
		}
		
		if(loc.getAdjacentLoc(Location.NORTHWEST).getRow() >= 0 && loc.getAdjacentLoc(Location.NORTHWEST).getRow() < board.length)
		{
			if(loc.getAdjacentLoc(Location.NORTHWEST).getCol() >= 0 && loc.getAdjacentLoc(Location.NORTHWEST).getCol() < board[0].length)
			{
				holdList.add(loc.getAdjacentLoc(Location.NORTHWEST));
			}
		}
		
		if(loc.getAdjacentLoc(Location.SOUTHEAST).getRow() >= 0 && loc.getAdjacentLoc(Location.SOUTHEAST).getRow() < board.length)
		{
			if(loc.getAdjacentLoc(Location.SOUTHEAST).getCol() >= 0 && loc.getAdjacentLoc(Location.SOUTHEAST).getCol() < board[0].length)
			{
				holdList.add(loc.getAdjacentLoc(Location.SOUTHEAST));
			}
		}
		
		if(loc.getAdjacentLoc(Location.SOUTHWEST).getRow() >= 0 && loc.getAdjacentLoc(Location.SOUTHWEST).getRow() < board.length)
		{
			if(loc.getAdjacentLoc(Location.SOUTHWEST).getCol() >= 0 && loc.getAdjacentLoc(Location.SOUTHWEST).getCol() < board[0].length)
			{
				holdList.add(loc.getAdjacentLoc(Location.SOUTHWEST));
			}
		}
		
		return holdList;
    }

	//----------------------------------------------------------------------------

    //Precondition:  loc is valid in this grid
	//Postcondition: returns an ArrayList of valid empty locations adjacent to loc
	//				 in all eight compass directions (north, northeast, east,
	//				 southeast, south, southwest, west, and northwest).
    public ArrayList<Location> getEmptyAdjacentLocations(Location loc)
    {

    	ArrayList <Location> holdList = getValidAdjacentLocations(loc);
    	ArrayList <Location> newList = new ArrayList <Location>();
    	
    	for (int i = 0; i < holdList.size(); i++)
    	{
    		if(board[holdList.get(i).getRow()][holdList.get(i).getCol()] == null)
    		{
    			newList.add(holdList.get(i));
    		}
    	}
    	
    	return newList;
    }


	//----------------------------------------------------------------------------
	//Precondition:	  loc is valid in this grid
	//Postcondition:  returns an ArrayList of valid occupied locations adjacent to
	//				  loc in all eight compass directions (north, northeast, east,
	//				  southeast, south, southwest, west, and northwest).
   	public ArrayList<Location> getOccupiedAdjacentLocs(Location loc)
	{


   		ArrayList <Location> holdList = getValidAdjacentLocations(loc);
    	ArrayList <Location> newList = new ArrayList <Location>();
    	
    	for (int i = 0; i < holdList.size(); i++)
    	{
    		if(board[holdList.get(i).getRow()][holdList.get(i).getCol()] != null)
    		{
    			newList.add(holdList.get(i));
    		}
    	}
    	
    	return newList;
   		
		
	}



	//----------------------------------------------------------------------------
	//Postcondition: displays the board and its values onto the screen.
	public void display()
	{
		System.out.println();
		System.out.print(String.format("%4s", " "));
		for (int i = 0; i < board[0].length; i++)
			System.out.print(String.format("%4d", i));

		System.out.println("\n");

		for (int i = 0; i < board.length; i++)
		{
			System.out.print(String.format("%4d", i));
			for (int j = 0; j < board[0].length; j++)
			{
				if (board[i][j] != null)
					System.out.print(String.format("%4s", board[i][j]));
				else
					System.out.print(String.format("%4s", "."));
			}
			System.out.println("\n");
		}

		System.out.println();
	}

	//----------------------------------------------------------------------------
}