package br.com.sistelecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sistelecom.connection.SistelecomSingleConnection;
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
            ps.setInt(10, funcionario.getCep());
            ps.setDate(11, new java.sql.Date(funcionario.getNasc().getTime()));
            ps.setInt(12, funcionario.getTel1());
            ps.setInt(13, funcionario.getTel2());
            ps.setString(14, funcionario.getEmail());
            ps.setInt(15, funcionario.getDoc());
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
	            ps.setInt(10, funcionario.getCep());
	            ps.setDate(11, new java.sql.Date(funcionario.getNasc().getTime()));
	            ps.setInt(12, funcionario.getTel1());
	            ps.setInt(13, funcionario.getTel2());
	            ps.setString(14, funcionario.getEmail());
	            ps.setInt(15, funcionario.getDoc());
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
				list.add(new Funcionario(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getDate(12), rs.getInt(13), rs.getInt(14), rs.getString(15), rs.getInt(16), rs.getString(17), rs.getInt(18), rs.getInt(19), rs.getString(20), rs.getDate(21), rs.getString(22), rs.getString(23), rs.getString(24)));
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

				list.add(new FuncionarioTO(Boolean.FALSE, idFuncionario, cpf, departamento, nomeFuncionario));
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
			funcionario.setCep(rs.getInt(11));
			funcionario.setNasc(rs.getDate(12));
			funcionario.setTel1(rs.getInt(13));
			funcionario.setTel2(rs.getInt(14));
			funcionario.setDoc(rs.getInt(15));
			funcionario.setTipoDoc(rs.getString(16));
			funcionario.setCargo(rs.getInt(17));
			funcionario.setSupervFuncao(rs.getInt(18));
			funcionario.setSupervNome(rs.getString(19));
			funcionario.setAdmissao(rs.getDate(20));
			funcionario.setStatus(rs.getString(21));
			funcionario.setLogin(rs.getString(22));
			funcionario.setPassword(rs.getString(23));
			
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

}
