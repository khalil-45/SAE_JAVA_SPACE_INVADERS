import java.util.ArrayList;

/**
 * La classe GestionJeu gère le déroulement du jeu. Elle contient le vaisseau, les aliens,
 * le projectile, les chaînes de caractères correspondant à chacun de ces éléments,
 * et permet également de déplacer le vaisseau et de lancer un projectile.
 */
public class GestionJeu {
    
    private double largeur;
    private double hauteur;
    private double positionX;
    private EnsembleChaines chaines;
    private Vaisseau vaisseau;
    private Projectile projectile;
    public boolean lancerProj;
    private Score score;
    private ArrayList<Alien> aliens;
    private boolean gameOver;


    /**
     * Constructeur de la classe GestionJeu
     * Initialise les attributs et crée une liste d'aliens au début du jeu.
     */
    public GestionJeu(){
        this.largeur=100;
        this.hauteur=60;
        this.chaines = new EnsembleChaines();
        this.vaisseau = new Vaisseau(positionX);
        this.lancerProj = false;
        this.score = new Score();
        this.aliens = new ArrayList<Alien>();
        this.gameOver = false;
        this.projectile = new Projectile(0,0);
        // Crée une liste d'aliens
        this.aliens.add(new Alien(0, hauteur-8, 0.1));
        this.aliens.add(new Alien(10, hauteur-8, 0.1));
        this.aliens.add(new Alien(20, hauteur - 8, 0.1));
        this.aliens.add(new Alien(30, hauteur - 8, 0.1));
        this.aliens.add(new Alien(40, hauteur - 8, 0.1));
        this.aliens.add(new Alien(50,hauteur - 8, 0.1));
        this.aliens.add(new Alien(60, hauteur - 8, 0.1));
        this.aliens.add(new Alien(70, hauteur - 8, 0.1));
    }

    public double getLargeur(){return largeur;}

    public double getHauteur(){return hauteur;}

    public EnsembleChaines getChaines(){return chaines;}

    public boolean getGameOver(){return gameOver;}

    /**
     * Déplace le vaisseau vers la droite de 2 unités.
     */
    public void toucheDroite(){
        System.out.println("clic droit");
        this.vaisseau.deplace(2);
    }

    /**
     * Déplace le vaisseau vers la gauche de 2 unités.
     */
    public void toucheGauche(){
	    System.out.println("clic gauche");
        this.vaisseau.deplace(-2);
    }

    /**
     * Lance un projectile en créant un objet Projectile et en initialisant l'attribut lancerProj à true.
     * Le projectile est lancé depuis la position du canon du vaisseau.
     */
    public void toucheEspace(){
        if (lancerProj == false){
        System.out.println("Appui sur la touche espace");
        this.lancerProj = true;
        this.projectile = new Projectile(vaisseau.positionCanon(), 2);
        }
    }

    /**
     * Permet de jouer un tour en mettant à jour l'état de tous les objets du jeu.
     * Met à jour les positions du vaisseau, du projectile et des aliens, 
     * vérifie si le projectile touche un alien et le retire le cas échéant.
     * Met également à jour le score.
     * Si tous les aliens ont été éliminés, affiche un message de victoire et termine le programme.
     */
    public void jouerUnTour(){
        // Mettre à jour les chaines de caractères de chaque élément
        this.chaines = new EnsembleChaines();
        this.chaines.union(vaisseau.getEnsembleChaines());
    
        // Si le projectile est lancé, faire évoluer sa position et mettre à jour ses chaines de caractères
        if (lancerProj){
            projectile.evolue();
            this.chaines.union(projectile.getEnsembleChaines());
        }
    
        // Si le projectile sort de l'écran, le désactiver
        if (projectile.getPositionY() > this.hauteur){
            lancerProj = false;
        }
    
        // Mettre à jour le score
        score.ajouteScore(1);
    
        // Pour chaque alien, faire évoluer sa position, mettre à jour ses chaines de caractères et tester les collisions avec le projectile
        for (Alien alien : this.aliens){
            this.chaines.union(alien.getEnsembleChaines());
            alien.evolue((int) this.largeur);
    
            // Si le projectile touche l'alien, le retirer et augmenter le score
            if (lancerProj && projectile.touche(alien)) {
                aliens.remove(alien);
                lancerProj = false;
                score.ajouteScore(10);
            }
        }
    
        // Si tous les aliens ont été détruits, mettre gameOver à true, sinon le mettre à false afin de pouvoir gérer l'affichage du message de victoire
        if (this.aliens.isEmpty()){
            this.gameOver = true;
        }
    }


}