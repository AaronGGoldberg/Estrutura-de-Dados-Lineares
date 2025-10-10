public class TesteDeques {

    public static void main(String[] args) {
        System.out.println("===== Testando Deque Duplamente Encadeado =====");
        DequeDuplamenteEncadeado<Integer> dequeDuplo = new DequeDuplamenteEncadeado<>();

        dequeDuplo.addFront(10);
        dequeDuplo.addRear(20);
        dequeDuplo.addFront(5);
        dequeDuplo.addRear(30);

        System.out.println("Tamanho atual: " + dequeDuplo.size());
        System.out.println("Removendo do início: " + dequeDuplo.removeFront());
        System.out.println("Removendo do fim: " + dequeDuplo.removeRear());
        System.out.println("Tamanho após remoções: " + dequeDuplo.size());
        System.out.println("Está vazio? " + dequeDuplo.isEmpty());

        System.out.println("\n===== Testando Deque Simplesmente Encadeado =====");
        DequeSimplesmenteEncadeado<String> dequeSimples = new DequeSimplesmenteEncadeado<>();

        dequeSimples.addFront("A");
        dequeSimples.addRear("B");
        dequeSimples.addFront("C");
        dequeSimples.addRear("D");

        System.out.println("Tamanho atual: " + dequeSimples.size());
        System.out.println("Removendo do início: " + dequeSimples.removeFront());
        System.out.println("Removendo do fim: " + dequeSimples.removeRear());
        System.out.println("Tamanho após remoções: " + dequeSimples.size());
        System.out.println("Está vazio? " + dequeSimples.isEmpty());
    }
}
