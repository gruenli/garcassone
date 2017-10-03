package git_garcasonne;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Card extends StackPane
{
	private Rectangle m_border;
	int m_iCardNumber;
	int[][] m_iArLandscape;
	int m_xPos;
	int m_yPos;
	int m_tileSize;

	public Card( int _iCardNumber, int[][] _iArLandscape )
	{
		m_iCardNumber = _iCardNumber;
		m_iArLandscape = _iArLandscape;
	}
	
	//Konstruktor für Dummicards
	public Card(int _xPos, int _yPos, int tileSize)
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
		m_xPos = _xPos;
		m_yPos = _yPos;
		m_tileSize = tileSize;
		m_border = new Rectangle( m_tileSize-2, m_tileSize-2 );
		m_border.setStroke(Color.ALICEBLUE);
		
		setTranslateX( m_xPos * m_tileSize);
		setTranslateY( m_yPos * m_tileSize);

		getChildren().add(m_border);
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

