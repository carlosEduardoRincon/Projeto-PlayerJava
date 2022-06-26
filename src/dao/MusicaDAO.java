/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Musica;

/**
 *
 * @author 322015
 */
public class MusicaDAO implements DAO<Musica>{
    
    private final Repositorio rep = new Repositorio();
    
    @Override
    public void inserir(Musica obj) {
        rep.musicas.add(obj);
        //rep.inserirMusica(obj);
    }

    @Override
    public void excluir(int index) {
        rep.musicas.remove(index);
        //rep.excluirMusica(index);
    }

    @Override
    public void alterar(int index, Musica obj) {   
        rep.musicas.get(index).setNome(obj.getNome());
        rep.musicas.get(index).setCantor(obj.getCantor());
        rep.musicas.get(index).setDuracao(obj.getDuracao());
        //rep.alterarMusica(index, obj);
    }  

    @Override
    public Musica buscarPorId(int id) {
    //rep.buscarPorIdMusica(id);
        return null;
    }

    @Override
    public List<Musica> listar() {
        //return rep.listarMusicas();
        return rep.musicas;
    }

}
