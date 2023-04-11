public class lancerJeuButton extends EventHandler<ActionEvent>{
    private GestionJeu gestionnaire;
    
    public lancerJeuButton(GestionJeu gestionnaire){
        this.gestionnaire = gestionnaire;
    }

    @Override
    public void handle(ActionEvent event) {
        this.gestionnaire.lancerJeu();
        System.out.println("Lancer le jeu");
    }
    
}
