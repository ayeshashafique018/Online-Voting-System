package onlinevoting;

import java.util.ArrayList;
import java.util.List;

public class Elections {
    private List<Party> parties;
    private VoteCounter voteCounter;

    public Elections() {
        this.parties = new ArrayList<>();
        this.voteCounter = new VoteCounter();
    }

    // Method to add a party to the elections
    public void addParty(Party party) {
        parties.add(party);
    }

    // Method to get the list of parties in the elections
    public List<Party> getParties() {
        return parties;
    }

    // Method to start the elections
    public void startElections() {
        // Implementation logic for starting the elections
        // For simplicity, it's left as an exercise
    }

    // Method to stop the elections and declare results
    public void stopElections() {
        // Implementation logic for stopping the elections and declaring results
        // For simplicity, it's left as an exercise
    }

    // Additional methods as needed for managing elections

    @Override
    public String toString() {
        return "Elections{" +
                "parties=" + parties +
                ", voteCounter=" + voteCounter +
                '}';
    }
}
