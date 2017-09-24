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
		Screen screen = new Screen();
		STAGE = stage;
		
		//Different Ingame-Windows
		Scene scene_game = new Scene(screen.createGame(Game.this));
		Scene scene_menu = new Scene(screen.createMenu(Game.this));

		GAME = scene_game;
		MENU = scene_menu;
		
		//Read and load Cards
		CardHandler CardHandler= new CardHandler(Game.this);
		CardHandler.loadCards();
	
		stage.setTitle("Carcasonne");
		stage.setScene(scene_menu);
		stage.show();	
	}
}
