/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Playlist;

/**
 *
 * @author 322015
 */
public class PlaylistDAO implements DAO<Playlist> {
    
    private final Repositorio rep = new Repositorio();
    
    @Override
    public void inserir(Playlist obj) {
        rep.playlists.add(obj);
        //rep.inserirPlaylist(obj);
    }

    @Override
    public void excluir(int index) {
        rep.playlists.remove(index);
        //rep.excluirPlaylist(index);
    }

    @Override
    public void alterar(int index, Playlist obj) {   
        rep.playlists.get(index).setNome(obj.getNome());
        //rep.alterarPlaylist(index, obj);
    }  

    @Override
    public Playlist buscarPorId(int id) {
        //rep.buscarPorIdPlaylist(id);
        return null;
    }

    @Override
    public List<Playlist> listar() {
        //return rep.listarPlaylists();
        return rep.playlists;
    }
}
