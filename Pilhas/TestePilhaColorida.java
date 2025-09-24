public class TestePilhaColorida {
    public static void main(String[] args) {
        PilhaColorida pilhas = new PilhaColorida(4);

        // Testando push nas duas pilhas
        pilhas.pushVermelha("A");
        pilhas.pushVermelha("B");
        pilhas.pushPreta("1");
        pilhas.pushPreta("2");

        pilhas.mostrarEstado();

        // Testando pop
        System.out.println("Pop vermelha: " + pilhas.popVermelha());
        System.out.println("Pop preta: " + pilhas.popPreta());

        pilhas.mostrarEstado();

        // Adicionando até expandir
        pilhas.pushVermelha("C");
        pilhas.pushVermelha("D");
        pilhas.pushVermelha("E"); // aqui deve dobrar a capacidade

        pilhas.mostrarEstado();
    }
}
