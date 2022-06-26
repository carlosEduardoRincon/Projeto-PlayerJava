package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    /* Attributes */
    private int codigo;
    private String nome;
    private List<Playlist> playlists = new ArrayList();

    public Usuario() {
    }

    public Usuario(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }        

    public Playlist getPlaylist(int index) {
        return playlists.get(index);
    }
        
    public void addPlaylist(Playlist playlist){
        playlists.add(playlist);
    }    

    @Override
    public String toString() {
        String res = "================================\n"; 
        res += "Usuario{" + "nome=" + nome + '}';
        for(int i=0; i<playlists.size(); i++){
            res += "\n" + playlists.get(i).toString();
        }
        res += "\n================================";
        return res;
    } 
}
