import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{
	
		Button button1;
		Button button2;
		
		public static void main(String[] args) {
			launch(args);
		}
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			primaryStage.setTitle("Title of the window");
			button1 = new Button();
			button1.setText("Click me?");
			button2 = new Button("Click me!");
		
			button1.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
				System.out.println("I come from an anonymous inner class!");
			}
			});
			
			button2.setOnAction(e -> {
				System.out.print("I am written by");
				System.out.println(" a lambda expression.");
			});
			
			StackPane layout = new StackPane();
			layout.getChildren().add(button1);
			layout.getChildren().add(button2);
			Scene scene = new Scene(layout, 500, 250);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
}

/*@Override
public void handle(ActionEvent event) {
	if (event.getSource() == button) {
		System.out.println("Mixing GUI with console.");
	}
}*/
