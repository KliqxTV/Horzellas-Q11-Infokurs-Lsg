public class Knoten extends Baumelement
{
    private Baumelement linkerNachfolger;
    private Baumelement rechterNachfolger;
    private Datenelement daten;

    public Knoten(Datenelement dNeu)
    {
        daten = dNeu;
    }

    public Datenelement suchen(String suchSchluessel)
    {
        if (daten.schluesselIstGleich(suchSchluessel))
        {
            return daten;
        }
        else if (daten.schluesselIstGroesserAls(suchSchluessel))
        {
            if (linkerNachfolger != null)
            {
                return linkerNachfolger.suchen(suchSchluessel);
            }
        }
        else if (daten.schluesselIstKleinerAls(suchSchluessel))
        {
            if (rechterNachfolger != null)
            {
                return rechterNachfolger.suchen(suchSchluessel);
            }
        }

        // Jeder vorherige Pfad würde entweder den Call mit einem 'daten'-Element beantworten oder an ein anderes Element weitergeben, also kann das gesuchte Element nicht vorhanden sein.
        return null;
    }

    public boolean istVorhanden(String suchSchluessel)
    {
        if (daten.schluesselIstGleich(suchSchluessel))
        {
            return true;
        }
        else if (daten.schluesselIstGroesserAls(suchSchluessel))
        {
            if (linkerNachfolger != null)
            {
                return linkerNachfolger.istVorhanden(suchSchluessel);
            }
        }
        else if (daten.schluesselIstKleinerAls(suchSchluessel))
        {
            if (rechterNachfolger != null)
            {
                return rechterNachfolger.istVorhanden(suchSchluessel);
            }
        }
        
        // Jeder vorherige Pfad würde entweder den Call mit 'true' beantworten oder an ein anderes Element weitergeben, also kann das gesuchte Element nicht vorhanden sein.
        return false;
    }

    public Baumelement einfuegen(Datenelement dNeu)
    {
        Woerterbucheintrag orig = (Woerterbucheintrag)daten;
        Woerterbucheintrag comp = (Woerterbucheintrag)dNeu;

        if (daten.istGleich(dNeu) || orig.SchluesselAlsStringGeben() == comp.SchluesselAlsStringGeben())
        {
            System.out.println("Eintrag bereits vorhanden!");
        }
        else if (daten.istGroesserAls(dNeu))
        {
            if (linkerNachfolger != null)
            {
                return linkerNachfolger.einfuegen(dNeu);
            }
            else
            {
                Knoten kNeu = new Knoten(dNeu);
                linkerNachfolger = kNeu;
                return kNeu;
            }
        }
        else if (daten.istKleinerAls(dNeu))
        {
            // Implizierter letzter Fall. Sollte immer eintreten wenn die vorherigen beiden nicht 'true' waren.
            if (rechterNachfolger != null)
            {
                return rechterNachfolger.einfuegen(dNeu);
            }
            else
            {
                Knoten kNeu = new Knoten(dNeu);
                rechterNachfolger = kNeu;
                return kNeu;
            }
        }
        
        // Jeder vorherige Pfad würde entweder den Call mit einem Knoten-Element beantworten
        // oder an ein anderes Element weitergeben, also kann dieser Fall *eigentlich* nicht eintreten.
        return null;
    }
    
    public void inOrderAusgabe()
    {
        Woerterbucheintrag dieseDaten = (Woerterbucheintrag)this.daten;
        
        // Weiter links gehen wenn möglich
        if (linkerNachfolger != null)
        {
            linkerNachfolger.inOrderAusgabe();
        }

        // Linksgehen war nicht möglich, jetzt Wurzeldaten ausgeben
        System.out.println("Wort: '"
            + dieseDaten.getWort()
            + "', Bedeutung(en): "
            + dieseDaten.getBedeutung());

        // Wurzeldaten ausgegeben, jetzt eins nach rechts gehen und weitermachen, wenn möglich
        if (rechterNachfolger != null)
        {
            rechterNachfolger.inOrderAusgabe();
        }
    }
    
    public void preOrderAusgabe()
    {
        Woerterbucheintrag dieseDaten = (Woerterbucheintrag)this.daten;
        
        // Zuerst Wurzeldaten ausgeben
        System.out.println("Wort: '"
            + dieseDaten.getWort()
            + "', Bedeutung(en): "
            + dieseDaten.getBedeutung());
        
        // Weiter links gehen wenn möglich
        if (linkerNachfolger != null)
        {
            linkerNachfolger.preOrderAusgabe();
        }

        // Eins nach rechts gehen und weitermachen, wenn möglich
        if (rechterNachfolger != null)
        {
            rechterNachfolger.preOrderAusgabe();
        }
    }
    
    public void postOrderAusgabe()
    {
        Woerterbucheintrag dieseDaten = (Woerterbucheintrag)this.daten;
        
        // Weiter links gehen wenn möglich
        if (linkerNachfolger != null)
        {
            linkerNachfolger.postOrderAusgabe();
        }

        // Linksgehen war nicht möglich, jetzt eins nach rechts gehen
        if (rechterNachfolger != null)
        {
            rechterNachfolger.postOrderAusgabe();
        }
        
        // Zuletzt Wurzeldaten ausgeben
        System.out.println("Wort: '"
            + dieseDaten.getWort()
            + "', Bedeutung(en): "
            + dieseDaten.getBedeutung());
    }

    public Datenelement getDaten()
    {
        return daten;
    }

    public void setDaten(Datenelement dNeu)
    {
        daten = dNeu;
    }
}