package git_garcasonne;

import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;

public class Game 
{
	private int iWidth = 1200;
	private int iHeigth = 900;
	private int iPuffer = 200;
	private static final int iXCards = 50;
	private static final int iYCards = 50;
	private Card [][] grid = new Card[iXCards][iYCards];

	
	Stage STAGE;
	Scene GAME;
	Scene MENU;
	Scene MAP;
	
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
	

	Game(Stage stage)
	{
		CardHandler CardHandler = new CardHandler(this);
		GameManager GameManager = new GameManager(this, grid);

		
		Screen screen = new Screen();
		Scene scene_game = new Scene(screen.createGame(this, GameManager, CardHandler));
		Scene scene_menu = new Scene(screen.createMenu(this, GameManager));
		Parent map_pane = screen.createMap(this, grid);
		Scene scene_map = new Scene( map_pane);
		
		STAGE = stage;
		GAME = scene_game;
		MENU = scene_menu;
		MAP = scene_map;

		stage.setTitle("Carcasonne");
		stage.setScene(scene_menu);
		stage.show();
	}
}
