
package vms;

import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;

public class VotingPage extends JFrame {
  private JLabel label;
  private JComboBox candidates;
  private JButton voteButton;

  public VotingPage() {
    setLayout(new FlowLayout());

    label = new JLabel("Select a candidate:");
    add(label);

    candidates = new JComboBox();
    candidates.addItem("Candidate 1");
    candidates.addItem("Candidate 2");
    candidates.addItem("Candidate 3");
    add(candidates);

    voteButton = new JButton("Vote");
    add(voteButton);

    event e = new event();
    voteButton.addActionListener(e);
  }

   

  public class event implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      
      String candidate = (String)candidates.getSelectedItem();

      JOptionPane.showMessageDialog(null, "Thank you for voting for " + candidate + "!");
    }
  }

  public static void main(String[] args) {
    VotingPage vp = new VotingPage();
    vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    vp.setSize(300, 200);
    vp.setVisible(true);
    vp.setTitle("Voting Page");
  }
}

