package com.dayanfreitas.SystemCheck;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
    	Scanner in = new Scanner(System.in);
    	
        System.out.println("Digite a palavra: ");
        String busca = in.nextLine();
        
        Kmp procurar = new Kmp(busca);
        procurar.ler();

    }
}
