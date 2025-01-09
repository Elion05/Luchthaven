package Project.VluchtCode;

import Project.passagier.Passagier;

import java.util.ArrayList;
import java.util.List;

public class NieuweVlucht {
    private String vluchtCode;
    private String vluchtBestemming;
    private int aantalPlaatsenEco;
    private int aantalPlaatsenBussines;
    private List<String> toegewezenPersoneel;



    public NieuweVlucht(String vluchtCode,String vluchtBestemming, int aantalPlaatsenBussines, int aantalPlaatsenEco) {
        this.vluchtCode = vluchtCode;
        this.vluchtBestemming = vluchtBestemming;
        this.aantalPlaatsenBussines = aantalPlaatsenBussines;
        this.aantalPlaatsenEco = aantalPlaatsenEco;
        this.toegewezenPersoneel = new ArrayList<>();
    }

    public String getVluchtCode() {
        return vluchtCode;
    }
    public String getVluchtBestemming() {
        return vluchtBestemming;
    }
    public int getAantalPlaatsenBussines() {
        return aantalPlaatsenBussines;
    }
    public int getAantalPlaatsenEco() {
        return aantalPlaatsenEco;
    }
    public void voegPersoneelToe(String personeelNaam) {
        toegewezenPersoneel.add(personeelNaam);
    }
    public List<String> getToegewezenPersoneel() {
        return toegewezenPersoneel;
    }
    @Override
    public String toString() {   //als er geen personeel is toegewezen dan werkt het niet
        return "vluchtcode: " + vluchtCode +
                ", Bestemming: " + vluchtBestemming +
                ", Toegewezen personeel: " +
                (toegewezenPersoneel.isEmpty() ? " geen persooneel toegewezen " : String.join(", ", toegewezenPersoneel));

    }
}
