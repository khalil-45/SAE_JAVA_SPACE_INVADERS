public class Vaisseau {
    
    private double posX;


    public Vaisseau(double x){
        this.posX = x;
    }

    public double getPosX(){
        return this.posX;
    }

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

    public EnsembleChaines getEnsembleChaines(){
        EnsembleChaines e = new EnsembleChaines();
        e.ajouteChaine((int)posX, 0, "■■■█████■■■");
        e.ajouteChaine((int)posX, 1, "     uuu");
        e.ajouteChaine((int)posX, 2, "      ▲");
        return e;
    }

    public double positionCanon(){
        return this.posX + 5;
    }
}
