import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.media.MediaPlayer;


public class Options extends Application {

    private MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) {

        // Création des éléments de la fenêtre d'options
        Text titre = new Text("Options");
        Button muteSon = new Button("Mute");
        Button retourBtn = new Button("Retour");

        // Création d'un bouton pour mute le son du jeu
        muteSon.setOnAction(e -> {
            if (mediaPlayer.isMute()) {
                mediaPlayer.setMute(false);
            } else {
                mediaPlayer.setMute(true);
            }
        });

        // Ajout d'un événement de clic sur le bouton "Retour"
        retourBtn.setOnAction(e -> {
            // Retour au menu principal
            primaryStage.close();
        });

        // Création d'un layout pour organiser les éléments de la fenêtre d'options
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(titre, muteSon, retourBtn);

        // Création de la scène d'options
        Scene optionsScene = new Scene(layout, 400, 400);

        // Affichage de la scène d'options
        primaryStage.setTitle("Options");
        primaryStage.setScene(optionsScene);
        primaryStage.show();
    }

}
