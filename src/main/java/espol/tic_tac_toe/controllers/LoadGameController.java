package espol.tic_tac_toe.controllers;

import espol.tic_tac_toe.App;
import espol.tic_tac_toe.models.Match;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author argen
 */
public class LoadGameController implements Initializable{

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
        
        File[] savedMatches = (new File(App.path + "files")).listFiles();

        if (savedMatches != null) {
            for (File file : savedMatches) {
                if (file.isFile() && file.getName().endsWith(".bin")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                        
                        Match match = (Match) ois.readObject();
                        showMatch(match);
                        
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // TODO: mostrar mensaje: no existen matches guardados.
        }
        
    }
    
    @FXML
    void onBack(ActionEvent event) throws IOException {
        App.setRoot("home");
    }
    

    private void showMatch(Match match){
        mainContainer.getChildren().add(createMatchView(match));
    }
    
    private VBox createMatchView(Match match){
        
        VBox sessionContainer =  new VBox();
 
        //TODO: crear la vista de cada match
        
        return sessionContainer;
    }
    
    
}
