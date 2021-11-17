public class Hund extends Tier
{
    int gewicht;

    public Hund(String uename, int uealter, int uegewicht) {
        name = uename;
        alter = uealter;
        gewicht = uegewicht;
    }

    public void lautgeben() {
        System.out.println(name+" macht wau wau wau!");
        if (naechster != null) naechster.lautgeben();    
    }

    public void pflegen() {
        System.out.println(name+" will Gassi gehen.");
        if (naechster != null) naechster.pflegen();    
    }

    public void magfutter()
    {
        System.out.println(name + " mag Knochen.");

        if (naechster != null)
        {
            naechster.magfutter();
        }
    }

    @Override
    public void ausgabe()
    {
        System.out.println(name + ", " + alter + ", Gewicht: " + gewicht);

        if (naechster != null)
        {
            naechster.ausgabe();
        }
    }
}
