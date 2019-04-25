package com.dayanfreitas.SystemCheck;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
        System.out.println("Passando só a palavra:");
    	Kmp busca = new Kmp("Oi");
        busca.retornar();
        System.out.println(" ");
        System.out.println("Passando palavra de busca e Texto:");
        Kmp b  = new Kmp("seu","cala a boca seu gay");
        b.retornar();

    }
}
