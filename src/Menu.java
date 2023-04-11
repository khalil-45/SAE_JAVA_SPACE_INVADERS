import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class Menu extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Création des éléments du menu
        Text titre = new Text("IUTO Space Invader");
        Button jouerBtn = new Button("Jouer");
        Button optionsBtn = new Button("Options");
        Button quitterBtn = new Button("Quitter");

        // Ajout d'un événement de clic sur le bouton "Jouer"
        jouerBtn.setOnAction(e -> {
            // Lancement du jeu
            GestionJeu gestionnaire = new GestionJeu();
            Scene scene = new Scene(gestionnaire.getRoot(), gestionnaire.getLargeur()*gestionnaire.getLargeurCaractere(),
                    gestionnaire.getHauteur()*gestionnaire.getHauteurTexte());
            scene.addEventHandler(KeyEvent.KEY_PRESSED, gestionnaire::toucheAppuyee);
            scene.addEventHandler(KeyEvent.KEY_RELEASED, gestionnaire::toucheRelachee);
            primaryStage.setScene(scene);
            gestionnaire.jouer();
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
