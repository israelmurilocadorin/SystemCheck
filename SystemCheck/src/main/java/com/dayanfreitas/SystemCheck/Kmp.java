package com.dayanfreitas.SystemCheck;

public class Kmp {
    private String busca;
    private String texto = "Oi eu sou um texto de teste de busca";
    private int lps[];
    private int len = 0;
    private int i   = 1;
    private int m;
    private String achou;
    public Kmp(String busca) {
        this.busca = busca;
    }

    public Kmp(String busca,String texto) {
        this.busca = busca;
        this.texto = texto;
    }

    public void kmpSearch() {
        int m = busca.length();
        int n = texto.length();
        int lps[] = new int[m];
        int j = 0;
        int i = 0;

        while (i < n) {
            if (busca.charAt(j) == texto.charAt(i)) {
                j++;
                i++;
            } if (j == m) {
                System.out.println("Palavra/letra encontrada na posição: " + (i - j));
                this.achou = "Achou";
                j = lps[j - 1];
            }
            else if (i < n && busca.charAt(j) != texto.charAt(i)) {
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
    public String getAchou() {
    	return this.achou;
    }
    public void retornar() {
        kmpSearch();
        computeLpsArray();
    }
}