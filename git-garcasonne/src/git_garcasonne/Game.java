package git_garcasonne;

import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;

public class Game 
{
	private final int iWidth = 1200;
	private final int iHeigth = 900;
	private final int iPuffer = 200;
	private static final int iXCards = 5;
	private static final int iYCards = 5;
	
	private Card [][] grid = new Card[iXCards][iYCards];
	
	private Stage STAGE;
	private Scene GAME;
	private Scene MENU;
	private Scene MAP;
	private Screen screen;
	
	public int getXCards()
	{
		return iXCards;
	}
	public int getYCards()
	{
		return iYCards;
	}
	public int getWidth()
	{
		return iWidth;
	}
	public int getHeigth()
	{
		return iHeigth;
	}
	public int getPuffer()
	{
		return iPuffer;
	}
	public Stage getSTAGE()
	{
		return STAGE;
	}
	public Scene getGAME()
	{
		return GAME;
	}
	public Scene getMENU()
	{
		return MENU;
	}
	public Scene getMAP()
	{
		return MAP;
	}
	public Screen getScreen()
	{
		return screen;
	}
	

	Game(Stage stage)
	{
		CardHandler CardHandler = new CardHandler(this);
		CardHandler.fillGrid(iXCards, iYCards, grid);
		GameManager GameManager = new GameManager(this, grid, CardHandler);
		
		Screen screen = new Screen( this, GameManager);
		STAGE = stage;
		GAME = new Scene(screen.createGame());
		MENU = new Scene(screen.createMenu());
		MAP = new Scene( screen.createMap(grid));
		
		stage.setTitle("Carcasonne");
		stage.setScene(MENU);
		stage.show();
	}
}
