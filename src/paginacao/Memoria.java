package paginacao;

public class Memoria {
    Read read = new Read() ;
    
    int pos,i;
    int contErro;
    
    
    
    public void lfu(int tam){
//Metodo da função lfu
    
        read.leitura();//inicia read(array list com os "processos")
        Pagina[] memoria; //inicia vetor com o umero de paginas pedidas
        memoria = new Pagina[tam];
        Pagina p = new Pagina();
        for (int j = 0; j < memoria.length; j++) {//roda todo o array memoria da uma pagina "vazia" pra ele
            memoria[j]=p;
            memoria[j].numero=-1;
        }
        pos =0;
        for(i=0;i<read.entradas.size();i++){ // for para rodar todo o array list de read
            for (int j=0;j<memoria.length;j++){//for para rodar "a memoria"
                if (memoria[j].numero == read.entradas.get(i).numero ){ //confere se o processo ja esta na "memoria"
                    pos = j;
                    contErro --; // subtrai 1 erro toda vez que ele nao ocorre
                    break;
                }
            }
            memoria[pos]= read.entradas.get(i);
            if(pos==memoria.length-1){ //volta a posição do contador pos para 0 caso seja a ultima posição da memoria
                pos=0;
            }else{
                pos++; 
            }
            contErro++;  //soma 1 toda rodada
        }
    }
    
    public void segundaChance(int tam){
        read.leitura();
        Pagina[] memoria;
        memoria = new Pagina[tam];
        Pagina p = new Pagina();
        for (int j = 0; j < memoria.length; j++) {
            memoria[j]=p;
            memoria[j].numero=-1;
            memoria[j].chance=0;
        }
        pos =0;
        for(i=0;i<read.entradas.size();i++){
            for (int j=0;j<memoria.length;j++){
                if (memoria[j].numero == read.entradas.get(i).numero ){
                    memoria[j].numero= read.entradas.get(i).numero;
                    
                    pos = j;
                    contErro --;
                    break;
                }
            }
            
            while (memoria[pos].chance==0){//confere se o "processo" ja ganhou sua segunda chance
                memoria[pos].chance++;
                if(pos==memoria.length){
                    pos=0;
                }else{
                    pos++;
                }
            }
                memoria[pos]= read.entradas.get(i);
                memoria[pos].chance=0;
                if(pos==memoria.length-1){
                    pos=0;
                }else{
                    pos++;
                }
                contErro++;  
            
        }
    }
    
}