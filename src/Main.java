import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
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
			window.setOnCloseRequest(e -> {
				e.consume();
				closeProgram();
			});
			
			button = new Button("Close program");
			button.setOnAction(e -> closeProgram());
			
			StackPane layout = new StackPane();
			layout.getChildren().add(button);
			Scene scene = new Scene(layout, 300, 250);
			window.setScene(scene);
			window.show();
		}
		
		private void closeProgram() {
			boolean answer = ConfirmBox.display("Confirmation of closing", "Are you sure you want to close the program?");
			if (answer)
				window.close();
		}
}

/*@Override
public void handle(ActionEvent event) {
	if (event.getSource() == button) {
		System.out.println("Mixing GUI with console.");
	}
}*/
