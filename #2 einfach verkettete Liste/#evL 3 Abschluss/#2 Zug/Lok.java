public class Lok extends Zugteil
{
    public int ps;

    public Lok(int laenge, int leergewicht, int ps)
    {
        this.laenge = laenge;
        this.leergewicht = leergewicht;
        this.ps = ps;
    }

    public void ausgabe()
    {
        System.out.println("Lok | Länge: "
            + laenge
            + ", Leergewicht: "
            + leergewicht
            + ", PS: "
            + ps);
            
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
            return naechster.gesamtladung();
        }
        else
        {
            return 0;
        }
    }
}