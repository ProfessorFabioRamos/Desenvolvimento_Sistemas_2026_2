public class Orc extends Enemy{
    public String nome;
    public int classeArmadura;

    public Orc(int hp, int damage,
               double speed, String nome, int ca){
        super("Orc", hp, damage, speed);
        this.nome = nome;
        this.classeArmadura = ca;
    }
}
