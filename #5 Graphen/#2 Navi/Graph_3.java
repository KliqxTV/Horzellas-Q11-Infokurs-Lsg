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

        ort[0] = "N�rdlingen";
        ort[1] = "Reimlingen";
        ort[2] = "M�ttingen";
        ort[3] = "Balgheim";
        ort[4] = "Alerheim";
        ort[5] = "Deiningen";
        ort[6] = "L�psingen";
        ort[7] = "Wallerstein";
        ort[8] = "Marktoffingen";
        ort[9] = "Maihingen";
        ort[10] = "Wechingen";
        ort[11] = "Pf�fflingen";
        ort[12] = "Wemdingen";

        kanteSetzen("N�rdlingen", "Reimlingen", 6);
        kanteSetzen("N�rdlingen", "M�ttingen", 9);
        kanteSetzen("N�rdlingen", "Deiningen", 7);
        kanteSetzen("N�rdlingen", "L�psingen", 6);
        kanteSetzen("N�rdlingen", "Wallerstein", 6);

        kanteSetzen("Reimlingen", "M�ttingen", 7);
        kanteSetzen("Reimlingen", "Balgheim", 3);

        kanteSetzen("M�ttingen", "Alerheim", 7);

        kanteSetzen("Alerheim", "Deiningen", 4);
        kanteSetzen("Alerheim", "Wechingen", 5);
        kanteSetzen("Alerheim", "Wemdingen", 9);

        kanteSetzen("Deiningen", "L�psingen", 4);
        kanteSetzen("Deiningen", "Pf�fflingen", 4);
        kanteSetzen("Deiningen", "Wemdingen", 12);

        kanteSetzen("Wallerstein", "Marktoffingen", 5);
        kanteSetzen("Wallerstein", "Maihingen", 6);

        kanteSetzen("Marktoffingen", "Maihingen", 3);

        kanteSetzen("Maihingen", "Pf�fflingen", 6);

        kanteSetzen("Wechingen", "Pf�fflingen", 5);

        kanteSetzen("Pf�fflingen", "L�psingen", 3);

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
                + "' hat keine Nachbarn... was physikalisch unm�glich ist.");
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
                            + "Das hei�t vermutlich, dass ein Kreis wie 0-5-6 betreten\n"
                            + "oder ein Problem wie N�rdlingen->Wallerstein->Marktoffingen (0-7-8) eingetreten ist.\n"
                            + "Aus diesen Kreisen kommt man nicht mehr heraus.\n"
                            + "Hier k�nnte es auch hei�en, dass es keinen Weg zwischen den Orten gibt.\n");

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
        boolean printedN�rdlingen = false;

        for (int i = 0; i < 1000; i++)
        {
            int[] arr = zufaelligesNavi(start, ziel, false, false);

            if (arr[arr.length - 1] > 0 && arr[arr.length - 1] < kuerzesteStrecke)
            {
                printedN�rdlingen = false;

                System.out.print("\n\nAbfolge:\n");

                for (int j = 0; j < arr.length - 1; j++)
                {
                    if (printedN�rdlingen == true && arr[j] == 0)
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
                        printedN�rdlingen = true;
                        continue;
                    }
                }

                kuerzesteStrecke = arr[arr.length - 1];
                System.out.print("Neue k�rzeste Strecke aufgrund dieser Abfolge: "
                    + kuerzesteStrecke);
            }
        }

        System.out.print("\n\nK�rzeste Strecke: "
            + kuerzesteStrecke);

        // SOLLTE auch nur ein einziges Mal '1000' als kuerzesteStrecke ausgegeben werden, bitte sofort
        // die erforderlichen Ma�nahmen f�r diesen Super-GAU vornehmen. Vielen Dank.
    }
}