package app;

import enemy.Enemy;
import enemy.humanoid.Orc;

public class Main {
    public static void main(String[] args) {
        /* Classe abstrata Enemy não pode
        ser instanciada
        Enemy inimigo_1 = new Enemy("Goblin",10,
                2,5);
        inimigo_1.emitirSom();
        inimigo_1.tomarDano(5);
        System.out.println(inimigo_1.hp);
        */
        Orc orc_1 = new Orc(30, 10, 9,
                "Thrall",5);
        orc_1.emitirSom();
        orc_1.tomarDano(20);
        orc_1.atacar();
        //System.out.println();
    }
}
