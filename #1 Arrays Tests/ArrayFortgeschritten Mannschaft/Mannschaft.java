public class Mannschaft
{
    int anzahl;
    Spieler[] fussballer = new Spieler[20];

    public Mannschaft()
    {
        start();
        beispielausgabe();
    }

    public void start()
    {
        fussballer[0] = new Spieler("Neuer", 30, "Torwart", 100000, "FCB");
        fussballer[1] = new Spieler("Hummels", 27, "Abwehr", 90000, "FCB");

        //Extraspieler sodass die Sort-Methode auch was zu tun hat...
        fussballer[2] = new Spieler("Jespersen", 27, "Abwehr", 90000, "FCB");
        fussballer[3] = new Spieler("Rumer", 29, "Verteidigung", 120000, "FCB");
        fussballer[4] = new Spieler("Merzdorf", 32, "Verteidigung", 120000, "FCB");
        fussballer[5] = new Spieler("Vinson", 24, "Mittelfeld", 150000, "FCB");
        fussballer[6] = new Spieler("Harvey", 36, "Mittelfeld", 160000, "FCB");

        anzahl = 7;
    }

    public void beispielausgabe()
    {
        for (int i = 0; i < anzahl; i++)
        {
            System.out.println("[" + i + "] " + fussballer[i].name + ", " + fussballer[i].position);
        }
    }

    public void ausfuehrlicheAusgabe()
    {
        for (int i = 0; i < anzahl; i++)
        {
            System.out.println("[" + i + "] " + fussballer[i].name + ", " + fussballer[i].alter + ", " + fussballer[i].position + ", " + fussballer[i].gehalt + ", " + fussballer[i].verein);
        }
    }

    public void nameZuRueckenummer(int nr)
    {
        if (fussballer[nr].name != ""  || fussballer[nr].name == null)
        {
            System.out.println("Rückennummer " + nr + " gehört " + fussballer[nr].name + ".");
        }
        else
        {
            System.out.println("Rückennummer " + nr + " nicht gefunden.");
        }
    }

    public void umbenennen(int nr, String nameNeu)
    {
        if (fussballer[nr].name != "" || fussballer[nr].name == null)
        {
            fussballer[nr].name = nameNeu;            
            System.out.println("Rückennummer " + nr + " gehört  jetzt " + fussballer[nr].name + ".");
        }
        else
        {
            System.out.println("Rückennummer " + nr + " nicht gefunden.");
        }

        System.out.println("Neue Zusammensetzung:");
        beispielausgabe();
    }

    public void gibtsDen(String suchName)
    {
        boolean gefunden = false;

        for (int i = 0; i < fussballer.length; i++)
        {
            if (fussballer[i].name == suchName)
            {
                System.out.println(suchName + " hat Rückennummer " + i + ".");
                gefunden = true;
                break;
            }
        }

        if (gefunden == false)
        {
            System.out.println("\"" + suchName + "\" in folgender Zusammensetzung nicht gefunden:");
            beispielausgabe();
        }
    }

    public void hintenAnfuegen(String neuName, int neuAlter, String neuPosition, double neuGehalt, String neuVerein)
    {
        fussballer[anzahl] = new Spieler(neuName, neuAlter, neuPosition, neuGehalt, neuVerein);
        anzahl++;

        System.out.println(neuName + " wurde eingefügt. Neue Zusammensetzung:");
        beispielausgabe();
    }

    public void loeschen(int nr)
    {
        System.out.println(fussballer[nr].name + " wurde gelöscht. Neue Zusammensetzung:");

        try
        {    
            for (int i = nr; i < anzahl; i++)
            {
                fussballer[i] = fussballer[i];
            }
        }
        catch (Exception ex)
        {
            // Ende des Arrays bzw. letztes nicht-null Element erreicht
        }

        anzahl--;
        fussballer[anzahl] = null;

        beispielausgabe();
    }

    public void rueckennummernTauschen(int nrVon, int nrZu, boolean output)
    {
        //nrZu frei machen und vorherige Werte zwischenspeichern
        fussballer[anzahl] = new Spieler(fussballer[nrZu].name, fussballer[nrZu].alter, fussballer[nrZu].position, fussballer[nrZu].gehalt, fussballer[nrZu].verein);
        anzahl++;

        //Alte Referenzen zu nrZu löschen
        fussballer[nrZu] = null;

        //Werte von nrVon übernehmen und alte Referenzen zu nrVon löschen
        fussballer[nrZu] = new Spieler(fussballer[nrVon].name, fussballer[nrVon].alter, fussballer[nrVon].position, fussballer[nrVon].gehalt, fussballer[nrVon].verein);
        fussballer[nrVon] = null;

        //Mit den zwischengespeicherten Werten nrZu auf dem alten Platz von nrVon wiederherstellen
        fussballer[nrVon] = new Spieler(fussballer[anzahl - 1].name, fussballer[anzahl - 1].alter, fussballer[anzahl - 1].position, fussballer[anzahl - 1].gehalt, fussballer[anzahl - 1].verein);

        //Alte Referenzen zu den zwischengespeicherten Werten löschen
        fussballer[anzahl - 1] = null;
        anzahl--;

        //Ausgabe
        if (output == true)
        {
            System.out.println("Rückennummer " + nrZu + " hat mit " + nrVon + " getauscht. Neue Zusammensetzung:");
            beispielausgabe();
        }
    }

    public void sortiereNachGehalt()
    {
        //Hinweis: Diese Methode achtet wirklich NUR auf das Gehalt. Sollten diese Werte gleich sein, wird kein Tausch durchgeführt.
        
        boolean getauscht = true;
        Spieler[] sortErgebnis = fussballer;

        int n = anzahl;

        while (getauscht == true)
        {
            getauscht = false;

            for (int i = 1; i <= n - 1; i++)
            {
                if (sortErgebnis[i - 1].gehalt > sortErgebnis[i].gehalt)
                {
                    rueckennummernTauschen(i - 1, i, false);
                    getauscht = true;
                }
            }
        }

        fussballer = sortErgebnis;
        ausfuehrlicheAusgabe();
    }
}