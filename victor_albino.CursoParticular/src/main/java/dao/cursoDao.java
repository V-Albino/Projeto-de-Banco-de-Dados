
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
            String SQL="INSERT INTO victor_albino.curso (nome, endereco, salas, preco) VALUES (?,?,?,?)";
            Connection c = conexao.getConexao();
            PreparedStatement comando = c.prepareStatement(SQL);
            comando.setString(1, a.getNome());
            comando.setString(2, a.getEndereco());
            comando.setInt(3, a.getSalas());
            comando.setString(4, a.getPreco());   
            int retorno=comando.executeUpdate();
            c.close();
            if(retorno>0){
                JOptionPane.showMessageDialog(null,"Curso "+a.getNome()+ " inserido com sucesso");
            }else{
                JOptionPane.showMessageDialog(null,"Erro ao inserir o curso: "+a.getNome()+ ". Verifique os LOGs");
            }
        } catch (SQLException ex) {
            Logger.getLogger(cursoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
