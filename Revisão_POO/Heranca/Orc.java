public class Orc extends Enemy{
    public String nome;
    public int classeArmadura;

    public Orc(int hp, int damage,
               double speed, String nome, int ca){
        super("Orc", hp, damage, speed);
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
}
