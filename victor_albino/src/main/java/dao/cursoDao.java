
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import my.conexao.conexao;
import my.model.curso;


public class cursoDao {
    public cursoDao(){
    }
    
    public void inserirCurso(curso a){
        try {
            String SQL="INSERT INTO curso (endereço, salas, preço, nome) VALUE (?,?,?,?)";
            Connection MinhaCon = conexao.getConexao();
            PreparedStatement comando = MinhaCon.prepareStatement(SQL);
            comando.setString(1, a.getEndereco());
            comando.setInt(2, a.getSalas());
            comando.setString(3, a.getPreco());
            comando.setString(4, a.getNome());
            MinhaCon.close();
            int retorno=comando.executeUpdate();
            if(retorno>0){
                JOptionPane.showMessageDialog(null,"Curso "+a.getNome()+ "inserido com sucesso");
            }else{
                JOptionPane.showMessageDialog(null,"Erro ao inserir o curso: "+a.getNome()+ ". Verifique os LOGs");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cursoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
