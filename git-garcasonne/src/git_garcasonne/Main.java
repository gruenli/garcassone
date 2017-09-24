package git_garcasonne;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application 
{
	@Override
	public void start(Stage stage) throws Exception
	{
		Game game = new Game(stage);
		System.out.println("**********GIT-VERSION***********");
		System.out.println("**********First Upload***********");
	}
	
	public static void main(String[] args)
	{		
		launch(args);
	}
}

