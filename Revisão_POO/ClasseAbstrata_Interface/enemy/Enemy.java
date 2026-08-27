package enemy;

public abstract class Enemy {
    protected String raca;
    protected int hp;
    protected int damage;
    protected double speed;

    public Enemy(String raca, int hp, int damage,
                 double speed) {
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
    // Metodo abstrato
    public abstract void atacar();
}
