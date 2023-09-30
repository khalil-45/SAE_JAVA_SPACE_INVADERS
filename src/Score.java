/**
 * La classe Score représente le score actuel du joueur.
 */
public class Score {
    /**
     * Le score actuel du joueur.
     */
    private int score;

    /**
     * Constructeur par défaut initialisant le score à zéro.
     */
    public Score(){
        this.score = 0;
    }

    /**
     * Retourne le score actuel du joueur.
     * @return Le score actuel du joueur.
     */
    public int getScore(){return score;}

    /**
     * Ajoute une valeur spécifiée au score actuel du joueur.
     * @param valeur Elle représente la valeur à ajouter au score.
     */
    public void ajouteScore(int valeur){
        this.score += valeur;
    }
}
