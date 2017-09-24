package git_garcasonne;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Screen
{
	public Parent createMenu(Game game)
	{
		Pane menu_pane = new Pane();
		menu_pane.setPrefSize(game.getWidth() + game.getPuffer(), game.getHeigth());
		
		Button startgame = new Button("START");
		startgame.setOnAction(e -> switchScenes(2, game));
		
		Button exit = new Button("EXIT");
		exit.setOnAction(e -> Platform.exit());
		exit.setLayoutX(100);
		
		menu_pane.getChildren().addAll(startgame,exit);
		return menu_pane;
	}
	
	public Parent createGame(Game game)
	{
		Pane game_pane = new Pane();
		game_pane.setPrefSize(game.getWidth() + game.getPuffer(), game.getHeigth());
			
		Button menu = new Button("Menu");
		menu.setOnAction(e -> switchScenes(1, game));
		menu.setLayoutX(1210);
		
		game_pane.getChildren().add(menu);
		
		return game_pane;
	}
	
	//Scene-Manager
	public void switchScenes(int a, Game game)
	{
		switch (a){
		case 1:	a=1;
				game.getSTAGE().setScene(game.getMENU());
				break;
		case 2:	a=2;
				game.getSTAGE().setScene(game.getGAME());
				break;
		}
	}	
}
