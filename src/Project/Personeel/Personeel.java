package Project.Personeel;

public class Personeel {
    private String naam;
    private int leeftijd;
    private String functie;
    private String toegewezenVlucht;



    public Personeel(String naam, int leeftijd, String functie) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.functie = functie;
        this.toegewezenVlucht = "/";
    }
    public String getNaam() {
        return naam;
    }
    public String getFunctie() {
        return functie;
    }
    public String getToegewezenVlucht() {
        return toegewezenVlucht;
    }
    public void setToegewezenVlucht(String vluchtCode){
        this.toegewezenVlucht = vluchtCode;
    }
    @Override
    public String toString() {
        return "Personeel{" +
                "Naam:'" + naam + '\'' +
                ",Functie: '" + functie +
                ",toegewezen vlucht: '" + (toegewezenVlucht  != null ? toegewezenVlucht : "geen toegewezen vlucht") + '\''+
                '}';
    }
}
