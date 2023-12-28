package espol.tic_tac_toe.controllers;

import espol.tic_tac_toe.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author argen
 */
public class LoadGameController implements Initializable{
    
    @FXML
    private HBox logo;
    
    @FXML
    private VBox root;
    
    @FXML
    private Button backBtn;

    @FXML
    private BorderPane infoContainer;

    @FXML
    private VBox mainContainer;

    @FXML
    private Label matchId;

    @FXML
    private Label matchTime;

    @FXML
    private Button playBtn;

    @FXML
    private VBox sessionContainer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    void onBack(ActionEvent event) throws IOException {
        App.setRoot("home");
    }


}
