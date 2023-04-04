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
        this.alien.add(new Alien(0, 50));
        this.alien.add(new Alien(10, 50));
        this.alien.add(new Alien(20, 50));
        this.alien.add(new Alien(30, 50));
        this.alien.add(new Alien(40, 50));
        this.alien.add(new Alien(50,50));
        this.alien.add(new Alien(60, 50));
        this.alien.add(new Alien(70, 50));
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

        for (Alien a : alien){
            a.evolue();
            System.out.println(a.getEnsembleChaines());
            this.chaines.union(a.getEnsembleChaines());
        }
    }


    
}
