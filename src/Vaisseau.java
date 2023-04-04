public class Vaisseau {
    
    private double posX;


    public Vaisseau(double x){
        this.posX = x;
    }

    public double getPosX(){
        return posX;
    }

    public void deplace(double dx){
        double limiteGauche = 0;
        double limiteDroite = 100-10;

        if (posX + dx < limiteGauche){
            posX = limiteGauche;
        } else if (posX + dx > limiteDroite){
            posX = limiteDroite;
        } else {
            posX += dx;
        }
    }

    public EnsembleChaines getEnsembleChaines(){
        EnsembleChaines e = new EnsembleChaines();
        e.ajouteChaine((int)posX, 0, "■■■█████■■■");
        e.ajouteChaine((int)posX, 1, "     uuu");
        e.ajouteChaine((int)posX, 2, "      ▲");
        return e;
    }

    public double positionCanon(){
        return posX + 5;
    }
}
