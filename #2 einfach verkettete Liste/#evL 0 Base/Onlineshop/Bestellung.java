public class Bestellung
{
    String artikel;
    int anzahl;
    double einzelpreis;
    Bestellung naechster;
    
    public Bestellung(String art, int anz, double ein)
    {
        artikel = art;
        anzahl = anz;
        einzelpreis = ein;
    }
}