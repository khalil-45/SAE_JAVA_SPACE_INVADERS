/**
 * La classe Projectile représente un projectile qui est tiré par le joueur pour détruire les aliens.
 * Le projectile est représenté par sa position en X et en Y sur le plateau de jeu.
 */
public class Projectile {
    private double positionX; // la position en X du projectile
    private double positionY; // la position en Y du projectile

    /**
     * Constructeur de la classe Projectile
     * @param x la position en X initiale du projectile
     * @param y la position en Y initiale du projectile
     */
    public Projectile(double x, double y){
        this.positionX = x;
        this.positionY = y;
    }

    /**
     * Accesseur pour la position en X du projectile
     * @return la position en X du projectile
     */
    public double getPositionX(){return positionX;}

    /**
     * Accesseur pour la position en Y du projectile
     * @return la position en Y du projectile
     */
    public double getPositionY(){return positionY;}

    /**
     * Renvoie l'ensemble de chaînes de caractères représentant le projectile
     * @return l'ensemble de chaînes de caractères représentant le projectile
     */
    public EnsembleChaines getEnsembleChaines(){
        EnsembleChaines e = new EnsembleChaines();
        e.ajouteChaine((int)positionX, (int)positionY, "■");
        return e;
    }

    /**
     * Met à jour la position du projectile pour qu'il avance d'une unité en direction des aliens
     */
    public void evolue(){
        positionY += 1;
    }

    /**
     * Vérifie si le projectile a touché l'alien spécifié
     * @param alien l'alien à vérifier
     * @return true si le projectile a touché l'alien, false sinon
     */
    public boolean touche(Alien alien){
        if (this.positionX >= alien.getPositionX() && this.positionX <= alien.getPositionX()+10 && this.positionY >= alien.getPositionY() && this.positionY <= alien.getPositionY()+5){
            return true;
        }
        return false;
    }
}
