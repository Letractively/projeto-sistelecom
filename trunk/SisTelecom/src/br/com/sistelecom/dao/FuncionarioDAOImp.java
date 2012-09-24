/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.sistelecom.connection.ConnectionFactory;
import br.com.sistelecom.entity.Funcionario;
import br.com.sistelecom.interfaces.dao.FuncionarioDAO;

/**
 *
 * @author Danilo Alves
 */
public class FuncionarioDAOImp implements FuncionarioDAO {
    
    private Connection conn;
    
    /**
     * 
     * @throws Exception 
     */
    public FuncionarioDAOImp () throws Exception {
        
        try{
            this.conn = ConnectionFactory.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro " + "\n" + e.getMessage());
        }
    }
    /**
     * Método que cria um funcionário
     * @param funcionario
     * @throws Exception 
     */
    //@Override
    public void salvar(Funcionario funcionario) throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        
        if(funcionario == null) {
            throw new Exception("O valor que é passado não pode ser nulo.");
        }
        
        try{
            
            String SQL = "INSERT INTO funcionario (cpf, departamento, nome, logradouro, numero,"
                    + " complemento, bairro, cidade, uf, cep, nasc, tel_1, tel_2, doc, tipo_doc, cargo, superv_funcao,"
                    + " superv_nome, admissao, status, auditoria, login, password)" +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, funcionario.getCpf());
            ps.setInt(2, funcionario.getDepartamento());
            ps.setString(3, funcionario.getNome());
            ps.setString(4, funcionario.getLogradouro());
            ps.setInt(5, funcionario.getNumero());
            ps.setString(6, funcionario.getComplemento());
            ps.setString(7, funcionario.getBairro());
            ps.setInt(8, funcionario.getCidade());
            ps.setInt(9, funcionario.getUf());
            ps.setInt(10, funcionario.getCep());
            ps.setDate(11, new java.sql.Date(funcionario.getNasc().getTime()));
            ps.setInt(12, funcionario.getTel1());
            ps.setInt(13, funcionario.getTel2());
            ps.setInt(14, funcionario.getDoc());
            ps.setString(15, funcionario.getTipoDoc());
            ps.setInt(16, funcionario.getCargo());
            ps.setString(17, funcionario.getSupervFuncao());
            ps.setString(18, funcionario.getSupervNome());
            ps.setDate(19, new java.sql.Date(funcionario.getAdmissao().getTime()));
            ps.setString(20, funcionario.getStatus());
            ps.setDate(21, new java.sql.Date(funcionario.getAuditoria().getTime()));
            ps.setString(22, funcionario.getLogin());
            ps.setString(23, funcionario.getPassword());
            
            ps.executeUpdate();
        } catch (Exception sqle) {
            throw new Exception ("Erro ao inserir o funcionário: " + sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
    }
    /**
     * Métodos que atualiza o cadastro de funcionarios
     * @param funcionario
     * @throws Exception 
     */
    //@Override
    public void atualizar(Funcionario funcionario) throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        
        if(funcionario == null) {
            throw new Exception ("O valor a ser passado não pode ser nulo.");
        }
        try{
            String SQL = "UPDATE funcionario SET cpf=?, departamento=?, nome=?, logradouro=?, numero=?, complemento=?, " +
                    "bairro=?, cidade=?, uf=?, cep=?, nasc=?, tel_1=?, tel_2=?, doc=?, tipo_doc=?, cargo=?, superv_funcao=?, superv_nome=?, " +
                    "admissao=?, status=?, auditoria=?, login=?, password=? " +
                    "WHERE idfuncionario = ?;";
            
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, funcionario.getCpf());
            ps.setInt(2, funcionario.getDepartamento());
            ps.setString(3, funcionario.getNome());
            ps.setString(4, funcionario.getLogradouro());
            ps.setInt(5, funcionario.getNumero());
            ps.setString(6, funcionario.getComplemento());
            ps.setString(7, funcionario.getBairro());
            ps.setInt(8, funcionario.getCidade());
            ps.setInt(9, funcionario.getUf());
            ps.setInt(10, funcionario.getCep());
            ps.setDate(11, new java.sql.Date(funcionario.getNasc().getTime()));
            ps.setInt(12, funcionario.getTel1());
            ps.setInt(13, funcionario.getTel2());
            ps.setInt(14, funcionario.getDoc());
            ps.setString(15, funcionario.getTipoDoc());
            ps.setInt(16, funcionario.getCargo());
            ps.setString(17, funcionario.getSupervFuncao());
            ps.setString(18, funcionario.getSupervNome());
            ps.setDate(19, new java.sql.Date(funcionario.getAdmissao().getTime()));
            ps.setString(20, funcionario.getStatus());
            ps.setDate(21, new java.sql.Date(funcionario.getAuditoria().getTime()));
            ps.setString(22, funcionario.getLogin());
            ps.setString(23, funcionario.getPassword());
            ps.setInt(24, funcionario.getIdFuncionario());
            
            ps.executeUpdate();
        } catch (Exception sqle) {
            throw new Exception ("Erro ao atualizar os dados " + sqle.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
    }
    /**
     * Método que lista todos os funcionarios
     * @return
     * @throws Exception 
     */
    //@Override
    public List todosFuncionarios() throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        try{
            
            conn = this.conn;
            ps = conn.prepareStatement("select * from funcionario");
            rs = ps.executeQuery();
            List<Funcionario> list = new ArrayList<Funcionario>();
            while (rs.next()) {
                Integer idFuncionario = rs.getInt(1);
                String cpf = rs.getString(2);
                Integer departamento = rs.getInt(3);
                String nome = rs.getString(4);
                String logradouro = rs.getString(5);
                Integer numero = rs.getInt(6);
                String complemento = rs.getString(7);
                String bairro = rs.getString(8);
                Integer cidade = rs.getInt(9);
                Integer uf = rs.getInt(10);
                Integer cep = rs.getInt(11);
                Date nasc = rs.getDate(12);
                Integer tel1 = rs.getInt(13);
                Integer tel2 = rs.getInt(14);
                Integer doc = rs.getInt(15);
                String tipoDoc = rs.getString(16);
                Integer cargo = rs.getInt(17);
                String supervFuncao = rs.getString(18);
                String supervNome = rs.getString(19);
                Date admissao = rs.getDate(20);
                String status = rs.getString(21);
                Date auditorio = rs.getDate(22);
                String login = rs.getString(23);
                String password = rs.getString(24);
                
                list.add(new Funcionario(idFuncionario, cpf, departamento, nome, logradouro, numero, complemento, bairro, cidade, uf, cep, nasc, tel1, tel2, doc, tipoDoc, cargo, supervFuncao, supervNome, admissao, status, auditorio, login, password));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception (sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }
    /**
     * Método que procura um funcionário pelo id
     * @param idfuncionario
     * @return
     * @throws Exception 
     */

    //@Override
    public Funcionario procurarIdFuncionario(Integer idFuncionario) throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        try{
            conn = this.conn;
            ps = conn.prepareStatement("select * from funcionario where idfuncionario = ?");
            ps.setInt(1, idFuncionario);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new Exception("Não foi encontrado nenhum funcionario com esse id: " + idFuncionario);
        }
            String cpf = rs.getString(2);
            Integer departamento = rs.getInt(3);
            String nome = rs.getString(4);
            String logradouro = rs.getString(5);
            Integer numero = rs.getInt(6);
            String complemento = rs.getString(7);
            String bairro = rs.getString(8);
            Integer cidade = rs.getInt(9);
            Integer uf = rs.getInt(10);
            Integer cep = rs.getInt(11);
            Date nasc = rs.getDate(12);
            Integer tel1 = rs.getInt(13);
            Integer tel2 = rs.getInt(14);
            Integer doc = rs.getInt(15);
            String tipoDoc = rs.getString(16);
            Integer cargo = rs.getInt(17);
            String supervFuncao = rs.getString(18);
            String supervNome = rs.getString(19);
            Date admissao = rs.getDate(20);
            String status = rs.getString(21);
            Date auditoria = rs.getDate(22);
            String login = rs.getString(23);
            String password = rs.getString(24);
            
            return new Funcionario(idFuncionario, cpf, departamento, nome, logradouro, numero, complemento, bairro, cidade, uf, cep, nasc, tel1, tel2, doc, tipoDoc, cargo, supervFuncao, supervNome, admissao, status, auditoria, login, password);
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }
    /**
     * Método que procura um funcionario pelo cpf
     * @param cpf
     * @return
     * @throws Exception 
     */
    //@Override
    public Funcionario procurarCpf(String cpf) throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from funcionario where cpf = ?");
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            
            if(!rs.next()) {
                throw new Exception ("Não foi possível localizar o funcionario do cpf: " + cpf);
            }
            
            Integer idFuncionario = rs.getInt(1);
            Integer departamento = rs.getInt(3);
            String nome = rs.getString(4);
            String logradouro = rs.getString(5);
            Integer numero = rs.getInt(6);
            String complemento = rs.getString(7);
            String bairro = rs.getString(8);
            Integer cidade = rs.getInt(9);
            Integer uf = rs.getInt(10);
            Integer cep = rs.getInt(11);
            Date nasc = rs.getDate(12);
            Integer tel1 = rs.getInt(13);
            Integer tel2 = rs.getInt(14);
            Integer doc = rs.getInt(15);
            String tipoDoc = rs.getString(16);
            Integer cargo = rs.getInt(17);
            String supervFuncao = rs.getString(18);
            String supervNome = rs.getString(19);
            Date admissao = rs.getDate(20);
            String status = rs.getString(21);
            Date auditoria = rs.getDate(22);
            String login = rs.getString(23);
            String password = rs.getString(24);
            
            return new Funcionario(idFuncionario, cpf, departamento, nome, logradouro, numero, complemento, bairro, cidade, uf, cep, nasc, tel1, tel2, doc, tipoDoc, cargo, supervFuncao, supervNome, admissao, status, auditoria, login, password);
        } catch (SQLException sqle) {
            throw new Exception (sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }
    /**
     * Método que deleta o funcionario
     * @param funcionario
     * @throws Exception 
     */
    //@Override
    public void excluir(Funcionario funcionario) throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        
        if(funcionario == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        
        try {
            conn = this.conn;
            ps = conn.prepareStatement("delete from funcionario where idfuncionario = ?");
            ps.setInt(1, funcionario.getIdFuncionario());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados: " + sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, null);
        }
    }
}