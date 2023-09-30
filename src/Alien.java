public class Alien {
    private double positionX;
    private double positionY;
    private double vitesse;

    public Alien(double x, double y, double vitesse) {
        this.positionX = x;
        this.positionY = y;
        this.vitesse = vitesse;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public EnsembleChaines getEnsembleChaines() {
        EnsembleChaines e = new EnsembleChaines();
        e.ajouteChaine((int)positionX, (int)positionY+4, "▀▄░░░▄▀");
        e.ajouteChaine((int)positionX, (int)positionY+3, "▄█▀███▀█▄");
        e.ajouteChaine((int)positionX, (int)positionY+2, "█▀███████▀█");
        e.ajouteChaine((int)positionX, (int)positionY+1, "█░█▀▀▀▀▀█░█");
        e.ajouteChaine((int)positionX, (int)positionY, "▀▀░▀▀");
        return e;
    }

    public void evolue(int largeurFenetre) {
        double deplacement = vitesse;

        positionX += deplacement;
        
        // Vérification de la limite droite de la fenêtre
        if (positionX > largeurFenetre) {
            positionX = largeurFenetre;
            positionY -= 5;
            vitesse = -vitesse; // Inversion de la vitesse pour repartir vers la gauche
        }
        
        // Vérification de la limite gauche de la fenêtre
        if (positionX < 0) {
            positionX = 0;
            positionY -= 5 ;
            vitesse = -vitesse; // Inversion de la vitesse pour repartir vers la droite
        }
    }
    
}
