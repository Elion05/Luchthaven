package Project.informatieFILE;


import Project.Personeel.Personeel;
import Project.Personeel.PersoneelManager;
import Project.VluchtCode.NieuweVlucht;
import Project.passagier.Bagage;
import Project.passagier.Passagier;

import java.util.List;




//hier gebeurt alles van case 7, en systemoutprint van alle info

public class allesPrinten {
    public static void printAlles(List<Passagier> passagierLijst, List<NieuweVlucht> vluchtLijst, PersoneelManager personeelManager) {
        System.out.println("============================");
        System.out.println("   Informatie file   ");
        System.out.println("============================");

        System.out.println("Passagier Informatie: ");
        for (Passagier passagier : passagierLijst) {
            System.out.println("Naam :" + passagier.getPassagierNaam());
            System.out.println("Email : " + passagier.getPassagierEmail());
            System.out.println("Telefoonnumer: " + passagier.getPassagiertelefoonnummer());
            System.out.println("Adres: " + passagier.getPassagierAddress());
            System.out.println("Leeftijd: " + passagier.getPassagierLeeftijd());

            Bagage bagage = passagier.getBagage();
            if (bagage != null) {
                System.out.println("Bagagegewicht: " + bagage.getGewicht() + " kg ");
            }
        }
        System.out.println("===========================");
        System.out.println("    Vlucht Informatie      ");
        System.out.println("===========================");
        for (NieuweVlucht vlucht : vluchtLijst) {
            System.out.println("Vluchtcode: " + vlucht.getVluchtCode());
            System.out.println("Bestemming: " + vlucht.getVluchtBestemming());
            System.out.println("Toegewezen Personeel: " + vlucht.getToegewezenPersoneel());
        }
        System.out.println("========================");
        System.out.println("  Personeel Informatie  ");
        System.out.println("========================");
        for (Personeel personeel : personeelManager.getPersoneelsLijst()) {
            System.out.println("Naam: " + personeel.getNaam());
            System.out.println("Functie: " + personeel.getFunctie());
            System.out.println("Toegewezen vlucht: " + personeel.getToegewezenVlucht());
        }
    }
}
