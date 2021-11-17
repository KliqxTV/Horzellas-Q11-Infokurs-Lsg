import java.util.Scanner;

public class Main
{
    // Erstelle ein Routenplaner- und ein Scanner-Objekt
    static Routenplaner rp = new Routenplaner();
    static Scanner s = new Scanner(System.in);

    // Erstelle Variablen
    static int startort;
    static int zielort;
    static int nextInt;
    static int km;

    public static void main(String[] args)
    {
        // Keine Erklärungen für Menüs, die sind selbsterklärend
        System.out.println();
        System.out.println("Bitte eine Option wählen: ");

        System.out.println("[1] Route berechnen");
        System.out.println("[2] Orte ausgeben");
        System.out.println("[3] Adjazenzmatrix (alle Straßenverbindungen) ausgeben");
        System.out.println("[4] Matrix für eingerichtete Straßensperren ausgeben");
        System.out.println();
        System.out.println("[8] STRAßENSPERRENMENÜ");
        System.out.println("[9] EINGABEOPTIONEN");
        System.out.println();
        System.out.println("[0] Beenden");

        switch (nextInt = s.nextInt())
        {
            case 1:
                routeBerechnen();
                main(null);
                break;
            case 2:
                rp.alleOrteAusgeben();
                main(null);
                break;
            case 3:
                rp.graphAusgeben();
                main(null);
                break;
            case 4:
                rp.graphStraßensperrenAusgeben();
                main(null);
                break;
            case 8:
                straßensperrenVerwalten();
                main(null);
                break;
            case 9:
                eingabeoptionen();
                main(null);
                break;
            case 0:
                quit();
                break;
            default:
                System.err.println("[ERR] Ungültige Eingabe...");
                System.err.println("[ERR] Wollten Sie Beenden? [j]");
                switch (s.next())
                {
                    case "j":
                        quit();
                    default:
                        main(null);
                }
        }
    }

    private static void quit()
    {
        // VSCode beschwert sich über resource leaking,
        // wenn man einen Scanner "offen" lässt, also nicht irgendwann close() aufruft
        s.close();
        System.exit(0);
    }

    private static void eingabeoptionen()
    {
        System.out.println("EINGABEOPTIONEN");
        System.out.println("***************");
        System.out.println("[1] Ort hinzufügen");
        System.out.println("[2] Straßenverbindung hinzufügen (Orte müssen bereits vorhanden sein)");
        System.out.println();
        System.out.println("[0] Zurück");

        switch (nextInt = s.nextInt())
        {
            case 1:
                ortHinzufügen();
                main(null);
                break;
            case 2:
                straßenverbindungHinzufügen();
                main(null);
                break;
            case 0:
                main(null);
                break;
            default:
                System.err.println("[ERR] Ungültige Eingabe...");
                System.err.println("[ERR] Wollten Sie Beenden? [j/n]");
                switch (s.next())
                {
                    case "j":
                        quit();
                    default:
                        eingabeoptionen();
                }
        }
    }

    private static void straßensperrenVerwalten()
    {
        System.out.println("STRAßENSPERREN-VERWALTUNG");
        System.out.println("*************************");
        System.out.println("[1] Straßensperre in eine Richtung hinzufügen (nur Start->Ziel)");
        System.out.println("[2] Straßensperre in beide Richtungen hinzufügen (Start->Ziel UND Ziel->Start)");
        System.out.println("[3] Eingerichtete Straßensperren ausgeben");
        System.out.println();
        System.out.println("[4] Straßensperre auflösen");
        System.out.println();
        System.out.println("[0] Abbrechen");

        switch (nextInt = s.nextInt())
        {
            case 1:
                straßensperreEinrichten(false);
                break;
            case 2:
                straßensperreEinrichten(true);
                break;
            case 3:
                rp.graphStraßensperrenAusgeben();
                break;
            case 4:
                straßensperreAuflösen();
                break;
            case 0:
                eingabeoptionen();
                break;
            default:
                System.err.println("[ERR] Ungültige Eingabe...");
                System.err.println("[ERR] Wollten Sie zurück? [j/n]");
                switch (s.next())
                {
                    case "j":
                        eingabeoptionen();
                    default:
                        straßensperrenVerwalten();
                }
        }
    }

    private static void straßensperreAuflösen()
    {
        // Frage nach Start- und Zielort vom Benutzer und übergib sie der Methode in rp
        System.out.println();
        startortWählen();
        
        System.out.println();
        zielortWählen();
        
        rp.straßensperreAuflösen(startort, zielort);
    }
    
    private static void straßensperreEinrichten(boolean beideRichtungen)
    {
        // Frage nach Start- und Zielort vom Benutzer und übergib sie der Methode in rp
        System.out.println();
        startortWählen();

        System.out.println();
        zielortWählen();

        rp.straßensperreEinrichten(startort, zielort, beideRichtungen);
    }

    private static void straßenverbindungHinzufügen()
    {
        // Frage nach Start- und Zielort und der Streckenlänge vom Benutzer und übergib sie der Methode in rp
        System.out.println();
        startortWählen();

        System.out.println();
        zielortWählen();
        
        System.out.println();
        System.out.println("Bitte die Streckenlänge zwischen den Orten eingeben:");
        int km = s.nextInt();

        rp.straßenverbindungHinzufügen(startort, zielort, km);
    }

    private static void ortHinzufügen()
    {
        // Frage nach Ortsname und Einwohnerzahl vom Benutzer, erstelle ein
        // neues Ort-Objekt und übergib es der Methode in rp
        System.out.println("Name des neuen Orts eingeben:");
        String name = s.next();

        System.out.println("Einwohnerzahl des neuen Orts eingeben:");
        int einwohner = s.nextInt();

        Ort newOrt = new Ort(name, einwohner);

        rp.ortHinzufügen(newOrt);
    }

    private static void routeBerechnen()
    {
        // Frage nach Start- und Zielort vom Benutzer und übergib sie der Methode in rp
        System.out.println();
        startortWählen();

        System.out.println();
        zielortWählen();

        System.out.println();
        rp.pfadZwischen(startort, zielort);
    }

    private static void zielortWählen()
    {
        System.out.println("Bitte wählen Sie einen Zielort: ");
        // Gib alle Orte aus
        rp.alleOrteAusgeben();
        System.out.println();
        nextInt = s.nextInt();
        
        // Falls die eingegebene Zahl nicht negativ und maximal so groß wie Anzahl Orte ist
        if (nextInt >= 0 && nextInt < rp.getOrte().size())
        {
            // Bestätige die Auswahl
            zielort = nextInt;
            System.out.println("Ort ausgewählt:\t["
            + zielort
            + "] "
            + rp.nameZuNummer(zielort));
        }
        else
        {
            // Ansonsten, beschweren und abbrechen
            System.err.println("[ERR] Ungültige Eingabe...");
            main(null);
        }
    }
    
    private static void startortWählen() {
        System.out.println("Bitte wählen Sie einen Startort: ");
        // Gib alle Orte aus
        rp.alleOrteAusgeben();
        System.out.println();
        nextInt = s.nextInt();
        
        // Falls die eingegebene Zahl nicht negativ und maximal so groß wie Anzahl Orte ist
        if (nextInt >= 0 && nextInt < rp.getOrte().size())
        {
            // Bestätige die Auswahl
            startort = nextInt;
            System.out.println("Ort ausgewählt:\t["
            + startort
            + "] "
            + rp.nameZuNummer(startort));
        }
        else
        {
            // Ansonsten, beschweren und abbrechen
            System.err.println("[ERR] Ungültige Eingabe...");
                main(null);
        }
    }
}