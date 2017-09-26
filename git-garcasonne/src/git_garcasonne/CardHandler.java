package git_garcasonne;

import javafx.scene.layout.Pane;

public class CardHandler 
{
	private int [] m_iArCardAmount; 
	private int m_iCardAmountTotal;
	private int [][][] m_iArLandscape;
	
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
			System.out.println("Nächste Karte: ");
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
	}

	public void loadCards()
	{
		CardConstructor CardConstructor = new CardConstructor();
		CardConstructor.read(this);
		printArray();
	}
	
	//TEST
	public void nextCard(Pane pane)
	{
		
	}
	
	CardHandler(Game game)
	{
		
	}
}
