package econHelp.econModel.econMicro;

import java.text.DecimalFormat;

import econHelp.Main.Main;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * This class deines the model class for Cross Price Elasticity. It defines methods to calculate,
 * CrosssPriceElasticity, change text and validate input values.
 * @author EconTeam(UMASS BOSTON)
 *
 */
public class CrossPriceElasticityDemandModel {
	static DecimalFormat df = new DecimalFormat("###.##");
	static Text description = new Text(600, 250, "");
	static Text interpretation = new Text(600, 350, "");
	/**
	 * This method calculates the cross price elasticity demand.
	 * @param Q1 TextField Quantity 1
	 * @param Q2 TextField Quantity 2
	 * @param P1 TextField Price 1
	 * @param P2 TextField Price 2
	 * @param messageExy Empty text Instance from Controller.
	 * @param messageExyModulus Empty text Instance from Controller.
	 * @return void
	 */
	public static void getCrossPriceElasticityDemand(TextField Q1, TextField Q2, TextField P1, TextField P2,
			Text messageExy, Text messageExyModulus) {

		try {
			Pane root = Main.getRoot();
			if (isValid(Q1) && isValid(Q2) && isValid(P1) && isValid(P2)) {
				double q1 = Double.parseDouble(Q1.getText());
				double q2 = Double.parseDouble(Q2.getText());
				double p1 = Double.parseDouble(P1.getText());
				double p2 = Double.parseDouble(P2.getText());
				double Exy;
				double ExyAbs;
				Exy = ((q2 - q1) / ((q2 + q1) / 2)) / ((p2 - p1) / ((p1 + p2) / 2));
				ExyAbs = Math.abs(Exy);
				String DecOrInc = " decrease ";
				if (Exy >= 0) {
					DecOrInc = " increase ";
				}
				messageExy = format(messageExy, "Exy = " + df.format(Exy), Color.LIGHTCORAL);
				messageExyModulus = format(messageExyModulus, "|Exy| = " + df.format(ExyAbs), Color.LIGHTCORAL);

				if (Exy > 0) {
					description = format(description, "|Exy| > 0	  Substitutes", Color.TEAL);
					interpretation = format(interpretation,
							"INTERPRETATION : \n\n" + "The cross price elasticity of " + df.format(ExyAbs)
									+ " means that a \n" + "1% increase in price of good Y, generated a "
									+ df.format(ExyAbs) + "% \n" + DecOrInc + "in the quantity demanded of good X.",
							Color.DARKSEAGREEN);
				}
				if (Exy < 0) {
					description = format(description, "|Exy| < 0 	(Complementary)", Color.NAVAJOWHITE);
					interpretation = format(interpretation,
							"INTERPRETATION : \n\n" + "The cross price elasticity of " + df.format(ExyAbs)
									+ " means that a \n" + "1% increase in price generated a " + df.format(ExyAbs)
									+ "% \n" + DecOrInc + "in the quantity demanded.",
							Color.DARKSEAGREEN);
				}
				if (ExyAbs == 0) {
					description = format(description, "|Exy| = 0	 (Independent)", Color.NAVAJOWHITE);
					interpretation = format(interpretation,
							"INTERPRETATION : \n\n" + "The cross price elasticity of " + df.format(ExyAbs)
									+ " means that  \n" + "quantity demanded does not change with change in price. ",
							Color.DARKSEAGREEN);
				}
				if (ExyAbs == Double.POSITIVE_INFINITY) {
					description = format(description, "|Exy| = +ve Infinity 	 (Perfect Substitutes)", Color.NAVAJOWHITE);
					interpretation = format(
							interpretation, "INTERPRETATION : \n\n" + "The cross price elasticity of "
									+ df.format(ExyAbs) + " means that  \n" + "the two goods are perfect substitutes.",
							Color.DARKSEAGREEN);
				}

				if (ExyAbs == Double.NEGATIVE_INFINITY) {
					description = format(description, "|Exy| = -ve Infinity 	 (Perfect Complemnts)", Color.NAVAJOWHITE);
					interpretation = format(
							interpretation, "INTERPRETATION : \n\n" + "The cross price elasticity of " + df.format(ExyAbs)
									+ " means that  \n" + "the two goods are perfects complements.",
							Color.DARKSEAGREEN);
				}
				if (Double.isNaN(ExyAbs)) {
					root.getChildren().remove(interpretation);
					description = format(description, "Please try again with different \n		numbers", Color.RED);
					interpretation = format(interpretation,
							"Price and Quantity cannot have \n" + "both Initial And final values = 0",
							Color.DARKSEAGREEN);
				}
			} else {

				System.out.println("Please enter valid Number");
				root.getChildren().remove(messageExyModulus);
				root.getChildren().remove(messageExy);
				root.getChildren().remove(interpretation);
				description = format(description, "Please enter valid Numbers", Color.RED);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method checks if the input value is a Number and +v or not.
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
