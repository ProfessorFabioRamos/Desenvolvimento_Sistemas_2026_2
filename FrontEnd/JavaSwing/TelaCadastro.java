import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TelaCadastro extends JFrame {
    private JTextField txtNome;
    private JTextField txtMatricula;
    private JTextField txtCurso;
    private JTextField txtDepartamentoId;

    public TelaCadastro() {
        // Configurações básicas da janela
        setTitle("Matrícula Aula");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Criar o painel e os componenentes
        JPanel painelMatricula = new JPanel(new GridLayout(
                5,2,5,15));
        painelMatricula.setBorder(BorderFactory.createEmptyBorder(
                20,20,20,20));

        painelMatricula.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelMatricula.add(txtNome);

        painelMatricula.add(new JLabel("Matricula:"));
        txtMatricula = new JTextField();
        painelMatricula.add(txtMatricula);

        painelMatricula.add(new JLabel("Curso:"));
        txtCurso = new JTextField();
        painelMatricula.add(txtCurso);

        painelMatricula.add(new JLabel("Departamento ID:"));
        txtDepartamentoId = new JTextField();
        painelMatricula.add(txtDepartamentoId);


        JButton btnMatricular= new JButton("Confirmar Matricula");
        btnMatricular.addActionListener(e -> processarMatricula());
        painelMatricula.add(btnMatricular);

        add(painelMatricula,BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    public void processarMatricula() {
        String nome = txtNome.getText();
        String matricula = txtMatricula.getText();
        String curso = txtCurso.getText();
        int departamentoId = Integer.parseInt(txtDepartamentoId.getText());
    }
}
