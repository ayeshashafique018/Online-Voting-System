package onlinevoting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VoterGUI extends JFrame {

    private JTextField cnicField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField ageField;
    private JTextField addressField;
    private JTextField emailField;
    private JTextField contactNoField;
    private final databsaeconnectivity databaseConnectivity;

    public VoterGUI() {
        databaseConnectivity = new databsaeconnectivity();
        databaseConnectivity.Connectivity();

        setTitle("Voter Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel cnicLabel = new JLabel("CNIC No:");
        cnicField = new JTextField();

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField();

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField();

        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();

        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();

        JLabel contactNoLabel = new JLabel("Contact No:");
        contactNoField = new JTextField();

        mainPanel.add(cnicLabel);
        mainPanel.add(cnicField);
        mainPanel.add(firstNameLabel);
        mainPanel.add(firstNameField);
        mainPanel.add(lastNameLabel);
        mainPanel.add(lastNameField);
        mainPanel.add(ageLabel);
        mainPanel.add(ageField);
        mainPanel.add(addressLabel);
        mainPanel.add(addressField);
        mainPanel.add(emailLabel);
        mainPanel.add(emailField);
        mainPanel.add(contactNoLabel);
        mainPanel.add(contactNoField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitVoterDetails();
            }
        });

        mainPanel.add(submitButton);
        add(mainPanel);
        setVisible(true);
    }

    private void submitVoterDetails() {
        String cnic = cnicField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String address = addressField.getText();
        String email = emailField.getText();
        long contactNo = Long.parseLong(contactNoField.getText());

        Voter voter = new Voter(cnic, firstName, lastName, age, address, email, contactNo);

        // Insert voter details into the database
        insertVoterDetails(voter);

        // Additional logic can be added, such as displaying a confirmation message.
    }

    private void insertVoterDetails(Voter voter) {
        try {
            Connection connection = databaseConnectivity.getCon();
            String sql = "INSERT INTO voterdata (CNIC, FirstName, LastName, Age, Address, Email, ContactNo) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, voter.getCnicNo());
                pstmt.setString(2, voter.getFirstName());
                pstmt.setString(3, voter.getLastName());
                pstmt.setInt(4, voter.getAge());
                pstmt.setString(5, voter.getAddress());
                pstmt.setString(6, voter.getEmail());
                pstmt.setLong(7, voter.getContactNo());

                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Voter details inserted successfully!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error inserting voter details: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VoterGUI();
        });
    }
}
