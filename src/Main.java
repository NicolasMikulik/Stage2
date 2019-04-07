import javafx.application.Application;
import javafx.scene.Scene;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application{
	
		Stage window;
		TableView<Product> table;
		Scene scene;
		Button button;
		
		public static void main(String[] args) {
			launch(args);
		}
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			window = primaryStage;
			window.setTitle("TableView Demo");
			
			//NameColumn
			TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
			nameColumn.setMinWidth(200);
			nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
			
			//PriceColumn
			TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
			priceColumn.setMinWidth(100);
			priceColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
			
			//QuantityColumn
			TableColumn<Product, String> quantityColumn = new TableColumn<>("Quantity");
			quantityColumn.setMinWidth(100);
			quantityColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("quantity"));
			
			table = new TableView<>();
			table.setItems(getProduct());
			table.getColumns().add(nameColumn);
			table.getColumns().add(priceColumn);
			table.getColumns().add(quantityColumn);
			
			//Name input
			TextField nameInput = new TextField();
			nameInput.setPromptText("Name");
			nameInput.setMinWidth(100);
			
			TextField priceInput = new TextField();
			priceInput.setPromptText("Price");
			
			TextField quantityInput = new TextField();
			quantityInput.setPromptText("Quantity");
			
			//Button
			button = new Button("Click me");
			Button addButton = new Button("Add");
			addButton.setOnAction(e -> addButtonClicked(nameInput, priceInput, quantityInput));
			Button deleteButton = new Button("Delete");
			deleteButton.setOnAction(e -> deleteButtonClicked());
			
			HBox hBox = new HBox();
			hBox.setPadding(new Insets(10,10,10,10));
			hBox.setSpacing(10);
			hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);
			
			//Layout
			VBox vBox = new VBox();
			vBox.getChildren().addAll(table, hBox);
			
			scene = new Scene(vBox);
			window.setScene(scene);
			window.show();
		}
	
		public void addButtonClicked(TextField nameInput, TextField priceInput, TextField quantityInput) {
			Product product = new Product();
			product.setName(nameInput.getText());
			product.setPrice(Double.parseDouble(priceInput.getText()));
			product.setQuantity(Integer.parseInt(quantityInput.getText()));
			table.getItems().add(product);
			nameInput.clear();
			priceInput.clear();
			quantityInput.clear();
		}
		
		public void deleteButtonClicked() {
			ObservableList<Product> productSelected, allProducts;
			allProducts = table.getItems();
			productSelected = table.getSelectionModel().getSelectedItems();
			
			productSelected.forEach(allProducts::remove);
		}
		
		public ObservableList<Product> getProduct(){
			ObservableList<Product> products = FXCollections.observableArrayList();
			products.add(new Product("Laptop", 859.00, 20));
			products.add(new Product("Bouncy Ball", 2.49, 198));
			products.add(new Product("Toilet", 99.00, 15));
			products.add(new Product("Noise", 1.15, 150));
			products.add(new Product("Corn", 2.30, 856));
			return products;
		}
		
}

/*@Override
public void handle(ActionEvent event) {
	if (event.getSource() == button) {
		System.out.println("Mixing GUI with console.");
	}
}*/
