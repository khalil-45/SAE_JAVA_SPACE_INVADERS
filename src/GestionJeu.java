public class GestionJeu{
    
    private double largeur;
    private double hauteur;
    private double positionX;
    private double positionY;
    private EnsembleChaines chaines;
    private Vaisseau vaisseau;
    private Projectile projectile;
    private int score;


    public GestionJeu(){
        this.largeur=100;
        this.hauteur=60;
        this.chaines = new EnsembleChaines();
        this.vaisseau = new Vaisseau(positionX);
        this.projectile = new Projectile(vaisseau.positionCanon(), 2);
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
    }

    public void jouerUnTour(){
            vaisseau.deplace(positionX);
            this.chaines = new EnsembleChaines();
            this.chaines.union(vaisseau.getEnsembleChaines());
            projectile.evolue();
            this.chaines.union(projectile.getEnsembleChaines());
    }


    
}
