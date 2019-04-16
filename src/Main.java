import javafx.application.Application;
import javafx.scene.Scene;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application{
	
		Stage window;
		Scene scene;
		Button button;
		BorderPane layout;
		
		public static void main(String[] args) {
			launch(args);
		}
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			window = primaryStage;
			window.setTitle("TableView Demo");
		
			Menu fileMenu = new Menu("File");
			
			MenuItem newFile = new MenuItem("New...");
			newFile.setOnAction(e -> System.out.println("Create a new file..."));
			fileMenu.getItems().add(newFile);

			fileMenu.getItems().add(new MenuItem("Open..."));
			fileMenu.getItems().add(new MenuItem("Save..."));
			fileMenu.getItems().add(new SeparatorMenuItem());
			fileMenu.getItems().add(new MenuItem("Settings..."));
			fileMenu.getItems().add(new SeparatorMenuItem());
			fileMenu.getItems().add(new MenuItem("Exit..."));
			
			Menu editMenu = new Menu("_Edit");
			MenuItem paste = new MenuItem("Paste");
			paste.setOnAction(e -> {
				System.out.println("Disable paste button");
				paste.setDisable(true);
			});
			
			editMenu.getItems().add(new MenuItem("Undo"));
			editMenu.getItems().add(paste);
			editMenu.getItems().add(new SeparatorMenuItem());
			editMenu.getItems().add(new MenuItem("Copy"));
			

			//Help menu
			Menu helpMenu = new Menu("Help");
			CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
			showLines.setOnAction(e -> {
				if(showLines.isSelected())
					System.out.println("Program will now display line numbers");
				else
					System.out.println("Hiding line numbers");
			});
			CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
			autoSave.setSelected(true);
			helpMenu.getItems().addAll(showLines, autoSave);
			
			MenuBar menuBar = new MenuBar();
			menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);
			
			layout = new BorderPane();
			layout.setTop(menuBar);
			scene = new Scene(layout, 400, 300);
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
