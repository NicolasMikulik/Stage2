import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
	
		Stage window;
		Scene scene1, scene2;
		
		public static void main(String[] args) {
			launch(args);
		}
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			window = primaryStage;
			
			Label label = new Label("Welcome to the first scene!");
			Button button1 = new Button("Go to scene 2.");
			button1.setOnAction(e -> window.setScene(scene2));
			
			//Layout 1 = children are laid out in a vertical column
			VBox layout1 = new VBox(20);
			layout1.getChildren().addAll(label, button1);
			scene1 = new Scene(layout1, 200, 200); 
			
			//Button 2
			Button button2 = new Button("Return to the first scene.");
			button2.setOnAction(e -> window.setScene(scene1));
			
			//Layout 2
			StackPane layout2 = new StackPane();
			layout2.getChildren().add(button2);
			scene2 = new Scene(layout2, 600, 300);
			
			window.setScene(scene1);
			window.setTitle("Changing scenes");
			window.show();
		}
}

/*@Override
public void handle(ActionEvent event) {
	if (event.getSource() == button) {
		System.out.println("Mixing GUI with console.");
	}
}*/
