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
			
			button = new Button("Click Me");
			button.setOnAction(e -> {
				boolean result = ConfirmBox.display("Title of window", "Wow, this alert box rules!");
				System.out.println(result);
			});
			
			StackPane layout = new StackPane();
			layout.getChildren().add(button);
			Scene scene = new Scene(layout, 500, 250);
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
