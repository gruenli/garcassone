package git_garcasonne;

public class Player {
	
	private int m_iPoints;
	private int m_iNumber;
	private String m_strName;
	private int m_iPawn;
	
	// Konstruktor
	public Player( int _iNumber )
	{
		m_iNumber = _iNumber;
	}
	
	
	void addPoints( int iPoints )
	{
		m_iPoints += iPoints;
	}
	
	void setName( String _strName )
	{
		m_strName = _strName;
	}
	
	
	
}	
	
	
