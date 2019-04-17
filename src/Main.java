import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

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

			IntegerProperty x = new SimpleIntegerProperty(3);
			IntegerProperty y = new SimpleIntegerProperty(3);
			
			y.bind(x.multiply(10));
			System.out.println("x: "+x.getValue());
			System.out.println("y: "+y.getValue()+"\n");
			
			x.setValue(9);
			System.out.println("x: "+x.getValue());
			System.out.println("y: "+y.getValue()+"\n");
			
			Person bucky = new Person();
			bucky.firstNameProperty().addListener((v, oldValue, newValue) ->{
			System.out.println("Name changed to "+newValue);
			System.out.println("firstNameProperty() "+bucky.firstNameProperty());
			System.out.println("getFirstName() "+bucky.getFirstName());
			});
			
			button = new Button("Submit");
			button.setOnAction(e -> bucky.setFirstName("Porky"));
			
			StackPane layout = new StackPane();
			layout.getChildren().add(button);
			Scene scene = new Scene(layout, 300, 250);
			window.setScene(scene);
			window.show();
		}
}