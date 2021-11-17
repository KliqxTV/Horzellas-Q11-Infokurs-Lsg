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

        naechster.ausgabe();
    }

    public int sitzplaetze()
    {
        return sitzplaetze + naechster.sitzplaetze();
    }

    public int gesamtladung()
    {
        return naechster.gesamtladung();
    }
}