package espol.tic_tac_toe.controllers;

import espol.tic_tac_toe.App;
import espol.tic_tac_toe.enums.Mark;
import espol.tic_tac_toe.models.Human;
import espol.tic_tac_toe.models.Match;
import espol.tic_tac_toe.models.Player;
import espol.tic_tac_toe.services.PredictionsService;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class GameController implements Initializable {

    private static Match match;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public static void initData(Player playerX, Player playerO, Player currentTurn) {
        match = new Match(playerX, playerO, currentTurn);
        
        System.out.println("getBestMovement()");
        System.out.println(PredictionsService.getBestMovement(match.getPredictionsTree(), match.getPlayerO(), match.getPlayerX()));
    }

    public void onRestart() {
        //faltan cosas por checar, just dummy data
        Player first = new Human(Mark.X);

        match = new Match(first,
                new Human(Mark.X), first);
    }

    public void onSave() {
        Thread thread = new Thread(() -> {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.path + "files/" + match.getId() + ".bin"))) {
                out.writeObject(match);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.run();
        thread.setDaemon(true);
    }

    public void onExit() throws IOException {
        App.setRoot("home");
    }

}
