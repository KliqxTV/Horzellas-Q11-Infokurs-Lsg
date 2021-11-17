import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.*;

public class Routenplaner
{
    // Erstelle eine eindimensionale List<Ort>, um die Orte zu speichern
    List<Ort> orte = new ArrayList<Ort>();
    // Erstelle eine zweidimensionale List<List<Integer>>, um den Graphen zu speichern
    List<List<Integer>> graph = new ArrayList<List<Integer>>();
    // Erstelle eine zweidimensionale List<List<Boolean>>, um die Straßensperren zu speichern
    List<List<Boolean>> graphStraßensperren = new ArrayList<List<Boolean>>();

    public Routenplaner()
    {
        // Füge erste Orte ein
        // Von den Wikipedia-Seiten der Orte; Stand egal, also kann gut sein, dass hier 15 Jahre alte Werte stehen
        orte.add(new Ort("Nördlingen",      20546));
        orte.add(new Ort("Reimlingen",      1306));
        orte.add(new Ort("Möttingen",       2605));
        orte.add(new Ort("Balgheim",        1244));
        orte.add(new Ort("Alerheim",        1666));
        orte.add(new Ort("Deiningen",       1814));
        orte.add(new Ort("Löpsingen",       1069));
        orte.add(new Ort("Wallerstein",     3390));
        orte.add(new Ort("Marktoffingen",   1311));
        orte.add(new Ort("Maihingen",       1212));
        orte.add(new Ort("Wechingen",       1432));
        orte.add(new Ort("Pfäfflingen",     506));
        orte.add(new Ort("Wemding",         5828));

        // Für jeden Ort, erstelle einen "Knoten" im "normalen" Graphen und in dem der Straßensperren
        for (int i = 0; i < orte.size(); i++)
        {
            graph.add(new ArrayList<Integer>());
            graphStraßensperren.add(new ArrayList<Boolean>());
            for (int j = 0; j < orte.size(); j++)
            {
                graph.get(i).add(0);
                graphStraßensperren.get(i).add(false);
            }
        }

        // Füge die Kanten für die bereits vorhandenen Knoten ein
        kanteSetzen(orte.get(0), orte.get(1), 6, true);
        kanteSetzen(orte.get(0), orte.get(2), 9, true);
        kanteSetzen(orte.get(0), orte.get(5), 7, true);
        kanteSetzen(orte.get(0), orte.get(6), 6, true);
        kanteSetzen(orte.get(0), orte.get(7), 6, true);

        kanteSetzen(orte.get(1), orte.get(2), 7, true);
        kanteSetzen(orte.get(1), orte.get(3), 3, true);

        kanteSetzen(orte.get(2), orte.get(4), 7, true);

        kanteSetzen(orte.get(4), orte.get(5), 4, true);
        kanteSetzen(orte.get(4), orte.get(10), 5, true);
        kanteSetzen(orte.get(4), orte.get(12), 9, true);

        kanteSetzen(orte.get(5), orte.get(6), 4, true);
        kanteSetzen(orte.get(5), orte.get(11), 4, true);
        kanteSetzen(orte.get(5), orte.get(12), 12, true);

        kanteSetzen(orte.get(6), orte.get(11), 3, true);

        kanteSetzen(orte.get(7), orte.get(8), 5, true);
        kanteSetzen(orte.get(7), orte.get(9), 6, true);

        kanteSetzen(orte.get(8), orte.get(9), 3, true);

        kanteSetzen(orte.get(9), orte.get(11), 6, true);

        kanteSetzen(orte.get(10), orte.get(11), 5, true);
    }

    public List<Ort> getOrte()
    {
        // Eine Kopie der Orte als List<Ort> zurückgeben (benötigt in Main.java)
        return orte;
    }

    public String nameZuNummer(int ortsnr)
    {
        // Zur gegebenen Zahl ortsnr den Namen zurückgeben
        return orte.get(ortsnr).getOrtsname();
    }

    public int nummerZuName(String ortsname)
    {
        // Alle Orte durchgehen
        for (int i = 0; i < orte.size(); i++)
        {
            // Wenn der gesuchte Ort Ortsname mit dem jetzigen Ortsnamen übereinstimmt, gib die Zahl zurück
            if (orte.get(i).getOrtsname() == ortsname)
            {
                return i;
            }
        }

        // Den gesuchten Ort gibt es nicht
        return -1;
    }

    public void alleOrteAusgeben()
    {
        // Alle Orte durchgehen und mit allen Daten ausgeben
        for (int i = 0; i < orte.size(); i++)
        {
            System.out.println("["
                + i
                + "]\t"
                + orte.get(i).getOrtsname()
                + "\t"
                + (orte.get(i).getOrtsname().length() < 8 ? "\t" : "")
                + orte.get(i).getEinwohnerzahl());
        }
    }

    private void kanteSetzen(Ort von, Ort bis, int km, boolean beideRichtungen)
    {
        // Finde die Nummer für den Graph / die Matrix aus dem Ort-Objekt
        int vonN = nummerZuName(von.getOrtsname());
        int bisN = nummerZuName(bis.getOrtsname());

        // Setze die Kantenlänge / "Gewichtung" und löse Straßensperren auf
        graph.get(vonN).set(bisN, km);
        graphStraßensperren.get(vonN).set(bisN, false);
        graphStraßensperren.get(bisN).set(vonN, false);

        // Wenn beideRichtungen als true übergeben wird, gilt diese Länge beidseitig
        if (beideRichtungen)
        {
            graph.get(bisN).set(vonN, km);
        }
    }

    public void graphStraßensperrenAusgeben()
    {
        // Alle Straßensperren durchgehen und als Matrix ausgeben
        // Enthält "Styling" mit Tabs, sodass es halbwegs gut aussieht
        System.out.print("\t");
        for (int i = 0; i < graphStraßensperren.size(); i++)
        {
            System.out.print("["
            + i
            + "]\t");
        }
        System.out.print("\n");
        
        for (int i = 0; i < graphStraßensperren.size(); i++)
        {
            System.out.print("["
            + i
            + "]\t");
            
            for (int j = 0; j < graphStraßensperren.size(); j++)
            {
                System.out.print((graphStraßensperren.get(j).get(i) ? "SPERRE" : "\t"));
                
                if (j == graphStraßensperren.size() - 1)
                {
                    System.out.print("\n");
                }
            }
        }
    }
    
    public void graphAusgeben()
    {
        // Alle Straßenverbindungen durchgehen und als Matrix ausgeben
        // Enthält "Styling" mit Tabs, sodass es halbwegs gut aussieht
        System.out.print("\t");
        for (int i = 0; i < graph.size(); i++)
        {
            System.out.print("["
                + i
                + "]\t");
        }
        System.out.print("\n");

        for (int i = 0; i < graph.size(); i++)
        {
            System.out.print("["
                + i
                + "]\t");

            for (int j = 0; j < graph.size(); j++)
            {
                if (graphStraßensperren.get(j).get(i))
                {
                    System.out.print("SPERRE\t");
                }
                else
                {
                    System.out.print((graph.get(j).get(i) > 0 ? graph.get(j).get(i) + "\t" : "\t"));
                }

                if (j == graph.size() - 1)
                {
                    System.out.print("\n");
                }
            }
        }
    }

    private List<Integer> alleNachbarn(int von)
    {
        // Verweis auf alleNachbarn(String von)
        return alleNachbarn(nameZuNummer(von));
    }

    private List<Integer> alleNachbarn(String von)
    {
        // Erstelle eine List<Integer> nachbarn
        List<Integer> nachbarn = new ArrayList<Integer>();

        // Finde die Zahl für den gesuchten Ort
        int v = nummerZuName(von);

        // Falls es den Ort nicht gibt, leere Liste zurückgeben
        if (v == -1)
        {
            return new ArrayList<Integer>();
        }

        // Alle Orte durchgehen
        for (int i = 0; i < graph.size(); i++)
        {
            // Wenn es eine Verbindung gibt, füge diesen Nachbarknoten in nachbarn ein
            if (graph.get(v).get(i) > 0)
            {
                nachbarn.add(i);
            }
        }

        // nachbarn zurückgeben
        return nachbarn;
    }

    public void pfadZwischen(int start, int ziel)
    {
        // Verweis auf pfadZwischen(String start, String ziel)
        pfadZwischen(nameZuNummer(start), nameZuNummer(ziel));
    }

    private void pfadZwischen(String start, String ziel)
    {
        // Wenn Start- und Zielort gleich sind, abbrechen
        if (start == ziel)
        {
            System.out.println();
            System.err.println("Start- und Zielort sind gleich.");
            return;
        }

        // Erstelle die List<Integer>'s abstände und vorgänger
        List<Integer> abstände = new ArrayList<Integer>();
        List<Integer> vorgänger = new ArrayList<Integer>();
        // Erstelle zwei AtomicReference<List<Integer>>'s refAbstände und refVorgänger
        // Was ist das? AtomicReferences kann man anderen Methoden übergeben und mithilfe der Methoden
        // get() und set() jeweils abrufen und bis hoch zum Eltern-Scope (in diesem Fall diese Methode pfadZwischen(...)) ändern
        AtomicReference<List<Integer>> refAbstände = new AtomicReference<List<Integer>>(abstände);
        AtomicReference<List<Integer>> refVorgänger = new AtomicReference<List<Integer>>(vorgänger);

        // Rufe die Methode dijkstra(String start, AtomicReference<List<Integer>> refAbstand, AtomicReference<List<Integer>> refVorgänger)
        // auf und übergib den Startort und die zwei AtomicReferences
        dijkstra(start, refAbstände, refVorgänger);
        // Nachdem in dijkstra(...) die AtomicReferences geändert wurden, rufe die Werte ab und speichere sie in den ursprüunglichen
        // Listen abstände und vorgänger
        abstände = (List<Integer>)refAbstände.get();
        vorgänger = (List<Integer>)refVorgänger.get();

        int weglänge = 0;

        if (abstände.size() == 0 || vorgänger.size() == 0)
        {
            // Wenn eine der List<Integer>'s keine Einträge hat, abbrechen
            // Das sollte absolut nie passieren
            System.out.println();
            return;
        }

        // Rückwärts die List<Integer>'s durchgehen, um vom Zielort zum Startort zu kommen:
        // Setze u gleich der Zahl des Zielorts
        int u = nummerZuName(ziel);
        // Erstelle eine Liste für den Weg
        List<Integer> weg = new ArrayList<Integer>();
        // Setze das jetzige u an den Anfang (macht die Ausgabe der Liste einfacher,
        // dann müssen wir sie nachher nicht selber umdrehen)
        weg.add(0, u);

        // Während der Vorgänger des derzeitigen u nicht -1 ist (siehe Initialisierung der vorgänger-Liste in dijsktra())
        while (vorgänger.get(u) != -1)
        {
            // Setze u gleich dem Vorgänger vom jetzigen u
            u = vorgänger.get(u);
            // Füge diesen Vorgängerknoten an den Anfang der weg-Liste ein
            weg.add(0, u);
        }

        // Gib die weg-Liste mit Ortsdaten und der bisherigen Weglänge aus
        System.out.println("Knotennummer\tOrtsname\tBisherige Länge");
        for (int ort : weg)
        {
            weglänge = abstände.get(ort);
            System.out.println(ort
                + "\t\t"
                + nameZuNummer(ort)
                + (nameZuNummer(ort).length() < 8 ? "\t" : "")
                + "\t"
                + weglänge);
        }

        // Gib zuletzt die Gesamtlänge des Wegs aus
        System.out.println("---> Gesamtlänge: "
            + weglänge);
    }

    private void dijkstra(String start, AtomicReference<List<Integer>> refAbstand, AtomicReference<List<Integer>> refVorgänger)
    {
        // Setze das jetzige u auf "unendlich" (sollte allerdings ein sint32 sein, also ein 32-bit Integer mit Vorzeichen)
        // Dabei bekommt jeweils plus und minus eine Hälfte der (2^32 - 1) möglichen Zahlen:
        // Integer.MAX_VALUE == 0x7FFFFFF == 2,147,483,647 == (2^31 - 1)
        int u = Integer.MAX_VALUE;

        // Erstelle eine List<Integer> mit Orten, die noch durchsucht werden müssen
        List<Integer> Q = new ArrayList<Integer>();
        for (int i = 0; i < orte.size(); i++)
        {
            Q.add(i, i);
        }

        // Erstelle eine List<Integer>, in der die Abstände der Knoten zueinander gespeichert werden,
        // und setze anfangs alle diese Abstände ebenfalls auf Integer.MAX_VALUE
        List<Integer> abstand = new ArrayList<Integer>();
        for (int i = 0; i < orte.size(); i++)
        {
            abstand.add(i, Integer.MAX_VALUE);
        }
        // Der Startort hat einen Abstand von 0
        abstand.set(nummerZuName(start), 0);
        
        // Erstelle eine List<Integer>, in der die Vorgänger der Knoten gespeichert werden,
        // und setze anfangs alle diese Vorgänger auf -1
        List<Integer> vorgänger = new ArrayList<Integer>();
        for (int i = 0; i < orte.size(); i++)
        {
            vorgänger.add(i, -1);
        }

        // Während die List<Integer> Q von Orten, die noch durchsucht werden müssen, nicht leer ist
        while (!Q.isEmpty())
        {
            // Setze u wieder auf Integer.MAX_VALUE
            u = Integer.MAX_VALUE;

            // Finde den kleinsten Abstand in der Liste und setze u gleich diesem Wert
            for (int v : Q)
            {
                if (abstand.get(v) < u)
                {
                    u = v;
                }
            }

            // Entferne den EINTRAG von u aus Q, NICHT den INDEX von u
            // Und ja, das macht einen Unterschied, weil der Eintrag mit dem WERT u entfernt werden muss,
            // NICHT der Eintrag mit dem INDEX u
            Q.remove(Q.lastIndexOf(u));

            // Erstelle eine List<Integer> aller Nachbarn von u
            List<Integer> nachbarn = alleNachbarn(u);
            // Wenn der Knoten keine Nachbarn hat, abbrechen
            if (nachbarn.size() == 0)
            {
                System.out.println();
                System.err.println("Der ausgewählte Startort hat keine Verbindungen zu anderen Orten.");
                return;
            }

            // DIJKSTRA-ALGORITHMUS
            // ********************
            // Gehe alle Nachbarn von u durch
            for (int v : alleNachbarn(u))
            {
                // Wenn der jetzige Nachbar in Q ist (also noch nicht besucht wurde)
                if (Q.contains(v))
                {
                    // Vergleiche, ob der neue Abstand alternativ kleiner ist als der zurzeit gespeicherte
                    int alternativ = abstand.get(u) + graph.get(u).get(v);
                    if (alternativ < abstand.get(v))
                    {
                        // Wenn keine Straßensperre von u zu v besteht
                        if (!graphStraßensperren.get(u).get(v))
                        {
                            // Setze den neuen Abstand von v zu alternativ
                            abstand.set(v, alternativ);
                            // Setze den neuen Vorgänger von v zu u
                            vorgänger.set(v, u);
                        }
                    }
                }
            }
        }

        // Aktualisiere die zwei AtomicReferences
        // Das ist praktisch ein return von zwei List<Integer>'s
        refAbstand.set(abstand);
        refVorgänger.set(vorgänger);
    }

    public void ortHinzufügen(Ort newOrt)
    {
        // Füge den übergebenen Ort in die Liste der Orte ein
        orte.add(newOrt);
        
        // Erstelle für den neuen Ort:
        // Einen Knoten im "normalen" Graph und im Graph der Straßensperren
        graph.add(new ArrayList<Integer>());
        graphStraßensperren.add(new ArrayList<Boolean>());
        // Gehe zum letzten Ort (also dem, den wir gerade zur Liste der Orte hinzugefügt haben)
        for (int i = 0; i < orte.size() - 1; i++)
        {
            // Füge eine Anzahl von (graph.size() - 1) List<Integer>'s ein, um Straßenverbindungen zu ermöglichen
            graph.get(graph.size() - 1).add(0);
            // Füge eine Anzahl von (graphStraßensperren.size() - 1) List<Integer>'s ein, um Straßensperren zu ermöglichen
            graphStraßensperren.get(graphStraßensperren.size() - 1).add(false);
        }

        // Gehe alle Knoten im "normalen" Graph und im Graph der Straßensperren durch und füge einen neuen Knoten für den neuen Ort ein
        for (int i = 0; i < orte.size(); i++)
        {
            graph.get(i).add(0);
            graphStraßensperren.get(i).add(false);
        }
    }

    public void straßenverbindungHinzufügen(int startort, int zielort, int km)
    {
        // Wenn Start- und Zielort gleich sind, abbrechen
        if (startort == zielort)
        {
            System.out.println();
            System.err.println("Start- und Zielort sind gleich.");
            return;
        }
        
        // Setze die Straßenverbindung auf die übergebene Länge km, beidseitig
        kanteSetzen(orte.get(startort), orte.get(zielort), km, true);
    }
    
    public void straßensperreEinrichten(int startort, int zielort, boolean beideRichtungen)
    {
        // Wenn Start- und Zielort gleich sind, abbrechen
        if (startort == zielort)
        {
            System.out.println();
            System.err.println("Start- und Zielort sind gleich.");
            return;
        }
        
        // Setze die Straßensperre vom Start- zum Zielort
        graphStraßensperren.get(startort).set(zielort, true);
        
        // Wenn beideRichtungen als true übergeben wird, gilt die Straßensperre beidseitig
        if (beideRichtungen)
        {
            graphStraßensperren.get(zielort).set(startort, true);
        }
        
        System.out.println();
    }
    
    public void straßensperreAuflösen(int startort, int zielort)
    {
        // Wenn Start- und Zielort gleich sind, abbrechen
        if (startort == zielort)
        {
            System.out.println();
            System.err.println("Start- und Zielort sind gleich.");
            return;
        }

        // Löse die Straßensperre von Start- zu Zielort auf (beidseitig)
        graphStraßensperren.get(startort).set(zielort, false);
        graphStraßensperren.get(zielort).set(startort, false);
    }
}