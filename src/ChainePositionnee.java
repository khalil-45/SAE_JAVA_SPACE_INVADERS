public class ChainePositionnee{
    // Coordonnée x de la chaine
    int x;
    
    // Coordonnée y de la chaine
    int y;
    
    // La chaine de caractères à afficher
    String c;
    
    public ChainePositionnee(int a,int b, String d){
        x=a;
        y=b;
        c=d;
    }

    /**
     * Retourne une chaîne de caractères représentant l'objet ChainePositionnee.
     * Cette chaîne contient les valeurs des attributs x, y et c de l'objet.
     *
     * @return Une chaîne de caractères représentant l'objet ChainePositionnee.
     */
    @Override
    public String toString() {
        return "ChainePositionnee{" +
                "x=" + x +
                ", y=" + y +
                ", c='" + c + '\'' +
                '}';
    }
}
