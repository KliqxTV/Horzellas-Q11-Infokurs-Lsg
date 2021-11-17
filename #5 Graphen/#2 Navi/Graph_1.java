import java.util.Random;

public class Graph_1
{
    int anzahl;
    String[] ort;
    int[][] matrix;

    public Graph_1()
    {
        Random ran = new Random();
        
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

    public String nameZuNummer(int ortsnr)
    {
        return ort[ortsnr];
    }

    public int nummerZuName(String ortsname)
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

    public void alleOrteAusgeben()
    {
        for (int i = 0; i < anzahl; i++)
        {
            System.out.println("["
                + i
                + "] "
                + ort[i]);
        }
    }

    public void kanteSetzen(String von, String bis, int km)
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

    public void matrixAusgeben()
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

    public void gibtEsDirekteVerbindung(String von, String bis)
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

    public void anzahlDerNachbarn(String von)
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
}