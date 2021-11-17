public class Personenwagen extends Zugteil
{
    public int sitzplaetze;

    public Personenwagen(int laenge, int leergewicht, int sitzplaetze)
    {
        this.laenge = laenge;
        this.leergewicht = leergewicht;
        this.sitzplaetze = sitzplaetze;
    }

    public void ausgabe()
    {
        System.out.println("Personenwagen | Länge: "
            + laenge
            + ", Leergewicht: "
            + leergewicht
            + ", Sitzplätze: "
            + sitzplaetze);

        if (naechster != null)
        {
            naechster.ausgabe();
        }
    }

    public int sitzplaetze()
    {
        if (naechster != null)
        {
            return sitzplaetze + naechster.sitzplaetze();
        }
        else
        {
            return sitzplaetze;
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