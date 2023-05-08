import java.util.ArrayList;

/**
 * La classe EnsembleChaines permet de stocker un ensemble de chaînes de caractères à des positions données.
 */
public class EnsembleChaines {
    /* Liste des chaînes positionnées dans l'ensemble */
    ArrayList<ChainePositionnee> chaines;

    /**
     * Constructeur de la classe EnsembleChaines.
     * Initialise une nouvelle instance de la liste chaines.
     */
    public EnsembleChaines(){
        chaines= new ArrayList<ChainePositionnee>();
    }

    /**
     * Retourne la liste des chaînes positionnées dans l'ensemble.
     *
     * @return Liste des chaînes positionnées dans l'ensemble.
     */
    public ArrayList<ChainePositionnee> getChaines(){
        return this.chaines;
    }

    /**
     * Ajoute une chaîne à la liste des chaînes positionnées dans l'ensemble.
     *
     * @param x Coordonnée x de la chaîne à ajouter.
     * @param y Coordonnée y de la chaîne à ajouter.
     * @param c Chaîne de caractères à ajouter.
     */
    public void ajouteChaine(int x, int y, String c){
        chaines.add(new ChainePositionnee(x,y,c));
    }

    /**
     * Combine cet ensemble de chaînes avec un autre ensemble de chaînes.
     *
     * @param e Ensemble de chaînes à combiner.
     */
    public void union(EnsembleChaines e){
        for(ChainePositionnee c : e.chaines){
            chaines.add(c);
        }
    }

    /**
     * Retourne une représentation sous forme de chaîne de l'ensemble de chaînes.
     *
     * @return Représentation sous forme de chaîne de l'ensemble de chaînes.
     */
    @Override
    public String toString() {
        return "EnsembleChaines{" +
                "chaines=" + chaines +
                '}';
    }

}
