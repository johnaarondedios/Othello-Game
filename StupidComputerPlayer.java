//John De Dios period 3

import java.util.ArrayList;

public class StupidComputerPlayer extends OthelloPlayer
{
	public StupidComputerPlayer (String inName, String inColor)
	{
		super (inName, inColor);
	}
	
	public Location getMove (ArrayList <Location> legalLocations)
	{
		int randomMove = (int) (Math.random() * legalLocations.size());
		
		return legalLocations.get(randomMove);
	}
}
