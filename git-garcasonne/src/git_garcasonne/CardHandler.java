package git_garcasonne;

public class CardHandler 
{
	private int iCardAmountTotal;
	private int [][][] iArTestArray;
	
	//Change Array-Size depending on the total card amount 
	public void initialize(int CardAmountTotal)
	{
		iCardAmountTotal = CardAmountTotal;
		iArTestArray = new int [CardAmountTotal] [5] [5];
	}
	
	//Testfunction to check the card-array
	public void printArray()
	{
		System.out.println("Anzahl verschiedener Karten im System: " + iCardAmountTotal);
		for(int i = 0; i < iCardAmountTotal; i++)
		{
			System.out.println("Nächste Karte: ");
			for(int n = 0; n < 5; n++)
			{
				System.out.println("--------");
				for(int m = 0; m < 5; m++)
				{
					System.out.println( i + "," + n + "," + m + ": " + iArTestArray[i][n][m]);
				}
			}
		}
	}
	
	//Filling the card-array with information from the CardConstructor
	public void fillArray(int iCardNumber, int i, int s, int iArLandscape)
	{
		iArTestArray[iCardNumber][i][s] = iArLandscape;
	}

	CardHandler(Game game)
	{
		
	}
}
