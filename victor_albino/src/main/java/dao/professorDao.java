
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import my.conexao.conexao;
import my.model.professor;


public class professorDao {
    public professorDao(){
    }
    
    public void inserirProfessor(professor a){
        try {
            String SQL="INSERT INTO professsor (materia, salario, CPF, nome, material, telefone, email) VALUE (?,?,?,?,?,?,?)";
            Connection MinhaCon = conexao.getConexao();
            PreparedStatement comando = MinhaCon.prepareStatement(SQL);
            comando.setString(1, a.getMateria());
            comando.setString(6, a.getSalario());
            comando.setString(4, a.getCPF());
            comando.setString(2, a.getNome());
            comando.setString(3, a.getMaterial());
            comando.setString(5, a.getTelefone()); 
            comando.setString(7, a.getEmail());
            int retorno=comando.executeUpdate();
            MinhaCon.close();
            if(retorno>0){
                JOptionPane.showMessageDialog(null,"Professor "+a.getNome()+ "inserido com sucesso");
            }else{
                JOptionPane.showMessageDialog(null,"Erro ao inserir o Professor: "+a.getNome()+ ". Verifique os LOGs");
            }
        } catch (SQLException ex) {
            Logger.getLogger(alunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
