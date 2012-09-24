/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.interfaces.dao;

import java.util.List;

import br.com.sistelecom.entity.Funcionario;

/**
 *
 * @author Danilo Alves
 */
public interface FuncionarioDAO {

    /**
     * Método que lista todos os funcionarios
     * @return
     * @throws Exception
     */
    List todosFuncionarios() throws Exception;

    /**
     * Método que cria um funcionário
     * @param funcionario
     * @throws Exception
     */
    void salvar(Funcionario funcionario) throws Exception;

    /**
     * Método que deleta o funcionario
     * @param funcionario
     * @throws Exception
     */
    void excluir(Funcionario funcionario) throws Exception;

    /**
     * Método que procura um funcionario pelo cpf
     * @param cpf
     * @return
     * @throws Exception
     */
    Funcionario procurarCpf(String cpf) throws Exception;

    /**
     * Método que procura um funcinario pelo id
     * @param idfuncionario
     * @return
     * @throws Exception 
     */
    Funcionario procurarIdFuncionario(Integer idfuncionario) throws Exception;

    /**
     * Métodos que atualiza o cadastro de funcionarios
     * @param funcionario
     * @throws Exception
     */
    void atualizar(Funcionario funcionario) throws Exception;
    
}
