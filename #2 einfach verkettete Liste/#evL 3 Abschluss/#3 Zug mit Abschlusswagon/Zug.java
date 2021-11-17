public class Zug
{
    public Zugteil erster;

    public Zug()
    {
        Zugteil z1 = new Lok(20, 30, 2000);
        Zugteil z2 = new Gueterwagen(20, 10, 20, "Sand");
        Zugteil z3 = new Personenwagen(22, 10, 50);
        Zugteil z4 = new Personenwagen(22, 10, 50);
        Zugteil z5 = new Personenwagen(30, 25, 70);
        Zugteil z6 = new Gueterwagen(18, 8, 30, "Kohle");
        Zugteil z7 = new Abschlusswagen(3, 2);

        erster = z1;
        z1.naechster = z2;
        z2.naechster = z3;
        z3.naechster = z4;
        z4.naechster = z5;
        z5.naechster = z6;
        z6.naechster = z7;

        ausgabe();
    }

    public void ausgabe()
    {
        erster.ausgabe();
    }

    public void leergewicht()
    {
        System.out.println("Der gesamte Zug hat ein Leergewicht von "
            + erster.leergewicht()
            + ".");
    }
    
    public void sitzplaetze()
    {
        System.out.println("Der Zug hat insgesamt "
            + erster.sitzplaetze()
            + " Plätze.");
    }
    
    public void gesamtladung()
    {
        System.out.println("Die Gesamtladung des Zugs ist "
            + erster.gesamtladung()
            + "t.");
    }
}