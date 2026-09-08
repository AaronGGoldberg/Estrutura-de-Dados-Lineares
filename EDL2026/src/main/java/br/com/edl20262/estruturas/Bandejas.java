package br.com.edl20262.estruturas;

public class BandejasEncadeadas<T> {

    private Bandeja<T> topo;
    private int tamanho;

    public void acrescentarBandeja(T valor){
        Bandeja<T> novaBandeja = new Bandeja<>(valor);
        novaBandeja.proximo = topo;
        topo = novaBandeja;
        tamanho++;
    }

    public T retirarBandeja(){
        validarNaoVazia();

        T valor = topo.valor;
        topo = topo.proximo;
        tamanho--;
        return valor;
    }

    public T obterTopo(){
        validarNaoVazia();

        return topo.valor;
    }

    public int tamanho(){
        return tamanho;
    }

    public boolean estaVazia(){
        return tamanho == 0;
    }

    private void validarNaoVazia(){
        
    }

}