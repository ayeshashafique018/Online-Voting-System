package onlinevoting;

import java.util.Map;
import java.util.Scanner;

public class Admin {
    private CandidateData candidateData;
    private VoteCounter voteCounter;

    public Admin(CandidateData candidateData, VoteCounter voteCounter) {
        this.candidateData = candidateData;
        this.voteCounter = voteCounter;
    }

    public void viewCandidates() {
        for (int i = 0; i < candidateData.getCandidateCount(); i++) {
            String[] personalInfo = candidateData.getCandidatePersonalInfo(i);
            String[] furtherInfo = candidateData.getCandidateFurtherInfo(i);

            System.out.println("Candidate " + (i + 1) + " Info:");
            System.out.println("Personal Info: " + personalInfo[0] + ", " + personalInfo[1] + ", " + personalInfo[2]);
            System.out.println("Further Info: " + furtherInfo[0] + ", " + furtherInfo[1]);
            System.out.println();
        }
    }

    public void performVoting() {
        Scanner scanner = new Scanner(System.in);
        int totalCandidates = candidateData.getCandidateCount();

        System.out.println("Enter candidate number to vote (or 0 for NOTA):");
        int candidateChoice = scanner.nextInt();

        if (candidateChoice >= 0 && candidateChoice <= totalCandidates) {
            if (candidateChoice == 0) {
                System.out.println("You voted for NOTA.");
            } else {
                String candidateNumber = String.valueOf(candidateChoice);
                voteCounter.countVote(candidateNumber);
                System.out.println("You voted for Candidate " + candidateChoice + ".");
            }
        } else {
            System.out.println("Invalid choice!");
        }
    }

    public void viewVoteCount() {
        Map<String, Integer> voteCount = voteCounter.getVoteCount();
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            System.out.println("Candidate " + entry.getKey() + " - Votes: " + entry.getValue());
        }
    }
}

