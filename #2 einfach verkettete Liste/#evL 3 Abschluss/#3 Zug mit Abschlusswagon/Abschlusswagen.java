public class Abschlusswagen extends Zugteil
{
    public Abschlusswagen(int laenge, int leergewicht)
    {
        this.laenge = laenge;
        this.leergewicht = leergewicht;
    }

    public void ausgabe()
    {
        System.out.println("Abschlusswagen | Länge: "
            + laenge
            + ", Leergewicht: "
            + leergewicht);
    }

    public int sitzplaetze()
    {
        return 0;
    }

    public int gesamtladung()
    {
        return 0;
    }
}