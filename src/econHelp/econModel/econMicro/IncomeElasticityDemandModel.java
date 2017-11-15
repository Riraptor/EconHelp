package econHelp.econModel.econMicro;

import java.text.DecimalFormat;

import econHelp.Main.Main;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * This class deines the model class for Income Elasticity Demand. It defines methods to calculate,
 * Income Elasticity demand, change text and validate input values.
 * @author EconTeam(UMASS BOSTON)
 *
 */
public class IncomeElasticityDemandModel {
	static DecimalFormat df = new DecimalFormat("###.##");
	static Text description = new Text(600, 250, "");
	static Text interpretation = new Text(600, 350, "");
	/**
	 * This method calculates the Income Price Elasticity demand.
	 * @param Q1 TextField Quantity 1
	 * @param Q2 TextField Quantity 2
	 * @param P1 TextField Price 1
	 * @param P2 TextField Price 2
	 * @param messageExy Empty text Instance from Controller.
	 * @param messageExyModulus Empty text Instance from Controller.
	 * @return void
	 */
	public static void getIncomePriceElasticityDemand(TextField Q1, TextField Q2, TextField P1, TextField P2, Text messageEi,
			Text messageEiModulus) {

		try {
			Pane root = Main.getRoot();

			if (isValid(Q1) && isValid(Q2) && isValid(P1) && isValid(P2)) {
				double q1 = Double.parseDouble(Q1.getText());
				double q2 = Double.parseDouble(Q2.getText());
				double p1 = Double.parseDouble(P1.getText());
				double p2 = Double.parseDouble(P2.getText());
				double Ei;
				double EiAbs;
				Ei = ((q2 - q1) / ((q2 + q1) / 2)) / ((p2 - p1) / ((p1 + p2) / 2));
				EiAbs = Math.abs(Ei);
				String DecOrInc = " decrease ";
				if (Ei >= 0) {
					DecOrInc = " increase ";
				}
				messageEi = format(messageEi, "Ei = " + df.format(Ei), Color.LIGHTCORAL);
				messageEiModulus = format(messageEiModulus, "|Ei| = " + df.format(EiAbs), Color.LIGHTCORAL);

				if (Ei < 0) {
					description = format(description, "|Ei| < 0	  (Inferior Good)", Color.TEAL);
					interpretation = format(interpretation,
							"INTERPRETATION : \n\n" + "The income price elasticity of " + df.format(EiAbs) + " means that a \n"
									+ "1% increase in income generated a " + df.format(EiAbs) + "% \n" + DecOrInc
									+ "in the quantity demanded.",
							Color.DARKSEAGREEN);
				}
				if (Ei <= 1 && Ei >= 0) {
					description = format(description, "|Ei| >=0 |Ei| <= 1	 (Normal/Necessary Good)", Color.NAVAJOWHITE);
					interpretation = format(interpretation,
							"INTERPRETATION : \n\n" + "The income price elasticity of " + df.format(EiAbs) + " means that a \n"
									+ "1% increase in income generated a " + df.format(EiAbs) + "% \n" + DecOrInc
									+ "in the quantity demanded.",
							Color.DARKSEAGREEN);
				}
				
				if (Ei > 1) {
					description = format(description, "|Ei| > 1 	(Superior Good)", Color.NAVAJOWHITE);
					interpretation = format(interpretation,
							"INTERPRETATION : \n\n" + "The income price elasticity of " + df.format(EiAbs) + " means that a \n"
									+ "1% increase in income generated a " + df.format(EiAbs) + "% \n" + DecOrInc
									+ "in the quantity demanded.",
							Color.DARKSEAGREEN);
				}

				
				
								
				
				if (Double.isNaN(EiAbs)) {
					root.getChildren().remove(interpretation);
					description = format(description, "Please try again with different \n		numbers", Color.RED);
					interpretation = format(interpretation,
							"Price and Quantity cannot have \n" + "both Initial And final values = 0",
							Color.DARKSEAGREEN);
				}
			} else {

				System.out.println("Please enter valid Number");
				root.getChildren().remove(messageEiModulus);
				root.getChildren().remove(messageEi);
				root.getChildren().remove(interpretation);
				description = format(description, "Please enter valid Numbers", Color.RED);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Checks if the input value is a Number and +v or not.
	 * @param input TextField 
	 * @return True if it is a number.
	 */
	public static boolean isValid(TextField input) {
		try {
			Double value = Double.parseDouble(input.getText());
			System.out.println("Actual value =" + input.getText());
			System.out.println("double value = " + value);
			if (value < 0) {
				throw new NumberFormatException();
			}
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	/**
	 * This method is called to format a Text.
	 * @param line Text that needs to be formatted.
	 * @param s String that is set to the Text.
	 * @param color change color of line to  passed Color. 
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
