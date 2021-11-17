public class Liste{
    Listenelement anfang;

    public Liste(){
        anfang = new Abschluss();
    }

    public void vorneEinfuegen(Patient pNeu){
        Knoten kNeu;
        kNeu = new Knoten(pNeu, anfang);
        anfang = kNeu;
    }

    public void hintenEinfuegen(Patient pNeu){
        anfang.hintenEinfuegen(pNeu);  
    }

    public void einfuegenVor(Patient pNeu, Patient pVergleich){
        anfang=anfang.einfuegenVor(pNeu,pVergleich);
    }

    public void sortiertEinfuegen(Patient pNeu){
        anfang=anfang.sortiertEinfuegen(pNeu);
    }

    public void knotenEntfernen(Patient pVergleich){
        anfang = anfang.knotenEntfernen(pVergleich);
    }

    public Patient anfangEntfernen(){
        Listenelement l = anfang;
        anfang = anfang.nachfolgerGeben();
        return l.inhaltGeben();
    }

    public Patient endeEntfernen(){
        Patient p;
        p = anfang.endeGeben(null); 
        anfang = anfang.endeEntfernen(p);
        return p;
    }

    public Patient suchen(String vergleichswert){
        return anfang.suchen(vergleichswert);
    }

    public int laengeGeben(){
        return anfang.restlaengeGeben();
    }

    void alleInformationenAusgeben(){
            anfang.informationAusgeben();
    }
}