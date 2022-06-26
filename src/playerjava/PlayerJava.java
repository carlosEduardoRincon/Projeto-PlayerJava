package playerjava;

import model.Playlist;
import model.Musica;
import model.Usuario;
import model.ControleRemoto;
import model.Player;

public class PlayerJava {

    public static void main(String[] args) {
        Usuario us = new Usuario(001,"Joao");
        Musica m1 = new Musica("Musica A", "Cantor A", 120);
        Musica m2 = new Musica("Musica B", "Cantor B", 111);
        Musica m3 = new Musica("Musica C", "Cantor C", 30);
        Playlist p1 = new Playlist(10, "play1");
        Playlist p2 = new Playlist(20, "play2");
        Player player = new Player(us, new ControleRemoto());
        p1.addMusica(m1);
        p1.addMusica(m2);
        p2.addMusica(m2);
        p2.addMusica(m3);
        us.addPlaylist(p1);
        us.addPlaylist(p2);
        player.getControle().ligar();
        player.reproduzindo(1);
    }
    
}
