package git_garcasonne;

public class Card
{

	int m_iCardNumber;
	int[][] m_iArLandscape;

	public Card( int _iCardNumber, int[][] _iArLandscape )
	{
		m_iCardNumber = _iCardNumber;
		m_iArLandscape = _iArLandscape;
	}
	
	public int[][] getLandscape()
	{
		return m_iArLandscape;
	}
	
	public void turnRight()
	{
		int[][] turnedLandscape = new int[5][5];
		for( int i = 0; i < m_iArLandscape.length; i++ )
		{
			for( int j = 0; j < m_iArLandscape[0].length; j++ )
			{
				turnedLandscape[j][(m_iArLandscape[0].length-i-1)] = m_iArLandscape[i][j];
			}
		}
		m_iArLandscape = turnedLandscape; 
	}
	
	public void turnLeft()
	{
		turnRight();
		turnRight();
		turnRight();
	}
	
	
	
	


}

