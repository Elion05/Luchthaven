package Project.ticketInfo;
import Project.VluchtCode.NieuweVlucht;
import Project.passagier.Passagier;


// dit is voor case 3 , hier wordt de ticket geprint


public class Ticketvlucht {
    private Passagier passagier;
    private NieuweVlucht vlucht;
    private String klasse;

    public Ticketvlucht(Passagier passagier, NieuweVlucht vlucht,String klasse) {
        this.passagier = passagier;
        this.vlucht = vlucht;
        this.klasse = klasse;
    }

    @Override
    public String toString() {
        return " Vliegticket:\n" +
        "Naam: " + passagier.getPassagierNaam() + "\n"  +
        "Vluchtcode: " + vlucht.getVluchtCode() +  "\n" +
       "Eindbestemming: " + vlucht.getVluchtBestemming() + "\n" +
        "Klasse: " + klasse + "\n" +
        "==================================================";
    }
}
