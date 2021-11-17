public class Patient
{
    String name;
    String kraka;
    int alter;
    Patient naechster;

    public Patient(String uename, String uekraka, int uealter)
    {
        name = uename;
        kraka = uekraka;
        alter = uealter;
    }

    public void ausgabe()
    {
        System.out.println(name + ", " + kraka + ", " + alter);

        if (naechster != null)
        {
            naechster.ausgabe();
        }
    }

    public int anzahl()
    {
        if (naechster == null) 
        {
            return 1;
        }
        else
        {
            return 1 + naechster.anzahl();
        }
    }

    public int anzahlPrivat()
    {
        if (naechster == null)
        {
            if (kraka == "Privat")
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            if (kraka == "Privat")
            {
                return 1 + naechster.anzahlPrivat();
            }
            else
            {
                return naechster.anzahlPrivat();
            }
        }
    }

    public int gibts(String such)
    {
        if (naechster == null)
        {
            if (name == such)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            if (name == such)
            {
                return 1 + naechster.anzahlPrivat();
            }
            else
            {
                return naechster.anzahlPrivat();
            }
        }
    }

    public void hintenanfuegen(Patient p)
    {
        if (naechster == null)
        {
            naechster = p;
        }
        else
        {
            naechster.hintenanfuegen(p);
        }
    }

    public int gesamtalter()
    {
        if (naechster == null) 
        {
            return alter;
        }
        else
        {
            return alter + naechster.gesamtalter();
        }
    }

    public String letztenAusgeben()
    {
        if (naechster == null)
        {
            return name;
        }
        else
        {
            return naechster.letztenAusgeben();
        }
    }

    public void loeschen(String n)
    {
        if (naechster != null)
        {
            if (naechster.name != n)
            {
                naechster.loeschen(n);
            }
            else
            {
                naechster = naechster.naechster;
            }
        }
    }

    public Patient einfuegen(Patient p, String derNaechste)
    {
        if (naechster != null)
        {
            if (name == derNaechste)
            {
                p.naechster = erster;

                erster = p;
            }
            else if (naechster.name == derNaechste)
            {
                p.naechster = naechster;

                naechster = p;
            }
            else
            {
                if (naechster.naechster.name != derNaechste)
                {
                    naechster.einfuegen(p, derNaechste);
                }
                else
                {
                    p.naechster = naechster.naechster;
                    naechster.naechster = p;
                }
            }
        }
        else
        {
            hintenanfuegen(p);
        }
        
        return erster;
    }
}