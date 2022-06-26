package controller;

import dao.PlaylistDAO;
import dao.UsuarioDAO;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Playlist;
import model.Usuario;

public class PlaylistController {

    private JTextField codigoTextField;
    private JTextField nomeTextField;
    private JTable tabela;
    private final PlaylistDAO playlistDAO = new PlaylistDAO(); 

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
        playlistDAO.inserir(new Playlist(Integer.parseInt(codigoTextField.getText()), nomeTextField.getText()));
    }
    
    public void editar(int index){
        playlistDAO.alterar(index, new Playlist(Integer.parseInt(codigoTextField.getText()), nomeTextField.getText()));
    }
    
    public void excluir(int index){
        playlistDAO.excluir(index);
    }
    
    public List<Playlist> listar(){
        return playlistDAO.listar();
    }    

    public void atualizarTabela(){
        List<Playlist> playlists = playlistDAO.listar();
        if(!playlists.isEmpty()){
            DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
            modeloTabela.setRowCount(playlists.size());
            tabela.setModel(modeloTabela);
            
            for(int i = 0; i < playlists.size(); i++){
                tabela.getModel().setValueAt(playlists.get(i).getCodigo(), i, 0);
                tabela.getModel().setValueAt(playlists.get(i).getNome(), i, 1);
            }
        }        
    }
}
