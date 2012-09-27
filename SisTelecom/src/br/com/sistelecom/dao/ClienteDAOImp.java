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

import br.com.sistelecom.connection.SistelecomSingleConnection;
import br.com.sistelecom.entity.Cliente;
import br.com.sistelecom.interfaces.dao.ClienteDAO;

/**
 *
 * @author Danilo Alves
 */
public class ClienteDAOImp implements ClienteDAO {
    
    private Connection conn;
    
    public ClienteDAOImp () throws Exception {
        
        try{
            this.conn = SistelecomSingleConnection.getConnection();
        }
        catch(Exception e){
            throw new Exception("Erro " + "\n" + e.getMessage());
        }
    }
    
    /**
     * Método que salva os dados dos clientes cadastrados
     * @param cliente
     * @throws Exception 
     */
    //@Override
    public void salvar(Cliente cliente) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        
        if(cliente == null){
            throw new Exception("O valor que é passado nao pode ser nulo");
        }
        
        try{
            String SQL = "INSERT INTO cliente (cnpj, razao_social, nome_fantasia, ramo, logradouro, numero, complemento, bairro, cidade, uf, cep,"
                    + " tel_1, tel_2, email, insc_est, desde, cpf_resp_1, nome_resp_1, nasc_resp_1, cpf_resp_2, nome_resp_2,"
                    + " nasc_resp_2, cpf_resp_3, nome_resp_3, nasc_resp_3, auditoria)" +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, cliente.getCnpj());
            ps.setString(2, cliente.getRazaoSocial());
            ps.setString(3, cliente.getNomeFantasia());
            ps.setInt(4, cliente.getRamo());
            ps.setString(5, cliente.getLogradouro());
            ps.setInt(6, cliente.getNumero());
            ps.setString(7, cliente.getComplemento());
            ps.setString(8, cliente.getBairro());
            ps.setInt(9, cliente.getCidade());
            ps.setInt(10, cliente.getUf());
            ps.setInt(11, cliente.getCep());
            ps.setInt(12, cliente.getTel1());
            ps.setInt(13, cliente.getTel2());
            ps.setString(14, cliente.getEmail());
            ps.setInt(15, cliente.getInscEst());
            ps.setDate(16, new java.sql.Date(cliente.getDesde( ).getTime()));
            ps.setString(17, cliente.getCpfResp1());
            ps.setString(18, cliente.getNomeResp1());
            ps.setDate(19, new java.sql.Date(cliente.getNascResp1().getTime()));
            ps.setString(20, cliente.getCpfResp2());
            ps.setString(21, cliente.getNomeResp2());
            ps.setDate(22, new java.sql.Date(cliente.getNascResp2().getTime()));
            ps.setString(23, cliente.getCpfResp3());
            ps.setString(24, cliente.getNomeResp3());
            ps.setDate(25, new java.sql.Date(cliente.getNascResp3().getTime()));
            ps.setDate(26, new java.sql.Date(cliente.getAuditoria().getTime()));
            
            ps.executeUpdate();
        }
        catch (SQLException sqle) {
            throw new Exception("Erro ao inserir cliente: "+ sqle);
        } finally {
            SistelecomSingleConnection.closeConnection(conn, ps);
        }    
        
    }
    /**
     * Método que atualiza os dados na tabela Clientes
     * @param cliente
     * @throws Exception 
     */
    //@Override
    public void atualizar(Cliente cliente) throws Exception {
    
        PreparedStatement ps = null;
        Connection conn = null;
        
        if (cliente == null){
            throw new Exception("O valor passado não pode ser nulo");
        }
        try{
            String SQL = "UPDATE cliente SET cnpj=?, razao_social=?, nome_fantasia=?, ramo=?, logradouro=?, numero=?, " +
                    "complemento=?, bairro=?, cidade=?, uf=?, cep=?, tel_1=?, tel_2=?, email=?, insc_est=?, desde=?, cpf_resp_1=?, " +
                    "nome_resp_1=?, nasc_resp_1=?, cpf_resp_2=?, nome_resp_2=?, nasc_resp_2=?, cpf_resp_3=?, " +
                    "nome_resp_3=?, nasc_resp_3=?, auditoria=? " + 
                    "where idcliente = ?";
            
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, cliente.getCnpj());
            ps.setString(2, cliente.getRazaoSocial());
            ps.setString(3, cliente.getNomeFantasia());
            ps.setInt(4, cliente.getRamo());
            ps.setString(5, cliente.getLogradouro());
            ps.setInt(6, cliente.getNumero());
            ps.setString(7, cliente.getComplemento());
            ps.setString(8, cliente.getBairro());
            ps.setInt(9, cliente.getCidade());
            ps.setInt(10, cliente.getUf());
            ps.setInt(11, cliente.getCep());
            ps.setInt(12, cliente.getTel1());
            ps.setInt(13, cliente.getTel2());
            ps.setString(14, cliente.getEmail());
            ps.setInt(15, cliente.getInscEst());
            ps.setDate(16, new java.sql.Date(cliente.getDesde( ).getTime()));
            ps.setString(17, cliente.getCpfResp1());
            ps.setString(18, cliente.getNomeResp1());
            ps.setDate(19, new java.sql.Date(cliente.getNascResp1().getTime()));
            ps.setString(20, cliente.getCpfResp2());
            ps.setString(21, cliente.getNomeResp2());
            ps.setDate(22, new java.sql.Date(cliente.getNascResp2().getTime()));
            ps.setString(23, cliente.getCpfResp3());
            ps.setString(24, cliente.getNomeResp3());
            ps.setDate(25, new java.sql.Date(cliente.getNascResp3().getTime()));
            ps.setDate(26, new java.sql.Date(cliente.getAuditoria().getTime()));
            ps.setInt(27, cliente.getIdCliente());
            
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception ("Erro ao atualizar dados: "+ sqle);
        } finally {
            SistelecomSingleConnection.closeConnection(conn, ps);
        }
        
    }
    
    /**
     * Método que lista todos os clientes
     * @return
     * @throws Exception 
     */
    //@Override
    public List todosClientes() throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        try{
            
            conn = this.conn;
            ps = conn.prepareStatement("select * from cliente");
            rs = ps.executeQuery();
            List<Cliente> list = new ArrayList<Cliente>();
            while( rs.next() ) {
                Integer idCliente = rs.getInt(1);
                String cnpj = rs.getString(2);
                String razaoSocial = rs.getString(3);
                String nomeFantasia = rs.getString(4);
                Integer ramo = rs.getInt(5);
                String logradouro = rs.getString(6);
                Integer numero = rs.getInt(7);
                String complemento = rs.getString(8);
                String bairro = rs.getString(9);
                Integer cidade = rs.getInt(10);
                Integer uf = rs.getInt(11);
                Integer cep = rs.getInt(12);
                Integer tel1 = rs.getInt(13);
                Integer tel2 = rs.getInt(14);
                String email = rs.getString(15);
                Integer inscEst = rs.getInt(16);
                Date desde = rs.getDate(17);
                String cpfResp1 = rs.getString(18);
                String nomeResp1 = rs.getString(19);
                Date nascResp1 = rs.getDate(20);
                String cpfResp2 = rs.getString(21);
                String nomeResp2 = rs.getString(22);
                Date nascResp2 = rs.getDate(23);
                String cpfResp3 = rs.getString(24);
                String nomeResp3 = rs.getString(25);
                Date nascResp3 = rs.getDate(26);
                Date auditoria = rs.getDate(27);

                list.add(new Cliente(idCliente, cnpj, razaoSocial, nomeFantasia, ramo, logradouro, numero, complemento, bairro, cidade, uf, cep, tel1, tel2, email, inscEst, desde, cpfResp1, nomeResp1, nascResp1, cpfResp2, nomeResp2, nascResp2, cpfResp3, nomeResp3, nascResp3, auditoria));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            SistelecomSingleConnection.closeConnection(conn, ps, rs);
        }
    }

    /**
     * Método que faz a busca na tabela cliente a partir do idcliente
     *
     * @param idcliente
     * @return
     * @throws Exception
     */
    //@Override
    public Cliente procurarIdCliente(Integer idCliente) throws Exception {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from cliente where idcliente = ?");
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new Exception("Não foi encontrado nenhum cliente com o numero de registro " + idCliente);
            }

            String cnpj = rs.getString(2);
            String razaoSocial = rs.getString(3);
            String nomeFantasia = rs.getString(4);
            Integer ramo = rs.getInt(5);
            String logradouro = rs.getString(6);
            Integer numero = rs.getInt(7);
            String complemento = rs.getString(8);
            String bairro = rs.getString(9);
            Integer cidade = rs.getInt(10);
            Integer uf = rs.getInt(11);
            Integer cep = rs.getInt(12);
            Integer tel1 = rs.getInt(13);
            Integer tel2 = rs.getInt(14);
            String email = rs.getString(15);
            Integer inscEst = rs.getInt(16);
            Date desde = rs.getDate(17);
            String cpfResp1 = rs.getString(18);
            String nomeResp1 = rs.getString(19);
            Date nascResp1 = rs.getDate(20);
            String cpfResp2 = rs.getString(21);
            String nomeResp2 = rs.getString(22);
            Date nascResp2 = rs.getDate(23);
            String cpfResp3 = rs.getString(24);
            String nomeResp3 = rs.getString(25);
            Date nascResp3 = rs.getDate(26);
            Date auditoria = rs.getDate(27);   
            
            return new Cliente(idCliente, cnpj, razaoSocial, nomeFantasia, ramo, logradouro, numero, complemento, bairro, cidade, uf, cep, tel1, tel2, email, inscEst, desde, cpfResp1, nomeResp1, nascResp1, cpfResp2, nomeResp2, nascResp2, cpfResp3, nomeResp3, nascResp3, auditoria);
            
        } catch(SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            SistelecomSingleConnection.closeConnection(conn, ps, rs);
        }
    }
    
    /**
     * Método que procura o cliente a partir do cnpj
     * @param cnpj
     * @return
     * @throws Exception 
     */
    //@Override
    public Cliente procurarCnpj (String cnpj) throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        try{
            conn = this.conn;
            ps = conn.prepareStatement("select * from cliente where cnpj= ?");
            ps.setString(1, cnpj);
            rs = ps.executeQuery();
            
            if(!rs.next()){
                throw new Exception("Não foi encontrado nenhum cliente com o cnpj digitado " + cnpj);
            }
            
            Integer idCliente = rs.getInt(1);
            String razaoSocial = rs.getString(3);
            String nomeFantasia = rs.getString(4);
            Integer ramo = rs.getInt(5);
            String logradouro = rs.getString(6);
            Integer numero = rs.getInt(7);
            String complemento = rs.getString(8);
            String bairro = rs.getString(9);
            Integer cidade = rs.getInt(10);
            Integer uf = rs.getInt(11);
            Integer cep = rs.getInt(12);
            Integer tel1 = rs.getInt(13);
            Integer tel2 = rs.getInt(14);
            String email = rs.getString(15);
            Integer inscEst = rs.getInt(16);
            Date desde = rs.getDate(17);
            String cpfResp1 = rs.getString(18);
            String nomeResp1 = rs.getString(19);
            Date nascResp1 = rs.getDate(20);
            String cpfResp2 = rs.getString(21);
            String nomeResp2 = rs.getString(22);
            Date nascResp2 = rs.getDate(23);
            String cpfResp3 = rs.getString(24);
            String nomeResp3 = rs.getString(25);
            Date nascResp3 = rs.getDate(26);
            Date auditoria = rs.getDate(27);
            
            return new Cliente(idCliente, cnpj, razaoSocial, nomeFantasia, ramo, logradouro, numero, complemento, bairro, cidade, uf, cep, tel1, tel2, email, inscEst, desde, cpfResp1, nomeResp1, nascResp1, cpfResp2, nomeResp2, nascResp2, cpfResp3, nomeResp3, nascResp3, auditoria);
            
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            SistelecomSingleConnection.closeConnection(conn, ps, rs);
        }
    }
    
    /**
     * Método que deleta o cliente a partir do id
     * @param cliente
     * @throws Exception 
     */
    //@Override
    public void excluir(Cliente cliente) throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        
        if(cliente == null){
            throw new Exception("O valor passado não pode ser nulo");
        }
        
        try{
            conn = this.conn;
            ps = conn.prepareStatement("delete from cliente where idcliente = ?");
            ps.setInt(1, cliente.getIdCliente());
            ps.executeUpdate();
            
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados: " + sqle);
        } finally {
            SistelecomSingleConnection.closeConnection(conn, ps);
        }
    }
    
    
}
