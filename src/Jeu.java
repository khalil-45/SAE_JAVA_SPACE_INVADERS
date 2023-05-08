import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.paint.Color;



public class Jeu extends Application {
    private Pane root;
    private Group caracteres;
    private GestionJeu gestionnaire;
    private int hauteurTexte;
    private int largeurCaractere;
    public static void main(String[] args) {
        launch(args);
    }

    /* 
    Cette fonction affiche les caractères de chaque chaine positionnée sur l'écran
    */
    private void afficherCaracteres(){
        // On efface les anciens caractères
        caracteres.getChildren().clear();
        // On récupère la hauteur de la fenêtre pour le placement des caractères
        int hauteur = (int) root.getHeight();
        for( ChainePositionnee c : gestionnaire.getChaines().chaines)
        {
            // On crée un nouveau Text pour chaque caractère
            Text t = new Text (c.x*largeurCaractere,hauteur - c.y*hauteurTexte, c.c);
            t.setFont(Font.font ("Monospaced", 10));
            t.setFill(Color.BLUEVIOLET);
            // On ajoute le Text au groupe de caractères
            caracteres.getChildren().add(t);
        }
    }

    /*
    Cette fonction lance l'animation du jeu en boucle infinie 
    */
    private void lancerAnimation() {
        // On crée une timeline avec deux keyframes, un pour jouer un tour et un autre pour mettre à jour l'affichage
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                    new EventHandler<ActionEvent>() {
                        @Override public void handle(ActionEvent actionEvent) {
                            // On joue un tour de jeu
                            gestionnaire.jouerUnTour();
                            // On affiche les nouveaux caractères
                            afficherCaracteres();
                        }
                    }),
                new KeyFrame(Duration.seconds(0.025))
                );
        // On définit que la timeline doit se répéter indéfiniment
        timeline.setCycleCount(Animation.INDEFINITE);
        // On lance la timeline
        timeline.play();
    }

    /* 
    Cette fonction crée et initialise la fenêtre de jeu
    */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("IUTO Space Invader");
        caracteres = new Group();
        
        // On charge l'image de fond de la fenêtre
        Image image = new Image("file:img/space.png");
        ImageView imageView = new ImageView(image);

        // On crée le conteneur principal de la fenêtre avec l'image de fond et le groupe de caractères
        root= new AnchorPane(imageView, caracteres);
        gestionnaire = new GestionJeu();
        Text t=new Text("█");
        t.setFont(Font.font("Monospaced",10));
        hauteurTexte =(int) t.getLayoutBounds().getHeight();
        largeurCaractere = (int) t.getLayoutBounds().getWidth();

        // On crée la scène de la fenêtre avec les dimensions du jeu
        Scene scene = new Scene(root,gestionnaire.getLargeur()*largeurCaractere,gestionnaire.getHauteur()*hauteurTexte);

        // On définit les actions à effectuer pour chaque touche pressée par l'utilisateur
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.LEFT)
                gestionnaire.toucheGauche();
            if(key.getCode()==KeyCode.RIGHT)
                gestionnaire.toucheDroite();
            if(key.getCode()==KeyCode.SPACE)
                gestionnaire.toucheEspace();
        });
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        // On lance l'animation du jeu
        lancerAnimation();

        // On définit le titre et le message de la fenêtre de dialogue en fonction du résultat de la partie
        if (gestionnaire.getGameOver()) {
            // On crée un objet Alert pour afficher la fenêtre de dialogue
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Victoire !");
            alert.setHeaderText("Bravo, vous avez gagné !");
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Défaite !");
            alert.setHeaderText("Dommage, vous avez perdu !");
        }
        
    }

                                                                               
}
