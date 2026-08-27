//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Enemy inimigo_1 = new Enemy("Goblin",10,
                2,5);
        inimigo_1.emitirSom();
        inimigo_1.tomarDano(5);
        System.out.println(inimigo_1.hp);

        Orc orc_1 = new Orc(30, 10, 9,
                "Thrall",5);
        orc_1.emitirSom();
        orc_1.tomarDano(20);
        System.out.println("HP restante: "+orc_1.hp);
    }
}
