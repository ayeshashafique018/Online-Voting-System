package onlinevoting;

import java.util.ArrayList;

public class NomineelistPTI {
    private ArrayList<Nominee> ptiNominees;

    public NomineelistPTI(ArrayList<Nominee> nominees) {
        this.ptiNominees = new ArrayList<>();
        for (Nominee nominee : nominees) {
            if (nominee.getParty().equals("PTI") && nominee.getNationality().equals("Pakistan")) {
                ptiNominees.add(nominee);
            }
        }
    }

    public ArrayList<Nominee> getPTINominees() {
        return ptiNominees;
    }
}

