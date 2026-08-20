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
        return toUp(nome);
    }

    private String toUp(String strToUp){
        return nome.toUpperCase();
    }

    public void setNome(String novoNome) {
        if(novoNome != null){
            nome = novoNome;
        }
    }

    public void setCurso(String novoCurso) {
        if(novoCurso != null){
            curso = novoCurso;
        }
    }
    public void setCurso(int codigo) {
        if (codigo == 1) curso = "Ciência da Computação";
        else if (codigo == 2) curso = "Ciência de Dados";
        else if (codigo == 3) curso = "ADS";
        else System.out.println("Curso Inválido");
    }

    public String getCurso(){
        return curso;
    }
}
