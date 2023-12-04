import javax.swing.*;

public class TelaPontuacao extends JFrame {

    // Componentes da tela
    private JLabel labelTime1;
    private JLabel labelTime2;
    private JLabel labelPlacar1;
    private JLabel labelPlacar2;
    private JButton botaoGolTime1;
    private JButton botaoGolTime2;

    // Construtor da tela de pontuação
    public TelaPontuacao() {
        // Configurações básicas da janela
        setTitle("Tela de Pontuação");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Layout nulo para posicionar os componentes manualmente

        // Labels para exibir os nomes dos times e os placares
        labelTime1 = new JLabel("Time 1");
        labelTime1.setBounds(20, 20, 100, 30);
        add(labelTime1);

        labelTime2 = new JLabel("Time 2");
        labelTime2.setBounds(160, 20, 100, 30);
        add(labelTime2);

        labelPlacar1 = new JLabel("0");
        labelPlacar1.setBounds(50, 50, 50, 50);
        add(labelPlacar1);

        labelPlacar2 = new JLabel("0");
        labelPlacar2.setBounds(190, 50, 50, 50);
        add(labelPlacar2);

        // Botões para adicionar gols aos times
        botaoGolTime1 = new JButton("Gol!");
        botaoGolTime1.setBounds(20, 120, 100, 30);
        botaoGolTime1.addActionListener(e -> aumentarPlacar(labelPlacar1));
        add(botaoGolTime1);

        botaoGolTime2 = new JButton("Gol!");
        botaoGolTime2.setBounds(160, 120, 100, 30);
        botaoGolTime2.addActionListener(e -> aumentarPlacar(labelPlacar2));
        add(botaoGolTime2);
    }

    // Método para aumentar o placar do time
    private void aumentarPlacar(JLabel labelPlacar) {
        int placar = Integer.parseInt(labelPlacar.getText());
        placar++;
        labelPlacar.setText(String.valueOf(placar));
    }

    public static void main(String[] args) {
        // Criar e exibir a tela de pontuação
        SwingUtilities.invokeLater(() -> {
            TelaPontuacao telaPontuacao = new TelaPontuacao();
            telaPontuacao.setVisible(true);
        });
    }
}
