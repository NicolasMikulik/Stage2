import javafx.application.Application;
import javafx.scene.Scene;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class Main extends Application{
	
		Stage window;
		Scene scene;
		Button button;
		TreeView<String> tree;
		
		public static void main(String[] args) {
			launch(args);
		}
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			window = primaryStage;
			window.setTitle("ListView Demo");
		
			TreeItem<String> root, bucky, megan;
			
			//Root
			root = new TreeItem<>();
			root.setExpanded(true);
			
			//Bucky
			bucky = makeBranch("Bucky", root);
			makeBranch("thenewboston", bucky);
			makeBranch("YouTube", bucky);
			makeBranch("Chicken", bucky);
			
			//Megan
			megan = makeBranch("Megan", root);
			makeBranch("Sparkles", megan);
			makeBranch("Makeup", megan);
			
			//Create tree
			tree = new TreeView<>(root);
			tree.setShowRoot(false);
			tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) ->{
				if(newValue != null)
					System.out.println(newValue.getValue());
			});
			
			//Button
			button = new Button("Click me");
			
			//Layout
			StackPane layout = new StackPane();
			layout.getChildren().add(tree);
			scene = new Scene(layout, 300, 250);
			window.setScene(scene);
			window.show();
		}
		
		//Create branches
		public TreeItem<String> makeBranch(String title, TreeItem<String> parent){
			TreeItem<String> item = new TreeItem<>(title);
			item.setExpanded(true);
			parent.getChildren().add(item);
			return item;
		}
		
}

/*@Override
public void handle(ActionEvent event) {
	if (event.getSource() == button) {
		System.out.println("Mixing GUI with console.");
	}
}*/
