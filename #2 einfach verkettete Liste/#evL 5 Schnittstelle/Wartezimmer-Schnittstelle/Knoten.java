public class Knoten extends Listenelement{
    private Listenelement nachfolger;
    private Datenelement inhalt;

    public Knoten(Datenelement d, Listenelement l) {
        inhalt = d;
        nachfolger = l;
    }
    
    public Knoten hintenEinfuegen(Datenelement dNeu){
        nachfolger=nachfolger.hintenEinfuegen(dNeu);
        return this;
    }
    
    public Knoten einfuegenVor(Datenelement dNeu, Datenelement dVergleich){
        if(inhalt == dVergleich){
            Knoten kNeu;
            kNeu = new Knoten(dNeu, this);
            return kNeu;
        }
        else{
            nachfolger=nachfolger.einfuegenVor(dNeu, dVergleich);
            return this;
        }
    }

    public Knoten sortiertEinfuegen(Datenelement dNeu){
        if(inhalt.istKleinerAls(dNeu)){
            nachfolger=nachfolger.sortiertEinfuegen(dNeu);
            return this;
        }
        else{
            Knoten kNeu;
            kNeu = new Knoten(dNeu, this);
            return kNeu;
        }
    }    
    
    public Listenelement knotenEntfernen(Datenelement dVergleich){
        if(inhalt == dVergleich){
            return nachfolger;
        }
        else{
            nachfolger=nachfolger.knotenEntfernen(dVergleich);
            return this;
        }
    }
    
    public Datenelement endeGeben(Datenelement d){
        return nachfolger.endeGeben(inhalt);
    }
    
    public Listenelement endeEntfernen(Datenelement d){
        if(inhalt == d){
            return nachfolger;
        }
        else{
            nachfolger=nachfolger.endeEntfernen(d);
            return this;
        }
    }
    
    public Datenelement inhaltGeben(){
        return inhalt;
    }
    
    public Listenelement nachfolgerGeben(){
        return nachfolger;
    }
    
    public Datenelement suchen(String vergleichswert){
        if(inhalt.schluesselIstGleich(vergleichswert)){
            return inhalt;
        }
        else{
            return nachfolger.suchen(vergleichswert);
        }
    }
    
    public void informationAusgeben(){
        inhalt.informationAusgeben();
        nachfolger.informationAusgeben();
    }
    
    public int restlaengeGeben(){
        return nachfolger.restlaengeGeben()+1;
    }
}
