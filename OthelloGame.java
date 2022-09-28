//John De Dios period 3

import java.util.ArrayList;

public class OthelloGame
{
	private OthelloPlayer humanPlayer;		//human Othello player
	private OthelloPlayer compPlayer;		//computer Othello player
	private Grid board;						//board

	//----------------------------------------------------------------------------------
	public OthelloGame()
	{
	
		//testing entire game with a 4 x 4
		//board = new BoundedGrid(4);

		//testing entire game with an 8 x8 instead of 4 x 4. Try this after 4 x 4 works.
		board = new BoundedGrid(8);

		//initialize the humanPlayer object
		humanPlayer = new HumanOthelloPlayer("Human", "B");
		//initialize the compPlayer object
		compPlayer = new StupidComputerPlayer("Computer", "W");

		initializeBoard();
	}
	//----------------------------------------------------------------------------------
	//Description:  This method places the "B"'s and "W"'s in the appropriate 
	// 				place on the game board. Pretend you don't know the size of 
	// 				the board - i.e. write generically.

	//Postcondition: "B"'s and "W"'s are placed in the appropriate place on the
	//				 board.

	private void initializeBoard()
	{
		Location blackOne = new Location((board.getNumRows() / 2) - 1, (board.getNumCols() / 2) - 1);
		Location blackTwo = new Location((board.getNumRows() / 2), (board.getNumCols() / 2));
		Location whiteOne = new Location((board.getNumRows() / 2) - 1, (board.getNumCols() / 2));
		Location whiteTwo = new Location((board.getNumRows() / 2), (board.getNumCols() / 2) - 1);
		
		board.put(blackOne, "B");
		board.put(blackTwo, "B");
		board.put(whiteOne, "W");
		board.put(whiteTwo, "W");
	}
	//----------------------------------------------------------------------------------
	/*
	The playGame method (below) has the players alternate moves until the board is filled or both
	players have no legal moves.  A winner is then declared.

	When it's the human's turn, all legal moves are displayed on the screen.  If there are legal
	moves, the human is asked for a move (in another method).  The move is made and the board is
	reconfigured according to the rules of the game.  If there are no legal moves, display a message
	stating there are no legal moves. Switch the player.

	When it's the computer's turn, all legal moves are displayed on the screen.  If there are legal
	moves, a random move is selected (not in this method).   The move is made and the board is
	reconfigured according to the rules of the game.  If there are no legal moves display a message
	stating there are no legal moves. Switch the player.

	This method calls other methods to help do its job.
	*/

	public void playGame()
	{
		//your local variables that are needed go here.
		int boardSize = board.getNumCols()*board.getNumRows();
		OthelloPlayer turn = humanPlayer;
		Location chosenMove = null;
		int humanNum = 0;
		int compNum = 0;

		while (board.getOccupiedLocs().size() != boardSize && (getLegalMoves(humanPlayer.getColor()).size() != 0 || getLegalMoves(compPlayer.getColor()).size() != 0))	//keep playing while the game is not over
		{
			//display the board
			board.display();
			
			//display who is taking a turn
			System.out.println(turn.getName() + " - your turn");
			
			//Get the legal moves.
			//display the legal moves to the user or display no moves are left.
			System.out.println("legalMoves: " + getLegalMoves(turn.getColor()));
			System.out.println();

			//Get a VALID move from the list of legal moves just generated (or
			//no move if none exist)
			if (getLegalMoves(turn.getColor()).size() != 0)
			{	
				chosenMove = turn.getMove(getLegalMoves(turn.getColor()));
				System.out.println();
				
				//after a valid move chosen, make the move and display where the
				//current player has moved to
				System.out.println("MOVING TO: " + chosenMove);

				//update the board with the move taken.
				updateBoard(chosenMove, turn.getColor());
			}
			else
			{
				System.out.println("There are no moves possible for " + turn.getName());
			}


			//Check for a winner and provide code if a winner exists.			
			//switch the current player
			if (turn == humanPlayer)
			{
				turn = compPlayer;
			}
			else
			{
				turn = humanPlayer;
			}
		}
		
		board.display();
		
		for (int i = 0; i < board.getOccupiedLocs().size(); i++)
		{
			if (board.get(board.getOccupiedLocs().get(i)) == humanPlayer.getColor())
			{
				humanNum++;
			}
			else
			{
				compNum++;
			}
		}
		
		
		//Announce winner or tie
		if (humanNum > compNum)
		{
			System.out.println(humanPlayer.getName() + " wins!");
		}
		else if (compNum > humanNum)
		{
			System.out.println(compPlayer.getName() + " wins!");
		}
		else
		{
			System.out.println("It is a tie!");
		}
		
		System.out.println("Process completed.");
	}

	
	//----------------------------------------------------------------------------------
	public ArrayList<Location> getLegalMoves(String curColor)
	{
		//use your code from a previous section
		//your code here
				ArrayList <Location> legalMovesList = new ArrayList <Location>();
				ArrayList <Location> occList = board.getOccupiedLocs();
				
				for (int i = 0; i < occList.size(); i++)
				{
					if (board.get(occList.get(i)).equals(curColor))
					{
						ArrayList <Location> adjOccList = board.getOccupiedAdjacentLocs(occList.get(i));
													
						for (int x = 0; x < adjOccList.size(); x++) //CHECK ALL ADJACENT
						{
							if (!(board.get(adjOccList.get(x)).equals(curColor)))       //IF THE 1ST ADJACENT PIECE IS OPPOSITE COLOR
							{
								int direction = occList.get(i).getDirectionToward(adjOccList.get(x)); //KEEP GOING IN SAME DIRECTION
								
								Location next = adjOccList.get(x).getAdjacentLoc(direction);
								
								while (board.isValid(next) && board.get(next) != null && !(board.get(next).equals(curColor))) //WHILE NEXT PIECE IS VALID AND OPPOSITE COLOR						
								{
									next = next.getAdjacentLoc(direction);
								}
								
								if (board.isValid(next) && board.get(next) == null)
								{
									int check = 0;
									
									for (int a = 0; a < legalMovesList.size(); a++)
									{	
										if ((next.equals(legalMovesList.get(a))))
										{									
											check++;
										}
							        }
									    
									if (check == 0)
									{	
										legalMovesList.add(next);
									}	
								}
							}
						}
					}
				}
						
				return legalMovesList;
	}
	//----------------------------------------------------------------------------------

	public void updateBoard(Location nextMove, String targetString)
	{
		//use your code from a previous section
board.put(nextMove, targetString);                                               //FIXED FROM PSEUDO CODE
		
		ArrayList <Location> adjOccList = board.getOccupiedAdjacentLocs(nextMove);
		
		for (int i = 0; i < adjOccList.size(); i++)
		{
			boolean check = false;                                                       //START OF CHECK VARIABLE TO CHECK END
			
			if (!(board.get(adjOccList.get(i)).equals(targetString)))                       //IF THE 1ST ADJACENT PIECE IS OPPOSITE COLOR
			{
				int direction = nextMove.getDirectionToward(adjOccList.get(i));
				
				Location next = adjOccList.get(i).getAdjacentLoc(direction);
				
				while (board.isValid(next) && board.get(next) != null && !(board.get(next).equals(targetString))) //WHILE NEXT PIECE IS VALID AND OPPOSITE COLOR						
				{
					next = next.getAdjacentLoc(direction);
				}
				
				if (board.isValid(next) && board.get(next) != null && board.get(next).equals(targetString))
				{
										
					Location next2 = adjOccList.get(i);                              //CHANGE OF PSEUDO CODE - START FLIPPING HERE
					
					while (board.isValid(next2) && board.get(next2) != null && !(board.get(next2).equals(targetString))) //WHILE NEXT PIECE IS VALID AND OPPOSITE COLOR						
					{
						board.put(next2, targetString);
						
						next2 = next2.getAdjacentLoc(direction);        
					}
				}
			}
		}
	}
	
}
