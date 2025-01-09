package Project;
import Project.Boarding.BoardingManager;
import Project.Personeel.Personeel;
import Project.Personeel.PersoneelManager;
import Project.VluchtCode.NieuweVlucht;
import Project.informatieFILE.allesPrinten;
import Project.passagier.Bagage;
import Project.passagier.Passagier;
import Project.ticketInfo.Ticketvlucht;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;





public class Main {
    private static NieuweVlucht geselecteerdeVlucht;
    private static String geselecteerdeKlasse;
    private static Passagier geselecteerdePassagier;

    private static List<NieuweVlucht>vluchtLijst = new ArrayList<>();



    public static void main(String[] args) {
        List<Passagier> passagierLijst = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Scanner scannergetal = new Scanner(System.in);
        boolean run = true;

        PersoneelManager personeelManager = new PersoneelManager();



       // NieuweVlucht vlucht1 = new NieuweVlucht("01", "van Brussel naar Berlijn", 10, 200);// later verwijderen als ik dit niet nodig heb
        // NieuweVlucht vlucht2 = new NieuweVlucht("02", "van Brussel naar Albanië", 10, 150); //

        while (run) {        //keuzemenu
            System.out.println("========================");
            System.out.println("        Welkom!     ");
            System.out.println("========================");
            System.out.println("KeuzeMenu:");
            System.out.println("1. Nieuwe passagier aanmaken ");
            System.out.println("2. Vlucht keuzes ");
            System.out.println("3. Ticket Printen ");
            System.out.println("4. Bagagecontrole");
            System.out.println("5. Boarding");
            System.out.println("6. Toewijzen personeel");
            System.out.println("7. Print complete informatie");
            System.out.println("8. Afsluiten ");

            int keuze = scannergetal.nextInt();

            switch (keuze) {
                case 1:               //passagier gemaakt door gebruiker, hoeveel je wil.
                    Passagier passagier = maakPassagier(scanner);
                    passagierLijst.add(passagier);
                    System.out.println("Passagier is succesvol aangemaakt, welcome " + passagier.getPassagierNaam() + " ! ");
                    System.out.println(passagier);// override
                    break;


                case 2:      //Vlucht bestemming en klasse door gebruiker gekozen//
                    voegNieuweVluchtToe(scanner);
                    break;

                case 3://Ticket geprint met alle informatie over de vlucht en klasse en passagier zelf.

                    if (passagierLijst.isEmpty()) {
                        System.out.println("Maak eerst een passagier. ");
                        break;
                    }
                    System.out.println("Selecteer een passagier");
                    for (int i = 0; i < passagierLijst.size(); i++) {
                        System.out.println((i + 1) + ". " + passagierLijst.get(i).getPassagierNaam());
                    }

                    int passagierKeuze = Integer.parseInt(scanner.nextLine()) - 1;
                    try {
                        if (passagierKeuze >= 0 && passagierKeuze < passagierLijst.size()) {
                            geselecteerdePassagier = passagierLijst.get(passagierKeuze);
                        } else {
                            System.out.println("Ongeldige invoer. ");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ongeldige invoer. ");
                        break;
                    }


                    Ticketvlucht ticket = new Ticketvlucht(geselecteerdePassagier, geselecteerdeVlucht, geselecteerdeKlasse);
                    System.out.println(ticket);
                    break;


                case 4: //bagagecontrole, overgewicht = boete betalen

                    if (passagierLijst.isEmpty()) {
                        System.out.println("Maak eerst een passagier. ");
                        break;
                    }

                    System.out.println("Selecteer een passagier voor bagagecontrole: ");
                    for (int i = 0; i < passagierLijst.size(); i++) {
                        System.out.println((i + 1) + ". " + passagierLijst.get(i).getPassagierNaam());
                    }
                    int bagagePassagierKeuze = scannergetal.nextInt() - 1;
                    if (bagagePassagierKeuze >= 0 && bagagePassagierKeuze < passagierLijst.size()) {
                        geselecteerdePassagier = passagierLijst.get(bagagePassagierKeuze);
                        System.out.println("Voer het gewicht van je bagage in(kg): ");
                        double bagageGewicht = scannergetal.nextDouble();
                        Bagage bagage = new Bagage(bagageGewicht);
                        geselecteerdePassagier.setBagage(bagage);

                        if (bagage.isOvergewicht()) {
                            System.out.println("Je bagage is zwaarder dan  normaal toegelaten. ");
                            System.out.println("Je betaalt " + bagage.berekenExtrakosten() + " euro extra als boeten. " );
                        } else {
                            System.out.println("Je bagage is  correct gewogen");
                        }
                    } else {
                        System.out.println("Ongeldige invoer. ");
                    }
                    break;


                case 5:     //boarding toegang , als je geen passagier of vlucht heb gekozen, moet je het eerst aanvullen
                    if(geselecteerdePassagier == null) {
                        System.out.println("Geen passagier geselecteerd. ");
                        break;
                    }
                    if (geselecteerdeVlucht == null) {
                        System.out.println("Geen vlucht geselecteerd. ");
                        break;
                    }
                    BoardingManager boardingManager = new BoardingManager();
                    boardingManager.boardPassagier(scanner, geselecteerdeVlucht, passagierLijst);
                    break;

                case 6: //personeel dat wordt toegvoegt aan een vlucht, wordt dan opgeslaan in een aparte lijst voor de totale print
                    System.out.println("Beschikbare vluchten: ");
                    for(NieuweVlucht vlucht : vluchtLijst){
                        System.out.println(" Bestemming: " + vlucht.getVluchtBestemming() + ", Vluchtcode: " + vlucht.getVluchtCode());
                    }
                    System.out.println("Aan welke vlucht wil je jouw personeel toevoegen? ");
                    String geselecteerdeBestemming = scanner.nextLine();

                    NieuweVlucht gevondenVlucht = null;
                    for (NieuweVlucht vlucht : vluchtLijst) {
                        if (vlucht.getVluchtBestemming().equalsIgnoreCase(geselecteerdeBestemming)) {
                            gevondenVlucht = vlucht;
                            break;
                        }
                    }
                    if (gevondenVlucht == null) {
                        System.out.println("Geen vlucht geselecteerd. ");
                        break;
                    }
                    personeelManager.toonPersoneelsleden();
                    System.out.println("Typ de naam van een personeelslid om toe te wijzen aan deze vlucht. (met of zonder hoofdletters. type stop om te stoppen. ");

                    while (true){
                        String geselecteerdePersoneelsNaam = scanner.nextLine();
                        if (geselecteerdePersoneelsNaam.equalsIgnoreCase("stop")) {
                            break;
                        }
                        for (Personeel personeel : personeelManager.getPersoneelsLijst()){
                            if (personeel.getNaam().equalsIgnoreCase(geselecteerdePersoneelsNaam)){
                                if (gevondenVlucht.getToegewezenPersoneel().contains(personeel.getNaam())){
                                    System.out.println(personeel.getNaam() + "kan je niet toewijzen. ");
                                }else{
                                    personeel.setToegewezenVlucht(gevondenVlucht.getVluchtCode());
                                    gevondenVlucht.voegPersoneelToe(personeel.getNaam());
                                    System.out.println(personeel.getNaam() + " is succesvol toegevoegt aan deze vlucht. ");
                                }
                                break;
                            }
                        }
                    }
                    break;


                case 7:    //hier wordt al de informatie opgeslagen en onder elkaar geprint

                     allesPrinten.printAlles(passagierLijst,vluchtLijst,personeelManager);
                break;


                case 8: //gewoon om het programma te beindigen
                run = false;
                System.out.println("Einde");
                break;
            default:
                System.out.println("Ongeldige keuze ingevoert.");
        }
    }
}
private static Passagier maakPassagier(Scanner scanner) {          //Passagier aanmaken hier
    Passagier passagier = new Passagier();

    System.out.println("Voer je volledige naam in: ");
    passagier.setPassagierNaam(scanner.nextLine());

    System.out.println("Voer je email in: ");
    passagier.setPassagierEmail(scanner.nextLine());

    System.out.println("Voer je telefoonnumer in: ");
    passagier.setPassagiertelefoonnummer(scanner.nextLine());

    System.out.println("Voer je adres in: ");
    passagier.setPassagierAddress(scanner.nextLine());

    while (true) {   //deze while zorgt ervoor dat je getallen in geeft in plaats van letters met de "try catch" numberformat
        System.out.println("Voer je leeftijd in: ");


        try {

            passagier.setPassagierLeeftijd(Integer.parseInt(scanner.nextLine()));
            break;
        } catch (NumberFormatException e) {
            System.out.println("Ongeldige leeftijd ingevoert. ");
        }
    }
    return passagier;
}
private static void voegNieuweVluchtToe(Scanner scanner) {     //hier kan je jouw vlucht 'zoeken' en geeft die een vlucht code, die slaat dat ook op,
    System.out.println("Voer uw bestemming in: ");
    String bestemming = scanner.nextLine();

    String gegenereerdeVluchtCode = "NMVB22 " + (vluchtLijst.size()+1);


    int standaardBusinessPlaatsen = 10;
    int standaardEconomyPlaatsen = 100;

    NieuweVlucht nieuweVlucht = new NieuweVlucht(gegenereerdeVluchtCode,bestemming,standaardBusinessPlaatsen,standaardEconomyPlaatsen);
    vluchtLijst.add(nieuweVlucht);
    System.out.println("Vlucht gevonden: ");
    System.out.println("Vluchtcode: " + nieuweVlucht.getVluchtCode());
    System.out.println("Bestemming: " + nieuweVlucht.getVluchtBestemming());
    System.out.println(" Aantal Business plaatsen : " + nieuweVlucht.getAantalPlaatsenBussines());
    System.out.println("Aantal Economy plaatsen : " + nieuweVlucht.getAantalPlaatsenEco());

    System.out.println("Kies een klasse voor de vlucht(Economy/Business): "); //hier kies je jouw klasse, economy of business
    String gekozenKlasse = scanner.nextLine();

    if (gekozenKlasse.equalsIgnoreCase("Economy") || gekozenKlasse.equalsIgnoreCase("Business")) {
        geselecteerdeKlasse = gekozenKlasse;
        geselecteerdeVlucht = nieuweVlucht;
        System.out.println("Je hebt voor  "  +  gekozenKlasse  +  " gekozen. " );
    }else{
        System.out.println("Ongeldige invoer");
    }
}
}








