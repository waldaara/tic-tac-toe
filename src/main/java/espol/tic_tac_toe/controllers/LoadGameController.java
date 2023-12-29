package espol.tic_tac_toe.controllers;

import espol.tic_tac_toe.App;
import espol.tic_tac_toe.models.Match;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;

/**
 * FXML Controller class
 *
 * @author argen
 */
public class LoadGameController implements Initializable {

    @FXML
    private VBox mainContainer;

    @FXML
    private ScrollPane scrollContainer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Platform.runLater(()
                -> scrollContainer.lookup(".scroll-bar").setStyle("-fx-opacity: 0;"));

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

    private void showMatch(Match match) {
        mainContainer.getChildren().add(createMatchView(match));
    }

    private VBox createMatchView(Match match) {

        VBox sessionContainer = new VBox();
        sessionContainer.getStyleClass().add("sessionContainer");

        BorderPane infoContainer = new BorderPane();
        infoContainer.getStyleClass().add("info");

        VBox textContainer = new VBox();
        textContainer.setAlignment(Pos.CENTER_LEFT);
        textContainer.setSpacing(6);

        Label matchId = new Label(("Game :" + match.getId()).toUpperCase());
        matchId.getStyleClass().add("text");

        Label matchTime = new Label(match.getSaveDateTime().toString());
        matchTime.getStyleClass().add("text");

        textContainer.getChildren().addAll(matchId, matchTime);

        SVGPath playIcon = new SVGPath();
        playIcon.setContent("M4.55 19A1 1 0 0 1 3 18.13V1.87A1 1 0 0 1 "
                + "4.55 1l12.2 8.13a1 1 0 0 1 0 1.7z");

        Button playBtn = new Button();
        playBtn.getStyleClass().add("resumeBtn");
        playBtn.setGraphic(playIcon);
        infoContainer.setAlignment(playBtn, Pos.CENTER_RIGHT);

        //TODO: set resume game logic and rename game title (en funcion de los jugadores)
        infoContainer.setRight(playBtn);
        infoContainer.setLeft(textContainer);

        sessionContainer.getChildren().add(infoContainer);

        return sessionContainer;
    }

}
