import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import java.io.File;



public class Menu extends Application {

    @Override
    public void start(Stage primaryStage){
        // Création des éléments du menu
        Text titre = new Text("IUTO Space Invader");
        Button jouerBtn = new Button("Jouer");
        Button optionsBtn = new Button("Options");
        Button quitterBtn = new Button("Quitter");

        // Ajout de la musique en arrière-plan
        SampledPlayer bgMusic = new SampledPlayer(new File("src/MenuJeu.mp3"));
        bgMusic.play(true);        

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


    public static void main(String[] args) {
        launch(args);
    }
}
