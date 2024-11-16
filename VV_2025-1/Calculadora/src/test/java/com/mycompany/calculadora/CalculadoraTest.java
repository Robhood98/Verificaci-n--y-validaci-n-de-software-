/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.calculadora;

import static org.junit.Assert.*;

/**
 *
 * @author chris
 */
public class CalculadoraTest {
    
    public CalculadoraTest() {
    }

    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Calculadora.main(args);
        //fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testSuma() {
        System.out.println("suma");
        int a = 0;
        int b = 0;
        int expResult = 0;
        int result = Calculadora.suma(a, b);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testDivision() {
        System.out.println("division");
        int a = 0;
        int b = 0;
        int expResult = 0;
        int result = Calculadora.division(a, b);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testResta() {
        System.out.println("resta");
        int a = 0;
        int b = 0;
        int expResult = 0;
        int result = Calculadora.resta(a, b);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testMultiplicacion() {
        System.out.println("multiplicacion");
        int a = 0;
        int b = 0;
        int expResult = 0;
        int result = Calculadora.multiplicacion(a, b);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
}
