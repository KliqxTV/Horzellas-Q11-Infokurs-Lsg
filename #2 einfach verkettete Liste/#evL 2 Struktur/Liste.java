public class Liste
{
    Knoten anfang;

    public Liste()
    {
        anfang = null;
    }

    public void vorneEinfuegen(Patient pNeu)
    {
        Knoten kNeu;
        kNeu = new Knoten(pNeu, anfang);
        anfang = kNeu;
    }

    public void hintenEinfuegen(Patient pNeu)
    {
        if (anfang == null)
        {
            vorneEinfuegen(pNeu);
        }
        else
        {
            anfang.hintenEinfuegen(pNeu);  
        }
    }

    public void einfuegenVor(Patient pNeu, Patient pVergleich)
    {
        if (anfang == null)
        {
            vorneEinfuegen(pNeu);
        }
        else
        {
            anfang = anfang.einfuegenVor(pNeu, pVergleich);
        }
    }

    public void sortiertEinfuegen(Patient pNeu)
    {
        if (anfang == null)
        {
            vorneEinfuegen(pNeu);
        }
        else
        {
            anfang = anfang.sortiertEinfuegen(pNeu);
        }
    }

    public void knotenEntfernen(Patient pVergleich)
    {
        if (anfang != null)
        {
            anfang = anfang.knotenEntfernen(pVergleich);
        }
    }

    public Patient anfangEntfernen()
    {
        if (anfang != null)
        {
            Knoten k = anfang;
            anfang = anfang.nachfolgerGeben();
            return k.inhaltGeben();
        }
        else
        {
            return null;
        }
    }

    public Patient endeEntfernen()
    {
        if (anfang != null)
        {
            Patient p;
            p = anfang.endeGeben(); 
            anfang = anfang.endeEntfernen();
            return p;
        }
        else
        {
            return null;
        }
    }

    public Patient suchen(String vergleichswert)
    {
        if (anfang == null)
        {
            return null;
        }
        else
        {
            return anfang.suchen(vergleichswert);
        }
    }

    public int laengeGeben()
    {
        if (anfang == null)
        {
            return 0;
        }
        else
        {
            return anfang.restlaengeGeben();
        }
    }

    void alleInformationenAusgeben()
    {
        if (anfang == null)
        {
            System.out.println("Die Liste ist leer.");
        }
        else{
            anfang.informationAusgeben();
        }   
    }
}