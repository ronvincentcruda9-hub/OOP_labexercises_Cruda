import javax.swing.*;      // Import Swing components
import java.awt.*;         // Import layout and color classes
import java.awt.event.*;   // Import event listener classes
import java.util.Random;   // Import for random number generation

public class ArithmeticGame extends JFrame implements ActionListener {
    private JLabel questionLabel, scoreLabel, feedbackLabel;  // Labels for question, score, and feedback
    private JTextField answerField;                            // Input field for user's answer
    private JButton submitButton, nextButton;                  // Buttons for submit and next
    private int num1, num2, correctAnswer, score = 0;          // Variables for operands, correct answer, and score
    private String operator;                                   // Operator symbol (+, -, *, /)
    private Random rand = new Random();                        // Random object for generating numbers

    // Constructor
    public ArithmeticGame() {
        setTitle("Arithmetic Game");                // Set window title
        setSize(400, 250);                          // Set window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close app on exit
        setLayout(new GridLayout(5, 1));            // 5 rows, 1 column layout

        // Create GUI components
        questionLabel = new JLabel("", SwingConstants.CENTER);
        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        feedbackLabel = new JLabel("", SwingConstants.CENTER);

        answerField = new JTextField();
        submitButton = new JButton("Submit");
        nextButton = new JButton("Next Question");

        // Add action listeners
        submitButton.addActionListener(this);
        nextButton.addActionListener(this);

        // Add components to frame
        add(questionLabel);
        add(answerField);
        add(submitButton);
        add(nextButton);
        add(scoreLabel);
        add(feedbackLabel);

        generateQuestion(); // Generate first question

        setVisible(true); // Display window
    }

    // Generate a random arithmetic question
    private void generateQuestion() {
        num1 = rand.nextInt(10) + 1; // random 1–10
        num2 = rand.nextInt(10) + 1;
        int op = rand.nextInt(4); // choose operation (0–3)

        switch (op) {
            case 0:
                operator = "+";
                correctAnswer = num1 + num2;
                break;
            case 1:
                operator = "-";
                correctAnswer = num1 - num2;
                break;
            case 2:
                operator = "×";
                correctAnswer = num1 * num2;
                break;
            case 3:
                operator = "÷";
                // Ensure divisible numbers
                num1 = num1 * num2;
                correctAnswer = num1 / num2;
                break;
        }

        questionLabel.setText("What is " + num1 + " " + operator + " " + num2 + "?");
        feedbackLabel.setText("");
        answerField.setText("");
    }

    // Handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            try {
                int userAnswer = Integer.parseInt(answerField.getText());
                if (userAnswer == correctAnswer) {
                    score++;
                    feedbackLabel.setText("✅ Correct!");
                } else {
                    feedbackLabel.setText("❌ Incorrect! The answer is " + correctAnswer);
                }
                scoreLabel.setText("Score: " + score);
            } catch (NumberFormatException ex) {
                feedbackLabel.setText("⚠️ Please enter a valid number!");
            }
        } else if (e.getSource() == nextButton) {
            generateQuestion();
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        new ArithmeticGame();
    }
}
