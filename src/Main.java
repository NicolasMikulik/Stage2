import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{
	
		Stage window;
		Button button;
		
		public static void main(String[] args) {
			launch(args);
		}
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			window = primaryStage;
			window.setTitle("thenewboston");
			
			HBox topMenu = new HBox(10);
			Button buttonA = new Button("File");
			Button buttonB = new Button("Edit");
			Button buttonC = new Button("View");
			topMenu.getChildren().addAll(buttonA, buttonB, buttonC);
			
			VBox leftMenu = new VBox(10);
			Button buttonD = new Button("D");
			Button buttonE = new Button("E");
			Button buttonF = new Button("F");
			leftMenu.getChildren().addAll(buttonD, buttonE, buttonF);
			
			BorderPane borderPane = new BorderPane();
			borderPane.setTop(topMenu);
			borderPane.setLeft(leftMenu);
			
			Scene scene = new Scene(borderPane, 300, 250);
			window.setScene(scene);
			window.show();
		}
}

/*@Override
public void handle(ActionEvent event) {
	if (event.getSource() == button) {
		System.out.println("Mixing GUI with console.");
	}
}*/
