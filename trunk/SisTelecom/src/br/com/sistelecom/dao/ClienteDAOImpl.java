package br.com.sistelecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sistelecom.connection.SistelecomSingleConnection;
import br.com.sistelecom.entity.Cliente;
import br.com.sistelecom.to.ClienteTO;

public class ClienteDAOImpl implements DAO<Cliente>{

	public void salvar(Cliente cliente) throws Exception {
		try{
			Connection conn = SistelecomSingleConnection.getConnection();

			String SQL = "INSERT INTO cliente (cnpj, razao_social, nome_fantasia, ramo, logradouro, numero, complemento, bairro, cidade, uf, cep,"
					+ " tel_1, tel_2, email, insc_est, desde, cpf_resp_1, nome_resp_1, nasc_resp_1, cpf_resp_2, nome_resp_2,"
					+ " nasc_resp_2, cpf_resp_3, nome_resp_3, nasc_resp_3)" +
					"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, cliente.getCnpj());
			ps.setString(2, cliente.getRazaoSocial());
			ps.setString(3, cliente.getNomeFantasia());
			ps.setInt(4, cliente.getRamo());
			ps.setString(5, cliente.getLogradouro());
			ps.setInt(6, cliente.getNumero());
			ps.setString(7, cliente.getComplemento());
			ps.setString(8, cliente.getBairro());
			ps.setInt(8, cliente.getCidade());
			ps.setInt(9, cliente.getUf());
			ps.setInt(10, cliente.getCep());
			ps.setInt(11, cliente.getTel1());
			ps.setInt(12, cliente.getTel2());
			ps.setString(13, cliente.getEmail());
			ps.setInt(14, cliente.getInscEst());
			ps.setDate(15, new java.sql.Date(cliente.getDesde().getTime()));
			ps.setString(16, cliente.getCpfResp1());
			ps.setString(17, cliente.getNomeResp1());
			ps.setDate(18, new java.sql.Date(cliente.getNascResp1().getTime()));
			ps.setString(19, cliente.getCpfResp2());
			ps.setString(20, cliente.getNomeResp2());
			ps.setDate(21, new java.sql.Date(cliente.getNascResp2().getTime()));
			ps.setString(22, cliente.getCpfResp3());
			ps.setString(23, cliente.getNomeResp3());
			ps.setDate(24, new java.sql.Date(cliente.getNascResp3().getTime()));
			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception();
		} 
	}

	public void atualizar(Cliente cliente) throws Exception{
		try{
			Connection conn = SistelecomSingleConnection.getConnection();
			String SQL = "UPDATE cliente SET cnpj=?, razao_social=?, nome_fantasia=?, ramo=?, logradouro=?, numero=?, " +
					"complemento=?, bairro=?, cidade=?, uf=?, cep=?, tel_1=?, tel_2=?, email=?, insc_est=?, desde=?, cpf_resp_1=?, " +
					"nome_resp_1=?, nasc_resp_1=?, cpf_resp_2=?, nome_resp_2=?, nasc_resp_2=?, cpf_resp_3=?, " +
					"nome_resp_3=?, nasc_resp_3=? where idcliente = ?";

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, cliente.getCnpj());
			ps.setString(2, cliente.getRazaoSocial());
			ps.setString(3, cliente.getNomeFantasia());
			ps.setInt(4, cliente.getRamo());
			ps.setString(5, cliente.getLogradouro());
			ps.setInt(6, cliente.getNumero());
			ps.setString(7, cliente.getComplemento());
			ps.setString(8, cliente.getBairro());
			ps.setInt(8, cliente.getCidade());
			ps.setInt(9, cliente.getUf());
			ps.setInt(10, cliente.getCep());
			ps.setInt(11, cliente.getTel1());
			ps.setInt(12, cliente.getTel2());
			ps.setString(13, cliente.getEmail());
			ps.setInt(14, cliente.getInscEst());
			ps.setDate(15, new java.sql.Date(cliente.getDesde().getTime()));
			ps.setString(16, cliente.getCpfResp1());
			ps.setString(17, cliente.getNomeResp1());
			ps.setDate(18, new java.sql.Date(cliente.getNascResp1().getTime()));
			ps.setString(19, cliente.getCpfResp2());
			ps.setString(20, cliente.getNomeResp2());
			ps.setDate(21, new java.sql.Date(cliente.getNascResp2().getTime()));
			ps.setString(22, cliente.getCpfResp3());
			ps.setString(23, cliente.getNomeResp3());
			ps.setDate(24, new java.sql.Date(cliente.getNascResp3().getTime()));
			ps.setInt(25, cliente.getIdCliente());
			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception();
		}
	}

	public List<Cliente> listarTodos(){
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try{
			ps = conn.prepareStatement("select * from cliente");
			rs = ps.executeQuery();
			List<Cliente> list = new ArrayList<Cliente>();
			while(rs.next()) {
				list.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getString(14), rs.getInt(15), rs.getDate(16), rs.getString(17), rs.getString(18), rs.getDate(19), rs.getString(20), rs.getString(21), rs.getDate(22), rs.getString(23), rs.getString(24), rs.getDate(25)));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ClienteTO> todosClientesParaExibirEmTabela() {

		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try{
			ps = conn.prepareStatement("select * from cliente");
			rs = ps.executeQuery();
			List<ClienteTO> list = new ArrayList<ClienteTO>();
			while(rs.next()) {
				int idCliente = rs.getInt(1);
				String cnpj = rs.getString(2);
				String razaoSocial = rs.getString(3);
				String nomeResp1 = rs.getString(4);
				int tel1 = rs.getInt(5);

				list.add(new ClienteTO(Boolean.FALSE, idCliente, cnpj, razaoSocial, nomeResp1, tel1));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Cliente obterPorId(int id){

		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("select * from cliente where idcliente = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new Exception("Não foi encontrado o cliente com esse id: " + id);
			}

			Cliente cliente = new Cliente();
			cliente.setIdCliente(id);
			cliente.setCnpj(rs.getString(2));
			cliente.setRazaoSocial(rs.getString(3));
			cliente.setNomeFantasia(rs.getString(4));
			cliente.setRamo(rs.getInt(5));
			cliente.setLogradouro(rs.getString(6));
			cliente.setNumero(rs.getInt(7));
			cliente.setComplemento(rs.getString(8));
			cliente.setBairro(rs.getString(9));
			cliente.setCidade(rs.getInt(10));
			cliente.setUf(rs.getInt(11));
			cliente.setCep(rs.getInt(12));
			cliente.setTel1(rs.getInt(13));
			cliente.setTel2(rs.getInt(14));
			cliente.setEmail(rs.getString(15));
			cliente.setInscEst(rs.getInt(16));
			cliente.setDesde(rs.getDate(17));
			cliente.setCpfResp1(rs.getString(18));
			cliente.setNomeResp1(rs.getString(19));
			cliente.setNascResp1(rs.getDate(20));
			cliente.setCpfResp2(rs.getString(21));
			cliente.setNomeResp2(rs.getString(22));
			cliente.setNascResp2(rs.getDate(23));
			cliente.setCpfResp3(rs.getString(24));
			cliente.setNomeResp3(rs.getString(25));
			cliente.setNascResp3(rs.getDate(26));

			return cliente;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

	public void excluir(Cliente cliente) throws Exception {
		try{
			Connection conn = SistelecomSingleConnection.getConnection();

			String SQL = "delete from cliente where idcliente = ?";

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, cliente.getIdCliente());
			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception();
		}
	}

}
