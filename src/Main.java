import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class Main extends Application{
	
		Stage window;
		Scene scene;
		Button button;
		ComboBox<String> comboBox;
		
		public static void main(String[] args) {
			launch(args);
		}
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			window = primaryStage;
			window.setTitle("ComboBox Demo");
		
			//ComboBox
			comboBox = new ComboBox<>();
			comboBox.getItems().addAll("Bacon", "Ham", "Meatballs");
			comboBox.setPromptText("What is your favourite type of food?");
			comboBox.setOnAction(e -> System.out.println("User selected: "+comboBox.getValue()));
			comboBox.setEditable(true);
			
			//Button
			button = new Button("Click me");
			button.setOnAction(e -> printMovie());
			
			//Layout
			VBox layout = new VBox(10);
			layout.setPadding(new Insets(10,10,10,20));
			layout.getChildren().addAll(comboBox, button);
			
			scene = new Scene(layout, 300, 250);
			window.setScene(scene);
			window.show();
		}
		
		private void printMovie() {
			System.out.println(comboBox.getValue());
		}
}

/*@Override
public void handle(ActionEvent event) {
	if (event.getSource() == button) {
		System.out.println("Mixing GUI with console.");
	}
}*/
