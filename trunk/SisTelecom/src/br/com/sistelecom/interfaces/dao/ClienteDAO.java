/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.interfaces.dao;

import java.util.List;

import br.com.sistelecom.entity.Cliente;

/**
 *
 * @author Danilo Alves
 */
public interface ClienteDAO {

    /**
     * Método que lista todos os clientes
     * @return
     * @throws Exception
     */
    List todosClientes() throws Exception;

    /**
     * Método que salva os dados dos clientes cadastrados
     * @param cliente
     * @throws Exception
     */
    void salvar(Cliente cliente) throws Exception;
    
    /**
     * Método que deleta o cliente a partir do id
     * @param cliente
     * @throws Exception 
     */

    void excluir(Cliente cliente) throws Exception;
    
    /**
     * Método que procura o cliente a partir do cnpj
     * @param cnpj
     * @return
     * @throws Exception 
     */

    Cliente procurarCnpj(String cnpj) throws Exception;

    /**
     * Método que faz a busca na tabela cliente a partir do idcliente
     * @param idcliente
     * @return
     * @throws Exception
     */
    Cliente procurarIdCliente(Integer idcliente) throws Exception;

    /**
     * Método que atualiza os dados na tabela Clientes
     * @param cliente
     * @throws Exception
     */
    void atualizar(Cliente cliente) throws Exception;
    
}
