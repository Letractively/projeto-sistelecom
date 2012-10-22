package br.com.sistelecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import br.com.sistelecom.connection.SistelecomSingleConnection;
import br.com.sistelecom.entidade.relatorio.FuncionarioRelatorio;
import br.com.sistelecom.entity.Funcionario;
import br.com.sistelecom.to.FuncionarioTO;

public class FuncionarioDAOImpl implements DAO<Funcionario>{
	
	public void salvar(Funcionario funcionario) throws Exception {
		try{
			Connection conn = SistelecomSingleConnection.getConnection();
			
			String SQL = "INSERT INTO funcionario (cpf, departamento, nome, logradouro, numero, complemento, bairro, cidade, uf, cep, nasc, tel_1, tel_2, email, doc, tipo_doc, cargo, superv_funcao,"
                    + " superv_nome, admissao, status, login, password) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, funcionario.getCpf());
            ps.setInt(2, funcionario.getDepartamento());
            ps.setString(3, funcionario.getNome());
            ps.setString(4, funcionario.getLogradouro());
            ps.setInt(5, funcionario.getNumero());
            ps.setString(6, funcionario.getComplemento());
            ps.setString(7, funcionario.getBairro());
            ps.setInt(8, funcionario.getCidade());
            ps.setInt(9, funcionario.getUf());
            ps.setLong(10, funcionario.getCep());
            ps.setDate(11, new java.sql.Date(funcionario.getNasc().getTime()));
            ps.setLong(12, funcionario.getTel1());
            ps.setLong(13, funcionario.getTel2());
            ps.setString(14, funcionario.getEmail());
            ps.setLong(15, funcionario.getDoc());
            ps.setString(16, funcionario.getTipoDoc());
            ps.setInt(17, funcionario.getCargo());
            ps.setInt(18, funcionario.getSupervFuncao());
            ps.setString(19, funcionario.getSupervNome());
            ps.setDate(20, new java.sql.Date(funcionario.getAdmissao().getTime()));
            ps.setString(21, funcionario.getStatus());
            ps.setString(22, funcionario.getLogin());
            ps.setString(23, funcionario.getPassword());
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception();
		} 
	}
	
	public void atualizar(Funcionario funcionario) throws Exception{
		try{
			Connection conn = SistelecomSingleConnection.getConnection();
			
			String SQL = "UPDATE funcionario SET cpf=?, departamento=?, nome=?, logradouro=?, numero=?, complemento=?, " +
                    "bairro=?, cidade=?, uf=?, cep=?, nasc=?, tel_1=?, tel_2=?, email=?, doc=?, tipo_doc=?, cargo=?, superv_funcao=?, superv_nome=?, " +
                    "admissao=?, status=?, login=?, password=? " +
                    "where idfuncionario = ?;";
			
			PreparedStatement ps = conn.prepareStatement(SQL);
			 ps.setString(1, funcionario.getCpf());
	            ps.setInt(2, funcionario.getDepartamento());
	            ps.setString(3, funcionario.getNome());
	            ps.setString(4, funcionario.getLogradouro());
	            ps.setInt(5, funcionario.getNumero());
	            ps.setString(6, funcionario.getComplemento());
	            ps.setString(7, funcionario.getBairro());
	            ps.setInt(8, funcionario.getCidade());
	            ps.setInt(9, funcionario.getUf());
	            ps.setLong(10, funcionario.getCep());
	            ps.setDate(11, new java.sql.Date(funcionario.getNasc().getTime()));
	            ps.setLong(12, funcionario.getTel1());
	            ps.setLong(13, funcionario.getTel2());
	            ps.setString(14, funcionario.getEmail());
	            ps.setLong(15, funcionario.getDoc());
	            ps.setString(16, funcionario.getTipoDoc());
	            ps.setInt(17, funcionario.getCargo());
	            ps.setInt(18, funcionario.getSupervFuncao());
	            ps.setString(19, funcionario.getSupervNome());
	            ps.setDate(20, new java.sql.Date(funcionario.getAdmissao().getTime()));
	            ps.setString(21, funcionario.getStatus());
	            ps.setString(22, funcionario.getLogin());
	            ps.setString(23, funcionario.getPassword());
	            ps.setInt(24, funcionario.getIdFuncionario());
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public List<Funcionario> listarTodos(){
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try{
			ps = conn.prepareStatement("select * from funcionario");
			rs = ps.executeQuery();
			List<Funcionario> list = new ArrayList<Funcionario>();
			while(rs.next()) {
				list.add(new Funcionario(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getLong(11), rs.getDate(12), rs.getLong(13), rs.getLong(14), rs.getString(15), rs.getLong(16), rs.getString(17), rs.getInt(18), rs.getInt(19), rs.getString(20), rs.getDate(21), rs.getString(22), rs.getString(23), rs.getString(24)));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<FuncionarioTO> todosFuncionariosParaExibirEmTabela() {
		
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try{
			ps = conn.prepareStatement("select * from funcionario");
			rs = ps.executeQuery();
			List<FuncionarioTO> list = new ArrayList<FuncionarioTO>();
			while(rs.next()) {
				Integer idFuncionario = rs.getInt(1);
				String cpf = rs.getString(2);
				int departamento = rs.getInt(3);
				String nomeFuncionario = rs.getString(4);
		

				list.add(new FuncionarioTO(Boolean.FALSE, idFuncionario, cpf, departamento, null, nomeFuncionario));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Funcionario obterPorId(int id){

		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("select * from funcionario where idfuncionario = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new Exception("Não foi encontrado o funcionario com esse id: " + id);
			}
			
			Funcionario funcionario = new Funcionario();
			funcionario.setIdFuncionario(id);
			funcionario.setCpf(rs.getString(2));
			funcionario.setDepartamento(rs.getInt(3));
			funcionario.setNome(rs.getString(4));
			funcionario.setLogradouro(rs.getString(5));
			funcionario.setNumero(rs.getInt(6));
			funcionario.setComplemento(rs.getString(7));
			funcionario.setBairro(rs.getString(8));
			funcionario.setCidade(rs.getInt(9));
			funcionario.setUf(rs.getInt(10));
			funcionario.setCep(rs.getLong(11));
			funcionario.setNasc(rs.getDate(12));
			funcionario.setTel1(rs.getLong(13));
			funcionario.setTel2(rs.getLong(14));
			funcionario.setEmail(rs.getString(15));
			funcionario.setDoc(rs.getLong(16));
			funcionario.setTipoDoc(rs.getString(17));
			funcionario.setCargo(rs.getInt(18));
			funcionario.setSupervFuncao(rs.getInt(19));
			funcionario.setSupervNome(rs.getString(20));
			funcionario.setAdmissao(rs.getDate(21));
			funcionario.setStatus(rs.getString(22));
			funcionario.setLogin(rs.getString(23));
			funcionario.setPassword(rs.getString(24));
			
			return funcionario;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public void excluir(Funcionario funcionario) throws Exception {
		try{
			Connection conn = SistelecomSingleConnection.getConnection();
			
			String SQL = "delete from funcionario where idfuncionario = ?";
			
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, funcionario.getIdFuncionario());
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public List<Funcionario> buscarFuncionarioComCargoConsultorComercial(final int idCargo){
		
		String sql = "select f.idfuncionario, f.nome from funcionario as f ";
		sql += "inner join cargo as c ";
		sql += "on f.cargo = c.idcargo ";
		sql += "where c.idcargo = ?";
		
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idCargo);
			
			rs = ps.executeQuery();
			
			List<Funcionario> lista = new LinkedList<Funcionario>();
			
			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setIdFuncionario(rs.getInt("idfuncionario"));
				funcionario.setNome(rs.getString("nome"));
				
				lista.add(funcionario);
			}
			
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public List<FuncionarioRelatorio> listarParaRelatorio(){
		
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try{
			ps = conn.prepareStatement("select * from funcionario");
			rs = ps.executeQuery();
			List<FuncionarioRelatorio> listRelatorio = new ArrayList<FuncionarioRelatorio>();
			while(rs.next()) {
				
				int idFuncionario = rs.getInt(1);
				String nome = rs.getString(4);
				long tel1 = rs.getLong(13);
				String email = rs.getString(15);
				Date admissao = rs.getDate(21);
				String status = rs.getString(22);
				String login = rs.getString(23);
				
				listRelatorio.add(new FuncionarioRelatorio(idFuncionario, nome, tel1, email, admissao, status, login));
			}
			return listRelatorio;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String validarLogin (String login, String password) throws Exception{
		
		PreparedStatement ps = null;
		Connection conn = SistelecomSingleConnection.getConnection();
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("select * from funcionario where `login` = ?");
			ps.setString(1, login);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new Exception("Login digitado incorretamente: " + login);
			}
			
			Funcionario funcionario = new Funcionario();
			String senha = funcionario.getPassword();
			
			String loginBD = rs.getString(23);
			String passwordBD = rs.getString(24);
			
			if(login == loginBD && senha == passwordBD){
				String nome = rs.getString(4);
				return nome;
			}
		}catch(Exception e){	
			e.printStackTrace();
		}
		return null;
	}
}
