package git_garcasonne;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Card
{
	private Rectangle border = new Rectangle(80,80);
	

	int m_iCardNumber;
	int[][] m_iArLandscape;

	public Card( int _iCardNumber, int[][] _iArLandscape )
	{
		m_iCardNumber = _iCardNumber;
		m_iArLandscape = _iArLandscape;
	}
	
	public Card()
	{
		m_iArLandscape = new int [5][5];
		for (int y = 0; y < 5; y++)
		{
			for (int x = 0; x < 5; x++)
			{
				m_iArLandscape[y][x] = 5;
			}
		}
		m_iCardNumber = 99;
		border.setStroke(Color.ALICEBLUE);
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

