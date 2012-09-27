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
import br.com.sistelecom.entity.Cargo;
import br.com.sistelecom.interfaces.dao.CargoDAO;

/**
 *
 * @author Danilo Alves
 */
public class CargoDAOImp implements CargoDAO {
    
    private Connection conn;
    
    public CargoDAOImp () throws Exception {
        
        try{
            this.conn = SistelecomSingleConnection.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro " + "\n" + e.getMessage());
        }
    }
    /**
     * Método que cria cargos
     * @param cargo
     * @throws Exception 
     */
    //@Override
    public void salvar(Cargo cargo) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        
        if(cargo==null) {
            throw new Exception("O valor passado não pode ser nulo.");
        }
        
        try{
            
            String SQL = "INSERT INTO cargo (nome_cargo) VALUES (?)";
            
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, cargo.getNomeCargo());
            
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception ("Erro ao inserir o cargo: " + sqle);
        } finally {
            SistelecomSingleConnection.closeConnection(conn, ps);
        }
    }
    /**
     * Método que atualiza os cargos
     * @param cargo
     * @throws Exception 
     */
    //@Override
    public void atualizar(Cargo cargo) throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        
        if(cargo==null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        
        try {
            
            String SQL = "UPDATE cargo SET nome_cargo=? where idcargo = ?";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, cargo.getNomeCargo());
            ps.setInt(2, cargo.getIdCargo());            
            ps.executeUpdate();
            
        } catch (SQLException sqle) {
            throw new Exception("Erro ao atualizar os dados: " + sqle);
        } finally {
            SistelecomSingleConnection.closeConnection(conn, ps);
        }
    }
    /**
     * Método que lista todos os cargos
     * @return
     * @throws Exception 
     */
    //@Override
    public List todosCargos() throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        try {
            
            conn = this.conn;
            ps = conn.prepareStatement("select * from cargo");
            rs = ps.executeQuery();
            List<Cargo> list = new ArrayList<Cargo>();
            while (rs.next()) {
                Integer idCargo = rs.getInt(1);
                String nomeCargo = rs.getString(2);
                
                list.add(new Cargo(idCargo, nomeCargo));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            SistelecomSingleConnection.closeConnection(conn, ps, rs);
        }
    }
    /**
     * Método que procurar cargo pelo idcargo
     * @param idcargo
     * @return
     * @throws Exception 
     */
    ///@Override
    public Cargo procurarIdCargo(Integer idCargo) throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from cargo where idcargo = ?");
            ps.setInt(1, idCargo);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new Exception("Não foi encontrado o cargo com esse id: " + idCargo);
            }
            
            String nomeCargo = rs.getString(2);
            
            return new Cargo(idCargo, nomeCargo);
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            SistelecomSingleConnection.closeConnection(conn, ps, rs);
        }
    }
    /**
     * Método que deleta o cargo
     * @param cargo
     * @throws Exception 
     */
    //@Override
    public void excluir(Cargo cargo) throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        
        if(cargo==null) {
            throw new Exception("O valoar passado não pode ser nulo.");
        }
        
        try{
            conn = this.conn;
            ps = conn.prepareStatement("delete from cargo where idcargo = ?");
            ps.setInt(1, cargo.getIdCargo());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados: " + sqle);
        } finally {
            SistelecomSingleConnection.closeConnection(conn, ps);
        }
    }
}