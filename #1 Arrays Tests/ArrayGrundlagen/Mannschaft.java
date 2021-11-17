public class Mannschaft
{
    int anzahl = 0;
    String[] name = new String[20];

    public Mannschaft()
    {
        start(); 
    }

    public void start()
    { 
        name[0] = "Jespersen";
        name[1] = "Rumer";
        name[2] = "Merzdorf";
        name[3] = "Vinson";
        name[4] = "Harvey";
        name[5] = "Haerdle";
        name[6] = "Ahmed";
        name[7] = "Hotchkiss";
        name[8] = "Gostin";
        name[9] = "Braddock";
        name[10] = "Sterne";
        name[11] = "Scott";
        name[12] = "Luther";
        name[13] = "Howerton";
        name[14] = "Howe";
        name[15] = "Raferty";
        name[16] = "Hardy";
        name[17] = "Carson";

        anzahl = 18;
    }

    public void ausgabe()
    { 
        for (int i = 0; i < anzahl; i++) 
        {
            System.out.println(name[i]);
        }
    }

    public void nameZuRueckenummer(int nr)
    {
        if (name[nr] != "" && name[nr] != null)
        {
            System.out.println("Rückennummer " + nr + " gehört " + name[nr] + ".");
        }
        else
        {
            System.out.println("Rückennummer " + nr + " nicht gefunden.");
        }
    }

    public void umbenennen(int nr, String nameNeu)
    {
        if (name[nr] == null)
        {
            name[nr] = nameNeu;            
            System.out.println("Rückennummer " + nr + " gehört  jetzt " + name[nr] + ".");
        }
        else
        {
            System.out.println("Rückennummer " + nr + " nicht gefunden.");
        }

        System.out.println("Neue Zusammensetzung:");
        ausgabe();
    }

    public void gibtsDen(String suchName)
    {
        boolean gefunden = false;

        for (int i = 0; i < name.length; i++)
        {
            if (name[i] == suchName)
            {
                System.out.println(suchName + " hat Rückennummer " + i + ".");
                gefunden = true;
                break;
            }
        }

        if (gefunden == false)
        {
            System.out.println("\"" + suchName + "\" in folgender Zusammensetzung nicht gefunden:");
            ausgabe();
        }
    }

    public void hintenAnfuegen(String neuName)
    {
        int neueRueckennummer = 0;
        
        anzahl++;

        for (int i = 0; i < name.length; i++)
        {
            if (name[i] == "" || name[i] == null)
            {
                name[i] = neuName;
                neueRueckennummer = i;
                break;
            }
        }

        System.out.println(neuName + " wurde eingefügt. Rückennummer: " + neueRueckennummer + ". Neue Zusammensetzung:");
        ausgabe();
    }

    public void loeschen(int nr)
    {
        System.out.println(name[nr] + " wurde gelöscht. Neue Zusammensetzung:");

        anzahl--;
        
        try
        {    
            for (int i = nr; i < name.length; i++)
            {
                name[i] = name[i + 1];
            }
        }
        catch (Exception ex)
        {
            // Ende des Arrays erreicht
        }

        ausgabe();
    }
}