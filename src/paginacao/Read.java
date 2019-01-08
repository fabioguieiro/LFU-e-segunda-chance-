package paginacao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Read {
public ArrayList<Pagina> entradas ;
    public Read(){
        entradas = new ArrayList<>();
    }
  public void leitura(){
    Scanner ler = new Scanner(System.in);
    int num,i=-1;
    System.out.printf("Informe o nome de arquivo texto:\n");
    String nome = ler.nextLine();
 
    System.out.printf("\nConteúdo do arquivo texto:\n");
    try {
      FileReader arq = new FileReader(nome);
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine(); // lê a primeira linha
// a variável "linha" recebe o valor "null" quando o processo
// de repetição atingir o final do arquivo texto
      while (linha != null) {
        i++;
        num =  Integer.parseInt(linha);
        entradas.add(i,new Pagina());
        entradas.get(i).numero = num;
        System.out.printf("%s\n", linha);
 
        linha = lerArq.readLine(); // lê da segunda até a última linha
      }
 
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
 
    System.out.println("arrayist: ");
      for (int j = 0; j < entradas.size(); j++) {
          System.out.println(entradas.get(j).numero);
      }
}
}