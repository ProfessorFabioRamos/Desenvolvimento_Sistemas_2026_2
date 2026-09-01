public class Main{
    public static void main(String[] args){
        Enemy enemy_1 = new Enemy("Goblin",
                10, 2,5);
        enemy_1.emitirSom();
        enemy_1.tomarDano(5);
        System.out.println("HP restante: "+enemy_1.hp);

        Orc orc_1 = new Orc(30,10,9,
                "Thrall",5);
        orc_1.emitirSom();
        orc_1.tomarDano(20);
        System.out.println("HP restante: "+orc_1.hp);
    }
}
