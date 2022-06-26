package model;

public class Musica {

    /* Attributes */
    private int codigo;
    private String nome;
    private String cantor;
    private int duracao;

    /* External Key */
    private int idPlaylist;

    public Musica() {
    }

    public Musica(int codigo, String nome, String cantor, int duracao) {
        this.codigo = codigo;
        this.nome = nome;
        this.cantor = cantor;
        this.duracao = duracao;
    }

    public Musica(String nome, String cantor, int duracao) {
        this.nome = nome;
        this.cantor = cantor;
        this.duracao = duracao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCantor() {
        return cantor;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    @Override
    public String toString() {
        return "Musica{" + "código=" + codigo + ", nome=" + nome + ", cantor=" + cantor + ", duracao=" + duracao + '}';
    }        
    
}
