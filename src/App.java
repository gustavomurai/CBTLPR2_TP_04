// Projeto feito por Gustavo Murai e Igor Murai

import javax.swing.*;
import java.sql.*;

public class App {

    // Objetos de banco (conexão e resultado)
    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FuncionarioFrame frame = new FuncionarioFrame();
            configurarEventos(frame);
            frame.setVisible(true);
        });
    }

    private static void configurarEventos(FuncionarioFrame frame) {
        frame.getBtnPesquisar().addActionListener(e -> {
            String filtro = frame.getTxtNomeBusca().getText().trim();
            pesquisar(frame, filtro);
        });

        frame.getBtnProximo().addActionListener(e -> mostrarProximo(frame));
        frame.getBtnAnterior().addActionListener(e -> mostrarAnterior(frame));
    }

    private static void pesquisar(FuncionarioFrame frame, String filtro) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DatabaseConnection.getConnection();
            }

            if (rs != null && !rs.isClosed()) rs.close();
            if (ps != null && !ps.isClosed()) ps.close();

            String sql =
                "SELECT f.cod_func, f.nome_func, f.sal_func, c.ds_cargo " +
                "FROM tbfuns f " +
                "JOIN tbcargos c ON f.cod_cargo = c.cd_cargo " +
                "WHERE f.nome_func LIKE ? " +
                "ORDER BY f.cod_func";

            ps = conn.prepareStatement(
                sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            );

            ps.setString(1, "%" + filtro + "%");
            rs = ps.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(frame,
                    "Nenhum funcionário encontrado.",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
                limparCampos(frame);
                return;
            }

            rs.first();
            mostrarRegistroAtual(frame);

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame,
                "Erro ao pesquisar: " + ex.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void mostrarRegistroAtual(FuncionarioFrame frame) {
        if (rs == null) return;

        try {
            String nome = rs.getString("nome_func");
            if (nome != null) nome = nome.trim();

            double salario = rs.getDouble("sal_func");
            String cargo = rs.getString("ds_cargo");
            if (cargo != null) cargo = cargo.trim();

            frame.getTxtNome().setText(nome);
            frame.getTxtSalario().setText(String.format("%.2f", salario));
            frame.getTxtCargo().setText(cargo);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void mostrarProximo(FuncionarioFrame frame) {
        if (rs == null) return;

        try {
            if (!rs.isLast()) {
                rs.next();
                mostrarRegistroAtual(frame);
            } else {
                JOptionPane.showMessageDialog(frame,
                    "Você já está no último registro.",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void mostrarAnterior(FuncionarioFrame frame) {
        if (rs == null) return;

        try {
            if (!rs.isFirst()) {
                rs.previous();
                mostrarRegistroAtual(frame);
            } else {
                JOptionPane.showMessageDialog(frame,
                    "Você já está no primeiro registro.",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void limparCampos(FuncionarioFrame frame) {
        frame.getTxtNome().setText("");
        frame.getTxtSalario().setText("");
        frame.getTxtCargo().setText("");
    }
}
