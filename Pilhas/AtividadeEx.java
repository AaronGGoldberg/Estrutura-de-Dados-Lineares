public interface Pilha {
public int size();
public boolean isEmpty();
public Object top() throws pilhaVaziaExcecao;
public void push(Object o);
public Object pop() throws PilhaVaziaExcecao;
Interface JAVA correspondente ao nosso TAD
Pilha
Requer a definição da classe EPilhaVazia
Diferente da classe interna JAVA java.util.Stack

PilhaArray – classe
PilhaVaziaExcecao

public class PilhaVaziaExcecao extends
RuntimeException {
public PilhaVaziaExcecao(String err){
super(err);
}
}

PilhaArray – atributos e

construtor

public class PilhaArray implements Pilha {
private int capacidade;
private Object[] a;
private int t;
private int FC;
public PilhaArray(int capacidade, int

crescimento){

this.capacidade=capacidade;
t=-1;
FC=crescimento;
if (crescimento<=0)
FC=0;
a=new Object[capacidade];
}

PilhaArray - Push

public void push(Object o) {
if(t>=capacidade-1){
if(FC==0)
capacidade*=2;
else
capacidade+=FC;
Object b[]=new Object[capacidade];
for(int f=0;f<a.length;f++)
b[f]=a[f];
a=b;
}
a[++t]=o;
}

PilhaArray - Pop

public Object pop()throws PilhaVaziaExcecao {
if(isEmpty())
throw new PilhaVaziaExcecao("A Pilha está
vazia");
Object r=a[t--];
return r;
}

PilhaArray - Top

public Object top()throws PilhaVaziaExcecao {
if(isEmpty())
throw new PilhaVaziaExcecao("A Pilha
está vazia");
return a[t];
}

PilhaArray – isEmpty, size

public boolean isEmpty(){
return t==-1;
}

public int size(){
return t+1;
}
}