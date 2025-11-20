// Projeto feito por Gustavo Murai e Igor Murai

import javax.swing.*;
import java.awt.*;

public class FuncionarioFrame extends JFrame {

    private JTextField txtNomeBusca;
    private JButton btnPesquisar;

    private JTextField txtNome;
    private JTextField txtSalario;
    private JTextField txtCargo;

    private JButton btnAnterior;
    private JButton btnProximo;

    public FuncionarioFrame() {
        setTitle("TRABALHO PRATICO 04");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 250);
        setLocationRelativeTo(null);

        JPanel painelPrincipal = new JPanel(new BorderLayout(5, 5));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Linha de cima
        JPanel painelBusca = new JPanel(new BorderLayout(5, 5));

        JPanel painelLabelNome = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelLabelNome.add(new JLabel("Nome:"));
        painelBusca.add(painelLabelNome, BorderLayout.WEST);

        txtNomeBusca = new JTextField();
        painelBusca.add(txtNomeBusca, BorderLayout.CENTER);

        btnPesquisar = new JButton("Pesquisar");
        JPanel painelBotaoPesquisar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotaoPesquisar.add(btnPesquisar);
        painelBusca.add(painelBotaoPesquisar, BorderLayout.SOUTH);

        // Bloco do meio
        JPanel painelCaixa = new JPanel(new BorderLayout());
        painelCaixa.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JPanel painelDados = new JPanel(new GridLayout(3, 2, 5, 5));
        painelDados.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        painelDados.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        txtNome.setEditable(false);
        painelDados.add(txtNome);

        painelDados.add(new JLabel("Salário:"));
        txtSalario = new JTextField();
        txtSalario.setEditable(false);
        painelDados.add(txtSalario);

        painelDados.add(new JLabel("Cargo:"));
        txtCargo = new JTextField();
        txtCargo.setEditable(false);
        painelDados.add(txtCargo);

        painelCaixa.add(painelDados, BorderLayout.CENTER);

        // Rodapé
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 5));
        btnAnterior = new JButton("Anterior");
        btnProximo = new JButton("Próximo");
        painelBotoes.add(btnAnterior);
        painelBotoes.add(btnProximo);

        painelPrincipal.add(painelBusca, BorderLayout.NORTH);
        painelPrincipal.add(painelCaixa, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        setContentPane(painelPrincipal);
    }

    public JTextField getTxtNomeBusca() {
        return txtNomeBusca;
    }

    public JButton getBtnPesquisar() {
        return btnPesquisar;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtSalario() {
        return txtSalario;
    }

    public JTextField getTxtCargo() {
        return txtCargo;
    }

    public JButton getBtnAnterior() {
        return btnAnterior;
    }

    public JButton getBtnProximo() {
        return btnProximo;
    }
}
