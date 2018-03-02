import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JPanel;

import com.sun.javafx.geom.Rectangle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class FrameworksGUIStage1 extends Application implements EventHandler<ActionEvent> {

	ProblemFrame problemFrame;
	Button resetButton;

	public static void main(String[] args) {
		
		/**Some basic functions:
		 *A) Click once on domain to begin interface creation
		 *B) Click again on a different domain to create an interface
		 *C) This interface should be blank until it is clicked on to add detail
		 *D) Double click on open space to create a new blank domain at that position
		 *E) Double click on a domain or interface to edit it
		 *F) This edit includes a great deal, examine photos in library
		 *G) Click and drag domains to move them, any interface in between must render to move with them
		 *H) This render should place the interface from the middle of the sidebar nearest each domain to the other
		 *I) Ability to reset or erase problem frame
		 *J) Save PF
		 *K) Open PF
		*/
		launch(args);
	}
	
	/**
	 * This method is used to create the string list of domain names
	 * for the creation of interfaces.
	 * @return Domain List as String List
	 */
	public ArrayList<String> getDomainsAsStringList(){
		ArrayList<String> domainList = new ArrayList<String>();
		
		for(Domain domainX : problemFrame.domains){
			domainList.add(domainX.name);
		}
		
		return domainList;
		
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Frameworks");

		problemFrame = new ProblemFrame();
		resetButton = new Button();

		resetButton.setText("Erase Diagram");

		
		//Set Up The Dialogs
		//A) Reset Button is Clicked Dialog
		//B) Domain is Clicked Dialog
		
		
		TextInputDialog domainCreationDialog = new TextInputDialog("Domain X");
		domainCreationDialog.setTitle("Domain Creation Dialogue");
		domainCreationDialog.setHeaderText("Domain Creation Dialog");
		domainCreationDialog.setContentText("Please enter domain name");

		ChoiceDialog<String> interfaceCreationDialog = 
				new ChoiceDialog<String>("Choose A Domain To Link Via Interface", getDomainsAsStringList());
		
		ChoiceDialog<String> remover = new ChoiceDialog<String>("Okay", "Cancel", "Okay");
		remover.setHeaderText("Are You Sure You Want To Remove This?");

	   // HBox topMenu = new HBox();

	    //topMenu.getChildren().addAll(button1, button2);
	    
		BorderPane layout = new BorderPane();
		Pane pane1 = new Pane();
		pane1.setLayoutX(100);
		pane1.setLayoutY(100);
	    layout.getChildren().add(pane1);
		
		Scene scene = new Scene(layout, 1000, 750);
		
		/*
		scene.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent click) {
				
				if(2 == click.getClickCount()){
					//and not in any element, create new domain
					//if in element, open edit menu for that element
					System.out.println("DoubleClick: (" + click.getSceneX() + "," + click.getSceneY() + ")");
				} else if(1 == click.getClickCount()){
					System.out.println("SingleClick: (" + click.getSceneX() + "," + click.getSceneY() + ")");
					//if inside a domain, start interface addition process
					//else ignore
				}
				
			}
			
		});
		*/ 
		scene.setOnMouseClicked(new EventHandler<MouseEvent>(){

		    @Override
		    public void handle(MouseEvent mouseEvent) {
		        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
		            if(mouseEvent.getClickCount() == 2){
		                System.out.println("Double clicked");
		            } else { 
		            	System.out.println("Single Click");
		            	Domain domainToAdd = new Domain("Domain A");
		            	
		            	problemFrame.addDomain(domainToAdd);
		            	
		            	System.out.println(problemFrame.getDomains());
		            	
		            	Pane newDomainPane = new Pane();
		            	newDomainPane.setLayoutX(mouseEvent.getSceneX());
		            	newDomainPane.setLayoutY(mouseEvent.getSceneY());
		            	
		            	layout.getChildren().add(newDomainPane);
		            	System.out.println(layout.getChildren());
		            	
		            }
		        }
		    }
			
		});
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//Get the response Value
		//Optional<String> result = dialog.showAndWait();
		//result.ifPresent(name -> System.out.println("Name of Domain: " + name));
		
		
	}

	/**
	@Override
	public void handle(ActionEvent event) {

		if(event.getEventType().getName().equals("MouseEvent")){
			long currentTime = System.currentTimeMillis();
			long diff = 0;
			long lastTime = 0;
			boolean doubleClicked = false;

			if(lastTime!=0 && currentTime!=0){
				diff=currentTime-lastTime;

				if( diff<=500)
					doubleClicked=true;
				else
					doubleClicked=false;
			}

			lastTime = currentTime;

			System.out.println("Detected Double Click"); 

			//Single Click Occurred, if it was on a domain, begin process to create interface between domains    
			if(!doubleClicked){

			} else {
				Rectangle domain = new Rectangle(20, 40);

				//this was a double click. If it was on an element, edit that element. If not, then create a new domain on the spot
			}
		}
		
		
	}*/

	public void eraseProblemFrame(){
		this.problemFrame = new ProblemFrame();
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
