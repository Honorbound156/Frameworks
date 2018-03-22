import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JPanel;

import com.sun.javafx.geom.Rectangle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FrameworksGUIStage1 extends Application implements EventHandler<ActionEvent> {

	ProblemFrame problemFrame;

	public static void main(String[] args) {
		
		/**Some basic functions:
		 Click once on open space to create domain (Primary for given, Secondary for designed).
		 Click once (Primary) on domain to begin interface creation 
		 Click again on a different domain to create an interface (Should generate a line to show this)
		 This interface should be blank until it is clicked on to add detail
		 Mouse over component to get component detail in lower bar
		 Primary click on interface does nothing
		 Secondary click opens edit/delete menu on Domain or Interfaces
		 This edit includes a great deal, examine photos in library
		 Click and drag (Primary or Secondary) domains to move them, any interface in between must render to move with them
		 This render should place the interface from the middle of the side-bar nearest each domain to the other
		 Ability to reset problem frame
		 Compile Document? (This is the logic engine it seems for PFEdit)
		 Save PF
		 Open PF
		 
		//Set Up The Dialogs
		//A) Reset Button is Clicked Dialog
		//B) Domain is Clicked Dialog
		//C) Interface is Clicked Dialog
		//D) Save and Load Dialogs
		//E) Compile Dialog
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
		
		//SET UP MENU BAR
        //File menu
        Menu fileMenu = new Menu("File");
        MenuItem newFile = new MenuItem("New File");
        newFile.setOnAction(e -> System.out.println("Create a new file..."));
        fileMenu.getItems().add(newFile);
        fileMenu.getItems().add(new MenuItem("Open XML File"));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Save (XML)"));
        fileMenu.getItems().add(new MenuItem("Save As XML"));
        fileMenu.getItems().add(new MenuItem("Save As Image"));
        fileMenu.getItems().add(new MenuItem("Save As Text"));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Print Diagram"));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit"));

        //Edit menu
        Menu toolsMenu = new Menu("Tools");
        toolsMenu.getItems().add(new MenuItem("Compile Document"));
        toolsMenu.getItems().add(new MenuItem("Undo"));
        toolsMenu.getItems().add(new MenuItem("Redo"));
        toolsMenu.getItems().add(new SeparatorMenuItem());
        toolsMenu.getItems().add(new MenuItem("Hide Context Description"));
        toolsMenu.getItems().add(new MenuItem("Hide Component Details"));
        toolsMenu.getItems().add(new MenuItem("Show/Hide Grid"));
        toolsMenu.getItems().add(new MenuItem("Erase Diagram"));
        toolsMenu.getItems().add(new SeparatorMenuItem());
        toolsMenu.getItems().add(new MenuItem("Customize Toolbar"));
        toolsMenu.getItems().add(new MenuItem("Lock Document"));

        //Tools menu
        Menu formatMenu = new Menu("Format");
        MenuItem changeColor = new MenuItem("Change Color");
        changeColor.setOnAction(e -> System.out.println("Change Color"));
        changeColor.setDisable(true);
        MenuItem changeFont = new MenuItem("Change Font");
        changeFont.setOnAction(e -> System.out.println("Change Font"));
        MenuItem changeSize = new MenuItem("Change Size");
        changeSize.setOnAction(e -> System.out.println("Change Size"));
        formatMenu.getItems().addAll(changeColor, changeFont, changeSize);
        
        //Help menu
        Menu helpMenu = new Menu("Help");
        helpMenu.getItems().add(new MenuItem("FrameWorks Help"));
        helpMenu.getItems().add(new SeparatorMenuItem());
        helpMenu.getItems().add(new MenuItem("Quick Start"));
        helpMenu.getItems().add(new MenuItem("Turn On Tutorial"));
        helpMenu.getItems().add(new SeparatorMenuItem());
        helpMenu.getItems().add(new MenuItem("About Frameworks"));
        helpMenu.getItems().add(new MenuItem("Keyboard Shortcuts"));

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, toolsMenu, formatMenu, helpMenu);
		//END TOP MENU BAR
        
		//SET UP TOP BUTTON BAR
		Button newButton = new Button("N");
		Button openButton = new Button("O");
		Button saveButton = new Button("S");
		Button saveAsButton = new Button("SA");
		Button printButton = new Button("P");
		Button undoButton = new Button("U");
		Button redoButton = new Button("RE");
		Button compileButton = new Button("C");
		Button resetButton = new Button("E");
		Button helpButton = new Button("H");
		Button quickStartButton = new Button("Q");
		Button hideToolbarButton = new Button("HT");
		newButton.setPrefSize(35, 35);
		openButton.setPrefSize(35, 35);
		saveButton.setPrefSize(35, 35);
		saveAsButton.setPrefSize(35, 35);
		printButton.setPrefSize(35, 35);
		undoButton.setPrefSize(35, 35);
		redoButton.setPrefSize(35, 35);
		compileButton.setPrefSize(35, 35);
		resetButton.setPrefSize(35, 35);
		helpButton.setPrefSize(35, 35);
		quickStartButton.setPrefSize(35, 35);
		hideToolbarButton.setPrefSize(35, 35);
		
		newButton.setTooltip(new Tooltip("New Diagram"));
		openButton.setTooltip(new Tooltip("Open Diagram"));
		saveButton.setTooltip(new Tooltip("Save Diagram"));
		saveAsButton.setTooltip(new Tooltip("Save Diagram As"));
		printButton.setTooltip(new Tooltip("Print Diagram"));
		undoButton.setTooltip(new Tooltip("Undo Last"));
		redoButton.setTooltip(new Tooltip("Redo Last"));
		compileButton.setTooltip(new Tooltip("Compile Document"));
		resetButton.setTooltip(new Tooltip("Erase Diagram"));
		helpButton.setTooltip(new Tooltip("Frameworks Help"));
		quickStartButton.setTooltip(new Tooltip("Quick Start"));
		hideToolbarButton.setTooltip(new Tooltip("Hide This Toolbar"));
		
		resetButton.setOnAction(e -> System.out.println("Reset the diagram"));
		compileButton.setOnAction(e -> System.out.println("Compile the document"));
		
	    HBox buttonMenu = new HBox();
	    buttonMenu.getChildren().addAll(newButton, openButton, saveButton, saveAsButton, printButton, undoButton,
	    		redoButton, compileButton, resetButton, helpButton, quickStartButton, hideToolbarButton);
	    buttonMenu.setSpacing(5);
	    //END TOP BUTTON BAR
	    
	    //SET UP THE PRIMARY SANBOX AREA
	    BorderPane mainLayout = new BorderPane();
	    BorderPane topBarLayout = new BorderPane();
	    GridPane domainSandboxLayout = new GridPane();
	    topBarLayout.setTop(menuBar);
	    topBarLayout.setCenter(buttonMenu);
	    topBarLayout.setPrefSize(800, 65);
	    
        domainSandboxLayout.setGridLinesVisible(true);
        final int numCols = 10 ;
        final int numRows = 10 ;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            domainSandboxLayout.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            domainSandboxLayout.getRowConstraints().add(rowConst);         
        }
        //END PRIMARY SANDBOX AREA
	    
        //SET UP BOTTOM PANE LAYOUT
        BorderPane bottomContentLayout = new BorderPane();
        TextField bottomTextRegion = new TextField();
        TextField lastEventTextField = new TextField();
        bottomTextRegion.setPrefSize(800, 100);
        lastEventTextField.setPrefSize(800, 25);
        bottomTextRegion.setText("This Text Will Change Based On The Context Of The Mouse In The Above Area");
        lastEventTextField.setText("Last Event -> \"X\"");

        bottomContentLayout.setTop(bottomTextRegion);
        bottomContentLayout.setBottom(lastEventTextField);
        //END BOTTOM PANE LAYOUT
        
        //SET APP LAYOUT
		mainLayout.setTop(topBarLayout);
		mainLayout.setCenter(domainSandboxLayout);
		mainLayout.setBottom(bottomContentLayout);
	    mainLayout.setPrefSize(800, 600);
	    
	    //FINISH AND DISPLAY
		Scene scene = new Scene(mainLayout, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//SET UP DIALOGS
		//CREATE DOMAIN DIALOG
		TextInputDialog domainCreationDialog = new TextInputDialog("Domain X");
		domainCreationDialog.setTitle("Domain Creation Dialogue");
		domainCreationDialog.setHeaderText("Domain Creation Dialog");
		domainCreationDialog.setContentText("Please enter domain name");

		//REMOVE DOMAIN DIALOG
		Alert removeDomainDialog = new Alert(AlertType.CONFIRMATION);
		removeDomainDialog.setTitle("Remove Domain Dialog");
		removeDomainDialog.setHeaderText("Remove Domain?");
		removeDomainDialog.setContentText("Are You Sure You Want To Remove This Domain?");

		Optional<ButtonType> removeResult = removeDomainDialog.showAndWait();
		if (removeResult.get() == ButtonType.OK){
		    // ... user chose OK
		} else {
		    // ... user chose CANCEL or closed the dialog
		}
		
		//REMOVE INTERFACE DIALOG
		Alert removeInterfaceDialog = new Alert(AlertType.CONFIRMATION);
		removeInterfaceDialog.setTitle("Remove Interface Dialog");
		removeInterfaceDialog.setHeaderText("Remove Interface?");
		removeInterfaceDialog.setContentText("Are You Sure You Want To Remove This Interface?");

		removeResult = removeInterfaceDialog.showAndWait();
		if (removeResult.get() == ButtonType.OK){
		    // ... user chose OK
		} else {
		    // ... user chose CANCEL or closed the dialog
		}
		
		//ADD PHENOMENON DIALOG
		//ADD INTERFACE DIALOG
		//DELETE PHENOMENON DIALOG
		
		//END DIALOG SETUP	
		
		//Temporary Changes for demo
		quickStartButton.setOnAction(e -> {
		
			domainCreationDialog.showAndWait();
		
		});
		
		helpButton.setOnAction(e ->{
			
			removeDomainDialog.showAndWait();
			
		});
		
		hideToolbarButton.setOnAction(e -> {
			
			removeInterfaceDialog.showAndWait();
			
		});
		
		domainSandboxLayout.setOnMouseClicked( e -> {
			double xOfClick = e.getSceneX();
			double yOfClick = e.getSceneY();
			
			Pane domainPane = new Pane();
			domainPane.setPrefSize(60, 40);
			domainPane.setBackground(new Background(new BackgroundFill(Color.web("BLUE"), CornerRadii.EMPTY, Insets.EMPTY)));
			
			//domainSandboxLayout.add(domainPane, (int)xOfClick, (int)yOfClick);
			domainSandboxLayout.add(domainPane, 1, 1);
			
			Optional<String> nameOfDomain = domainCreationDialog.showAndWait();
			
			Domain domainCreated = new Domain(nameOfDomain.toString());
			
			this.problemFrame.addDomain(domainCreated);
			System.out.println("Problem Frame Domain List: ");
			for(Domain domain : this.problemFrame.domains){
				System.out.println(domain.getName());
			}
		});
		
	}

	public void eraseProblemFrame(){
		this.problemFrame = new ProblemFrame();
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
