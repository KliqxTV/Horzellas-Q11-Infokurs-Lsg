public class Abschluss extends Baumelement
{
    private Baumelement nachfolger;
    
    public Datenelement suchen(String suchSchluessel)
    {
        return nachfolger.suchen(suchSchluessel);
    }

    public boolean istVorhanden(String suchSchluessel)
    {
        return nachfolger.istVorhanden(suchSchluessel);
    }

    public Baumelement einfuegen(Datenelement dNeu)
    {
        if (nachfolger == null)
        {
            return nachfolger = new Knoten(dNeu);
        }
        else
        {
            return nachfolger.einfuegen(dNeu);
        }
    }

    public Datenelement getDaten()
    {
        // Abschluss-Element hat keine Daten
        return null;
    }

    public void setDaten(Datenelement dNeu)
    {
        // Kann Abschluss-Element keine Daten übergeben
    }
    
    public void inOrderAusgabe()
    {
        nachfolger.inOrderAusgabe();
    }
    
    public void preOrderAusgabe()
    {
        nachfolger.preOrderAusgabe();
    }
    
    public void postOrderAusgabe()
    {
        nachfolger.postOrderAusgabe();
    }
}