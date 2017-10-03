package git_garcasonne;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

public class Screen
{
	GameManager m_gameManager;
	Game m_game;
	int m_iWidth;
	int m_iHeigth;
	int m_iPuffer;
	
	public Screen( Game game, GameManager gameManager )
	{
		m_game = game;
		m_iWidth = game.getWidth();
		m_iHeigth = game.getHeigth();
		m_iPuffer = game.getPuffer();
		m_gameManager = gameManager;
	}
	
	public Parent createMenu()
	{
		Pane menu_pane = new Pane();
		menu_pane.setPrefSize( m_iWidth + m_iPuffer, m_iHeigth);
		
		Button startgame = new Button("START");
		startgame.setOnAction(e -> switchScenes(2));
		
		Button exit = new Button("EXIT");
		exit.setOnAction(e -> Platform.exit());
		exit.setLayoutX(600);
		
		Button playerAmount1 = new Button("1 Player");
		playerAmount1.setOnAction(e -> m_gameManager.setPlayerAmount(1));
		playerAmount1.setLayoutX(100);
		
		Button playerAmount2 = new Button("2 Players");
		playerAmount2.setOnAction(e -> m_gameManager.setPlayerAmount(2));
		playerAmount2.setLayoutX(200);
		
		Button playerAmount3 = new Button("3 Players");
		playerAmount3.setOnAction(e -> m_gameManager.setPlayerAmount(3));
		playerAmount3.setLayoutX(300);
		
		menu_pane.getChildren().addAll(startgame,exit, playerAmount1, playerAmount2, playerAmount3);
		return menu_pane;
	}
	
	public Parent createGame()
	{
		System.out.println("GAME ANGELEGT!!!!");
		Pane game_pane = new Pane();
		game_pane.setPrefSize(m_iWidth + m_iPuffer, m_iHeigth);
			
		Button menu = new Button("Menu");
		menu.setOnAction(e -> switchScenes(1));
		menu.setLayoutX(1210);
		
		Button startGame = new Button("Start the Game");
		startGame.setOnAction(e -> 
		{ 
			m_gameManager.startGame(); 
			switchScenes(3);
		});
		startGame.setLayoutX(110);
		
		game_pane.getChildren().addAll(menu, startGame);
		return game_pane;
	}
	
	public Parent createMap( Card [][] grid)
	{
		Pane map_pane = new Pane();
		map_pane.setPrefSize(m_iWidth + m_iPuffer, m_iHeigth);
		for( int i = 0; i < grid.length; i++ )
		{
			for( int j = 0; j < grid[0].length; j++ )
			{
				map_pane.getChildren().add( grid[i][j]);
			}
		}
		return map_pane;
	}

	//Scene-Manager
	public void switchScenes(int a)
	{
		switch (a){
		case 1:	a=1;
				m_game.getSTAGE().setScene(m_game.getMENU());
				break;
		case 2:	a=2;
				m_game.getSTAGE().setScene(m_game.getGAME());
				break;
		case 3: a=3;
				m_game.getSTAGE().setScene(m_game.getMAP());
				break;
		}
	}	
}