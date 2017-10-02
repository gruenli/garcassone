package git_garcasonne;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Screen
{
	public Parent createMenu(Game game, GameManager GameManager)
	{
		Pane menu_pane = new Pane();
		menu_pane.setPrefSize(game.getWidth() + game.getPuffer(), game.getHeigth());
		
		Button startgame = new Button("START");
		startgame.setOnAction(e -> switchScenes(2, game));
		
		Button exit = new Button("EXIT");
		exit.setOnAction(e -> Platform.exit());
		exit.setLayoutX(600);
		
		//NEEEEEEEEEEEEEEEEEEEEEEU!!!!!!!!!!!!!!
		Button playerAmount1 = new Button("1 Player");
		playerAmount1.setOnAction(e -> GameManager.setPlayerAmount(1));
		playerAmount1.setLayoutX(100);
		
		Button playerAmount2 = new Button("2 Players");
		playerAmount2.setOnAction(e -> GameManager.setPlayerAmount(2));
		playerAmount2.setLayoutX(200);
		
		Button playerAmount3 = new Button("3 Players");
		playerAmount3.setOnAction(e -> GameManager.setPlayerAmount(3));
		playerAmount3.setLayoutX(300);
		//NEEEEEEEEEEEEEEEEEEEEEEU!!!!!!!!!!!!!!
		
		menu_pane.getChildren().addAll(startgame,exit, playerAmount1, playerAmount2, playerAmount3);
		return menu_pane;
	}
	
	public Parent createGame(Game game, GameManager GameManager, CardHandler CardHandler)
	{
		System.out.println("GAME ANGELEGT!!!!");
		Pane game_pane = new Pane();
		game_pane.setPrefSize(game.getWidth() + game.getPuffer(), game.getHeigth());
			
		Button menu = new Button("Menu");
		menu.setOnAction(e -> switchScenes(1, game));
		menu.setLayoutX(1210);
		
		Button startGame = new Button("Start the Game");
		startGame.setOnAction(e -> startGame(GameManager,CardHandler));
		startGame.setLayoutX(110);
		
		game_pane.getChildren().addAll(menu, startGame);

		return game_pane;
	}

	//NEEEEEEEEEEEEEEEEEEEEEEU!!!!!!!!!!!!!!
	public void startGame(GameManager GameManager, CardHandler CardHandler)
	{
			CardHandler.loadCards();
			CardHandler.setIntCardsLeft(CardHandler.getICardAmountTotal());
			
			while (CardHandler.getIntCardsLeft() != 0)
			{
				if(CardHandler.getIntCardsLeft() == CardHandler.getICardAmountTotal())
				{
					GameManager.createPlayer(GameManager.getPlayerAmount());
					GameManager.startGame();
				}
				//Hier vielleicht gameManeger.getActivePlayer(player, player2) ... mal gucken!
				//player.getActiveplayer().makeMove(CardHandler.giveRandomCard());
				//GameManager.checkPoints(GameManager.getActivePlayer(player, player2));
				CardHandler.setIntCardsLeft(CardHandler.getIntCardsLeft()-1);
			}
			GameManager.endGame();
	}
	//NEEEEEEEEEEEEEEEEEEEEEEU!!!!!!!!!!!!!!
		
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
