package git_garcasonne;

import javafx.stage.Stage;
import javafx.scene.Scene;

public class Game 
{
	private int iWidth = 1200;
	private int iHeigth = 900;
	private int iPuffer = 200;
	
	Stage STAGE;
	Scene GAME;
	Scene MENU;
	
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

	Game(Stage stage)
	{
		CardHandler CardHandler = new CardHandler(Game.this);
		GameManager GameManager = new GameManager(Game.this);
		
		Screen screen = new Screen();
		Scene scene_game = new Scene(screen.createGame(Game.this, GameManager, CardHandler));
		Scene scene_menu = new Scene(screen.createMenu(Game.this, GameManager));
		
		STAGE = stage;
		GAME = scene_game;
		MENU = scene_menu;

		stage.setTitle("Carcasonne");
		stage.setScene(scene_menu);
		stage.show();
	}
}
