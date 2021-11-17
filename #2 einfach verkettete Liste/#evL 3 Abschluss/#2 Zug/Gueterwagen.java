public class Gueterwagen extends Zugteil
{
    public int masse;
    public String art;

    public Gueterwagen(int laenge, int leergewicht, int masse, String art)
    {
        this.laenge = laenge;
        this.leergewicht = leergewicht;
        this.masse = masse;
        this.art = art;
    }

    public void ausgabe()
    {
        System.out.println("Güterwagen | Länge: "
            + laenge
            + ", Leergewicht: "
            + leergewicht
            + ", Ladung: "
            + masse + "t " + art);
            
        if (naechster != null)
        {
            naechster.ausgabe();
        }
    }
    
    public int sitzplaetze()
    {
        if (naechster != null)
        {
            return naechster.sitzplaetze();
        }
        else
        {
            return 0;
        }
    }
    
    public int gesamtladung()
    {
        if (naechster != null)
        {
            return masse + naechster.gesamtladung();
        }
        else
        {
            return masse;
        }
    }
}