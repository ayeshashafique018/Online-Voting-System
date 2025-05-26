package onlinevoting;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private String name;
    private String area;
    private String nationality;
    private List<Nominee> nominees;

    public Party(String name, String area, String nationality) {
        this.name = name;
        this.area = area;
        this.nationality = nationality;
        this.nominees = new ArrayList<>();
    }

    // Getters and setters for the fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    // Method to add a nominee to the party
    public void addNominee(Nominee nominee) {
        nominees.add(nominee);
    }

    // Method to get the list of nominees associated with the party
    public List<Nominee> getNominees() {
        return nominees;
    }

    @Override
    public String toString() {
        return "Party{" +
                "name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", nationality='" + nationality + '\'' +
                ", nominees=" + nominees +
                '}';
    }
}
