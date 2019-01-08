package paginacao;

import java.util.ArrayList;
import java.util.Scanner;

public class Paginacao {

    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
       
        System.out.println("Digite o tamanho do vetor:");
        int tam = ler.nextInt();
        Memoria memo = new Memoria();
        
        System.out.println("Qual algoritiomo voce deseja trabalhar? \n 1-Substituição LFU \n 2-Algoritimo da segunda chance");
        int alg = ler.nextInt();
        
        switch(alg){
            case 1:
                memo.lfu(tam);
                System.out.println("Erros: "+memo.contErro+"");
            break;
                
            case 2:
                memo.lfu(tam);
                System.out.println("Erros: "+memo.contErro+"");
                
            break;
                default:
                    System.out.println("Valor invalido");
        }
    }
    
}
