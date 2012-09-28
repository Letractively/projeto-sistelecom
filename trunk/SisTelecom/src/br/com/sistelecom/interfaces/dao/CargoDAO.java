/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.interfaces.dao;

import java.util.List;

import br.com.sistelecom.entity.Cargo;

/**
 *
 * @author Danilo Alves
 */
public interface CargoDAO {

    /**
     * Método que lista todos os cargos
     * @return
     * @throws Exception
     */
    List todosCargos();

    /**
     * Método que cria cargos
     * @param cargo
     * @throws Exception
     */
    void salvar(Cargo cargo);

    /**
     * Método que deleta o cargo
     * @param cargo
     * @throws Exception
     */
    void excluir(Cargo cargo);

    /**
     * Método que procurar cargo pelo idcargo
     * @param idcargo
     * @return
     * @throws Exception
     */
    Cargo procurarIdCargo(Integer idcargo);

    /**
     * Método que atualiza os cargos
     * @param cargo
     * @throws Exception
     */
    void atualizar(Cargo cargo);
    
}
