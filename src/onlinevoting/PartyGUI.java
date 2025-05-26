package onlinevoting;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PartyGUI extends JFrame {
    private JPanel mainPanel;
    private JComboBox<String> partyComboBox;
    private JButton submitButton;

    public PartyGUI(ArrayList<Nominee> nominees) {
        setTitle("List of Nominees");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create party selection dropdown
        String[] partyOptions = {"PPP", "PTI", "PMLN"};
        partyComboBox = new JComboBox<>(partyOptions);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String selectedParty = (String) partyComboBox.getSelectedItem();
            if (selectedParty.equals("PTI")) {
                PTIGUI ptiGUI = new PTIGUI(nominees); // Assuming PTIGUI class exists and takes ArrayList<Nominee> as a parameter
                ptiGUI.setVisible(true);
            } else {
                displayNominees(nominees, selectedParty); // For other parties, display nominees
            }
        });

        JPanel partySelectionPanel = new JPanel();
        partySelectionPanel.add(new JLabel("Select your party: "));
        partySelectionPanel.add(partyComboBox);
        partySelectionPanel.add(submitButton); // Add submit button

        add(partySelectionPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void displayNominees(ArrayList<Nominee> nominees, String selectedParty) {
        mainPanel.removeAll(); // Clear existing content

        for (Nominee nominee : nominees) {
            if (nominee.getParty().equals(selectedParty)) {
                JLabel nomineeLabel = new JLabel("Name: " + nominee.getName() + ", Area: " + nominee.getArea() + ", Nationality: " + nominee.getNationality());
                mainPanel.add(nomineeLabel);
            }
        }

        revalidate();
        repaint();
    }

    public void setTitleText(String title) {
        setTitle(title);
    }
}
