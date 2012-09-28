/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    /**
     * Método que cria departamentos
     * @param departamento
     * @throws Exception 
     */
    //@Override
    public void salvar(Departamento departamento) {

        PreparedStatement ps = null;
        Connection conn = SistelecomSingleConnection.getConnection();

        try {

            String SQL = "INSERT INTO departamento (nome_departamento, gerente_departamento)"
                    + "values (?, ?)";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, departamento.getNomeDepartamento());
            ps.setString(2, departamento.getGerenteDepartamento());
            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    /**
     * Método que atualiza os departamentos
     * @param departamento
     * @throws Exception 
     */
    //@Override
    public void atualizar(Departamento departamento) {

        PreparedStatement ps = null;
        Connection conn = SistelecomSingleConnection.getConnection();
        
        try {
            String SQL = "UPDATE departamento SET nome_departamento=?, gerente_departamento=? where iddepartamento = ?";
            
            ps = conn.prepareStatement(SQL);
            ps.setString(1, departamento.getNomeDepartamento());
            ps.setString(2, departamento.getGerenteDepartamento());
            ps.setInt(3, departamento.getIdDepartamento());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    /**
     * Método que lista todos departamentos
     * @return
     * @throws Exception 
     */
    //@Override
    @SuppressWarnings("rawtypes")
	public List todosDepartamentos() {

        PreparedStatement ps = null;
        Connection conn = SistelecomSingleConnection.getConnection();
        ResultSet rs = null;

        try {

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
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    /**
     * Método que procura um departamento pelo id
     * @param iddepartamento
     * @return
     * @throws Exception 
     */
    //@Override
    public Departamento procurarIdDepartamento(Integer idDepartamento) {

        PreparedStatement ps = null;
        Connection conn = SistelecomSingleConnection.getConnection();
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("select * from departamento where iddepartamento = ?");
            ps.setInt(1, idDepartamento);
            rs = ps.executeQuery();

            String nomeDepartamento = rs.getString(2);
            String gerenteDepartamento = rs.getString(3);

            return new Departamento(idDepartamento, nomeDepartamento, gerenteDepartamento);
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    /**
     * Método que procura um departamento pelo seu nome
     * @param nome_departamento
     * @return
     * @throws Exception 
     */
    //@Override
    public Departamento procurarNomeDepartamento(String nome_departamento) {

        PreparedStatement ps = null;
        Connection conn = SistelecomSingleConnection.getConnection();
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("select * from departamento where nome_departamento = ?");
            ps.setString(1, nome_departamento);
            rs = ps.executeQuery();

            Integer iddepartamento = rs.getInt(1);
            String gerente_departamento = rs.getString(2);

            return new Departamento(iddepartamento, nome_departamento, gerente_departamento);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    /**
     * Método que deleta um departamento
     * @param departamento
     * @throws Exception 
     */
    //@Override
    public void excluir(Departamento departamento) {
        
        PreparedStatement ps = null;
        Connection conn = SistelecomSingleConnection.getConnection();

        try {
            ps = conn.prepareStatement("delete from departamento where iddepartamento = ?");
            ps.setInt(1, departamento.getIdDepartamento());
            ps.executeUpdate();
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}