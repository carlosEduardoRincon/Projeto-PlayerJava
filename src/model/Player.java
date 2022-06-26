package model;

public class Player {
    
    private Usuario user;
    private Controlavel controle;

    public Player(Usuario user, Controlavel controle) {
        this.user = user;
        this.controle = controle;
    }

    public Controlavel getControle() {
        return controle;
    }        
    
    public void reproduzindo(int index){
        System.out.println(user.getPlaylist(index).toString());
    }
    
}
