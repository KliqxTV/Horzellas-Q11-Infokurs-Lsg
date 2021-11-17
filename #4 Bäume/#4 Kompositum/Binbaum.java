public class Binbaum
{
    private Baumelement wurzel;

    public Binbaum()
    {
        wurzel = new Abschluss();
    }

    public Datenelement suchen(String suchSchluessel)
    {
        return wurzel.suchen(suchSchluessel);
    }

    public boolean istVorhanden(String suchSchluessel)
    {
        return wurzel.istVorhanden(suchSchluessel);
    }

    public void einfuegen(Datenelement dNeu)
    {
        wurzel.einfuegen(dNeu);
    }
    
    public void inOrderAusgabe()
    {
        wurzel.inOrderAusgabe();
    }
    
    public void preOrderAusgabe()
    {
        wurzel.preOrderAusgabe();
    }
    
    public void postOrderAusgabe()
    {
        wurzel.postOrderAusgabe();
    }
}