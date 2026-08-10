package calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * Interface de usuário para o Solucionador de Sistemas Lineares.
 * Atende aos requisitos de interface intuitiva e grade interativa[cite: 13, 14].
 */
public class SolverGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTable matrixTable;
    private JTextField txtSize, txtTol, txtMaxIter;
    private JTextArea txtAreaResult;
    private JComboBox<String> comboMethod;

    public SolverGUI() {
        setTitle("UFN - Solucionador de Sistemas Lineares");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        // Painel Superior: Definição do tamanho da matriz [cite: 14]
        JPanel pnlTop = new JPanel(new FlowLayout());
        pnlTop.add(new JLabel("Tamanho n:"));
        txtSize = new JTextField("3", 3);
        JButton btnGenerate = new JButton("Gerar Grade");
        btnGenerate.addActionListener(e -> setupTable());
        pnlTop.add(txtSize);
        pnlTop.add(btnGenerate);

        matrixTable = new JTable();
        setupTable();

        // Painel Sul: Parâmetros de controle e Seleção de Método [cite: 15, 16]
        JPanel pnlSouth = new JPanel(new BorderLayout());
        JPanel pnlControl = new JPanel(new FlowLayout());
        
        txtTol = new JTextField("0.001", 5);
        txtMaxIter = new JTextField("100", 4);
        comboMethod = new JComboBox<>(new String[]{
            "Eliminação de Gauss", 
            "Método de Jacobi", 
            "Método de Gauss-Seidel"
        });
        
        JButton btnRun = new JButton("Resolver");
        btnRun.setBackground(new Color(0, 102, 204));
        btnRun.setForeground(Color.WHITE);
        btnRun.addActionListener(e -> executeSolver());

        pnlControl.add(new JLabel("Tolerância:")); pnlControl.add(txtTol);
        pnlControl.add(new JLabel("Iterações:")); pnlControl.add(txtMaxIter);
        pnlControl.add(comboMethod); pnlControl.add(btnRun);

        // Área de Resultados [cite: 20]
        txtAreaResult = new JTextArea(10, 30);
        txtAreaResult.setFont(new Font("Monospaced", Font.PLAIN, 13));
        txtAreaResult.setEditable(false);
        txtAreaResult.setBorder(BorderFactory.createTitledBorder("Resultados"));

        pnlSouth.add(pnlControl, BorderLayout.NORTH);
        pnlSouth.add(new JScrollPane(txtAreaResult), BorderLayout.CENTER);

        add(pnlTop, BorderLayout.NORTH);
        add(new JScrollPane(matrixTable), BorderLayout.CENTER);
        add(pnlSouth, BorderLayout.SOUTH);
        
        setLocationRelativeTo(null);
    }

    private void setupTable() {
        try {
            int n = Integer.parseInt(txtSize.getText());
            DefaultTableModel model = new DefaultTableModel(n, n + 1);
            String[] headers = new String[n + 1];
            for(int i=0; i<n; i++) headers[i] = "A" + (i+1);
            headers[n] = "b";
            model.setColumnIdentifiers(headers);
            matrixTable.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um tamanho válido.");
        }
    }

    private void executeSolver() {
        try {
            int n = matrixTable.getRowCount();
            double[][] A = new double[n][n];
            double[] b = new double[n];

            // Captura os dados da grade interativa [cite: 14]
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Object cellA = matrixTable.getValueAt(i, j);
                    A[i][j] = Double.parseDouble(cellA != null ? cellA.toString() : "0");
                }
                Object cellB = matrixTable.getValueAt(i, n);
                b[i] = Double.parseDouble(cellB != null ? cellB.toString() : "0");
            }

            MatrixSystem sys = new MatrixSystem(A, b, 
                Double.parseDouble(txtTol.getText()), 
                Integer.parseInt(txtMaxIter.getText()));
            
            LinearSolver.Result res;
            String method = (String) comboMethod.getSelectedItem();

            if (method.contains("Seidel")) {
                res = LinearSolver.solveIterative(sys, true);
            } else if (method.contains("Jacobi")) {
                res = LinearSolver.solveIterative(sys, false);
            } else {
                res = LinearSolver.solveGauss(A, b);
            }

            displayResult(res);

        } catch (NumberFormatException e) {
            txtAreaResult.setText("ERRO: Digite apenas números nos campos da matriz e parâmetros."); 
        } catch (Exception ex) {
            // Exibe mensagem amigável para erro de convergência ou matriz singular [cite: 25]
            txtAreaResult.setText("MENSAGEM: " + ex.getMessage());
        }
    }

    private void displayResult(LinearSolver.Result res) {
        StringBuilder sb = new StringBuilder();
        sb.append("Vetor Solução:\n"); 
        DecimalFormat df = new DecimalFormat("0.0000");
        
        for(int i=0; i<res.x.length; i++) {
            sb.append("x").append(i+1).append(" = ").append(df.format(res.x[i])).append("\n");
        }
        
        // Mostra o número de iterações para métodos iterativos [cite: 24]
        if(res.iterations > 0) {
            sb.append("\nIterações para convergir: ").append(res.iterations);
        }
        txtAreaResult.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SolverGUI().setVisible(true));
    }
}