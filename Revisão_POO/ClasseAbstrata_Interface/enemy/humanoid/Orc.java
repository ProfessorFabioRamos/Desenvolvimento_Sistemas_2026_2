package enemy.humanoid;

import enemy.Enemy;
import interfaces.IAgrupar;
import interfaces.IZombie;
//import interfaces.*;

public class Orc extends Enemy implements IAgrupar, IZombie{
    protected String nome;
    protected int classeArmadura;

    public Orc(int hp, int damage,
               double speed, String nome, int ca){
        super("enemy.humanoid.Orc", hp, damage, speed);
        this.nome = nome;
        this.classeArmadura = ca;
    }

    @Override
    public void emitirSom(){
        super.emitirSom();
        System.out.printf("Meu nome é %s, e vou te matar!\n",
                nome);
    }

    @Override
    public void tomarDano(int dano){
        int danoFinal = dano - classeArmadura;
        if(danoFinal < 1) danoFinal = 0;
        super.tomarDano(danoFinal);
    }

    @Override
    public void atacar(){
        System.out.println("Dano causado: "+damage);
    }

    @Override
    public void agruparComRaca(int quantidade) {
        System.out.printf("Tamanho do grupo: %d\n", quantidade);
    }

    @Override
    public void setNomeCla(String nomeCla) {
        System.out.printf("Nome do clã: %s\n", nomeCla);
    }

    @Override
    public void mudarRaca() {
        raca = raca+" Zombie";
    }

    @Override
    public void reduzirDeslocamento() {
        speed = speed/2;
    }

    @Override
    public void infectar() {
        atacar();
        System.out.println("Alvo do ataque foi infectado");
    }

    @Override
    public void regeneracao() {
        int hpMaximo = hp;
        hp+=5;
        if(hp > hpMaximo) hp = hpMaximo;
    }
}
