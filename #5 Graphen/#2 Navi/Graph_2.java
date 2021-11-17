import java.util.Random;

public class Graph_2
{
    int anzahl;
    String[] ort;
    int[][] matrix;
    boolean[] besucht = new boolean[20];

    public Graph_2()
    {
        anzahl = 9;
        ort = new String[20];
        matrix = new int[20][20];

        ort[0] = "Nördlingen";
        ort[1] = "Reimlingen";
        ort[2] = "Möttingen";
        ort[3] = "Balgheim";
        ort[4] = "Alerheim";
        ort[5] = "Deiningen";
        ort[6] = "Löpsingen";
        ort[7] = "Wallerstein";
        ort[8] = "Marktoffingen";

        kanteSetzen("Nördlingen", "Reimlingen", 6);
        kanteSetzen("Nördlingen", "Möttingen", 9);
        kanteSetzen("Nördlingen", "Deiningen", 7);
        kanteSetzen("Nördlingen", "Löpsingen", 6);
        kanteSetzen("Nördlingen", "Wallerstein", 6);

        kanteSetzen("Reimlingen", "Möttingen", 7);
        kanteSetzen("Reimlingen", "Balgheim", 3);

        kanteSetzen("Möttingen", "Alerheim", 7);

        kanteSetzen("Alerheim", "Deiningen", 4);

        kanteSetzen("Deiningen", "Löpsingen", 4);

        kanteSetzen("Wallerstein", "Marktoffingen", 5);

        alleOrteAusgeben();
        System.out.println();
        matrixAusgeben();
    }

    private String nameZuNummer(int ortsnr)
    {
        return ort[ortsnr];
    }

    private int nummerZuName(String ortsname)
    {
        for (int i = 0; i < anzahl; i++)
        {
            if (ort[i] == ortsname)
            {
                return i;
            }
        }

        // Den gesuchten Ort gibt es nicht.
        return -1;
    }

    private void alleOrteAusgeben()
    {
        for (int i = 0; i < anzahl; i++)
        {
            System.out.println("["
                + i
                + "] "
                + ort[i]);
        }
    }

    private void kanteSetzen(String von, String bis, int km)
    {
        int v = nummerZuName(von);
        int b = nummerZuName(bis);

        if (v == -1 || b == -1)
        {
            System.out.println("Mindestens ein Ortsname ist fehlerhaft!");
            return;
        }

        matrix[v][b] = km;
        matrix[b][v] = km;

        // matrixAusgeben();
    }

    private void matrixAusgeben()
    {
        System.out.print("\t");
        for (int i = 0; i < anzahl; i++)
        {
            System.out.print("["
                + i
                + "]\t");
        }
        System.out.print("\n");

        for (int i = 0; i < anzahl; i++)
        {
            System.out.print("["
                + i
                + "]\t");

            for (int j = 0; j < anzahl; j++)
            {
                System.out.print(matrix[i][j]
                    + "\t");

                if (j == anzahl - 1)
                {
                    System.out.print("\n");
                }
            }
        }
    }

    private void gibtEsDirekteVerbindung(String von, String bis)
    {
        int v = nummerZuName(von);
        int b = nummerZuName(bis);

        if (v == -1 || b == -1)
        {
            System.out.println("Mindestens ein Ortsname ist fehlerhaft!");
            return;
        }

        int d = matrix[v][b];

        if (d == 0 || d == -1)
        {
            System.out.println("Zwischen '"
                + von
                + "' und '"
                + bis
                + "' gibt es keine direkte Verbindung.");
        }
        else
        {
            System.out.println("Die Strecke zwischen '"
                + von
                + "' und '"
                + bis
                + "' ist "
                + d
                + " lang.");
        }
    }

    private void anzahlDerNachbarn(String von)
    {
        int v = nummerZuName(von);

        if (v == -1)
        {
            System.out.println("Der Ortsname ist fehlerhaft!");
            return;
        }

        int count = 0;

        for (int i = 0; i < anzahl; i++)
        {
            if (matrix[v][i] > 0 || matrix[i][v] > 0)
            {
                count++;
            }
        }

        if (count == 0)
        {
            System.out.println("'"
                + von
                + "' hat keine Nachbarn... was physikalisch unmöglich ist.");
        }
        else
        {
            System.out.println("'"
                + von
                + "' hat "
                + count
                + " Nachbarn.");
        }
    }

    public void dreierroute(String start, String mitte, String ziel)
    {
        int s = nummerZuName(start);
        int m = nummerZuName(mitte);
        int z = nummerZuName(ziel);

        int d = 0;

        if (s == -1 || m == -1 || z == -1)
        {
            System.out.println("Mindestens ein Ortsname ist fehlerhaft!");
            return;
        }

        if (matrix[s][m] > 0)
        {
            d += matrix[s][m];
        }
        else
        {
            System.out.println("Startort hat keine direkte Verbindung mit dem Zwischenziel!");
            return;
        }

        if (matrix[m][z] > 0)
        {
            d += matrix[m][z];
        }
        else
        {
            System.out.println("Zwischenziel hat keine direkte Verbindung mit dem Zielort!");
            return;
        }

        System.out.println("Die Route "
            + start
            + "-"
            + mitte
            + "-"
            + ziel
            + " ist "
            + d
            + " lang.");
    }

    public void zufaelligerNachbarVon(String von)
    {
        int v = nummerZuName(von);

        if (v == -1)
        {
            System.out.println("Der Ortsname ist fehlerhaft!");
            return;
        }

        Random ran = new Random();
        int ranNum = ran.nextInt(anzahl);

        if (matrix[v][ranNum] > 0)
        {
            System.out.println("Die Strecke zwischen "
                + von
                + " und "
                + nameZuNummer(ranNum)
                + " ist "
                + matrix[v][ranNum]
                + " lang.");

            return;
        }
        else
        {
            System.out.println("Die Orte "
                + von
                + " und "
                + nameZuNummer(ranNum)
                + " haben keine direkte Verbindung.");

            zufaelligerNachbarVon(von);

            return;
        }
    }

    private int zufaelligerNachbar(String von)
    {
        int v = nummerZuName(von);

        if (v == -1)
        {
            System.out.println("Der Ortsname ist fehlerhaft!");
            return -1;
        }

        Random ran = new Random();
        int ranNum = ran.nextInt(anzahl);

        if (matrix[v][ranNum] > 0)
        {
            return ranNum;
        }
        else
        {
            return zufaelligerNachbar(von);
        }
    }

    public void zufaelligeViererroute(String start, boolean keineDoppelt)
    {
        int iterationCount = 0;

        int[] route = new int[4];

        int d = 0;

        route[0] = nummerZuName(start);
        besucht[route[0]] = true;

        if (route[0] == -1)
        {
            System.out.println("Der Ortsname ist fehlerhaft!");
            return;
        }

        if (keineDoppelt == true)
        {
            for (int i = 0; i < route.length - 1; i++)
            {
                boolean foundOrt = false;

                while (foundOrt == false)
                {
                    iterationCount++;

                    route[i + 1] = zufaelligerNachbar(nameZuNummer(route[i]));

                    if (besucht[route[i + 1]] == false)
                    {
                        besucht[route[i + 1]] = true;

                        foundOrt = true;
                        d += matrix[route[i]][route[i + 1]];
                    }

                    if (iterationCount > 500)
                    {
                        System.out.println("Unendliche Schleife nach 500 Schritten im while-Loop.\n"
                            + "Das heißt vermutlich, dass ein Kreis wie 0-5-6 betreten\n"
                            + "oder ein Problem wie Nördlingen->Wallerstein->Marktoffingen (0-7-8) eingetreten ist.\n"
                            + "Aus diesen Kreisen kommt man nicht mehr heraus.\n");

                        System.out.print("Bisherige Abfolge: ");

                        for (int k = 0; k < route.length - 1; k++)
                        {
                            try
                            {
                                System.out.print(route[k]
                                    + "  ");
                            }
                            catch (Exception e) { }
                        }

                        System.out.println();
                        System.out.println();

                        return;
                    }
                }
            }
        }
        else
        {
            for (int i = 0; i < route.length - 1; i++)
            {
                boolean foundOrt = false;

                while (foundOrt == false)
                {
                    Random ran = new Random();
                    route[i + 1] = ran.nextInt(anzahl);

                    if (matrix[route[i]][route[i + 1]] > 0)
                    {
                        foundOrt = true;
                        d += matrix[route[i]][route[i + 1]];
                    }
                }
            }
        }

        System.out.println("Gewählte Orte:"
            + "\n["
            + route[0]
            + "] "
            + nameZuNummer(route[0])
            + "\n["
            + route[1]
            + "] "
            + nameZuNummer(route[1])
            + "\n["
            + route[2]
            + "] "
            + nameZuNummer(route[2])
            + "\n["
            + route[3]
            + "] "
            + nameZuNummer(route[3])
            + "\n");

        System.out.println("Die Route "
            + nameZuNummer(route[0])
            + "-"
            + nameZuNummer(route[1])
            + "-"
            + nameZuNummer(route[2])
            + "-"
            + nameZuNummer(route[3])
            + " ist "
            + d
            + " lang.");

        for (int i = 0; i < besucht.length; i++)
        {
            besucht[i] = false;
        }
    }
}