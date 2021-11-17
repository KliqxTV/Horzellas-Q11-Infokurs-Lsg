public class Knoten extends Listenelement{
    private Listenelement nachfolger;
    private Patient inhalt;

    public Knoten(Patient p, Listenelement l) {
        inhalt = p;
        nachfolger = l;
    }

    public Knoten hintenEinfuegen(Patient pNeu){
        nachfolger = nachfolger.hintenEinfuegen(pNeu);
        return this;
    }

    public Knoten einfuegenVor(Patient pNeu, Patient pVergleich){
        if(inhalt == pVergleich){
            Knoten kNeu;
            kNeu = new Knoten(pNeu, this);
            return kNeu;
        }
        else{
            nachfolger=nachfolger.einfuegenVor(pNeu, pVergleich);
            return this;
        }
    }

    public Knoten sortiertEinfuegen(Patient pNeu){
        if(inhalt.istKleinerAls(pNeu)){
            nachfolger=nachfolger.sortiertEinfuegen(pNeu);
            return this;
        }
        else{
            Knoten kNeu;
            kNeu = new Knoten(pNeu, this);
            return kNeu;
        }
    }    

    public Listenelement knotenEntfernen(Patient pVergleich){
        if(inhalt == pVergleich){
            return nachfolger;
        }
        else{
            nachfolger=nachfolger.knotenEntfernen(pVergleich);
            return this;
        }
    }

    public Patient endeGeben(Patient p){
        return nachfolger.endeGeben(inhalt);
    }

    public Listenelement endeEntfernen(Patient p){
        if(inhalt == p){
            return nachfolger;
        }
        else{
            nachfolger=nachfolger.endeEntfernen(p);
            return this;
        }
    }

    public Patient inhaltGeben(){
        return inhalt;
    }

    public Listenelement nachfolgerGeben(){
        return nachfolger;
    }

    public Patient suchen(String vergleichswert){
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
        return 1 + nachfolger.restlaengeGeben();
    }
}
