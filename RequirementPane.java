import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class RequirementPane extends Pane{
	Requirement associatedRequirement;
	
	public RequirementPane(double xCoordinate, double yCoordinate, Requirement Requirement){
		this.associatedRequirement = Requirement;
		this.setBackground(new Background(new BackgroundFill(Color.web("PINK"), CornerRadii.EMPTY, Insets.EMPTY)));
		this.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, new BorderWidths(2))));
		
		this.setPrefSize(60, 40);
		this.setLayoutX(xCoordinate);
		this.setLayoutY(yCoordinate);
		
		this.setOnMouseClicked(e -> {System.out.println(this.associatedRequirement.getName() + " has been clicked on");});
		this.setOnMouseDragged(e -> {
			System.out.println(this.associatedRequirement.getName() + "is being dragged to: " + e.getSceneX() + "," + e.getSceneY());
			//left
			if(e.getSceneX() < 0 && e.getSceneY() > 0 && e.getSceneY() < 530) {
				this.setLayoutX(0);
				this.setLayoutY(e.getSceneY());
			//bottom left
			} else if (e.getSceneX() < 0 && e.getSceneY() > 530){
				this.setLayoutX(0);
				this.setLayoutY(530);
			//top left
			} else if (e.getSceneX() < 0 && e.getSceneY() < 57){
				this.setLayoutX(0);
				this.setLayoutY(0);
			//top
			} else if (e.getSceneY() < 57 && e.getSceneX() > 0 && e.getSceneX() < 950){
				this.setLayoutX(e.getSceneX());
				this.setLayoutY(0);
			//top right
			} else if (e.getSceneX() > 950 && e.getSceneY() < 57){
				this.setLayoutX(950);
				this.setLayoutY(0);
			//right
			} else if (e.getSceneX() > 950 && e.getSceneY() > 0 && e.getSceneY() < 530) {
				this.setLayoutX(950);
				this.setLayoutY(e.getSceneY());
			//bottom right
			} else if (e.getSceneX() > 950 && e.getSceneY() > 530){
				this.setLayoutX(950);
				this.setLayoutY(530);
			//bottom
			} else if (e.getSceneY() > 600 && e.getSceneX() > 0 && e.getSceneX() < 950){
				this.setLayoutX(e.getSceneX());
				this.setLayoutY(530);
			//else we are within the bounds of the drawing area
			} else {
					this.setLayoutX(e.getSceneX());
					this.setLayoutY(e.getSceneY()-65);
			}
		});
	}
	
	public RequirementPane(){
		
	}
	
}
