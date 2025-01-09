package Project.Personeel;

import java.util.ArrayList;
import java.util.List;

public class PersoneelManager {
    private List<Personeel> personeelsLijst;

 //hier is de al gemaakte personeel om dat aan te tonen in case 6 met functie en naam
    public PersoneelManager() {
        personeelsLijst = new ArrayList<>();
        personeelsLijst.add(new Personeel("Bruce Banner", 35, "bagagepersoneel"));
        personeelsLijst.add(new Personeel("Luna Snow", 22, "Stewardesse"));
        personeelsLijst.add(new Personeel("Peter Quill", 44, "Piloot"));
        personeelsLijst.add(new Personeel("Cloack Dagger", 25, "Stewardesse"));
        personeelsLijst.add(new Personeel("Adam Warlock", 30, "Co-piloot"));
        personeelsLijst.add(new Personeel("Rocket Raccoon", 32, "Piloot"));
    }

    public List<Personeel> getPersoneelsLijst() {
        return personeelsLijst;
    }

    public void toonPersoneelsleden() {
        System.out.println("Lijst met personeelsleden: ");
        for (Personeel personeel : personeelsLijst) {
            System.out.println(personeel);
        }
    }
}