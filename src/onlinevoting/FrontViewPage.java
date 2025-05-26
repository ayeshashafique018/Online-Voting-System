package onlinevoting;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontViewPage extends JFrame {

    public FrontViewPage() {
        // Setting up the frame
        setTitle("Online Voting System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Creating components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(240, 240, 240));

        JLabel titleLabel = new JLabel("ONLINE VOTING SYSTEM");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(50, 50, 50));

        // Create a dropdown for election types
        String[] electionTypes = {"Baldayati", "Cantonment", "Sobai Zameeni"};
        JComboBox<String> electionDropdown = new JComboBox<>(electionTypes);
        JLabel selectLabel = new JLabel("Select Type of Election: "); // Label for the dropdown
        selectLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Font style

        JPanel dropdownPanel = new JPanel(); // Panel to hold the dropdown and label
        dropdownPanel.setBackground(new Color(240, 240, 240));
        dropdownPanel.add(selectLabel);
        dropdownPanel.add(electionDropdown);

        JButton adminButton = new JButton("Election Manager");
        customizeButton(adminButton);
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide the FrontViewPage frame
                new AdminGUI().setVisible(true); // Show the AdminGUI frame
            }
        });
 JButton voterButton = new JButton("Voter");
        customizeButton(voterButton);
        voterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new VoterGUI().setVisible(true);
            }
        });



        JButton nomineeButton = new JButton("Nominee");
        customizeButton(nomineeButton);

        // Adding components to the main panel
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 0, 10)); // Grid layout with one column and spacing
        buttonPanel.setBackground(new Color(240, 240, 240));
        buttonPanel.add(dropdownPanel); // Adding the dropdown panel
        buttonPanel.add(adminButton);
        buttonPanel.add(voterButton);
        buttonPanel.add(nomineeButton);

        // Create a container panel to set a specific size
        JPanel containerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        containerPanel.setPreferredSize(new Dimension(400, 300)); // Set the size of the container panel
        containerPanel.add(buttonPanel);

        mainPanel.add(containerPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    private void customizeButton(JButton button) {
        button.setPreferredSize(new Dimension(200, 50)); // Set button size
        button.setHorizontalAlignment(SwingConstants.CENTER); // Center-align text
        button.setVerticalAlignment(SwingConstants.CENTER);
        button.setBackground(Color.WHITE); // Button background color
        button.setFont(new Font("Arial", Font.BOLD, 14)); // Button font
        button.setForeground(Color.BLACK); // Button text color
    }
}
