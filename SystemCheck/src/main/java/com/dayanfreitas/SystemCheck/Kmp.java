package com.dayanfreitas.SystemCheck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Kmp {
	
    File funk = new File("C:\\Users\\cliente\\Desktop\\SystemCheck\\SystemCheck\\src\\main\\java\\com\\dayanfreitas\\SystemCheck\\Funk.txt");
    private String busca;
    private int lps[];
    private int len = 0;
    private int i = 1;
    private int m;
      
    public void ler() {
	    try {
	    	FileReader ler = new FileReader(funk);
	    	BufferedReader lerb = new BufferedReader(ler);
	    	String linha = lerb.readLine();
	    	
	    	while(linha != null) {
	    		System.out.println(linha);
	    		linha = lerb.readLine();
	    	}
	    } catch(IOException ex) {
	    	
	    }
    }
   
    public Kmp(String busca) {
        this.busca = busca;
    }

    public void kmpSearch() {
        m = busca.length();
        long n = funk.length();
        int lps[] = new int[m];
        int j = 0; 
        int i = 0;

        while (i < n) {
            if (busca.charAt(j) == ((CharSequence) funk).charAt(i)) {
                j++;
                i++;
            } if (j == m) {
                System.out.println("Palavra/letra encontrada na posição: " + (i - j));
                j = lps[j - 1];
            }
            else if (i < n && busca.charAt(j) != ((CharSequence) funk).charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    public void computeLpsArray() {
        while (i < this.m) {
            if (this.busca.charAt(i) == this.busca.charAt(this.len)) {
                len++;
                this.lps[i] = this.len;
                i++;
            } else {
                if (this.len != 0) {
                    this.len = this.lps[this.len - 1];
                } else {
                    this.lps[i] = this.len;
                    i++;
                }
            }
        }
    }
    

    public void retornar() {
        kmpSearch();
        computeLpsArray();
    }
}
