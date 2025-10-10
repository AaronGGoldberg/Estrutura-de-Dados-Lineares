public class DequeDuplamenteEncadeado<T> {
    // Nó duplamente encadeado
    private class No {
        T dado;
        No anterior;
        No proximo;
        No(T dado) { this.dado = dado; }
    }

    private No inicio;
    private No fim;
    private int tamanho;

    // Adiciona no início
    public void addFront(T elemento) {
        No novo = new No(elemento);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
        tamanho++;
    }

    // Adiciona no final
    public void addRear(T elemento) {
        No novo = new No(elemento);
        if (fim == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
        tamanho++;
    }

    // Remove do início
    public T removeFront() {
        if (inicio == null) return null;
        T valor = inicio.dado;
        inicio = inicio.proximo;
        if (inicio != null) inicio.anterior = null;
        else fim = null;
        tamanho--;
        return valor;
    }

    // Remove do final
    public T removeRear() {
        if (fim == null) return null;
        T valor = fim.dado;
        fim = fim.anterior;
        if (fim != null) fim.proximo = null;
        else inicio = null;
        tamanho--;
        return valor;
    }

    // Verifica se está vazio
    public boolean isEmpty() {
        return tamanho == 0;
    }

    // Retorna o tamanho
    public int size() {
        return tamanho;
    }
}