public class GestionJeu{
    
    private double largeur;
    private double hauteur;
    private double positionX;
    private EnsembleChaines chaines;
    private Vaisseau vaisseau;


    public GestionJeu(){
        this.largeur=100;
        this.hauteur=60;
        this.chaines = new EnsembleChaines();
        chaines.ajouteChaine(0,30,"@@");
        this.vaisseau = new Vaisseau(positionX);
    }

    public double getLargeur(){return largeur;}

    public double getHauteur(){return hauteur;}

    public EnsembleChaines getChaines(){return chaines;}

    public void toucheDroite(){
        System.out.println("clic droit");
        this.positionX++;
    }

    public void toucheGauche(){
	    System.out.println("clic gauche");
        this.positionX--;
    }

    public void toucheEspace(){
        System.out.println("Appui sur la touche espace");
    }

    public void jouerUnTour(){
            vaisseau.deplace(positionX);
            this.chaines = new EnsembleChaines();
            this.chaines.union(vaisseau.getEnsembleChaines());
    }


    
}
