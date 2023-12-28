package espol.tic_tac_toe.controllers;

import espol.tic_tac_toe.App;
import espol.tic_tac_toe.enums.Mark;
import espol.tic_tac_toe.models.CPU;
import espol.tic_tac_toe.models.Human;
import espol.tic_tac_toe.models.Player;
import java.io.IOException;
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
    private VBox root;

    @FXML
    private HBox logo;

    @FXML
    private VBox selectorContainer;

    @FXML
    private Label pickLabel;

    @FXML
    private HBox XOBtnContainer;

    @FXML
    private ToggleGroup markSelector;

    @FXML
    private ToggleButton xSelectionBtn;

    @FXML
    private ToggleButton oSelectionBtn;

    @FXML
    private SVGPath xSVG;

    @FXML
    private SVGPath oSVG;

    @FXML
    private HBox startBtnContainer;

    @FXML
    private Label whoStartsLabel;

    @FXML
    private ToggleGroup firstSelector;

    @FXML
    private ToggleButton xFirstBtn;

    @FXML
    private ToggleButton oFirstBtn;

    @FXML
    private SVGPath xFirstSVG;

    @FXML
    private SVGPath oFirstSVG;

    @FXML
    private Button versusCPUBtn;

    @FXML
    private Button versusP2Btn;

    @FXML
    private Button loadGameBtn;

    @FXML
    private Button fullCPUBtn;

    private Mark firstTurnMark;
    private Mark player1Mark;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void onMarkSelected(ActionEvent event) {

        if (event.getSource() == xSelectionBtn) {
            switchButtonAppearance("#a8bfc9", "#1a2a33");
            player1Mark = Mark.X;

        } else if (event.getSource() == oSelectionBtn) {
            switchButtonAppearance("#1a2a33", "#a8bfc9");
            player1Mark = Mark.O;
        }

    }

    private void switchButtonAppearance(String color1, String color2) {
        xSelectionBtn.setStyle("-fx-background-color: " + color1);
        xSVG.setStyle("-fx-fill: " + color2);
        oSelectionBtn.setStyle("-fx-background-color: " + color2);
        oSVG.setStyle("-fx-fill: " + color1);
    }

    @FXML
    void onFirstSelected(ActionEvent event) {

        if (event.getSource() == xFirstBtn) {
            switchButtonAppearance2("#a8bfc9", "#1a2a33");
            firstTurnMark = Mark.X;

        } else if (event.getSource() == oFirstBtn) {
            switchButtonAppearance2("#1a2a33", "#a8bfc9");
            firstTurnMark = Mark.O;
        }
    }

    private void switchButtonAppearance2(String color1, String color2) {
        xFirstBtn.setStyle("-fx-background-color: " + color1);
        xFirstSVG.setStyle("-fx-fill: " + color2);
        oFirstBtn.setStyle("-fx-background-color: " + color2);
        oFirstSVG.setStyle("-fx-fill: " + color1);
    }

    @FXML
    void onNewGameVersusCPU(ActionEvent event) throws IOException {
        //TODO: no se puede cambiar a la siguiente vista si no se ha selecciona una marca
        // y no se ha seleccionado quien va primero

        App.setRoot("game");

        Player playerX;
        Player playerO;

        if (player1Mark == Mark.X) {
            playerX = new Human(Mark.X);
            playerO = new CPU(Mark.O);
        } else {
            playerO = new Human(Mark.O);
            playerX = new CPU(Mark.X);
        }

        GameController.initData(playerX, playerO, firstTurnMark == Mark.X ? playerX : playerO);
    }

    @FXML
    void onNewGameVersusP2(ActionEvent event) throws IOException {
        //TODO: no se puede cambiar a la siguiente vista si no se ha selecciona una marca
        // y no se ha seleccionado quien va primero

        App.setRoot("game");
    }

    @FXML
    void onLoadGame(ActionEvent event) throws IOException {
        App.setRoot("loadGame");
    }

    @FXML
    void onNewGameCPU1vsCPU2(ActionEvent event) throws IOException {
        //TODO: no se puede cambiar a la siguiente vista si no se ha selecciona una marca
        // y no se ha seleccionado quien va primero
        App.setRoot("game");

    }

}
