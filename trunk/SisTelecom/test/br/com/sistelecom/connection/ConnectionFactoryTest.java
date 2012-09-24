/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistelecom.connection;

import org.junit.Assert;
import org.junit.Test;

import br.com.sistelecom.connection.ConnectionFactory;

/**
 *
 * @author Danilo Alves
 */
public class ConnectionFactoryTest {
    
    @Test
    public void testConexaoComBancoDeDados() throws Exception{
        Assert.assertNotNull(ConnectionFactory.getConnection());
    }
        
}
