package br.ufma.ecp.paradigmas.tutorial1;

import java.util.logging.Logger;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple Pessoa.
 */
public class PessoaTest 
    extends TestCase
{


    /**
     * Rigourous Test :-)
     */
    public void testPessoa()
    {
        Pessoa p = new Pessoa("Joe Q Author", 42);
        Logger l = Logger.getLogger(Pessoa.class.getName());
        l.info("Name: " + p.getNome());
        l.info("Age:" + p.getIdade());
    
        assertEquals("Joe Q Author", p.getNome());
        assertEquals(42, p.getIdade());
        

    }
}