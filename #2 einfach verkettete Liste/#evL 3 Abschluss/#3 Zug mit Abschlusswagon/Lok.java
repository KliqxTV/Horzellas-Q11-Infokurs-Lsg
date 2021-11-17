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

        naechster.ausgabe();
    }

    public int sitzplaetze()
    {
        return naechster.sitzplaetze();
    }

    public int gesamtladung()
    {
        return naechster.gesamtladung();
    }
}