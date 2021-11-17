import java.lang.String.*;

public class Woerterbucheintrag implements Datenelement
{
    private String wort; 
    private String bedeutung;

    public Woerterbucheintrag(String wortNeu, String bedeutungNeu)
    {
        wort = wortNeu;
        bedeutung = bedeutungNeu;
    }

    public void informationAusgeben()
    {
        System.out.println(wort
            + ": "
            + bedeutung);
    }

    public boolean istKleinerAls(Datenelement dVergleich)
    {
        Woerterbucheintrag vergleichsWbe;
        vergleichsWbe = (Woerterbucheintrag)dVergleich;

        if (wort.compareTo(vergleichsWbe.getWort()) < 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean istGroesserAls(Datenelement dVergleich)
    {
        Woerterbucheintrag vergleichsWbe;
        vergleichsWbe = (Woerterbucheintrag) dVergleich;

        if (wort.compareTo(vergleichsWbe.getWort()) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean istGleich(Datenelement dVergleich)
    {
        Woerterbucheintrag vergleichsWbe;
        vergleichsWbe = (Woerterbucheintrag) dVergleich;

        if (wort.compareTo(vergleichsWbe.getWort()) == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean schluesselIstGleich(String vergleichsSchluessel)
    {
        return (wort == vergleichsSchluessel);
    }

    public boolean schluesselIstGroesserAls(String vergleichsSchluessel)
    {
        if (wort.compareTo(vergleichsSchluessel) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean schluesselIstKleinerAls(String vergleichsSchluessel)
    {
        if (wort.compareTo(vergleichsSchluessel) < 0)
        {
            return true;
        }
        else
        {
            return false;
        }         
    }

    public String SchluesselAlsStringGeben()
    {
        return wort;
    }

    public String getWort()
    {
        return wort;
    }

    public String getBedeutung()
    {
        return bedeutung;
    }

    public void setBedeutung(String bedeutungNeu)
    {
        bedeutung = bedeutungNeu;
    }
}