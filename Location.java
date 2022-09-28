//John De Dios

public class Location
{
	private int row;
	private int col;

	//COMPASS DIRECTIONS
	public static final int NORTH = 0;
	public static final int EAST = 90;
	public static final int SOUTH = 180;
	public static final int WEST = 270;
	public static final int NORTHEAST = 45;
	public static final int SOUTHEAST = 135;
	public static final int SOUTHWEST = 225;
	public static final int NORTHWEST = 315;

	public Location(int inRow, int inCol)
	{

		row = inRow;
		col = inCol;
	}


	//----------------------------------------------------------------------
	//Description:  Gets the row coordinate.
	//Postcondition:  returns the row of this location

	public int getRow()
	{

		return row;
	}


	//----------------------------------------------------------------------
	//Description:  Gets the column coordinate.
	//Postcondition: returns the column for this Location
	public int getCol()
	{

		return col;
	}


	//----------------------------------------------------------------------
	//Description:  Gets the adjacent location in any one of the eight
	//			    compass directions.
	//			    It is possible to return a Location that is out of bounds.
	//Precondition:  dir is one of the 8 compass directions.
	//Postcondition: returns the adjacent location in the direction that is closest to dir
	public Location getAdjacentLoc(int dir)
	{

		Location holdLoc = null;
		
		if (dir == NORTH)
		{
			holdLoc = new Location(row - 1, col);
		}
		if (dir == EAST)
		{
			holdLoc = new Location(row, col + 1);
		}
		if (dir == SOUTH)
		{
			holdLoc = new Location(row + 1, col);
		}
		if (dir == WEST)
		{
			holdLoc = new Location(row, col - 1);
		}
		if (dir == NORTHEAST)
		{
			holdLoc = new Location(row - 1, col + 1);
		}
		if (dir == SOUTHEAST)
		{
			holdLoc = new Location(row + 1, col + 1);
		}
		if (dir == SOUTHWEST)
		{
			holdLoc = new Location(row + 1, col - 1);
		}
		if (dir == NORTHWEST)
		{
			holdLoc = new Location(row - 1, col - 1);
		}
		
		return holdLoc;
	}


	//----------------------------------------------------------------------
	//Description: Returns the direction from this location toward another
	//             location. The direction is one of the eight compass
	//             directions.
	//Precondition:  target - a location that is different from this location.
	//			 	 target is an adjacent Location.
	//				 target is valid in the matrix
	//Postcondition: returns the closest compass direction from this location
	//				 toward target
	public int getDirectionToward(Location target)
	{
		int dir = 99;
		
		if(target.getRow() == row - 1 && target.getCol() == col)
		{
			dir = NORTH;
		}
		else if(target.getRow() == row && target.getCol() == col + 1)
		{
			dir = EAST;
		}
		else if(target.getRow() == row + 1 && target.getCol() == col)
		{
			dir = SOUTH;
		}
		else if(target.getRow() == row && target.getCol() == col - 1)
		{
			dir = WEST;
		}
		else if(target.getRow() == row - 1 && target.getCol() == col + 1)
		{
			dir = NORTHEAST;
		}
		else if(target.getRow() == row + 1 && target.getCol() == col + 1)
		{
			dir = SOUTHEAST;
		}
		else if(target.getRow() == row + 1 && target.getCol() == col - 1)
		{
			dir = SOUTHWEST;
		}
		else // is NORTHWEST
		{
			dir = NORTHWEST;
		}
		
		return dir;
	}


	//----------------------------------------------------------------------
	//override .equals method
	//Description: Determines if this Location is equal to otherLoc
	//Precondition: otherLoc is a Location object and is valid in the matrix
	//Postcondition: return true if otherLoc is a Location with the same row
	//               and column as this location; false otherwise.
	public boolean equals(Object otherLoc)
	{

		if (row == ((Location)(otherLoc)).getRow() && col == ((Location)(otherLoc)).getCol())
		{
			return true;
		}
		
		return false;
	}


	//----------------------------------------------------------------------
	//Postcondition: returns a String with the row and col of this location
	//				 in the format: (row, col)
	public String toString()
	{

		return ("(" + row + ", " + col + ")");
	}

}
