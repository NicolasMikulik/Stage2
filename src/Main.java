import javafx.application.Application;
import javafx.scene.Scene;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class Main extends Application{
	
		Stage window;
		Scene scene;
		Button button;
		ListView<String> listView;
		
		public static void main(String[] args) {
			launch(args);
		}
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			window = primaryStage;
			window.setTitle("ListView Demo");
		
			//ListView
			listView = new ListView<>();
			listView.getItems().addAll("Iron Man", "Titanic", "Contact", "Surrogates");
			listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			
			//Button
			button = new Button("Click me");
			button.setOnAction(e -> buttonClicked());
			
			//Layout
			VBox layout = new VBox(10);
			layout.setPadding(new Insets(20,20,20,20));
			layout.getChildren().addAll(listView, button);
			
			scene = new Scene(layout, 300, 250);
			window.setScene(scene);
			window.show();
		}
		
		private void buttonClicked() {
			String message = "";
			ObservableList<String> movies;
			movies = listView.getSelectionModel().getSelectedItems();
			
			for(String m: movies) {
				message += m + "\n";
			}
			System.out.println(message);
		}
}

/*@Override
public void handle(ActionEvent event) {
	if (event.getSource() == button) {
		System.out.println("Mixing GUI with console.");
	}
}*/
