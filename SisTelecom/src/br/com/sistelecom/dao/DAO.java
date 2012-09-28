package br.com.sistelecom.dao;

import java.util.List;

public interface DAO<E> {

    List<E> listarTodos();

    void salvar(E entidade) throws Exception;

    void excluir(E entidade) throws Exception;

    void atualizar(E entidade) throws Exception;
    
    E obterPorId(int id);

}
