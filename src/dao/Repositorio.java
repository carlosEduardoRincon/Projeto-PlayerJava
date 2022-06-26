package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.Musica;
import model.Playlist;
import model.Usuario;

public class Repositorio {
    public static Repositorio instance;

    public static final File diretorioPlayer = new File(System.getProperty("user.dir") + "\\repositorio");
    public final File arqUsuarios = new File(diretorioPlayer + "\\usuarios.txt");
    public final File arqPlaylists = new File(diretorioPlayer + "\\playlists.txt");
    public final File arqMusicas = new File(diretorioPlayer + "\\musicas.txt");

    public List<Usuario> usuarios;
    public List<Playlist> playlists;
    public List<Musica> musicas;

    public static Repositorio getInstance() {
        if (instance == null) {
            instance = new Repositorio();
            criarDiretorio(diretorioPlayer);
        }
        return instance;
    }

    public Repositorio() {
        usuarios = new ArrayList();
        playlists = new ArrayList();
        musicas = new ArrayList();

        // 
        //usuarios = listarUsuarios();
        //playlists = listarPlaylists();
        //musicas = listarMusicas();
    }

    public void inserirUsuario(Usuario usuario){
        try {
            System.out.println("Criando usuário " + usuario.getNome() + ".");

            File arquivo = new File(diretorioPlayer, arqUsuarios.getAbsolutePath());
            FileWriter fileWriter;
            PrintWriter printWriter;

            fileWriter = new FileWriter(arquivo, false);
            printWriter = new PrintWriter(fileWriter);
            printWriter.print(usuario.getCodigo() + "," + usuario.getNome());
            printWriter.flush();
            printWriter.close();
            System.out.println("Usuário criado com sucesso.");
        } catch (Throwable e) {
            System.out.println("Usuário não criado com sucesso.");
        }
    }

    public void inserirPlaylist(Playlist playlist){
        try {
            System.out.println("Criando playlist " + playlist.getNome() + ".");

            File arquivo = new File(diretorioPlayer, arqPlaylists.getAbsolutePath());
            FileWriter fileWriter;
            PrintWriter printWriter;

            fileWriter = new FileWriter(arquivo, false);
            printWriter = new PrintWriter(fileWriter);
            printWriter.print(playlist.getCodigo() + "," + playlist.getNome() + ":" + playlist.getIdUsuario());
            printWriter.flush();
            printWriter.close();
            System.out.println("Playlist criada com sucesso.");
        } catch (Throwable e) {
            System.out.println("Playlist não criada com sucesso.");
        }
    }

    public void inserirMusica(Musica musica){
        try {
            System.out.println("Criando musica " + musica.getNome() + ".");

            File arquivo = new File(diretorioPlayer, arqMusicas.getAbsolutePath());
            FileWriter fileWriter;
            PrintWriter printWriter;

            fileWriter = new FileWriter(arquivo, false);
            printWriter = new PrintWriter(fileWriter);
            printWriter.print(musica.getCodigo() + "," + musica.getNome() + "," + musica.getCantor() + "," + musica.getDuracao() + ":" + musica.getIdPlaylist());
            printWriter.flush();
            printWriter.close();
            System.out.println("Música criada com sucesso.");
        } catch (Throwable e) {
            System.out.println("Música não criada com sucesso.");
        }
    }

    public List<Usuario> listarUsuarios(){
        File usuarios = new File(arqUsuarios.getAbsolutePath());
        FileReader leitor;
        BufferedReader buffer;
        List<Usuario> listUsuarios = new ArrayList<>();
        try {
            System.out.println("Listando Usuários.");

            leitor = new FileReader(usuarios);
            buffer = new BufferedReader(leitor);
            String linha = "";
            StringBuilder strBuilder = new StringBuilder(linha);
            while((linha = buffer.readLine()) != null){
                strBuilder.append(linha);
            }

            String linhas = strBuilder.substring(0);
            String [] linhasUsuarios = linhas.split("\n");

            for (String l: linhasUsuarios) {
                Usuario usuario = new Usuario();
                usuario.setCodigo(Integer.valueOf(l.split(",")[0]));
                usuario.setNome(l.split(",")[1]);
                listUsuarios.add(usuario);
            }

            leitor.close();
            buffer.close();

            System.out.println("Usuários listados com sucesso.");
            return listUsuarios;
        } catch (Throwable e) {
            System.out.println("Usuários não listados com sucesso.");
        }
        return null;
    }

    public List<Playlist> listarPlaylists(){
        File playlists = new File(arqPlaylists.getAbsolutePath());
        FileReader leitor;
        BufferedReader buffer;
        List<Playlist> listPlaylist = new ArrayList<>();
        try {
            System.out.println("Listando Playlists.");

            leitor = new FileReader(playlists);
            buffer = new BufferedReader(leitor);
            String linha = "";
            StringBuilder strBuilder = new StringBuilder(linha);
            while((linha = buffer.readLine()) != null){
                strBuilder.append(linha);
            }

            String linhas = strBuilder.substring(0);
            String [] linhasPlaylists = linhas.split("\n");

            for (String l: linhasPlaylists) {
                Playlist playlist = new Playlist();
                playlist.setCodigo(Integer.valueOf(l.split(",")[0]));
                playlist.setNome(l.split(",")[1]);
                playlist.setIdUsuario(Integer.valueOf(l.split(";")[1]));
                listPlaylist.add(playlist);
            }

            leitor.close();
            buffer.close();

            System.out.println("Playlists listadas com sucesso.");
            return listPlaylist;
        } catch (Throwable e) {
            System.out.println("Playlists não listadas com sucesso.");
        }
        return null;
    }

    public List<Musica> listarMusicas(){
        File musicas = new File(arqMusicas.getAbsolutePath());
        FileReader leitor;
        BufferedReader buffer;
        List<Musica> listMusicas = new ArrayList<>();
        try {
            System.out.println("Listando Músicas.");

            leitor = new FileReader(musicas);
            buffer = new BufferedReader(leitor);
            String linha = "";
            StringBuilder strBuilder = new StringBuilder(linha);
            while((linha = buffer.readLine()) != null){
                strBuilder.append(linha);
            }

            String linhas = strBuilder.substring(0);
            String [] linhasMusicas = linhas.split("\n");

            for (String l: linhasMusicas) {
                Musica musica = new Musica();
                musica.setCodigo(Integer.valueOf(l.split(",")[0]));
                musica.setNome(l.split(",")[1]);
                musica.setCantor(l.split(",")[2]);
                musica.setDuracao(Integer.valueOf(l.split(",")[3]));
                musica.setIdPlaylist(Integer.valueOf(l.split(";")[1]));
                listMusicas.add(musica);
            }

            leitor.close();
            buffer.close();  
           
            System.out.println("Músicas listadas com sucesso.");
            return listMusicas;
        } catch (Throwable e) {
            System.out.println("Músicas não listadas com sucesso.");
        }
        return null;
    }

    public void excluirUsuario(int codUsuario){
        System.out.println("Removendo usuário com código" + codUsuario + ".");
        boolean status = false;

        List<Usuario> usuarios = listarUsuarios();
        File file = new File(arqUsuarios.getAbsolutePath());
        status = file.delete();

        for (Usuario u: usuarios) {
            if (codUsuario != u.getCodigo()) {
                inserirUsuario(u);
            } 
        }

        if (status) {
            System.out.println("Usuário removido com sucesso.");
        } else {
            System.out.println("Usuário não removido com sucesso.");
        }
    }

    public void excluirPlaylist(int codPlaylist){
        System.out.println("Removendo playlist com código" + codPlaylist + ".");
        boolean status = false;

        List<Playlist> playlists = listarPlaylists();
        File file = new File(arqPlaylists.getAbsolutePath());
        status = file.delete();

        for (Playlist p: playlists) {
            if (codPlaylist != p.getCodigo()) {
                inserirPlaylist(p);
            } 
        }        

        if (status) {
            System.out.println("Playlist removida com sucesso.");
        } else {
            System.out.println("Playlist não removida com sucesso.");
        }
    }

    public void excluirMusica(int codMusica){
        System.out.println("Removendo música com código" + codMusica + ".");
        boolean status = false;

        List<Musica> Musicas = listarMusicas();
        File file = new File(arqMusicas.getAbsolutePath());
        status = file.delete();

        for (Musica m: musicas) {
            if (codMusica != m.getCodigo()) {
                inserirMusica(m);
            } 
        }         

        if (status) {
            System.out.println("Música removida com sucesso.");
        } else {
            System.out.println("Música não removida com sucesso.");
        }
    }

    public File alterarUsuario(int index, Usuario obj){
        return new File("");
    }

    public File alterarPlaylist(int index, Playlist obj){
        return new File("");
    }

    public File alterarMusica(int index, Musica obj){
        return new File("");
    }

    public File buscarPorIdUsuario(int id){
        return new File("");
    }

    public File buscarPorIdPlaylist(int id){
        return new File("");
    }

    public File buscarPorIdMusica(int id){
        return new File("");
    }

    public static void criarDiretorio(File dir){
        System.out.println("Criando diretório.");
        boolean status = false;

        if(dir.exists()){
            System.out.println("O Diretório especificado já existe.");
        } else {
            status = dir.mkdir();
        }

        if (status) {
            System.out.println("O Diretório foi criado com sucesso.");
        } else {
            System.out.println("Diretório não foi criado  com sucesso.");
        }
    }

}
