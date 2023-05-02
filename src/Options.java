import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


public class Options extends Application {

    private MediaPlayer mediaPlayer;
    private Slider volumeSlider;

    @Override
    public void start(Stage primaryStage) {

        // Création des éléments de la fenêtre d'options
        Text titre = new Text("Options");
        volumeSlider = new Slider(0, 1, 0.5);
        Button retourBtn = new Button("Retour");

        // Chargement des réglages actuels
        loadSettings();

        // Ajout d'un écouteur sur le slider de volume
        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                setVolume(newValue.doubleValue());
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
        layout.getChildren().addAll(titre, volumeSlider, retourBtn);

        // Création de la scène d'options
        Scene optionsScene = new Scene(layout, 400, 400);

        // Affichage de la scène d'options
        primaryStage.setTitle("Options");
        primaryStage.setScene(optionsScene);
        primaryStage.show();
    }

    private void loadSettings() {
        // Chargement des réglages actuels
        double volume = 0.5; // valeur par défaut
        // Charger le volume depuis les préférences ou tout autre moyen de stockage de données

        setVolume(volume);
        volumeSlider.setValue(volume);
    }

    private void setVolume(double volume) {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(volume);
        }
        // Enregistrer le volume dans les préférences ou tout autre moyen de stockage de données
    }
}
