package Lab13;import javax.swing.*;
import java.awt.*;

// ─── Custom Exception ─────────────────────────────────────────────────────────

class NegativeNumberException extends Exception {
    private int detail;

    NegativeNumberException(int n) {
        detail = n;
    }

    public String toString() {
        return "NegativeNumberException: " + detail;
    }
}

// ─── Calculation Worker (Multithreading via SwingWorker) ──────────────────────

class CalculationWorker extends SwingWorker<Double, Void> {

    public enum Operation {
        SQUARE, SQUARE_ROOT, LOG, MODULUS, POWER
    }

    private final double num1;
    private final double num2;
    private final Operation operation;
    private final JTextField resultField;
    private final JButton[] buttons;

    CalculationWorker(double num1, double num2, Operation op,
                      JTextField resultField, JButton[] buttons) {
        this.num1        = num1;
        this.num2        = num2;
        this.operation   = op;
        this.resultField = resultField;
        this.buttons     = buttons;
    }

    @Override
    protected Double doInBackground() throws Exception {
        Thread.sleep(300); // simulate work; demonstrates background thread
        switch (operation) {
            case SQUARE:
                if (num1 < 0) throw new NegativeNumberException((int) num1);
                return num1 * num1;
            case SQUARE_ROOT:
                if (num1 < 0) throw new NegativeNumberException((int) num1);
                return Math.sqrt(num1);
            case LOG:
                if (num1 <= 0) throw new NegativeNumberException((int) num1);
                return Math.log(num1);
            case MODULUS:
                if (num2 == 0) throw new ArithmeticException("Modulus by zero");
                return num1 % num2;
            case POWER:
                return Math.pow(num1, num2);
            default:
                throw new IllegalArgumentException("Unknown operation");
        }
    }

    @Override
    protected void done() {
        for (JButton btn : buttons) btn.setEnabled(true);
        try {
            double result = get();
            resultField.setText(String.valueOf(result));
        } catch (java.util.concurrent.ExecutionException ee) {
            Throwable cause = ee.getCause();
            String msg = (cause instanceof NegativeNumberException)
                    ? cause.toString()
                    : "Error: " + cause.getMessage();
            resultField.setText(msg);
            JOptionPane.showMessageDialog(null, msg, "Calculation Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            resultField.setText("Unexpected Error");
        }
    }
}

// ─── Main Calculator Frame ────────────────────────────────────────────────────

public class Calculator extends JFrame {

    private JTextField nameField;
    private JTextField rollField;
    private JTextField num1Field;
    private JTextField num2Field;
    private JTextField resultField;

    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        initComponents();
        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 14, 10, 14));

        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 5, 5, 5);
        gc.fill   = GridBagConstraints.HORIZONTAL;

        // ── Uneditable info fields ────────────────────────────────────────────
        nameField = new JTextField("John Doe", 16);
        nameField.setEditable(false);

        rollField = new JTextField("2401234567", 16);
        rollField.setEditable(false);

        // ── Editable input fields ─────────────────────────────────────────────
        num1Field   = new JTextField(16);
        num2Field   = new JTextField(16);
        resultField = new JTextField(16);
        resultField.setEditable(false);

        // ── Layout rows ───────────────────────────────────────────────────────
        addRow(mainPanel, gc, "Name:",           nameField,   0);
        addRow(mainPanel, gc, "Roll No:",        rollField,   1);
        addRow(mainPanel, gc, "Enter Number 1:", num1Field,   2);
        addRow(mainPanel, gc, "Enter Number 2:", num2Field,   3);
        addRow(mainPanel, gc, "Result:",         resultField, 4);

        // ── Buttons ───────────────────────────────────────────────────────────
        JButton squareBtn  = new JButton("Square");
        JButton sqrtBtn    = new JButton("Square Root");
        JButton logBtn     = new JButton("Log");
        JButton modulusBtn = new JButton("Modulus");
        JButton powerBtn   = new JButton("Power");

        JButton[] allBtns = {squareBtn, sqrtBtn, logBtn, modulusBtn, powerBtn};

        squareBtn .addActionListener(e -> runCalc(CalculationWorker.Operation.SQUARE,      allBtns));
        sqrtBtn   .addActionListener(e -> runCalc(CalculationWorker.Operation.SQUARE_ROOT, allBtns));
        logBtn    .addActionListener(e -> runCalc(CalculationWorker.Operation.LOG,         allBtns));
        modulusBtn.addActionListener(e -> runCalc(CalculationWorker.Operation.MODULUS,     allBtns));
        powerBtn  .addActionListener(e -> runCalc(CalculationWorker.Operation.POWER,       allBtns));

        // Row 5 – Square | Square Root
        gc.gridy = 5; gc.gridx = 0; gc.weightx = 0.5; mainPanel.add(squareBtn,  gc);
        gc.gridx = 1;                                   mainPanel.add(sqrtBtn,   gc);

        // Row 6 – Log | Modulus
        gc.gridy = 6; gc.gridx = 0;                    mainPanel.add(logBtn,    gc);
        gc.gridx = 1;                                   mainPanel.add(modulusBtn, gc);

        // Row 7 – Power
        gc.gridy = 7; gc.gridx = 0;                    mainPanel.add(powerBtn,  gc);

        add(mainPanel);
    }

    private void addRow(JPanel p, GridBagConstraints gc,
                        String labelText, JTextField field, int row) {
        gc.gridy = row; gc.gridx = 0; gc.weightx = 0.0; gc.gridwidth = 1;
        p.add(new JLabel(labelText), gc);
        gc.gridx = 1; gc.weightx = 1.0;
        p.add(field, gc);
    }

    private void runCalc(CalculationWorker.Operation op, JButton[] allBtns) {
        double n1, n2 = 0;

        try {
            n1 = Double.parseDouble(num1Field.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid number in field 1.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (op == CalculationWorker.Operation.MODULUS ||
                op == CalculationWorker.Operation.POWER) {
            try {
                n2 = Double.parseDouble(num2Field.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a valid number in field 2.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        for (JButton b : allBtns) b.setEnabled(false);
        resultField.setText("Computing...");
        new CalculationWorker(n1, n2, op, resultField, allBtns).execute();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> new Calculator().setVisible(true));
    }
}