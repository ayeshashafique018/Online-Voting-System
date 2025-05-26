package onlinevoting;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PTIGUI extends JFrame {
    private JPanel mainPanel;

    public PTIGUI(ArrayList<Nominee> nominees) {
        setTitle("PTI Nominees in Pakistan");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        displayPTINominees(nominees);

        add(mainPanel);
        setVisible(true);
    }

    public void displayPTINominees(ArrayList<Nominee> nominees) {
        mainPanel.removeAll(); // Clear existing content

        NomineelistPTI ptiNomineeList = new NomineelistPTI(nominees);
        ArrayList<Nominee> ptiNominees = ptiNomineeList.getPTINominees();

        ButtonGroup nomineeGroup = new ButtonGroup();

        for (Nominee nominee : ptiNominees) {
            JRadioButton nomineeButton = new JRadioButton("Name: " + nominee.getName() + ", Area: " + nominee.getArea() + ", Nationality: " + nominee.getNationality());
            nomineeButton.setActionCommand(nominee.getName()); // Setting nominee's name as action command

            nomineeGroup.add(nomineeButton); // Add to button group
            mainPanel.add(nomineeButton);
        }

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String selectedNominee = nomineeGroup.getSelection().getActionCommand();
            // Process the selected nominee, e.g., store it for voting

            // Show a confirmation or proceed further based on the selected nominee
            JOptionPane.showMessageDialog(null, "You selected: " + selectedNominee);
            // Add further logic here, e.g., moving to the next step or confirming the selection
        });
        mainPanel.add(submitButton); // Add submit button after the nominees

        revalidate();
        repaint();
    }
}
