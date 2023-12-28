package espol.tic_tac_toe.controllers;

import espol.tic_tac_toe.App;
import espol.tic_tac_toe.models.Human;
import espol.tic_tac_toe.models.Mark;
import espol.tic_tac_toe.models.Match;
import espol.tic_tac_toe.models.Player;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class GameController implements Initializable {
    
    private Match match;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // aquí debsería instanciarce el match
    }
    
    public void onRestart() {
        //faltan cosas por checar, just dummy data
        Player first = new Human(Mark.X);
        
        match = new Match(first,
                new Human(Mark.X), first);
    }
    
    public void onSave() {
        Thread thread = new Thread(() -> {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(match.getId() + ".bin"))) {
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
