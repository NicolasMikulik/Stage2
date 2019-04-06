import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class Main extends Application{
	
		Stage window;
		Scene scene;
		Button button;
		
		public static void main(String[] args) {
			launch(args);
		}
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			window = primaryStage;
			window.setTitle("thenewboston");
		
			//Choicebox
			ChoiceBox<String> choiceBox = new ChoiceBox<>();
			
			choiceBox.getItems().add("Apples");
			choiceBox.getItems().add("Bananas");
			choiceBox.getItems().addAll("Bacon", "Ham", "Meatballs");
			choiceBox.setValue("Ham");
			
			choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> System.out.println(newValue));
			
			//Button
			button = new Button("Click me");
			button.setOnAction(e -> getChoice(choiceBox));
			
			//Layout
			VBox layout = new VBox(10);
			layout.setPadding(new Insets(10,10,10,20));
			layout.getChildren().addAll(choiceBox, button);
			
			scene = new Scene(layout, 300, 250);
			window.setScene(scene);
			window.show();
		}
		
		private void getChoice(ChoiceBox<String> choiceBox) {
			String choice = choiceBox.getValue();
			System.out.println(choice);
		}
}

/*@Override
public void handle(ActionEvent event) {
	if (event.getSource() == button) {
		System.out.println("Mixing GUI with console.");
	}
}*/
