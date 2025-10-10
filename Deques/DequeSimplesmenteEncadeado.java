public class DequeSimplesmenteEncadeado<T> {
    // Nó simplesmente encadeado
    private class No {
        T dado;
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
            fim = novo;
        }
        tamanho++;
    }

    // Remove do início
    public T removeFront() {
        if (inicio == null) return null;
        T valor = inicio.dado;
        inicio = inicio.proximo;
        if (inicio == null) fim = null;
        tamanho--;
        return valor;
    }

    // Remove do final (precisa percorrer)
    public T removeRear() {
        if (inicio == null) return null;
        if (inicio == fim) {
            T valor = inicio.dado;
            inicio = fim = null;
            tamanho--;
            return valor;
        }
        No atual = inicio;
        while (atual.proximo != fim) {
            atual = atual.proximo;
        }
        T valor = fim.dado;
        fim = atual;
        fim.proximo = null;
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