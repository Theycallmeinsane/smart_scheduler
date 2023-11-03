import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI extends JFrame implements ActionListener {

    private JLabel fileLabel;
    private JLabel sheetLabel;
    private JTextField fileTextField;
    private JTextField sheetTextField;
    private JButton generateButton;

    public GUI() {
        super("Schedule Generator");

        fileLabel = new JLabel("ClassRooms Excel File:");
        fileLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        sheetLabel = new JLabel("Professor Excel File:");
        sheetLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        fileTextField = new JTextField(20);
        sheetTextField = new JTextField(20);
        generateButton = new JButton("Generate Schedule");
        generateButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(fileLabel);
        panel.add(fileTextField);
        panel.add(sheetLabel);
        panel.add(sheetTextField);
        panel.add(new JLabel(""));
        panel.add(generateButton);

        getContentPane().add(panel);

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateButton) {
            try {
                generateSchedule();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public void generateSchedule() throws IOException {
        String classesFile = fileTextField.getText();
        String professorFile = sheetTextField.getText();
        ScheduleGUI scheduleGUI = new ScheduleGUI(classesFile, professorFile);
       

        JOptionPane.showMessageDialog(this, "Schedule generated successfully!");
    }

    public static void main(String[] args) {
        System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
        new GUI();
    }

}
