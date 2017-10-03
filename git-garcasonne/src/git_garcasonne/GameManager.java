package git_garcasonne;

public class GameManager {
	
	private int iPlayerAmount;
	Player[] PlayerArray;
	Player activePlayer;
	int active = 0;	
	Card[] [] grid;
	Game game;

	GameManager(Game game, Card [][] grid)
	{
		this.grid = grid;
		this.game = game;
	}
	
	public int getPlayerAmount() 
	{
		return iPlayerAmount;
	}
	
	public void startGame(CardHandler CardHandler)
	{
				CardHandler.loadCards();
				CardHandler.setIntCardsLeft(CardHandler.getSummOfAllCards());
				CardHandler.fillGrid(game.getXCards(), game.getYCards(), grid);
				createPlayer(getPlayerAmount());
				createMap();
				while (CardHandler.getIntCardsLeft() != 0)
				{
					
					//PlayerArray[active].makeMove(CardHandler.giveRandomCard());
					checkPoints();
					if(active < getPlayerAmount()-1)
					{
						active++;
					} else
					{
						active = 0;
					}
					CardHandler.setIntCardsLeft(CardHandler.getIntCardsLeft()-1);
				}
				endGame();
		}
		//NEEEEEEEEEEEEEEEEEEEEEEU!!!!!!!!!!!!!!
	
	
	public void createPlayer(int PlayerAmount)
	{
		Player player[] = new Player[PlayerAmount];
		for (int i = 0; i < PlayerAmount; i++)
		{
			player[i] = new Player(i);
			
		}
		PlayerArray = player;
	}
	
	public void endGame()
	{
		//Gewinner Ausgeben!
	}
	
	public void setPlayerAmount(int PlayerAmount)
	{
		iPlayerAmount = PlayerAmount;
	}
	
	public int getActive()
	{
		return active;
	}
	
	public void checkPoints()
	{
		//Gucken welcher Spieler wieviele Punklte bekommt und dann die AddPoints Funktion der 
		//Spieler aufrufen
	}
	
	public void createMap()
	{
		
	}

}
