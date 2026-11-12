import javax.swing.*;
import java.awt.*;

public class TelaCadastro extends JFrame {
    private JTextField txtNome;
    private JTextField txtMatricula;
    private JTextField txtCurso;
    private JTextField txtDepartamentoId;

    public TelaCadastro() {
        // Configurações básicas da janela
        setTitle("Matrícula Aula");
        setSize(600,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Criar o painel e os componenentes
        JPanel painelMatricula = new JPanel(new GridLayout(
                3,2,5,15));
        painelMatricula.setBorder(BorderFactory.createEmptyBorder(
                20,20,20,20));

        setLocationRelativeTo(null);
    }
}
