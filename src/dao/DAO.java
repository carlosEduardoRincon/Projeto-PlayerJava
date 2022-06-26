package dao;

import java.util.List;


/*
    Interface criada com os métodos necessários para o uso
    em uma classe que trabalha com DAO
*/

public interface DAO<T> {      
    
        public abstract void inserir(T obj);
        public abstract void excluir(int index);
        public abstract void alterar(int index, T obj);
        public abstract T buscarPorId(int id);
        public abstract List<T> listar();
        
}
