public class Woerterbuch
{
    private Binbaum woerterbuch;

    public Woerterbuch() {
        woerterbuch = new Binbaum();

        einfuegen("clip", "Klammer, abschneiden, anstecken");
        einfuegen("car", "Auto, Fahrzeug, Waggon");
        einfuegen("cat", "Katze");
        einfuegen("care", "Fuersorge, Sorgfalt");
        einfuegen("cave", "Hoehle, aushöhlen, einbrechen");
        einfuegen("crab", "Krabbe, Krebs, Griesgram");
        einfuegen("coin", "Muenze, ausprägen, erfinden");
    }

    public void einfuegen(String wort, String bedeutung)
    {
        Woerterbucheintrag neuerWoerterbucheintrag;
        neuerWoerterbucheintrag = new Woerterbucheintrag(wort, bedeutung);
        woerterbuch.einfuegen(neuerWoerterbucheintrag);
    }

    public Datenelement suchen(String gesuchtesWort)
    {
        Datenelement result = woerterbuch.suchen(gesuchtesWort);

        if (result == null)
        {
            System.out.println("Die Suche nach '"
                + gesuchtesWort
                + "' ist fehlgeschlagen. Vermutlich existiert der Eintrag nicht.");
        }
        else
        {
            System.out.println("Die Suche nach "
                + gesuchtesWort
                + " war erfolgreich.");
        }

        return result;
    }

    public void bedeutungSetzen(String gesuchtesWort, String bedeutungNeu)
    {
        Woerterbucheintrag woerterbucheintrag = (Woerterbucheintrag)suchen(gesuchtesWort);

        if (woerterbucheintrag == null)
        {
            System.out.println("Eintrag existiert nicht!");
        }
        else
        {
            woerterbucheintrag.setBedeutung(bedeutungNeu);
        }        
    }
    
    public void inOrderAusgabe()
    {
        woerterbuch.inOrderAusgabe();
    }
    
    public void preOrderAusgabe()
    {
        woerterbuch.preOrderAusgabe();
    }
    
    public void postOrderAusgabe()
    {
        woerterbuch.postOrderAusgabe();
    }
}