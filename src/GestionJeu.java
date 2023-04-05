import java.util.ArrayList;

public class GestionJeu {
    
    private double largeur;
    private double hauteur;
    private double positionX;
    private EnsembleChaines chaines;
    private Vaisseau vaisseau;
    private Projectile projectile;
    public boolean lancerProj;
    private Score score;
    private ArrayList<Alien> alien;


    public GestionJeu(){
        this.largeur=100;
        this.hauteur=60;
        this.chaines = new EnsembleChaines();
        this.vaisseau = new Vaisseau(positionX);
        this.projectile = new Projectile(vaisseau.positionCanon(), 2);
        this.lancerProj = false;
        this.score = new Score();
        this.alien = new ArrayList<Alien>();
        this.alien.add(new Alien(0, hauteur-8));
        this.alien.add(new Alien(10, hauteur-8));
        this.alien.add(new Alien(20, hauteur - 8));
        this.alien.add(new Alien(30, hauteur - 8));
        this.alien.add(new Alien(40, hauteur - 8));
        this.alien.add(new Alien(50,hauteur - 8));
        this.alien.add(new Alien(60, hauteur - 8));
        this.alien.add(new Alien(70, hauteur - 8));
    }

    public double getLargeur(){return largeur;}

    public double getHauteur(){return hauteur;}

    public EnsembleChaines getChaines(){return chaines;}

    public void toucheDroite(){
        System.out.println("clic droit");
        this.positionX += 0.1;
    }

    public void toucheGauche(){
	    System.out.println("clic gauche");
        this.positionX -= 0.1;
    }

    public void toucheEspace(){
        System.out.println("Appui sur la touche espace");
        this.lancerProj = true;
        
    }

    public void jouerUnTour(){
        vaisseau.deplace(positionX);
        this.chaines = new EnsembleChaines();
        this.chaines.union(vaisseau.getEnsembleChaines());

        if (lancerProj){
        projectile.evolue();
        this.chaines.union(projectile.getEnsembleChaines());
        }

        if (projectile.getPositionY() > this.hauteur){
            lancerProj = false;
            this.projectile = new Projectile(vaisseau.positionCanon(), 2);
        }

        score.ajouteScore(1);

        for (Alien alien : this.alien){
            this.chaines.union(alien.getEnsembleChaines());
            alien.evolue();
        }

        /* Si le projectile touche l'alien, on retire l'alien et on augmente le score
        if (lancerProj && projectile.touche(a)) {
            alien.remove(i);
            lancerProj = false;
            this.projectile = new Projectile(vaisseau.positionCanon(), 2);
            score.ajouteScore(10);
            break;
        }
        */
    }

    }
    
