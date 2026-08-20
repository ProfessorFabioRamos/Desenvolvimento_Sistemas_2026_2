public class Enemy {
    public String raca;
    public int hp;
    public int damage;
    public double speed;

    public Enemy(String raca, int hp, int damage, double speed) {
        this.raca = raca;
        this.hp = hp;
        this.damage = damage;
        this.speed = speed;
    }
    public void emitirSom(){
        System.out.println("RARRRRRRRR");
    }
    public void tomarDano(int dano){
        hp-=dano;
    }
}
