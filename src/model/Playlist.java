package model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    
    /* Attributes */
    private int codigo;
    private String nome;
    private List<Musica> musicas = new ArrayList();

    /* External Key */
    private int idUsuario;

    public Playlist(){
    }

    public Playlist(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addMusica(Musica musica){
        musicas.add(musica);
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    


    @Override
    public String toString() {
        String res = "================================\n"; 
        res += "Playlist{" + "codigo=" + codigo + ", nome=" + nome + '}';
        for(int i=0; i<musicas.size(); i++){
            res += "\n" + musicas.get(i).toString();
        }
        res += "\n================================";
        return res;
    } 
        
}
