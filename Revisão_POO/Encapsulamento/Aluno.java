public class Aluno {
    private String nome = "";
    private int idade = 0;
    private String curso = "";
    private int semestre = 0;
    private float nota = 0.0f;
    private boolean trancado = false;

    public Aluno(String nome, int idade, String curso) {
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
        this.semestre = 1;
        //nome = n //idade = i //curso = c;
    }

    public String getNome() {
        return nome.toUpperCase();
    }

    public void setNome(String novoNome) {
        if(novoNome != null){
            nome = novoNome;
        }
    }
}
