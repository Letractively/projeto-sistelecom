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
import java.util.List;

import br.com.sistelecom.connection.SistelecomSingleConnection;
import br.com.sistelecom.entity.Departamento;
import br.com.sistelecom.interfaces.dao.DepartamentoDAO;

/**
 *
 * @author Danilo Alves
 */
public class DepartamentoDAOImp implements DepartamentoDAO {

    private Connection conn;

    public DepartamentoDAOImp() throws Exception {

        try {

            this.conn = SistelecomSingleConnection.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro " + "\n" + e.getMessage());
        }
    }
    /**
     * Método que cria departamentos
     * @param departamento
     * @throws Exception 
     */
    //@Override
    public void salvar(Departamento departamento) throws Exception {

        PreparedStatement ps = null;
        Connection conn = null;

        if (departamento == null) {
            throw new Exception("O valor passado não pode ser nulo.");
        }

        try {

            String SQL = "INSERT INTO departamento (nome_departamento, gerente_departamento)"
                    + "values (?, ?)";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, departamento.getNomeDepartamento());
            ps.setString(2, departamento.getGerenteDepartamento());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir departamento " + sqle);
        } finally {
            SistelecomSingleConnection.closeConnection(conn, ps);
        }
    }
    /**
     * Método que atualiza os departamentos
     * @param departamento
     * @throws Exception 
     */
    //@Override
    public void atualizar(Departamento departamento) throws Exception {

        PreparedStatement ps = null;
        Connection conn = null;

        if (departamento == null) {
            throw new Exception("O valor passado nao pode ser nulo");
        }
        try {
            String SQL = "UPDATE departamento SET nome_departamento=?, gerente_departamento=? where iddepartamento = ?";
            
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, departamento.getNomeDepartamento());
            ps.setString(2, departamento.getGerenteDepartamento());
            ps.setInt(3, departamento.getIdDepartamento());
            
            ps.executeUpdate();
            
        } catch (SQLException sqle) {
            throw new Exception("Erro ao atualizar dados " + sqle);
        } finally {
            SistelecomSingleConnection.closeConnection(conn, ps);
        }
    }
    /**
     * Método que lista todos departamentos
     * @return
     * @throws Exception 
     */
    //@Override
    public List todosDepartamentos() throws Exception {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {

            conn = this.conn;
            ps = conn.prepareStatement("select * from departamento");
            rs = ps.executeQuery();
            List<Departamento> list = new ArrayList<Departamento>();
            while (rs.next()) {
                Integer idDepartamento = rs.getInt(1);
                String nomeDepartamento = rs.getString(2);
                String gerenteDepartamento = rs.getString(3);

                list.add(new Departamento(idDepartamento, nomeDepartamento, gerenteDepartamento));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            SistelecomSingleConnection.closeConnection(conn, ps, rs);
        }
    }
    /**
     * Método que procura um departamento pelo id
     * @param iddepartamento
     * @return
     * @throws Exception 
     */
    //@Override
    public Departamento procurarIdDepartamento(Integer idDepartamento) throws Exception {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from departamento where iddepartamento = ?");
            ps.setInt(1, idDepartamento);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new Exception("Não foi encontrado nenhum departamento com esse codigo."+ idDepartamento);
            }
            String nomeDepartamento = rs.getString(2);
            String gerenteDepartamento = rs.getString(3);

            return new Departamento(idDepartamento, nomeDepartamento, gerenteDepartamento);
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            SistelecomSingleConnection.closeConnection(conn, ps, rs);
        }
    }
    /**
     * Método que procura um departamento pelo seu nome
     * @param nome_departamento
     * @return
     * @throws Exception 
     */
    //@Override
    public Departamento procurarNomeDepartamento(String nome_departamento) throws Exception {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from departamento where nome_departamento = ?");
            ps.setString(1, nome_departamento);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new Exception("Não foi encontrado nenhum departamento com esse nome.");
            }

            Integer iddepartamento = rs.getInt(1);
            String gerente_departamento = rs.getString(2);

            return new Departamento(iddepartamento, nome_departamento, gerente_departamento);
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            SistelecomSingleConnection.closeConnection(conn, ps, rs);
        }
    }
    /**
     * Método que deleta um departamento
     * @param departamento
     * @throws Exception 
     */
    //@Override
    public void excluir(Departamento departamento) throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        
        if(departamento == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        
        try {
            conn = this.conn;
            ps = conn.prepareStatement("delete from departamento where iddepartamento = ?");
            ps.setInt(1, departamento.getIdDepartamento());
            ps.executeUpdate();
            
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            SistelecomSingleConnection.closeConnection(conn, ps);
        }
    }
}