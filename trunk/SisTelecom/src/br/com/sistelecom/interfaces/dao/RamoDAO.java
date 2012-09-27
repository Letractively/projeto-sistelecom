/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.interfaces.dao;

import java.util.List;

import br.com.sistelecom.entity.Ramo;

/**
 *
 * @author Danilo Alves
 */
public interface RamoDAO {

    /**
     * Método que lista todos os ramos
     * @return
     * @throws Exception
     */
    List todosRamos();

    /**
     * Método que cria os tios de ramos que o cliente pode ter
     * @param ramo
     * @throws Exception
     */
    void salvar(Ramo ramo);

    /**
     * Método que deleta um ramo
     * @param ramo
     * @throws Exception
     */
    void excluir(Ramo ramo);

    /**
     * Método que busca um ramo a partir de um id
     * @param idramo
     * @return
     * @throws Exception
     */
    Ramo procurarIdRamo(Integer idramo);

    /**
     * Método que atualiza um ramo
     * @param ramo
     * @throws Exception
     */
    void atualizar(Ramo ramo);
    
}
