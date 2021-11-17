public class Abschluss extends Listenelement
{

    public Knoten hintenEinfuegen(Datenelement pNeu){
        Knoten kneu;
        kneu = new Knoten(pNeu, this);
        return kneu;
    }

    public Knoten einfuegenVor(Datenelement pNeu, Datenelement pVergleich){
        return hintenEinfuegen(pNeu);
    }

    public Knoten sortiertEinfuegen(Datenelement pNeu){
        return hintenEinfuegen(pNeu);
    }    

    public Listenelement knotenEntfernen(Datenelement pVergleich){
        return null;
    }

    public Datenelement endeGeben(Datenelement p){
        return p;
    }

    public Listenelement endeEntfernen(Datenelement p){
        return this;
    }

    public Datenelement inhaltGeben(){
        return null;
    }

    public Listenelement nachfolgerGeben(){
        return this;
    }

    public Datenelement suchen(String vergleichswert){
        return null;
    }

    public void informationAusgeben(){
        System.out.println("Abschluss");
    }

    public int restlaengeGeben(){
        return 0;
    }    

}
