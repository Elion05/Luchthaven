package Project.passagier;



//hier wordt de passagier gemaakt en wordt het eerste text met info over jouw passagier geprint.
//

public class Passagier {
    private String passagierNaam;
    private String passagierEmail;
    private String passagiertelefoonnummer;
    private String passagierAddress;
    private int passagierLeeftijd;
    private Bagage bagage;

    public Bagage getBagage() {
        return bagage;
    }
    public void setBagage(Bagage bagage) {
        this.bagage = bagage;
    }

    public Passagier() {
    }
    public void setPassagierNaam(String passagierName) {
        this.passagierNaam = passagierName;
    }
    public String getPassagierNaam() {
        return passagierNaam;
    }

    public void setPassagierEmail(String passagierEmail) {
        this.passagierEmail = passagierEmail;
    }

    public String getPassagierEmail() {
        return passagierEmail;
    }

    public void setPassagiertelefoonnummer(String passagiertelefoonnummer) {
        this.passagiertelefoonnummer = passagiertelefoonnummer;
    }

    public String getPassagiertelefoonnummer() {
        return passagiertelefoonnummer;
    }

    public void setPassagierAddress(String passagierAddress) {
        this.passagierAddress = passagierAddress;
    }

    public String getPassagierAddress() {
        return passagierAddress;
    }
    public void setPassagierLeeftijd(int passagierLeeftijd) {
        this.passagierLeeftijd = passagierLeeftijd;
    }
    public int getPassagierLeeftijd() {
        return passagierLeeftijd;
    }
    @Override
    public String toString(){
        return "Passagier{" +
                "Naam: '" + passagierNaam + '\'' +
                ", Email: '" + passagierEmail + '\'' +
                ", Telefoonnumer:'" + passagiertelefoonnummer + '\'' +
                ", Adres: '" + passagierAddress + '\'' +
                ", Leeftijd: " + passagierLeeftijd +

                '}';
    }

}
