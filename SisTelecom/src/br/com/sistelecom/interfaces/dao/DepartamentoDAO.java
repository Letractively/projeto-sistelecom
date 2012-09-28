/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.interfaces.dao;

import java.util.List;

import br.com.sistelecom.entity.Departamento;

/**
 *
 * @author Danilo Alves
 */
public interface DepartamentoDAO {

    /**
     * Método que lista todos departamentos
     * @return
     * @throws Exception
     */
    List todosDepartamentos();

    /**
     * Método que cria departamentos
     * @param departamento
     * @throws Exception
     */
    void salvar(Departamento departamento);

    /**
     * Método que deleta um departamento
     * @param departamento
     * @throws Exception
     */
    void excluir(Departamento departamento);

    /**
     * Método que procura um departamento pelo id
     * @param iddepartamento
     * @return
     * @throws Exception
     */
    Departamento procurarIdDepartamento(Integer iddepartamento);

    /**
     * Método que procura um departamento pelo seu nome
     * @param nome_departamento
     * @return
     * @throws Exception
     */
    Departamento procurarNomeDepartamento(String nome_departamento);

    /**
     * Método que atualiza os departamentos
     * @param departamento
     * @throws Exception
     */
    void atualizar(Departamento departamento);
    
}
