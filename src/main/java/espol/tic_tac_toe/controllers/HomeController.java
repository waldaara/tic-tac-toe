package espol.tic_tac_toe.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;

/**
 * FXML Controller class
 *
 * @author argen
 */
public class HomeController implements Initializable {

    @FXML
    private HBox XOBtnContainer;

    @FXML
    private Button fullCPUBtn;

    @FXML
    private Button loadGameBtn;

    @FXML
    private HBox logo;

    @FXML
    private ToggleGroup markSelector;

    @FXML
    private SVGPath oSVG;

    @FXML
    private Label pickLabel;

    @FXML
    private VBox root;

    @FXML
    private VBox selectorContainer;

    @FXML
    private Button versusCPUBtn;

    @FXML
    private Button versusP2Btn;

    @FXML
    private Label whoStartsLabel;

    @FXML
    private SVGPath xSVG;

    @FXML
    private ToggleButton xSelectionBtn;

    @FXML
    private ToggleButton oSelectionBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void onMarkSelected(ActionEvent event) {

        if (event.getSource() == xSelectionBtn) {
            switchButtonAppearance("#a8bfc9", "#1a2a33");
            
        } else if (event.getSource() == oSelectionBtn) {
            switchButtonAppearance("#1a2a33", "#a8bfc9");
        }

    }

    private void switchButtonAppearance(String color1, String color2) {
        xSelectionBtn.setStyle("-fx-background-color: " + color1);
        xSVG.setStyle("-fx-fill: " + color2);
        oSelectionBtn.setStyle("-fx-background-color: " + color2);
        oSVG.setStyle("-fx-fill: " + color1);
    }

    @FXML
    void onLoadGame(ActionEvent event) {

    }

    @FXML
    void onNewGameCPU1vsCPU2(ActionEvent event) {

    }

    @FXML
    void onNewGameVersusCPU(ActionEvent event) {

    }

    @FXML
    void onNewGameVersusP2(ActionEvent event) {

    }

}
