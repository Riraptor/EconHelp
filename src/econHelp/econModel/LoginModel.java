package econHelp.econModel;

import java.text.DecimalFormat;

import econHelp.Main.Main;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * This class Defines the Model class for Login.
 * @author ECON TEAM(UMASS BOSTON)
 *
 */
public class LoginModel {
	static DecimalFormat df = new DecimalFormat("###.##");
	static Text description = new Text(600, 250, "");
	/**
	 * This method validates the ID. It is set to 0000.
	 * @param txtAreaID
	 * @return boolean
	 */
	public static boolean validateID(TextField txtAreaID) {
		String value = txtAreaID.getText();
		Text message = new Text(500, 70,"");
		Pane root = Main.getRoot();
		if(!value.equals("0000")){
			System.out.println("Enter the correct ID");
			description = format(description, "Please input the right ID", Color.TEAL);
			return false;
		}
		return true;
		
	}
	/**
	 * Defines the color and size of text.
	 * @param line  String that need to be formatted
	 * @param s	
	 * @param color
	 * @return Text
	 */
	public static Text format(Text line, String s, Color color) {
		Main.getRoot().getChildren().remove(line);
		line.setText(s);
		line.setFill(color);
		line.setScaleX(1.5);
		line.setScaleY(1.5);
		Main.getRoot().getChildren().add(line);
		return line;
	}

}
