/**
 * La classe Vaisseau représente un vaisseau.
 */
public class Vaisseau {
    
    private double posX; // Position horizontale du vaisseau.

    /**
     * Constructeur de la classe Vaisseau.
     * 
     * @param x La position horizontale initiale du vaisseau.
     */
    public Vaisseau(double x){
        this.posX = x;
    }

    /**
     * Retourne la position horizontale du vaisseau.
     * 
     * @return La position horizontale du vaisseau.
     */
    public double getPosX(){
        return this.posX;
    }

    /**
     * Déplace le vaisseau horizontalement d'une certaine distance.
     * 
     * @param dx La distance à laquelle le vaisseau doit être déplacé.
     */
    public void deplace(double dx){
        double limiteGauche = 0;
        double limiteDroite = 100-10;

        if (this.posX + dx < limiteGauche){
            this.posX = limiteGauche;
        } else if (posX + dx > limiteDroite){
            this.posX = limiteDroite;
        } else {
            this.posX += dx;
        }
    }

    /**
     * Retourne l'ensemble de chaînes de caractères représentant le vaisseau.
     * 
     * @return L'ensemble de chaînes de caractères représentant le vaisseau.
     */
    public EnsembleChaines getEnsembleChaines(){
        EnsembleChaines e = new EnsembleChaines();
        e.ajouteChaine((int)posX, 0, "■■■█████■■■");
        e.ajouteChaine((int)posX, 1, "     uuu");
        e.ajouteChaine((int)posX, 2, "      ▲");
        return e;
    }

    /**
     * Retourne la position horizontale du canon du vaisseau.
     * 
     * @return La position horizontale du canon du vaisseau.
     */
    public double positionCanon(){
        return this.posX + 5;
    }
}
