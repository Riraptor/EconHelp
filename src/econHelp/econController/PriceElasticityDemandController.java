package econHelp.econController;

import java.io.IOException;

import econHelp.Main.Main;
import econHelp.econModel.econMicro.PriceElasticityDemandModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

/**
 * This class is the controller for PriceElasticityDemandView.fxml
 * @author EconTeam(UMASS BOSTON)
 *
 */
public class PriceElasticityDemandController {

	Text messageEd = new Text(650, 150, "");
	Text messageEdModulus = new Text(647, 200, "");

	@FXML
	protected Button btnHome;
	@FXML
	protected Button btnMicro;
	@FXML
	protected Button btnMacro;
	@FXML
	protected Button btnLogOut;
	@FXML
	protected Button btnCal;
	@FXML
	protected TextField txtFieldQOne;
	@FXML
	protected TextField txtFieldPOne;
	@FXML
	protected TextField txtFieldQTwo;
	@FXML
	protected TextField txtFieldPTwo;

	// Menu bar
	// codes:__________________________________________________________________________________
	@FXML
	public void clickButtonHome() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/Index.fxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickButtonMicro() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/MicroContentsView.fxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickButtonMacro() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/MacroContentsView.fxml");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickButtonLogOut() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/Login.fxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// End of Menu bar
	// codes__________________________________________________________________________
	
	/**
	 * This medhod is called when user clicks calculate.
	 * This medhod calls getPriceElasticityDemand() in PriceElasticityDemandModel class.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void clickButtonCalculate(ActionEvent event) throws IOException {
		try {
			PriceElasticityDemandModel.getPriceElasticityDemand(txtFieldQOne, txtFieldQTwo, txtFieldPOne, txtFieldPTwo,
					messageEd, messageEdModulus);
			System.out.println("Ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function is called when the Refresh button is pressed in the  PriceElasticityDemandView.FXML
	 * This method calls a new PriceElasticityDemandView.fxml
	 */
	@FXML
	public void clickButtonRefresh() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/PriceElasticityDemandView.fxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function is called when the info button is pressed in the
	 * PriceElasticityDemandView.FXML. It does nothing.
	 */
	@FXML
	public void clickButtonInfo() throws IOException {

	}
	
}
