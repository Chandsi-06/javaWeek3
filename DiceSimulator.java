import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class DiceSimulator extends JFrame {

    private JLabel diceResultLabel;
    private JButton rollButton;
    private JTextArea historyArea;
    private int rollCount = 0;

    public DiceSimulator() {
        setTitle("Dice Simulator for Ludo/Monopoly");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        diceResultLabel = new JLabel("Roll the dice!", SwingConstants.CENTER);
        diceResultLabel.setFont(new Font("Arial", Font.BOLD, 24));

        rollButton = new JButton("Roll Dice");
        rollButton.addActionListener(e -> rollDice());

        historyArea = new JTextArea(5, 20);
        historyArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historyArea);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(diceResultLabel, BorderLayout.NORTH);
        panel.add(rollButton, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        add(panel);
    }

    private void rollDice() {
        int result = Dice.roll();
        rollCount++;
        diceResultLabel.setText("You rolled: " + result);
        historyArea.append("Roll " + rollCount + ": " + result + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DiceSimulator().setVisible(true));
    }
}
