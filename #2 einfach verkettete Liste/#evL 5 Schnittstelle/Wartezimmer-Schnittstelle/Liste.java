public class Liste{
    Listenelement anfang;

    public Liste(){
        anfang = new Abschluss();
    }

    public void vorneEinfuegen(Datenelement dNeu){
        Knoten kNeu;
        kNeu = new Knoten(dNeu, anfang);
        anfang = kNeu;
    }

    public void hintenEinfuegen(Datenelement dNeu){
        anfang.hintenEinfuegen(dNeu);  
    }

    public void einfuegenVor(Datenelement dNeu, Datenelement dVergleich){
        anfang=anfang.einfuegenVor(dNeu,dVergleich);
    }

    public void sortiertEinfuegen(Datenelement dNeu){
        anfang=anfang.sortiertEinfuegen(dNeu);
    }

    public void knotenEntfernen(Datenelement dVergleich){
        anfang = anfang.knotenEntfernen(dVergleich);
    }

    public Datenelement anfangEntfernen(){
        Listenelement l = anfang;
        anfang = anfang.nachfolgerGeben();
        return l.inhaltGeben();
    }

    public Datenelement endeEntfernen(){
        Datenelement d;
        d = anfang.endeGeben(null); 
        anfang = anfang.endeEntfernen(d);
        return d;
    }

    public Datenelement suchen(String vergleichswert){
        return anfang.suchen(vergleichswert);
    }

    public int laengeGeben(){
        return anfang.restlaengeGeben();
    }

    void alleInformationenAusgeben(){
            anfang.informationAusgeben();
    }
}