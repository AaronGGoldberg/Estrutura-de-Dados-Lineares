package br.com.edl20262.desenho;

import br.com.edl20262.estruturas.PilhaVetor;
import br.com.edl20262.desenho;

public class EditorDesenho {
    private PilhaVetor<Desenho> pilha;

    public EditorDesenho(int tamanho){
        this.pilha=new PilhaVetor<>(tamanho);
    }

    public void fazerDesenho(Desenho desenho){
        if (pilha.empilhar(desenho)){
            System.out.println("Açao feita:"+desenho.getAcao());
        }else{
            System.out.println("Ações Cheias");
        }
    }

    public void desfazer(){
        Desenho desenho=pilha.desempilhar();

        if (desenho!=null){
            System.out.println("Desenho removida:"+desenho.getAcao());
        }else{
            System.out.println("Ações Vazias!");
        }
    }
}