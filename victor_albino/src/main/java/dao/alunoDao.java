
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import my.conexao.conexao;
import my.model.aluno;


public class alunoDao {
    public alunoDao(){
    }
    
    public void inserirAluno(aluno a){
        try {
            String SQL="INSERT INTO aluno (nome, material, CPF, telefone) VALUE (?,?,?,?)";
            Connection MinhaCon = conexao.getConexao();
            PreparedStatement comando = MinhaCon.prepareStatement(SQL);
            comando.setString(1, a.getNome());
            comando.setString(2, a.getMaterial());
            comando.setString(3, a.getCPF());
            comando.setString(4, a.getTelefone());
            int retorno=comando.executeUpdate();
            MinhaCon.close();
            if(retorno>0){
                JOptionPane.showMessageDialog(null,"Aluno "+a.getNome()+ "inserido com sucesso");
            }else{
                JOptionPane.showMessageDialog(null,"Erro ao inserir o aluno: "+a.getNome()+ ". Verifique os LOGs");
            }
        } catch (SQLException ex) {
            Logger.getLogger(alunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
