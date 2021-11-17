public class Abschluss extends Listenelement
{

    public Knoten hintenEinfuegen(Patient pNeu){
        Knoten kNeu;
        kNeu = new Knoten(pNeu, this);
        return kNeu;
    }

    public Knoten einfuegenVor(Patient pNeu, Patient pVergleich){
        return hintenEinfuegen(pNeu);
    }

    public Knoten sortiertEinfuegen(Patient pNeu){
        return hintenEinfuegen(pNeu);
    }    

    public Listenelement knotenEntfernen(Patient pVergleich){
        return null;
    }

    public Patient endeGeben(Patient p){
        return p;
    }

    public Listenelement endeEntfernen(Patient p){
        return this;
    }

    public Patient inhaltGeben(){
        return null;
    }

    public Listenelement nachfolgerGeben(){
        return this;
    }

    public Patient suchen(String vergleichswert){
        return null;
    }

    public void informationAusgeben(){
        System.out.println("Abschluss");
    }

    public int restlaengeGeben(){
        return 0;
    }
}
