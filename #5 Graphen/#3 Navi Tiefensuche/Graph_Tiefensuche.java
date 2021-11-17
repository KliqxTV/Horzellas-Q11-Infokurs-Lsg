import java.util.Random;

public class Graph_Tiefensuche
{
    int anzahl;
    String[] ort;
    int[][] matrix;
    boolean[] besucht = new boolean[20];

    public Graph_Tiefensuche()
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

        System.out.println();
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

        /* System.out.println("Strecke zwischen '"
        + von
        + "' und '"
        + bis
        + "' auf "
        + km
        + " gesetzt.");
         */

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

    private int[] alleNachbarn(String von)
    {
        int count = 0;
        int forOffset = 0;

        int[] nachbarn = new int[anzahl];

        for (int i = 0; i < nachbarn.length; i++)
        {
            nachbarn[i] = -1;
        }

        int v = nummerZuName(von);

        if (v == -1)
        {
            return new int[anzahl + 1];
        }

        for (int i = 0; i < nachbarn.length; i++)
        {
            if (matrix[v][i] > 0 || matrix[i][v] > 0)
            {
                nachbarn[i] = i;
            }
        }

        for (int i = 0; i < nachbarn.length; i++)
        {
            if (nachbarn[i] > 0)
            {
                count++;
            }
        }

        int[] returnNachbarn = new int[count + 1];

        for (int i = 0; i < nachbarn.length; i++)
        {
            if (nachbarn[i] > -1)
            {
                returnNachbarn[forOffset] = nachbarn[i];
                forOffset++;
            }
        }

        return returnNachbarn;
    }

    public void testVonNoerdlingen()
    {
        besucht = new boolean[20];
        tiefensuche("Nördlingen");
    }

    private void tiefensuche(String start, int übergabeOrt)
    {
        int s = nummerZuName(start);
        int[] nachbarn = alleNachbarn(start);

        if (s == -1 || nachbarn.length == anzahl + 1)
        {
            System.out.println("Der Ortsname ist fehlerhaft!");
            return;
        }

        if (übergabeOrt == -1)
        {
            System.out.println("Ort: "
                + start
                + " - "
                + s);
        }
        else
        {
            System.out.println("Ort: "
                + start
                + " - "
                + s
                + "\tVon: "
                + nameZuNummer(übergabeOrt));
        }

        for (int i = 0; i < nachbarn.length; i++)
        {
            if (besucht[nachbarn[i]] == false)
            {
                besucht[s] = true;
                besucht[nachbarn[i]] = true;
                tiefensuche(nameZuNummer(nachbarn[i]), s);
            }
        }
    }

    public void tiefensuche(String start)
    {
        besucht = new boolean[20];
        tiefensuche(start, -1);
    }
}