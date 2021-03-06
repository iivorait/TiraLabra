/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.tiralabra_maven;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author iivo
 */
public class SolmuTest {
    
    private final int SEINAPAINO = -1;
    
    public SolmuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaArvotOikein() {
        Solmu solmu = new Solmu(3, 4, 5);
        assertEquals(3, solmu.getX());
        assertEquals(4, solmu.getY());
        assertEquals(5, solmu.getPaino());
        assertEquals(true, solmu.getVierus().onkoTyhja());
    }
    
    @Test
    public void setterit() {
        Solmu solmu = new Solmu(0, 0, 0);
        solmu.setX(6);
        solmu.setY(7);
        solmu.setPaino(8);
        solmu.setAlkuun(3);
        solmu.setLoppuun(9);
        solmu.setPolku(solmu);
        solmu.setIndeksi(11);
        
        assertEquals(6, solmu.getX());
        assertEquals(7, solmu.getY());
        assertEquals(8, solmu.getPaino());
        assertEquals(3, solmu.getAlkuun());
        assertEquals(9, solmu.getLoppuun());
        assertSame(solmu, solmu.getPolku());
        assertEquals(11, solmu.getIndeksi());
    }
    
    @Test
    public void vierussolmunLisays() {
        Solmu solmu1 = new Solmu(0, 0, 0);
        Solmu solmu2 = new Solmu(1, 0, 1);
        Solmu solmu3 = new Solmu(0, 1, SEINAPAINO); //läpäisemätön
        
        solmu1.lisaaVierus(solmu2);
        solmu1.lisaaVierus(solmu3);
        
        assertEquals(1, solmu1.getKaaripaino(solmu2));
        assertEquals(SEINAPAINO, solmu1.getKaaripaino(solmu3));
    }
}
