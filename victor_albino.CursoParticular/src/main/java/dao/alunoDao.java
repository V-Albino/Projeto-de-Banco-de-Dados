
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import my.conexao.conexao;
import my.model.aluno;
import java.util.List;
import java.util.ArrayList;


public class alunoDao {
    
    public alunoDao(){
    }
    
    public boolean inserirAluno(aluno a){
    try {
        String SQL="INSERT INTO aluno (nome, material, CPF, telefone) VALUE (?,?,?,?)";
        Connection c = conexao.getConexao();
        PreparedStatement comando = c.prepareStatement(SQL);
        comando.setString(1, a.getNome());
        comando.setString(2, a.getMaterial());
        comando.setString(3, a.getCPF());
        comando.setString(4, a.getTelefone());
        int retorno=comando.executeUpdate();
        c.close();
        if (retorno > 0) {
            return true;
        }
    } catch (SQLException ex) {
        Logger.getLogger(alunoDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;

    }
    
    public List<aluno> listarAlunos() {
    try {
        String SQL = "SELECT nome, material, CPF, telefone FROM  victor_albino.ALUNO ORDER BY nome_aluno";
        List<aluno> listaDeAlunos = new ArrayList<aluno>();
        Connection c = conexao.getConexao();
        PreparedStatement ps = c.prepareStatement(SQL);
        ResultSet resultado = ps.executeQuery();
        while (resultado.next()) {
            aluno atual = new aluno();
            atual = this.pegaDados(resultado);
            listaDeAlunos.add(atual);
        }

        return listaDeAlunos;
    } catch (SQLException ex) {
        Logger.getLogger(alunoDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;

    }

    private aluno pegaDados(ResultSet resultado) {
    try {
        aluno atual = new aluno();
        atual.setNome(resultado.getString("nome"));
        atual.setMaterial(resultado.getString("material"));

        atual.setCPF(resultado.getString("cpf"));
        atual.setTelefone(resultado.getString("telefone"));
        return atual;
    } catch (SQLException ex) {
        Logger.getLogger(alunoDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    }
    
    
    public aluno consulta(String matricula) {
    try {
        String SQL = "SELECT nome, material, CPF, telefone FROM  victor_albino.ALUNO";
        Connection c = conexao.getConexao();
        PreparedStatement ps = c.prepareStatement(SQL);
        ps.setInt(1, Integer.valueOf(matricula));
        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
            aluno atual = new aluno();
            atual = this.pegaDados(resultado);
            return atual;
        }
        return null;
    } catch (SQLException ex) {
        Logger.getLogger(alunoDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    }
        
        public boolean atualizaDados(aluno dados) {
        try {
            String SQL = "UPDATE victor_albino.aluno SET nome = ?, material = ?, CPF = ?, telefone = ?";
            Connection c = conexao.getConexao();
            PreparedStatement comando = c.prepareStatement(SQL);
            comando.setString(1, dados.getNome());
            comando.setString(2, dados.getMaterial());
            comando.setString(3, dados.getCPF());
            comando.setString(4, dados.getTelefone());
            int retorno = comando.executeUpdate();
            c.close();
            if (retorno > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(alunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public aluno consulta(aluno dados) {
        try {
            String SQL = "SELECT nome, material, cpf, telefone FROM  victor_albino.ALUNO ";
            String filtro="";
            Connection c = conexao.getConexao();
            
            if(dados!=null  && dados.getMaterial()!=null && !dados.getMaterial().equalsIgnoreCase("")){
                if(!filtro.equalsIgnoreCase("")){
                    filtro+=" AND material = '"+dados.getMaterial()+"'";
                }else{
                    filtro = " WHERE material = '"+dados.getMaterial()+"'";
                }
            }

            if(dados!=null  && dados.getNome()!=null && !dados.getNome().equalsIgnoreCase("")){
                if(!filtro.equalsIgnoreCase("")){
                    filtro+=" AND nome ilike '%"+dados.getNome()+"%'";
                }else{
                    filtro = " WHERE nome ilike '%"+dados.getNome()+"%'";
                }
            }
            if(dados!=null  && dados.getCPF()!=null && !dados.getCPF().equalsIgnoreCase("")){
                if(!filtro.equalsIgnoreCase("")){
                    filtro+=" AND CPF = '"+dados.getCPF()+"'";
                }else{
                    filtro = " WHERE CPF = '"+dados.getCPF()+"'";
                }
            }

            if(dados!=null  && dados.getTelefone()!=null && !dados.getTelefone().equalsIgnoreCase("")){
                if(!filtro.equalsIgnoreCase("")){
                    filtro+=" AND telefone = '"+dados.getTelefone()+"'";
                }else{
                    filtro = " WHERE telefone = '"+dados.getTelefone()+"'";
                }
            }
            PreparedStatement ps = c.prepareStatement(SQL + filtro);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                aluno atual = new aluno();
                atual = this.pegaDados(resultado);
                return atual;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(alunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

