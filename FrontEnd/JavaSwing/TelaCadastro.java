import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TelaCadastro extends JFrame{
    //Aluno
    public JTextField txtNome;
    public JTextField txtMatricula;
    public JTextField txtCurso;
    public JTextField txtDepartamentoId;
    // Departamento
    public JTextField txtNomeDepartamento;
    public JTextField txtSigla;

    public TelaCadastro(){
        //Configuraçõs básicas da janela
        setTitle("Sistema Universidade");
        setSize(400,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Criar o JTabbedPane qie vai conter as abas
        JTabbedPane abas = new JTabbedPane();

        // Criar o painel do departamento
        JPanel painelDepartamento= new JPanel(
                new GridLayout(3,2,5,15));
        painelDepartamento.setBorder(BorderFactory.createEmptyBorder(
                20,20,20,20));

        // Criar o painel do aluno
        JPanel painelMatricula = new JPanel(
                new GridLayout(5,2,5,15));
        painelMatricula.setBorder(BorderFactory.createEmptyBorder(
                20,20,20,20));

        // Adicionar os paineis nas abas
        abas.addTab("Cadastrar Departamento",painelDepartamento);
        abas.addTab("Matricular Aluno",painelMatricula);

        // Criar os componentes (widgets) do departamento
        painelDepartamento.add(new Label("Nome Departamento:"));
        txtNomeDepartamento = new JTextField();
        painelDepartamento.add(txtNomeDepartamento);

        painelDepartamento.add(new Label("Sigla:"));
        txtSigla = new JTextField();
        painelDepartamento.add(txtSigla);

        JButton btnCadastrarDep = new JButton("Criar Departamento");
        btnCadastrarDep.addActionListener(e -> processarDepartamento());
        painelDepartamento.add(btnCadastrarDep);

        // Criar os componentes (widgets) do aluno
        painelMatricula.add(new Label("Nome:"));
        txtNome = new JTextField();
        painelMatricula.add(txtNome);

        painelMatricula.add(new Label("Matrícula:"));
        txtMatricula= new JTextField();
        painelMatricula.add(txtMatricula);

        painelMatricula.add(new Label("Curso:"));
        txtCurso= new JTextField();
        painelMatricula.add(txtCurso);

        painelMatricula.add(new Label("Departamento Id:"));
        txtDepartamentoId= new JTextField();
        painelMatricula.add(txtDepartamentoId);

        JButton btnMatricular = new JButton("Confirmar Matrícula");
        btnMatricular.addActionListener(e -> processarMatricula());
        painelMatricula.add(btnMatricular);

        // Adicionar as abas ao frame e a posição na tela
        add(abas,BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    public void processarMatricula(){
        String nome = txtNome.getText();
        String matricula = txtMatricula.getText();
        String curso = txtCurso.getText();
        int departamentoId = Integer.parseInt(txtDepartamentoId.getText());
        // Criar um objeto da classe aluno e enviar ao metodo de POST
    }

    public void processarDepartamento(){
        String nomeDepartemento = txtNomeDepartamento.getText();
        String sigla = txtSigla.getText();
        // Criar um objeto da classe departamento e enviar ao metodo de POST
    }
}
