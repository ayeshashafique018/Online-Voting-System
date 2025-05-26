package onlinevoting;

import java.util.ArrayList;

public class CandidateData {
    private ArrayList<String[]> people;
    private ArrayList<String[]> furtherInfo;

    public CandidateData() {
        people = new ArrayList<>();
        furtherInfo = new ArrayList<>();

        // Initialize people and furtherInfo ArrayLists with default values
        people.add(new String[]{"Candidate 1", "Party A", "101"});
        people.add(new String[]{"Candidate 2", "Party B", "102"});
        people.add(new String[]{"Candidate 3", "Party C", "103"});
        //... Add more candidates as needed

        // Initialize further info of each candidate
        furtherInfo.add(new String[]{"Candidate 1 Details", "Info 1", "Some additional information about Candidate 1"});
        furtherInfo.add(new String[]{"Candidate 2 Details", "Info 2", "Some additional information about Candidate 2"});
        furtherInfo.add(new String[]{"Candidate 3 Details", "Info 3", "Some additional information about Candidate 3"});
        //... Add more additional information for candidates
    }

    public int getCandidateCount() {
        return people.size();
    }

    public String[] getCandidatePersonalInfo(int index) {
        if (index >= 0 && index < people.size()) {
            return people.get(index);
        }
        return null;
    }

    public String[] getCandidateFurtherInfo(int index) {
        if (index >= 0 && index < furtherInfo.size()) {
            return furtherInfo.get(index);
        }
        return null;
    }

    // Method to add a new candidate
    public void addCandidate(String[] personalInfo, String[] furtherInfo) {
        people.add(personalInfo);
        this.furtherInfo.add(furtherInfo);
    }

    // Method to retrieve the candidate's image file name
    public String getCandidateImageFileName(int index) {
        // Implement logic to retrieve candidate image file name
        // Example:
        // return "Candidate" + index + ".jpg";
        return null; // Replace this with actual logic
    }
}
