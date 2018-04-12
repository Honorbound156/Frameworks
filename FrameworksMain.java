import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class FrameworksMain  extends Application implements EventHandler<ActionEvent> {

	ContextDiagram contextDiagram = new ContextDiagram();
	ArrayList<ProblemDiagram> problemDiagrams = new ArrayList<ProblemDiagram>();
	
	public void addNewProblemDiagram(String nameOfDiagram){
		ProblemDiagram newDiagram = new ProblemDiagram(nameOfDiagram);
		this.problemDiagrams.add(newDiagram);
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
