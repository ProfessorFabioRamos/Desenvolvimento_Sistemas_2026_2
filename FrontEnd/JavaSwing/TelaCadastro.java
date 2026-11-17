import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TelaCadastro extends JFrame{
    //Aluno
    public JTextField txtNome;
    public JTextField txtMatricula;
    public JTextField txtCurso;
    public JTextField txtDepartamentoId;

    public TelaCadastro(){
        //Configuraçõs básicas da janela
        setTitle("Matrícula Aluno");
        setSize(400,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Criar o painel
        JPanel painelMatricula = new JPanel(
                new GridLayout(5,2,5,15));
        painelMatricula.setBorder(BorderFactory.createEmptyBorder(
                20,20,20,20));
        // Criar os componentes (widgets)
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

        // Adicionar o painel ap frame e a posição na tela
        add(painelMatricula,BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    public void processarMatricula(){
        String nome = txtNome.getText();
        String matricula = txtMatricula.getText();
        String curso = txtCurso.getText();
        int departamentoId = Integer.parseInt(txtDepartamentoId.getText());
        // Criar um objeto da classe aluno e enviar ao metodo de POST
    }
}
