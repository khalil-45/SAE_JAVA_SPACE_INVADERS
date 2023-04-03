public class Vaisseau {
    
    private double posX;


    public Vaisseau(double x){
        this.posX = x;
    }

    public double getPosX(){
        return posX;
    }

    public void deplace(double dx){
        posX += dx;
    }

    public EnsembleChaines getEnsembleChaines(){
        EnsembleChaines e = new EnsembleChaines();
        e.ajouteChaine((int)posX, 0, "■■■█████■■■");
        e.ajouteChaine((int)posX, 1, "     uu");
        e.ajouteChaine((int)posX, 2, "     ▲");
        return e;
    }
}
