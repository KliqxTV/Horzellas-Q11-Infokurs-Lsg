public class Knoten
{
    private Knoten nachfolger;
    private Patient inhalt;

    public Knoten(Patient p, Knoten k)
    {
        inhalt = p;
        nachfolger = k;
    }

    public void hintenEinfuegen(Patient pNeu)
    {
        if(nachfolger == null)
        {
            Knoten kneu;
            kneu = new Knoten(pNeu, null);
            nachfolger = kneu;
        }
        else
        {
            nachfolger.hintenEinfuegen(pNeu);
        }
    }

    public Knoten einfuegenVor(Patient pNeu, Patient pVergleich)
    {
        if (this.inhalt == pVergleich)
        {
            // Wenn this gesuchter Knoten ist
            // Erstelle Knoten, setze jetzigen als Nachfolger vom neuen
            Knoten neuKnoten;
            neuKnoten = new Knoten(pNeu, this);
            return neuKnoten;
        }
        else
        {
            if (nachfolger == null)
            {
                // Sonst, wenn dieser Knoten keinen Nachfolger hat
                hintenEinfuegen(pNeu);
            }
            else
            {
                // Sonst, wenn dieser Knoten einen Nachfolger hat
                nachfolger = nachfolger.einfuegenVor(pNeu, pVergleich);
            }

            // Dann gib diesen Knoten aus
            return this;
        }
    }

    public Knoten sortiertEinfuegen(Patient pNeu)
    {
        if (inhalt.istKleinerAls(pNeu))
        {
            // Wenn Name des Patienten vorher im Alphabet kommt als der des neuen
            if (nachfolger == null)
            {
                // Wenn es keinen Nachfolger gibt, ans Ende anfügen
                hintenEinfuegen(pNeu);
            }
            else
            {
                // Sonst nächsten
                nachfolger = nachfolger.sortiertEinfuegen(pNeu);
            }
            
            // Dann diesen Knoten ausgeben
            return this;
        }
        else
        {
            // Sonst hier den Knoten einfügen
            Knoten neuKnoten;
            neuKnoten = new Knoten(pNeu, this);
            return neuKnoten;
        }
    }    

    public Knoten knotenEntfernen(Patient pVergleich)
    {
        if (inhalt == pVergleich)
        {
            return nachfolger;
        }
        else
        {
            if (nachfolger == null)
            {
                return null;
            }
            else
            {
                nachfolger = nachfolger.knotenEntfernen(pVergleich);
                return this;
            }
        }
    }

    public Patient endeGeben()
    {
        if (nachfolger == null)
        {
            return inhalt;
        }
        else
        {
            return nachfolger.endeGeben();
        }
    }

    public Knoten endeEntfernen()
    {
        if (nachfolger == null)
        {
            return null;
        }
        else
        {
            nachfolger = nachfolger.endeEntfernen();
            return this;
        }
    }

    public Patient inhaltGeben()
    {
        return inhalt;
    }

    public Knoten nachfolgerGeben()
    {
        return nachfolger;
    }

    public Patient suchen(String vergleichswert)
    {
        if (inhaltGeben().nameGeben() == vergleichswert)
        {
            return inhaltGeben();
        }
        else if (nachfolger != null)
        {
            return nachfolgerGeben().suchen(vergleichswert);
        }
        else
        {
            return null;
        }
    }

    public void informationAusgeben()
    {
        inhalt.informationAusgeben();

        if (nachfolger != null)
        {
            nachfolger.informationAusgeben();
        }
    }

    public int restlaengeGeben()
    {
        if (nachfolger == null)
        {
            return 1;
        }
        else
        {
            return nachfolger.restlaengeGeben() + 1;
        }
    }
}
