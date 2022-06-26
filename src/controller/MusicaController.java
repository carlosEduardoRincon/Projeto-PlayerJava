package controller;

import dao.MusicaDAO;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Musica;

public class MusicaController {
    private JTextField codigoTextField;
    private JTextField nomeTextField;
    private JTextField cantorTextField;
    private JTextField duracaoTextField;
    private JTable tabela;
    private final MusicaDAO musicaDAO = new MusicaDAO(); 

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

    public JTextField getCantorTextField() {
        return cantorTextField;
    }

    public void setCantorTextField(JTextField cantorTextField) {
        this.cantorTextField = cantorTextField;
    }

    public JTextField getDuracaoTextField() {
        return duracaoTextField;
    }

    public void setDuracaoTextField(JTextField duracaoTextField) {
        this.duracaoTextField = duracaoTextField;
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }

    
    public void salvar(){        
        musicaDAO.inserir(new Musica(Integer.parseInt(codigoTextField.getText()), nomeTextField.getText(), cantorTextField.getText(), Integer.parseInt(duracaoTextField.getText())));
    }
    
    public void editar(int index){
        musicaDAO.alterar(index, new Musica(Integer.parseInt(codigoTextField.getText()), nomeTextField.getText(), cantorTextField.getText(), Integer.parseInt(duracaoTextField.getText())));
    }
    
    public void excluir(int index){
        musicaDAO.excluir(index);
    }
    
    public List<Musica> listar(){
        return musicaDAO.listar();
    }    

    public void atualizarTabela(){
        List<Musica> musicas = musicaDAO.listar();
        if(!musicas.isEmpty()){
            DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
            modeloTabela.setRowCount(musicas.size());
            tabela.setModel(modeloTabela);
            
            for(int i = 0; i < musicas.size(); i++){
                tabela.getModel().setValueAt(musicas.get(i).getCodigo(), i, 0);
                tabela.getModel().setValueAt(musicas.get(i).getNome(), i, 1);
                tabela.getModel().setValueAt(musicas.get(i).getCantor(), i, 2);
                tabela.getModel().setValueAt(musicas.get(i).getDuracao(), i, 3);
            }
        }        
    }
}
