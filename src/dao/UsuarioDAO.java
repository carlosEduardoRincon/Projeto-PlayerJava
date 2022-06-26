package dao;

import java.util.List;
import model.Usuario;

/*
    Métodos comentados pois não realizei os testes.
*/

public class UsuarioDAO implements DAO<Usuario>{

    private final Repositorio rep = Repositorio.getInstance();
    
    @Override
    public void inserir(Usuario obj) {
        rep.usuarios.add(obj);
        //rep.inserirUsuario(obj);
    }

    @Override
    public void excluir(int index) {
        rep.usuarios.remove(index);
        //rep.excluirUsuario(index);
    }

    @Override
    public void alterar(int index, Usuario obj) {   
        rep.usuarios.get(index).setNome(obj.getNome());
        //rep.alterarUsuario(index, obj);
    }  

    @Override
    public Usuario buscarPorId(int id) {
        //rep.buscarPorIdUsuario(id);
        return null;
    }

    @Override
    public List<Usuario> listar() {
        //return rep.listarUsuarios();
        return rep.usuarios;
    }


    
}
