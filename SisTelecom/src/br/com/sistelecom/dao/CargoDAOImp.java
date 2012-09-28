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
    
	
	/**
     * Método que cria cargos
     * @param cargo
     * @throws Exception 
     */
    //@Override
    public void salvar(Cargo cargo){
    	
    	PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
        
        try{
            
            String SQL = "INSERT INTO cargo (nome_cargo) VALUES (?)";
            
            ps = conn.prepareStatement(SQL);
            ps.setString(1, cargo.getNomeCargo());
            
            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    /**
     * Método que atualiza os cargos
     * @param cargo
     * @throws Exception 
     */
    //@Override
    public void atualizar(Cargo cargo) {
        
    	PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
        
        try {
            
            String SQL = "UPDATE cargo SET nome_cargo=? where idcargo = ?";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, cargo.getNomeCargo());
            ps.setInt(2, cargo.getIdCargo());            
            ps.executeUpdate();
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    /**
     * Método que lista todos os cargos
     * @return
     * @throws Exception 
     */
    //@Override
    public List todosCargos() {
        
        PreparedStatement ps = null;
        Connection conn = SistelecomSingleConnection.getConnection();
        ResultSet rs = null;
        
        try {
            
            ps = conn.prepareStatement("select * from cargo");
            rs = ps.executeQuery();
            List<Cargo> list = new ArrayList<Cargo>();
            while (rs.next()) {
                Integer idCargo = rs.getInt(1);
                String nomeCargo = rs.getString(2);
                
                list.add(new Cargo(idCargo, nomeCargo));
            }
            return list;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    /**
     * Método que procurar cargo pelo idcargo
     * @param idcargo
     * @return
     * @throws Exception 
     */
    ///@Override
    public Cargo procurarIdCargo(Integer idCargo) {
        
        PreparedStatement ps = null;
        Connection conn = SistelecomSingleConnection.getConnection();;
        ResultSet rs = null;
        
        try {
            ps = conn.prepareStatement("select * from cargo where idcargo = ?");
            ps.setInt(1, idCargo);
            rs = ps.executeQuery();
            
            String nomeCargo = rs.getString(2);
            
            return new Cargo(idCargo, nomeCargo);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    /**
     * Método que deleta o cargo
     * @param cargo
     * @throws Exception 
     */
    //@Override
    public void excluir(Cargo cargo) {
        
        PreparedStatement ps = null;
        Connection conn = null;
        
        try{
            ps = conn.prepareStatement("delete from cargo where idcargo = ?");
            ps.setInt(1, cargo.getIdCargo());
            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}