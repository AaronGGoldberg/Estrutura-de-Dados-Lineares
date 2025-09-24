public class PilhaColorida {
    private Object[] array;   // único array para as pilhas
    private int topoVermelha;
    private int topoPreta;

    // Construtor
    public PilhaColorida(int capacidadeInicial) {
        array = new Object[capacidadeInicial];
        topoVermelha = -1;            // vermelha começa no início
        topoPreta = capacidadeInicial; // preta começa no final
    }

    // Métodos push 
    public void pushVermelha(Object o) {
        if (estaCheio()) {
            aumentarCapacidade();
        }
        array[++topoVermelha] = o;
    }

    public void pushPreta(Object o) {
        if (estaCheio()) {
            aumentarCapacidade();
        }
        array[--topoPreta] = o;
    }

    // Métodos pop
    public Object popVermelha() throws PilhaVaziaExcecao {
        if (isEmptyVermelha()) {
            throw new PilhaVaziaExcecao("A pilha vermelha está vazia");
        }
        Object r = array[topoVermelha];
        topoVermelha--;
        verificarReducao();
        return r;
    }

    public Object popPreta() throws PilhaVaziaExcecao {
        if (isEmptyPreta()) {
            throw new PilhaVaziaExcecao("A pilha preta está vazia");
        }
        Object r = array[topoPreta];
        topoPreta++;
        verificarReducao();
        return r;
    }

    // Métodos top
    public Object topVermelha() throws PilhaVaziaExcecao {
        if (isEmptyVermelha()) {
            throw new PilhaVaziaExcecao("A pilha vermelha está vazia");
        }
        return array[topoVermelha];
    }

    public Object topPreta() throws PilhaVaziaExcecao {
        if (isEmptyPreta()) {
            throw new PilhaVaziaExcecao("A pilha preta está vazia");
        }
        return array[topoPreta];
    }

    // Métodos complementares
    public boolean isEmptyVermelha() {
        return topoVermelha == -1;
    }

    public boolean isEmptyPreta() {
        return topoPreta == array.length;
    }

    public int sizeVermelha() {
        return topoVermelha + 1;
    }

    public int sizePreta() {
        return array.length - topoPreta;
    }

    private boolean estaCheio() {
        return topoVermelha + 1 == topoPreta;
    }

    // Duplicar Array
    private void aumentarCapacidade() {
        int novaCapacidade = array.length * 2;
        Object[] novoArray = new Object[novaCapacidade];

        // Copiando a pilha vermelha para o início
        for (int i = 0; i <= topoVermelha; i++) {
            novoArray[i] = array[i];
        }

        // Copiando a pilha preta para o final
        int novaPosPreta = novaCapacidade - (array.length - topoPreta);
        for (int i = topoPreta; i < array.length; i++) {
            novoArray[novaPosPreta + (i - topoPreta)] = array[i];
        }

        topoPreta = novaPosPreta;
        array = novoArray;
    }

    // Dividindo array (OBS: 1/3)
    private void verificarReducao() {
        int usados = sizeVermelha() + sizePreta();
        if (usados <= array.length / 3 && array.length > 2) {
            int novaCapacidade = array.length / 2;
            Object[] novoArray = new Object[novaCapacidade];

            // Copiando pilha vermelha
            for (int i = 0; i <= topoVermelha; i++) {
                novoArray[i] = array[i];
            }

            // Cpiando pilha preta
            int novaPosPreta = novaCapacidade - sizePreta();
            for (int i = 0; i < sizePreta(); i++) {
                novoArray[novaPosPreta + i] = array[topoPreta + i];
            }

            topoPreta = novaPosPreta;
            array = novoArray;
        }
    }

    // Mostrar estado (debug)
    public void mostrarEstado() {
        System.out.println("Array capacidade: " + array.length);
        System.out.println("Pilha vermelha tamanho: " + sizeVermelha());
        System.out.println("Pilha preta tamanho: " + sizePreta());
    }
}

// Exceção
class PilhaVaziaExcecao extends RuntimeException {
    public PilhaVaziaExcecao(String err) {
        super(err);
    }
}
