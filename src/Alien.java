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
        while (positionY > 0){
            positionX += 0.1;
    
            if (positionX == 100){
                positionY -= 1;
                int cpt = 0;
    
                while (cpt < 100){
                    positionX -= 0.1;
                    cpt++;
                }
            }
    
            positionY -= 0.1;  // Ajout de cette ligne pour faire descendre l'alien
    
            // Condition pour sortir de la boucle
            if (positionY <= 0) {
                break;
            }
        }
    }
    }
