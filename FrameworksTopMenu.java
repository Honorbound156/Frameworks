import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FrameworksTopMenu extends Application {

    Stage window;
    BorderPane layout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Frameworks");

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

        //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, toolsMenu, formatMenu, helpMenu);

        layout = new BorderPane();
        layout.setTop(menuBar);
        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }


}