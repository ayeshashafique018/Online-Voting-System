package onlinevoting;

import java.util.ArrayList;
import java.util.List;

public class NomineeListPMLN {
    private List<Nominee> pmlnNominees;

    public NomineeListPMLN() {
        this.pmlnNominees = new ArrayList<>();
    }

    // Method to add a nominee to the PMLN list
    public void addNominee(Nominee nominee) {
        pmlnNominees.add(nominee);
    }

    // Method to get the list of PMLN nominees
    public List<Nominee> getPMLNNominees() {
        return pmlnNominees;
    }

    // Additional methods as needed for managing PMLN nominees

    @Override
    public String toString() {
        return "NomineeListPMLN{" +
                "pmlnNominees=" + pmlnNominees +
                '}';
    }
}

