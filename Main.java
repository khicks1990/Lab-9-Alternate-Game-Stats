import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Scanner;

// Main class for the Swing application
public class Main extends JFrame {
    private JTextArea textArea; // Text area to display the list
    private JTextField cmdTextField; // Text field for command input
    private SortedLinkedList sll; // Instance of the SortedLinkedList

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true)); // Create and show the GUI
    }

    public Main() {
        sll = new SortedLinkedList(); // Initialize the sorted linked list

        // Set up the JFrame
        setTitle("Top Ten Gamers");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Create the text area for displaying the list
        textArea = new JTextArea();
        textArea.setEditable(false); // Make it non-editable
        add(new JScrollPane(textArea), BorderLayout.CENTER); // Add scroll pane for text area

        // Create the command input panel
        JPanel cmdPanel = new JPanel();
        JLabel cmdLabel = new JLabel("Insert name score:");
        cmdTextField = new JTextField(20); // Create text field with a width of 20 columns

        // Add the label and text field to the command panel
        cmdPanel.add(cmdLabel);
        cmdPanel.add(cmdTextField);

        // Add action listener for the command text field
        cmdTextField.addActionListener(new CmdTextListener());

        // Add command panel to the bottom of the frame
        add(cmdPanel, BorderLayout.SOUTH);
    }

    // Inner class to handle command input
    class CmdTextListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            String cmd = cmdTextField.getText(); // Get the command text
            Scanner sc = new Scanner(cmd);
            String cmdOp = sc.next();

            if (cmdOp.equalsIgnoreCase("insert")) {
                // Check for missing name
                if (!sc.hasNext()) {
                    throw new RuntimeException("Missing name in insert command");
                }
                String name = sc.next();

                // Check for missing score
                if (!sc.hasNextInt()) {
                    throw new RuntimeException("Missing score in insert command");
                }
                int score = sc.nextInt();

                // Insert the new entry into the sorted linked list
                sll.insert(name, score);

                // Display the new list
                Iterator<GameStat> listIter = sll.iterator();
                textArea.setText(""); // Clear the text area
                int i = 1;
                while (listIter.hasNext()) {
                    GameStat stat = listIter.next();
                    textArea.append(i + " " + stat.toString() + "\n"); // Append each entry to the text area
                    i++;
                }
                cmdTextField.setText(""); // Clear the command text field
            }
        }
    }
}

/**
 * GameStat represents a pair consisting of a name and a score, to be stored in
 * the list.
 */
class GameStat implements Comparable<GameStat>
{
    String name;
    int score;

    public GameStat(String s, int i)
    {
        name = s;
        score = i;
    }

    @Override
    public String toString()
    {
        return name + " " + score;
    }

    @Override
    public int compareTo(GameStat other)
    {
        return score - other.score;
    }
}


class SortedLinkedList extends GenericLinkedList<GameStat>
{
    /**
     * getPosition
     *
     * @param stat A GameStat to be stored.
     * @return The index the GameStat will have when stored in the list.
     * When new element are added at the returned position, the larger values
     * will be at the beginning of the list
     */
    private int getPosition(GameStat stat)
    {

    }

    /**
     * void insert(String name, int score). Adds the score according to the
     * rules that govern the hall of fame list.
     *
     * @param name The name of the player.
     * @param score The player's score.
     */
    public void insert(String name, int score)
    {
      
    }
}



