package Project.passagier;

public class Bagage {
    private double gewicht;
    private final double maxgewicht = 40.0;


    public Bagage(double gewicht) {
        this.gewicht = gewicht;
    }
    public double getGewicht() {
        return gewicht;
    }
    public boolean isOvergewicht(){
        return gewicht > maxgewicht;
    }
    public double berekenExtrakosten() {
        if (isOvergewicht()) {
            return (gewicht  - maxgewicht) * 10;
        }
        return 0.0;
    }
}


