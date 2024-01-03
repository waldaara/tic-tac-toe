package espol.tic_tac_toe.controllers;

import espol.tic_tac_toe.App;
import espol.tic_tac_toe.models.Match;
import espol.tic_tac_toe.utils.MatchWrapper;
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

        File[] savedMatches = (new File(App.path + "files")).listFiles();

        if (savedMatches != null) {
            for (File file : savedMatches) {
                if (file.isFile() && file.getName().endsWith(".bin")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

                        MatchWrapper match = (MatchWrapper) ois.readObject();

                        //validate time when game saved
                        if (match.getId().equals(Match.id)
                                && !match.getSaveDateTime().equals(Match.saveDateTime)) {
                            match.setSaveDateTime(Match.saveDateTime);
                        }

                        showMatch(match);

                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        Platform.runLater(()
                -> scrollContainer.lookup(".scroll-bar").setStyle("-fx-opacity: 0;"));

    }

    @FXML
    void onBack(ActionEvent event) throws IOException {
        App.setRoot("home");
    }

    private void showMatch(MatchWrapper match) {
        mainContainer.getChildren().add(createMatchView(match));
    }

    private VBox createMatchView(MatchWrapper match) {

        VBox sessionContainer = new VBox();
        sessionContainer.getStyleClass().add("sessionContainer");

        BorderPane infoContainer = new BorderPane();
        infoContainer.getStyleClass().add("info");

        VBox textContainer = new VBox();
        textContainer.setAlignment(Pos.CENTER_LEFT);
        textContainer.setSpacing(6);

        Label matchId = new Label(("Game: " + match.getPlayers()).toUpperCase());
        matchId.getStyleClass().add("text");

        Label matchTime = new Label(match.getSaveDateTimeFormatted());
        matchTime.getStyleClass().add("text");

        textContainer.getChildren().addAll(matchId, matchTime);

        SVGPath playIcon = new SVGPath();
        playIcon.setContent("M4.55 19A1 1 0 0 1 3 18.13V1.87A1 1 0 0 1 "
                + "4.55 1l12.2 8.13a1 1 0 0 1 0 1.7z");

        Button playBtn = new Button();
        playBtn.getStyleClass().add("resumeBtn");
        playBtn.setGraphic(playIcon);
        playBtn.setOnMouseClicked(event -> loadGame(match));

        BorderPane.setAlignment(playBtn, Pos.CENTER_RIGHT);

        infoContainer.setRight(playBtn);
        infoContainer.setLeft(textContainer);

        sessionContainer.getChildren().add(infoContainer);

        return sessionContainer;
    }

    private void loadGame(MatchWrapper match) {

        updateMatchFrom(match);
        GameController.setSaved(true);

        try {
            App.setRoot("game");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    ;
    
    private void updateMatchFrom(MatchWrapper savedMatch) {

        Match.id = savedMatch.getId();
        Match.winsX = savedMatch.getWinsX();
        Match.winsO = savedMatch.getWinsO();
        Match.ties = savedMatch.getTies();
        Match.board = savedMatch.getBoard();
        Match.playerX = savedMatch.getPlayerX();
        Match.playerO = savedMatch.getPlayerO();
        Match.currentTurn = savedMatch.getCurrentTurn();
        Match.firstTurn = savedMatch.getFirstTurn();
        Match.predictionsTree = savedMatch.getPredictionsTree();
        Match.isPlayer1X = savedMatch.isPlayer1X();
        Match.saveDateTime = savedMatch.getSaveDateTime();

    }

}
