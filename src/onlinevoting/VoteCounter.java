package onlinevoting;

import java.util.HashMap;
import java.util.Map;

public class VoteCounter {
    private Map<String, Integer> voteCount;

    public VoteCounter() {
        voteCount = new HashMap<>();
    }

    // Method to count votes for a candidate
    public void countVote(String candidateNumber) {
        voteCount.put(candidateNumber, voteCount.getOrDefault(candidateNumber, 0) + 1);
    }

    // Method to retrieve the total votes for all candidates
    public Map<String, Integer> getVoteCount() {
        return voteCount;
    }

    // Method to retrieve votes for a specific candidate
    public int getVotesForCandidate(String candidateNumber) {
        return voteCount.getOrDefault(candidateNumber, 0);
    }

    // Method to get the candidate with the maximum votes
    public String getCandidateWithMaxVotes() {
        int maxVotes = 0;
        String candidate = null;
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                candidate = entry.getKey();
            }
        }
        return candidate;
    }
    
    // Method to get the total number of votes casted
    public int getTotalVotesCount() {
        int totalVotes = 0;
        for (int votes : voteCount.values()) {
            totalVotes += votes;
        }
        return totalVotes;
    }

    // Method to reset votes for a candidate
    public void resetVotesForCandidate(String candidateNumber) {
        voteCount.put(candidateNumber, 0);
    }
}

