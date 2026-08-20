public class Main{
    public static void main(String[] args){
        Aluno aluno_1 = new Aluno("Nayara Santos",
                23,
                "Publicidade");

        aluno_1.setNome("Naiara Santos");
        System.out.println(aluno_1.getNome());

        aluno_1.setCurso("Engenharia da Computação");
        System.out.println(aluno_1.getCurso());

        aluno_1.setCurso(1);
        System.out.println(aluno_1.getCurso());
    }
}
