import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FrameworksGUIStage1 extends Application implements EventHandler<ActionEvent> {

	Button button1;
	Button button2;
	Button button3;
	Button button4;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Frameworks");

		button1 = new Button();
		button2 = new Button();
		button3 = new Button();
		button4 = new Button();

		button1.setText("Add Domain");
		button2.setText("Add Interface");
		button3.setText("Remove Domain");
		button4.setText("Remove Interface");

		TextInputDialog dialog = new TextInputDialog("Component X");
		dialog.setTitle("Naming Component");
		dialog.setHeaderText("Component Naming Dialog");
		dialog.setContentText("Please enter Component Name");
		
		ChoiceDialog<String> remover = new ChoiceDialog<String>("Okay", "Cancel", "Okay");
		remover.setHeaderText("Are You Sure You Want To Remove This?");
		
		button1.setOnAction(event -> dialog.showAndWait());
		button2.setOnAction(event -> dialog.showAndWait());
		button3.setOnAction(event -> remover.showAndWait());
		button4.setOnAction(event -> remover.showAndWait());

	    HBox topMenu = new HBox();
	    button1.setPrefSize(200,30);
	    button2.setPrefSize(200,30);
	    button3.setPrefSize(200,30);
	    button4.setPrefSize(200,30);
	    topMenu.getChildren().addAll(button1, button2, button3, button4);
	    
		StackPane layout = new StackPane();
	    layout.getChildren().add(topMenu);
		
		Scene scene = new Scene(layout, 800, 750);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//Get the response Value
		//Optional<String> result = dialog.showAndWait();
		//result.ifPresent(name -> System.out.println("Name of Domain: " + name));
	}

	@Override
	public void handle(ActionEvent event) {
		
	}

}
