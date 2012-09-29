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
import br.com.sistelecom.entity.Cargo;
import br.com.sistelecom.to.RamoTO;

/**
 *
 * @author Danilo Alves
 */
public class CargoDAOImpl implements DAO<Cargo> {
    
    public void salvar(Cargo cargo) throws Exception{
    	    
        try{
        	
        	Connection conn = SistelecomSingleConnection.getConnection();
            
            String SQL = "INSERT INTO cargo (nome_cargo) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps = conn.prepareStatement(SQL);
            ps.setString(1, cargo.getNomeCargo());
            
            ps.executeUpdate();
        } catch (Exception e) {
        	throw new Exception();
        }
    }
    
    public void atualizar(Cargo cargo) throws Exception{
        
        try {
        	
        	Connection conn = SistelecomSingleConnection.getConnection();
            
            String SQL = "UPDATE cargo SET nome_cargo=? where idcargo = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, cargo.getNomeCargo());
            ps.setInt(2, cargo.getIdCargo());            
            ps.executeUpdate();
            
        } catch (Exception e) {
        	throw new Exception();
        }
    }
    public List <Cargo> listarTodos(){
        
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
    
public List<RamoTO> todosRamosParaExibirEmTabela() {
		
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try{
			ps = conn.prepareStatement("select * from ramo");
			rs = ps.executeQuery();
			List<RamoTO> list = new ArrayList<RamoTO>();
			while(rs.next()) {
				Integer idRamo = rs.getInt(1);
				String nomeRamo = rs.getString(2);

				list.add(new RamoTO(Boolean.FALSE,idRamo, nomeRamo));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    public Cargo obterPorId(int id) {
        
        PreparedStatement ps = null;
        Connection conn = SistelecomSingleConnection.getConnection();;
        ResultSet rs = null;
        
        try {
            ps = conn.prepareStatement("select * from cargo where idcargo = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
				throw new Exception("Não foi encontrado o cargo com esse id: " + id);
			}
            
            String nomeCargo = rs.getString(2);
            
            return new Cargo(id, nomeCargo);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    public void excluir(Cargo cargo) throws Exception{
        
        try{
        	Connection conn = SistelecomSingleConnection.getConnection();
        	PreparedStatement ps = conn.prepareStatement("delete from cargo where idcargo = ?");
            ps.setInt(1, cargo.getIdCargo());
            ps.executeUpdate();
            
        } catch (Exception e) {
        	throw new Exception();
        }
    }
}