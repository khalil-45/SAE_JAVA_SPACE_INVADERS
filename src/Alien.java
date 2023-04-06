public class Alien {
    private double positionX;
    private double positionY;

    public Alien(double x, double y){
        this.positionX = x;
        this.positionY = y;
    }

    public double getPositionX(){return positionX;}
    public double getPositionY(){return positionY;}

    public EnsembleChaines getEnsembleChaines(){
        EnsembleChaines e = new EnsembleChaines();
        e.ajouteChaine((int)positionX, (int)positionY+4, "▀▄░░░▄▀");
        e.ajouteChaine((int)positionX, (int)positionY+3, "▄█▀███▀█▄");
        e.ajouteChaine((int)positionX, (int)positionY+2, "█▀███████▀█");
        e.ajouteChaine((int)positionX, (int)positionY+1, "█░█▀▀▀▀▀█░█");
        e.ajouteChaine((int)positionX, (int)positionY, "▀▀░▀▀");
        return e;
    }

    public void evolue() {
        boolean directionDroite;

        if (positionX < 80) {
            positionX += 0.1;
        } else {
            positionY -= 2;
            directionDroite = false;
        }


        /* 
        if (directionDroite) {
            positionX += 0.1;
            if (positionX >= 80) {
                positionY -= 2;
                directionDroite = false;
            }
        } else {
            positionX -= 0.1;
            if (positionX <= 10) {
                positionY -= 2;
                directionDroite = true;
            }
        }
*/
        if (positionY <= 0) {
            System.out.println("Game Over");
            //System.exit(0);
        }
        }
    }

