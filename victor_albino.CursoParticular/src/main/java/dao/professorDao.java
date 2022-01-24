
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import my.conexao.conexao;
import my.model.professor;


public class professorDao {
    public professorDao(){
    }
    
    
     public boolean atualizaProfessor(professor a) {
        try {
            String SQL = " UPDATE victor_albino.PROFESSOR set materia = ?, salario = ?, CPF = ?, nome = ?, material = ?, telefone = ?, email = ?";
            Connection c = conexao.getConexao();
            PreparedStatement comando = c.prepareStatement(SQL);
            comando.setString(1, a.getMateria());
            comando.setString(6, a.getSalario());
            comando.setString(4, a.getCPF());
            comando.setString(2, a.getNome());
            comando.setString(3, a.getMaterial());
            comando.setString(5, a.getTelefone()); 
            comando.setString(7, a.getEmail());          
            int retorno = comando.executeUpdate();
            c.close();
            if (retorno > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(professorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean inserirProfessor(professor a){
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
            if (retorno > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(professorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
       
    }

    public professor professorConsulta(professor filtro) {
            try {
            professor retorna = null;
            String SQL = "SELECT * FROM janio_silva.PROFESSOR ORDER BY nome_professor ";
            String FiltroWhere="";
            if(filtro!=null && filtro.getMateria()!=null && !filtro.getMateria().equalsIgnoreCase("")){
                if(FiltroWhere.equalsIgnoreCase("")){
                    FiltroWhere=" WHERE ";
                }else{
                    FiltroWhere+=" AND ";
                }
                FiltroWhere+=" materia = '"+filtro.getMateria()+"'";
            }
            if(filtro!=null && filtro.getSalario()!=null && !filtro.getSalario().equalsIgnoreCase("")){
                if(FiltroWhere.equalsIgnoreCase("")){
                    FiltroWhere=" WHERE ";
                }else{
                    FiltroWhere+=" AND ";
                }
                FiltroWhere+=" salario = '"+filtro.getSalario()+"'";
            }
            
            if(filtro!=null && filtro.getCPF()!=null && !filtro.getCPF().equalsIgnoreCase("")){
                FiltroWhere=" WHERE cpf = '"+filtro.getCPF()+"'";
            }
            if(filtro!=null && filtro.getNome()!=null && !filtro.getNome().equalsIgnoreCase("")){
                if(FiltroWhere.trim().equalsIgnoreCase("")){
                    FiltroWhere=" WHERE ";
                }else{
                    FiltroWhere+=" AND ";
                }
                FiltroWhere+=" nome_professor ilike '%"+filtro.getNome()+"%'";
            }
            if(filtro!=null && filtro.getMaterial()!=null && !filtro.getMaterial().equalsIgnoreCase("")){
                if(FiltroWhere.equalsIgnoreCase("")){
                    FiltroWhere=" WHERE ";
                }else{
                    FiltroWhere+=" AND ";
                }
                FiltroWhere+=" material = '"+filtro.getMaterial()+"'";
            }
            
            if(filtro!=null && filtro.getTelefone()!=null && !filtro.getTelefone().equalsIgnoreCase("")){
                if(FiltroWhere.equalsIgnoreCase("")){
                    FiltroWhere=" WHERE ";
                }else{
                    FiltroWhere+=" AND ";
                }
                FiltroWhere+=" telefone = '"+filtro.getTelefone()+"'";
            }
            if(filtro!=null && filtro.getEmail()!=null && !filtro.getEmail().equalsIgnoreCase("")){
                if(FiltroWhere.equalsIgnoreCase("")){
                    FiltroWhere=" WHERE ";
                }else{
                    FiltroWhere+=" AND ";
                }
                FiltroWhere+=" email = '"+filtro.getEmail()+"'";
            }
            Connection c = conexao.getConexao();
            System.out.println(SQL + FiltroWhere);
            PreparedStatement comando = c.prepareStatement(SQL + FiltroWhere);
            ResultSet rs = comando.executeQuery();
            c.close();
            if(rs!=null && rs.next()){
                retorna = this.formata(rs);
            }
            return retorna;
            } catch (SQLException ex) {
            Logger.getLogger(professorDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    private professor formata(ResultSet rs){
        try {
            professor retorna = new professor();
            retorna.setMateria(rs.getString("materia"));
            retorna.setSalario(rs.getString("salario"));
            retorna.setCPF(rs.getString("cpf"));
            retorna.setNome(rs.getString("nome_professor"));
            retorna.setMaterial(rs.getString("material"));
            retorna.setTelefone(rs.getString("telefone"));
            retorna.setEmail(rs.getString("email"));
            return retorna;
        } catch (SQLException ex) {
            Logger.getLogger(professorDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    public List<professor> professorConsulta() {
        try {
            List<professor> retorna = new ArrayList<professor>();
            String SQL = "SELECT * FROM victor_albino.PROFESSOR ORDER BY nome_professor";
            Connection c = conexao.getConexao();
            PreparedStatement ps = c.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            c.close();
            while(rs.next()){
                professor atual = this.formata(rs);
                retorna.add(atual);
            }
            return retorna;
        } catch (SQLException ex) {
            Logger.getLogger(professorDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
