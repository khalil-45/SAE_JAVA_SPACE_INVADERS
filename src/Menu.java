import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.geometry.Pos;
import java.io.File;
import javafx.scene.media.Media;




public class Menu extends Application {


    @Override
    public void start(Stage primaryStage){
        // Création des éléments du menu
        Text titre = new Text("IUTO Space Invader");
        Button jouerBtn = new Button("Jouer");
        Button optionsBtn = new Button("Options");
        Button quitterBtn = new Button("Quitter");

        playMusic();

        // Ajout d'un événement de clic sur le bouton "Jouer"
        jouerBtn.setOnAction(e -> {
            // Lancement du jeu
                Jeu jeu = new Jeu();
                jeu.start(primaryStage);
        });

        // Ajout d'un événement de clic sur le bouton "Options"
        optionsBtn.setOnAction(e -> {
            // Lancement des options
            Options options = new Options();
            options.start(primaryStage);
        });

        // Ajout d'un événement de clic sur le bouton "Quitter"
        quitterBtn.setOnAction(e -> {
            primaryStage.close();
        });

        // Création d'un layout pour organiser les éléments du menu
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(titre, jouerBtn, optionsBtn, quitterBtn);

        // Création de la scène de menu
        Scene menuScene = new Scene(layout, 400, 400);

        // Affichage de la scène de menu
        primaryStage.setTitle("Menu");
        primaryStage.setScene(menuScene);
        primaryStage.show();

    }

    MediaPlayer mediaPlayer;
    public void playMusic(){
        String musicFile = "src/MenuJeu.mp3";
        Media media = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.1);
        mediaPlayer.play();
    }

    public MediaPlayer getMediaPlayer(){
        return this.mediaPlayer;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
