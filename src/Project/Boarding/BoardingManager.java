package Project.Boarding;
import Project.VluchtCode.NieuweVlucht;
import Project.passagier.Passagier;
import java.util.List;
import java.util.Scanner;



public class BoardingManager {
 //geen passagier, dan kan hij niet boarden

    public void boardPassagier(Scanner scanner, NieuweVlucht vlucht, List<Passagier> passagierLijst) {
        if(passagierLijst.isEmpty()) {
            System.out.println("Geen passagiers beschikbaar. ");
            return;
        }
        System.out.println("Beschikbare Passagiers: ");
        for(int i = 0; i < passagierLijst.size(); i++) {
            System.out.println((i + 1) + "." + passagierLijst.get(i).getPassagierNaam());
        }
        System.out.println("Selecteer een passagier. ");
        int keuze;
        try{
            keuze = Integer.parseInt(scanner.nextLine()) -1;
            if (keuze >= 0 && keuze <= passagierLijst.size()) {
                Passagier geselecteerdePassagier = passagierLijst.get(keuze);

                System.out.println("Wacht een moment, we controleren uw informatie " + geselecteerdePassagier.getPassagierNaam());

                if (geselecteerdePassagier.getBagage() == null) {
                    System.out.println("Weeg eerst je bagage af. ");
                }else{
                    System.out.println("Boarding goed gekeurd, welkom!");
                }
            }else{
                System.out.println("Ongeldige keuze. ");
            }
        }catch (NumberFormatException e){
            System.out.println("Ongeldige invoer. ");
        }
    }
}
