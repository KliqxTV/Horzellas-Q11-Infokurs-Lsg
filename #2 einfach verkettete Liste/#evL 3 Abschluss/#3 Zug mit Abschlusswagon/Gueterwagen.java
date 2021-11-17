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

        naechster.ausgabe();
    }

    public int sitzplaetze()
    {
        return naechster.sitzplaetze();
    }

    public int gesamtladung()
    {
        return masse + naechster.gesamtladung();
    }
}