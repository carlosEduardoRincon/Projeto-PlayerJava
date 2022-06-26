package controller;

import dao.UsuarioDAO;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Usuario;

/*
    Classe Controller do Usuário,
    Nessa classe que faz o vínculo entre modelo e tela,
    Tudo que tenho na tela, terei um componente aqui para controlar, se preciso.
    Por exemplo, preciso controlar os dados de 2 jTextFields que estão na tela
    UsuarioView. Esses campos servirão para fazer o CRUD do Usuario, salvar,
    alterar, excluir e leitura.
    Os métodos pegam os dados da view e passam para UsuarioDAO, que cuida de
    executar a ação no banco.
*/

public class UsuarioController {
    
    private JTextField codigoTextField;
    private JTextField nomeTextField;
    private JTable tabela;
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public JTextField getCodigoTextField() {
        return codigoTextField;
    }

    public void setCodigoTextField(JTextField codigoTextField) {
        this.codigoTextField = codigoTextField;
    }

    public JTextField getNomeTextField() {
        return nomeTextField;
    }

    public void setNomeTextField(JTextField nomeTextField) {
        this.nomeTextField = nomeTextField;
    }
    
    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }        

    public void salvar(){        
        usuarioDAO.inserir(new Usuario(Integer.parseInt(codigoTextField.getText()), nomeTextField.getText()));
    }
    
    public void editar(int index){
        usuarioDAO.alterar(index, new Usuario(Integer.parseInt(codigoTextField.getText()), nomeTextField.getText()));
    }
    
    public void excluir(int index){
        usuarioDAO.excluir(index);
    }
    
    public List<Usuario> listar(){
        return usuarioDAO.listar();
    }
    
    public void atualizarTabela(){
        List<Usuario> usuarios = usuarioDAO.listar();
        if(usuarios.size() > 0){
            DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
            modeloTabela.setRowCount(usuarios.size());
            tabela.setModel(modeloTabela);
            
            for(int i=0; i<usuarios.size(); i++){
                tabela.getModel().setValueAt(usuarios.get(i).getCodigo(), i, 0);
                tabela.getModel().setValueAt(usuarios.get(i).getNome(), i, 1);
            }
        }        
    }
}
