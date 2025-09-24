// Interface Pilha
public interface Pilha {
    public int size();
    public boolean isEmpty();
    public Object top() throws PilhaVaziaExcecao;
    public void push(Object o);
    public Object pop() throws PilhaVaziaExcecao;
}

// Classe de exceção PilhaVaziaExcecao
public class PilhaVaziaExcecao extends RuntimeException {
    public PilhaVaziaExcecao(String err) {
        super(err);
    }
}

// Implementação da pilha usando array
public class PilhaArray implements PilhaEx {
    private int capacidade;
    private Object[] a;
    private int t;
    private int FC;

    // Construtor
    public PilhaArray(int capacidade, int crescimento) {
        this.capacidade = capacidade;
        this.t = -1;
        this.FC = (crescimento <= 0) ? 0 : crescimento;
        this.a = new Object[capacidade];
    }

    // Push - empilhar
    public void push(Object o) {
        if (t >= capacidade - 1) {
            if (FC == 0) {
                capacidade *= 2;
            } else {
                capacidade += FC;
            }
            Object[] b = new Object[capacidade];
            for (int f = 0; f < a.length; f++) {
                b[f] = a[f];
            }
            a = b;
        }
        a[++t] = o;
    }

    // Pop - desempilhar
    public Object pop() throws PilhaVaziaExcecao {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }
        Object r = a[t--];
        return r;
    }

    // Top - consultar o topo
    public Object top() throws PilhaVaziaExcecao {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }
        return a[t];
    }

    // Verifica se está vazia
    public boolean isEmpty() {
        return t == -1;
    }

    // Retorna o tamanho
    public int size() {
        return t + 1;
    }
}
