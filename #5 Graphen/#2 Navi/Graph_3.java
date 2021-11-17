import java.util.Random;

public class Graph_3
{
    int anzahl;
    String[] ort;
    int[][] matrix;
    boolean[] besucht = new boolean[20];

    public Graph_3()
    {
        anzahl = 13;
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
        ort[9] = "Maihingen";
        ort[10] = "Wechingen";
        ort[11] = "Pfäfflingen";
        ort[12] = "Wemdingen";

        kanteSetzen("Nördlingen", "Reimlingen", 6);
        kanteSetzen("Nördlingen", "Möttingen", 9);
        kanteSetzen("Nördlingen", "Deiningen", 7);
        kanteSetzen("Nördlingen", "Löpsingen", 6);
        kanteSetzen("Nördlingen", "Wallerstein", 6);

        kanteSetzen("Reimlingen", "Möttingen", 7);
        kanteSetzen("Reimlingen", "Balgheim", 3);

        kanteSetzen("Möttingen", "Alerheim", 7);

        kanteSetzen("Alerheim", "Deiningen", 4);
        kanteSetzen("Alerheim", "Wechingen", 5);
        kanteSetzen("Alerheim", "Wemdingen", 9);

        kanteSetzen("Deiningen", "Löpsingen", 4);
        kanteSetzen("Deiningen", "Pfäfflingen", 4);
        kanteSetzen("Deiningen", "Wemdingen", 12);

        kanteSetzen("Wallerstein", "Marktoffingen", 5);
        kanteSetzen("Wallerstein", "Maihingen", 6);

        kanteSetzen("Marktoffingen", "Maihingen", 3);

        kanteSetzen("Maihingen", "Pfäfflingen", 6);

        kanteSetzen("Wechingen", "Pfäfflingen", 5);

        kanteSetzen("Pfäfflingen", "Löpsingen", 3);

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

    public void zufaelligesNavi(String start, String ziel)
    {
        zufaelligesNavi(start, ziel, false, true);
    }

    private int[] zufaelligesNavi(String start, String ziel, boolean errorOutput, boolean resultOutput)
    {
        besucht = new boolean[20];
        int iterationCount = 0;
        int[] route = new int[20];
        int d = 0;
        int besuchteOrte = 0;

        route[0] = nummerZuName(start);

        if (route[0] == -1)
        {
            System.out.println("Der Ortsname ist fehlerhaft!");
            return new int[1000];
        }

        besucht[route[0]] = true;

        for (int i = 0; i < route.length - 1; i++)
        {
            boolean foundOrt = false;
            boolean breakOut = false;

            while (foundOrt == false)
            {
                iterationCount++;

                route[i + 1] = zufaelligerNachbar(nameZuNummer(route[i]));

                if (besucht[route[i + 1]] == false)
                {
                    besucht[route[i + 1]] = true;
                    besuchteOrte++;

                    foundOrt = true;
                    d += matrix[route[i]][route[i + 1]];
                }

                if (route[i + 1] == nummerZuName(ziel))
                {
                    breakOut = true;
                    break;
                }

                if (iterationCount > 500)
                {
                    if (errorOutput == true)
                    {
                        System.out.println("Unendliche Schleife nach 500 Schritten im while-Loop.\n"
                            + "Das heißt vermutlich, dass ein Kreis wie 0-5-6 betreten\n"
                            + "oder ein Problem wie Nördlingen->Wallerstein->Marktoffingen (0-7-8) eingetreten ist.\n"
                            + "Aus diesen Kreisen kommt man nicht mehr heraus.\n"
                            + "Hier könnte es auch heißen, dass es keinen Weg zwischen den Orten gibt.\n");

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
                    }

                    return new int[1000];
                }
            }

            if (breakOut == true)
            {
                break;
            }
        }

        besucht = new boolean[20];

        if (resultOutput == true)
        {
            System.out.print("\nAbfolge:");

            for (int i = 0; i < besuchteOrte + 1; i++)
            {
                System.out.print("\n["
                    + route[i]
                    + "] "
                    + nameZuNummer(route[i])
                    + "\t");
            }
        }

        int[] returnArray = new int[route.length + 1];
        for (int i = 0; i < route.length; i++)
        {
            returnArray[i] = route[i];
        }
        returnArray[route.length] = d;

        return returnArray;
    }

    public void wiederholeZufaelligesNavi(String start, String ziel)
    {
        int kuerzesteStrecke = 1000;
        boolean printedNördlingen = false;

        for (int i = 0; i < 1000; i++)
        {
            int[] arr = zufaelligesNavi(start, ziel, false, false);

            if (arr[arr.length - 1] > 0 && arr[arr.length - 1] < kuerzesteStrecke)
            {
                printedNördlingen = false;

                System.out.print("\n\nAbfolge:\n");

                for (int j = 0; j < arr.length - 1; j++)
                {
                    if (printedNördlingen == true && arr[j] == 0)
                    {
                        break;
                    }
                    else
                    {
                        System.out.print("["
                            + j
                            + "] "
                            + nameZuNummer(arr[j])
                            + "\n");
                    }

                    if (arr[j] == 0)
                    {
                        printedNördlingen = true;
                        continue;
                    }
                }

                kuerzesteStrecke = arr[arr.length - 1];
                System.out.print("Neue kürzeste Strecke aufgrund dieser Abfolge: "
                    + kuerzesteStrecke);
            }
        }

        System.out.print("\n\nKürzeste Strecke: "
            + kuerzesteStrecke);

        // SOLLTE auch nur ein einziges Mal '1000' als kuerzesteStrecke ausgegeben werden, bitte sofort
        // die erforderlichen Maßnahmen für diesen Super-GAU vornehmen. Vielen Dank.
    }
}