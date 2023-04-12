public class Projectile {
    private double positionX;
    private double positionY;


    public Projectile(double x, double y){
        this.positionX = x;
        this.positionY = y;
    }

    public double getPositionX(){return positionX;}
    public double getPositionY(){return positionY;}
    public void setPositionX(double x){this.positionX = x;}
    public void setPositionY(double y){this.positionY = y;}

    public EnsembleChaines getEnsembleChaines(){
        EnsembleChaines e = new EnsembleChaines();
        e.ajouteChaine((int)positionX, (int)positionY, "■");
        return e;
    }

    public void evolue(){
        positionY += 1;
    }

    public boolean touche(Alien alien){
        if (this.positionX >= alien.getPositionX() && this.positionX <= alien.getPositionX()+10 && this.positionY >= alien.getPositionY() && this.positionY <= alien.getPositionY()+5){
            return true;
        }
        return false;
    }
}
