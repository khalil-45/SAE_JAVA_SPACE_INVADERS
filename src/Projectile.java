public class Projectile {
    private double positionX;
    private double positionY;


    public Projectile(double x, double y){
        this.positionX = x;
        this.positionY = y;
    }

    public double getPositionX(){return positionX;}
    public double getPositionY(){return positionY;}

    public EnsembleChaines getEnsembleChaines(){
        EnsembleChaines e = new EnsembleChaines();
        e.ajouteChaine((int)positionX, (int)positionY, "■");
        return e;
    }

    public void evolue(){
        positionY += 0.2;
    }

    public boolean touche(Alien alien){
        if (this.positionX >= alien.getPositionX() && this.positionX <= alien.getPositionX()+10 && this.positionY >= alien.getPositionY() && this.positionY <= alien.getPositionY()+5){
            return true;
        }
        return false;
    }
}
