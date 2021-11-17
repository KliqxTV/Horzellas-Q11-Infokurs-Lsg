import java.util.Random;

public class ZweidimensionalesArray
{
    String[][] mieter = new String[4][3];
    int[][] miete = new int[4][3];

    public ZweidimensionalesArray()
    {
        Random ran = new Random();

        mieter[0][0] = "Holm";
        mieter[0][1] = "Rehbein";
        mieter[0][2] = "Wilk";
        mieter[1][0] = "Pfisterer";
        mieter[1][1] = "Stehr";
        mieter[1][2] = "Lennartz";
        mieter[2][0] = "Schwerdtfeger";
        mieter[2][1] = "Klostermann";
        mieter[2][2] = "Zellner";
        mieter[3][0] = "Classen";
        mieter[3][1] = "Lind";
        mieter[3][2] = "Bonk";

        // Definiere Zufallswerte für die Mieten zwischen 150 und 375.
        miete[0][0] = ran.nextInt(225) + 150;
        miete[0][1] = ran.nextInt(225) + 150;
        miete[0][2] = ran.nextInt(225) + 150;
        miete[1][0] = ran.nextInt(225) + 150;
        miete[1][1] = ran.nextInt(225) + 150;
        miete[1][2] = ran.nextInt(225) + 150;
        miete[2][0] = ran.nextInt(225) + 150;
        miete[2][1] = ran.nextInt(225) + 150;
        miete[2][2] = ran.nextInt(225) + 150;
        miete[3][0] = ran.nextInt(225) + 150;
        miete[3][1] = ran.nextInt(225) + 150;
        miete[3][2] = ran.nextInt(225) + 150;

        alleMieterAusgeben();
    }

    public void alleMieterAusgeben()
    {
        System.out.println("\tG0\t\tG1\t\tG2\t\tG3");
        
        // Stockwerk-Schleife
        for (int i = mieter[0].length - 1; i != -1; i--)
        {
            System.out.print("["
                + i
                + "]\t");

            // Haus-Schleife
            for (int j = 0; j < mieter.length; j++)
            {
                if (mieter[j][i].length() < 8)
                {
                    System.out.print(mieter[j][i]
                        + "\t\t");
                }
                else if (mieter[j][i].length() >= 8)
                {
                    System.out.print(mieter[j][i]
                        + "\t");
                }
            }
            
            System.out.print("\n");
        }
    }

    public void alleMieterEinesGebaeudes(int j)
    {
        System.out.println("\tG"
            + j);

        // Stockwerk-Schleife
        for (int i = mieter[0].length - 1; i != -1; i--)
        {
            System.out.print("["
                + i
                + "]\t");
            
            System.out.print(mieter[j][i]
                + "\n");
        }
    }

    public void sucheMieter(String suchName)
    {
        int merkI = 0;
        int merkJ = 0;

        // Stockwerk-Schleife
        for (int i = mieter[0].length - 1; i != -1; i--)
        {
            // Haus-Schleife
            for (int j = 0; j < mieter.length; j++)
            {
                if (mieter[j][i] == suchName)
                {
                    System.out.println("Mieter '"
                    + suchName
                    + "' gefunden in Gebaeude "
                    + j
                    + ", Stockwerk "
                    + i
                    + ".");
                    
                    return;
                }
            }
            
            System.out.print("\n");
        }
        
        System.out.println("Mieter '"
            + suchName
            + "' nicht gefunden!");
    }

    public void mieterWechsel(String neu, int stock, int geb)
    {    
        System.out.print("Alter Mieter '"
            + mieter[geb][stock]
            + "' ersetzt durch '");

        mieter[geb][stock] = neu;

        System.out.print(mieter[geb][stock]
            + "'.\n\n");

        alleMieterAusgeben();
    }

    public void gesamtmieteAusgeben()
    {
        int count = 0;

        // Stockwerk-Schleife
        for (int i = mieter[0].length - 1; i != -1; i--)
        {
            // Haus-Schleife
            for (int j = 0; j < mieter.length; j++)
            {
                count += miete[j][i];
            }
            
            System.out.print("\n");
        }

        System.out.println("Die Gesamtmiete beträgt "
            + count
            + ".");
    }

    public void gesamtmieteEinesGebaeudes(int j)
    {
        int count = 0;

        // Stockwerk-Schleife
        for (int i = mieter[0].length - 1; i != -1; i--)
        {
            count += miete[j][i];
        }

        System.out.println("Die Miete des Gebäudes "
            + j
            + " beträgt "
            + count
            + ".");
    }

    public void maxMiete()
    {
        int merkI = 0;
        int merkJ = 0;
        int hmiet = 0;
        
        // Stockwerk-Schleife
        for (int i = mieter[0].length - 1; i != -1; i--)
        {
            // Haus-Schleife
            for (int j = 0; j < mieter.length; j++)
            {
                if (miete[j][i] > hmiet)
                {
                    hmiet = miete[j][i];
                    
                    merkI = i;
                    merkJ = j;
                }
            }
            
            System.out.print("\n");
        }

        System.out.println("Die höchste Miete von "
            + hmiet
            + " zahlt '"
            + mieter[merkJ][merkI]
            + "' aus Gebäude "
            + merkJ
            + ", Stockwerk "
            + merkI
            + ".");
    }
}