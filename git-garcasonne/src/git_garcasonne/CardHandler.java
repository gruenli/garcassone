package git_garcasonne;



import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class CardHandler 
{
	private int [] m_iArCardAmount; 
	private int m_iCardAmountTotal;
	private int [][][] m_iArLandscape;
	private int iCardsLeft;
	private int iSummOfAllCards;
	
	//Change Array-Size depending on the total card amount 
	public void initialize(int CardAmountTotal)
	{
		m_iCardAmountTotal = CardAmountTotal;
		m_iArLandscape = new int  [CardAmountTotal] [5] [5];
		m_iArCardAmount = new int [CardAmountTotal];
	}
	
	//Testfunction to check the card-array
	public void printArray()
	{
		System.out.println("Anzahl verschiedener Karten im System: " + m_iCardAmountTotal);
		for(int i = 0; i < m_iCardAmountTotal; i++)
		{
			System.out.println("N�chste Karte: ");
			for(int n = 0; n < 5; n++)
			{
				System.out.println("--------");
				for(int m = 0; m < 5; m++)
				{
					System.out.println( i + "," + n + "," + m + ": " + m_iArLandscape[i][n][m]);
				}
			}
		}
	}
	
	//Filling the card-array with information from the CardConstructor
	public void fillArrays(int iCardNumber,int iCardAmount, int [][] iArLandscape)
	{
		m_iArLandscape[iCardNumber] = iArLandscape;
		m_iArCardAmount [iCardNumber] = iCardAmount;
		iSummOfAllCards += iCardAmount;
		
	}

	public void loadCards()
	{
		CardConstructor CardConstructor = new CardConstructor();
		CardConstructor.read(this);
		//printArray();
	}
	
	//NEEEEEEEEEEEEEEEEEEEEEEU!!!!!!!!!!!!!!
	public int getICardAmountTotal()
	{
		return m_iCardAmountTotal;
	}
	public int getIntCardsLeft()
	{
		return iCardsLeft;
	}
	
	public void setIntCardsLeft(int cardsleft)
	{
		iCardsLeft = cardsleft;
	}
	
	
	CardHandler(Game game)
	{
		game = game;
	}
	
	//NOCH NICHT FERTIG!!!
	public Card giveRandomCard() {
		
		int rndNum = (int) (Math.random() * m_iCardAmountTotal);
		//Checken ob gew�hlte Karte �berhaupt noch im Pool ist, sonst neue Karte w�hlen!
		Card card = new Card(rndNum, m_iArLandscape[rndNum] );
		//Karte noch aus KartenPool entfernen!!!!!!!!! HOFFE DASS DAS STIMMT!
		m_iArCardAmount[rndNum]--;
		return card;
	}
	
	public int getSummOfAllCards()
	{
		return iSummOfAllCards;
	}
	
	public void fillGrid(int xCards, int yCards,Card[][] grid)
	{
		for (int y = 0; y < yCards; y++)
		{
			for (int x = 0; x < xCards; x++)
			{
				Card card = new Card();
				grid[x][y] = card;
				
			}
		}
	}
	//NEEEEEEEEEEEEEEEEEEEEEEU!!!!!!!!!!!!!!
}
