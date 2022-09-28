import java.util.ArrayList;
import java.util.Scanner;

//John De Dios period 3

public class HumanOthelloPlayer extends OthelloPlayer
{

	
	public HumanOthelloPlayer (String inName, String inColor)
	{
		super (inName, inColor);
		

	}
	
	public Location getMove (ArrayList <Location> legalLocations)
	{
		
		boolean check = false;
		Scanner input = new Scanner(System.in);
		int row = 0;
		int col = 0;
		Location chosen = null;
		
		do
		{
			System.out.print("Enter row: ");
			row = input.nextInt();
			
			System.out.print("Enter col: ");
			col = input.nextInt();
			
			for (int i = 0; i < legalLocations.size(); i++)
			{
				if (legalLocations.get(i).getRow() == row && legalLocations.get(i).getCol() == col)
				{
					chosen = legalLocations.get(i);
					check = true;
				}
			}
			
			if (check == false)
			{
				System.out.println("Invalid move. Please re-enter");
			}
			
		} while (check == false);
		
		return chosen;
			
	}
	
}
